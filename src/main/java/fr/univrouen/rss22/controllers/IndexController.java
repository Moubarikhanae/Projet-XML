package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.DTOs.ItemListDTO;
import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.mapping.ItemMapper;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Controller
public class IndexController {

   @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String homePage(Model model){
        return "Index";
    }

    @GetMapping("/help")
    public String helpPage(Model model){
        return "Help";
    }

    @GetMapping("/rss22/resume/html")
    public String showItemList(Model model) {
        List<Item> items=itemService.findItems();
        List<ItemListDTO> list=new ArrayList<>();
        for(var item : items)
        {
             list.add(ItemMapper.ItemEntityToDto(item));
        }
        model.addAttribute("items", list);
        return "itemList";
    }

    @GetMapping(value="/rss22/resume/html/{guid}")
    public String getItemByGuid(Model model, @PathVariable("guid") UUID guid) {

        try{
            Item item =itemService.findItemById(guid).get();
            model.addAttribute("item", item);
        }
        catch(NoSuchElementException exc)
        {
            model.addAttribute("errorMessage", "l'article avec guid"+guid+ "est introuvable");
        }
        return "ItemDetails";
    }

}
