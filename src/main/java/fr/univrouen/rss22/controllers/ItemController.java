package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.DTOs.ItemListDTO;
import fr.univrouen.rss22.iServices.CategoryService;
import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.iServices.PersonService;
import fr.univrouen.rss22.mapping.ItemMapper;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PersonService personService;

    @GetMapping(value="/rss22/resume/html")
    public ResponseEntity<List<ItemListDTO>> showItemList() {
        List<Item> items=itemService.findItems();
        List<ItemListDTO> list=new ArrayList<>();
        for(var item : items)
        {
            list.add(ItemMapper.ItemEntityToDto(item));
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping(value="/rss22/resume/html/{guid}")
    public ResponseEntity<Item> getItemByGuid(Model model, @PathVariable("guid") UUID guid) {

        try{
            Item item =itemService.findItemById(guid).get();
            return new ResponseEntity<>(item,HttpStatus.OK);
        }
        catch(NoSuchElementException exc)
        {
            model.addAttribute("errorMessage", "l'article avec guid"+guid+ "est introuvable");
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/rss22/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Items> getListOfItemWithXML() {
        List<Item> items = itemService.findItems();
        Items itemsList = new Items();
        for (var item : items) {
            ItemListDTO list = ItemMapper.ItemEntityToDto(item);
            itemsList.getItems().add(list);
        }
        return new ResponseEntity<Items>(itemsList, HttpStatus.OK);
    }

    @GetMapping(value = "/rss22/resume/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> getItemByGuid(@PathVariable("guid") UUID guid) {
        if(guid==null) {
            throw new RuntimeException(
                    "L'identifiant est null."
            );
        }
        Item item = itemService.findItemById(guid)
                .orElseThrow(() -> {
                    throw new RuntimeException(
                            "l'article avec guid" + guid + "est introuvable"
                    );
                });
        return new ResponseEntity<Item>(item,HttpStatus.OK);
    }

    @PostMapping(value = "/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> insertItem(@RequestBody Item item) {

        if(item==null) {
            throw new RuntimeException(
                    "L'article est null."
            );
        }
        var itemByDateAndTitle = itemService.findItemByDateAndTitle(item.getPublishedOrUpdated(),item.getTitle());
        if (itemByDateAndTitle.isPresent()) throw new RuntimeException(
                "L'article avec la même date et le titre existe déjà."
        );
        item.setGuid(UUID.randomUUID());
        var itemAdded=itemService.insertItem(item);
        for(var person : itemAdded.getAuthorOrContributor())
        {
            person.setItem(itemAdded);
            personService.updatePerson(person);
        }
        for(var categorie : itemAdded.getCategories())
        {
            categorie.setItem(itemAdded);
            categoryService.updateCategory(categorie);
        }

        return new ResponseEntity<>(itemService.findItemById(itemAdded.getGuid()).get(),HttpStatus.CREATED);
    }

    @GetMapping(value="/rss22/delete/{guid}",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Item> deleteItem(@PathVariable("guid") UUID guid) {
        Optional<Item> item;
        if(guid==null) {
            throw new RuntimeException(
                    "L'identifiant est null."
            );
        }
        else {
            item = itemService.findItemById(guid);
            if (!item.isPresent()) {
                throw new RuntimeException(
                        "L'article n'existe pas."
                );
            } else {
                itemService.deleteItem(guid);
            }
        }
            return new ResponseEntity<>(item.get(),HttpStatus.OK);
        }
}
