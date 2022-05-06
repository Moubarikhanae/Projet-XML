package fr.univrouen.rss22.controllers;

import fr.univrouen.rss22.DTOs.ItemListDTO;
import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.mapping.ItemMapper;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.models.Items;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping(value="/rss22/resume/xml", produces= MediaType.APPLICATION_XML_VALUE)
    public Items getListOfItemWithXML() {
        List<Item> items=itemService.findItems();
        Items itemsList=new Items();
        for(var item : items)
        {
            ItemListDTO list=ItemMapper.ItemEntityToDto(item);
            itemsList.getItems().add(list);
        }
        return itemsList;
    }

    @GetMapping(value="/rss22/resume/xml/{guid}", produces= MediaType.APPLICATION_XML_VALUE)
    public Item getItemByGuid(@PathVariable("guid") UUID guid) {
        Item item = itemService.findItemById(guid)
                .orElseThrow(() -> {throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "l'article avec guid"+guid+"est introuvable"
        );});
        return item;
    }


}
