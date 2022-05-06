package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.DTOs.ItemListDTO;
import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.mapping.ItemMapper;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping(value = "/rss22/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Items getListOfItemWithXML() {
        List<Item> items = itemService.findItems();
        Items itemsList = new Items();
        for (var item : items) {
            ItemListDTO list = ItemMapper.ItemEntityToDto(item);
            itemsList.getItems().add(list);
        }
        return itemsList;
    }

    @GetMapping(value = "/rss22/resume/xml/{guid}", produces = MediaType.APPLICATION_XML_VALUE)
    public Item getItemByGuid(@PathVariable("guid") UUID guid) {
        Item item = itemService.findItemById(guid)
                .orElseThrow(() -> {
                    throw new RuntimeException(
                            "l'article avec guid" + guid + "est introuvable"
                    );
                });
        return item;
    }

    @PostMapping(value = "/rss22/insert", produces = MediaType.APPLICATION_XML_VALUE
            , consumes = MediaType.APPLICATION_XML_VALUE)
    public Item insertItem(@RequestBody Item item) {

        var itemByTitle = itemService.findItemByTitle(item.getTitle());
        if (itemByTitle.isPresent()) throw new RuntimeException(
                "L'article avec le même nom existe déjà."
        );
        var itemByDate = itemService.findItemByDate(item.getPublishedOrUpdated());
        if (itemByDate.isPresent()) throw new RuntimeException(
                "L'article avec la même date existe déjà."
        );
        item.setGuid(UUID.randomUUID());
        itemService.insertItem(item);
        return item;
    }

}
