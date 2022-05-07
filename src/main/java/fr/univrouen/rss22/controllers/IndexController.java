package fr.univrouen.rss22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(Model model) {
        return "Index";
    }

    @GetMapping("/help")
    public String helpPage(Model model) {
        return "Help";
    }

    @GetMapping("/ListItem")
    public String listItems(Model model) {
        return "itemList";
    }

    @GetMapping("/detailItem/{guid}")
    public String detailItem(Model model, @PathVariable UUID guid) {
        model.addAttribute("guid", guid);
        return "itemDetails";
    }

    @GetMapping("/ListItemXML")
    public String listItemsXML(Model model) {
        return "itemListXML";
    }

    @GetMapping("/insertItem")
    public String insertItem(Model model) {
        return "insertItem";
    }

}
