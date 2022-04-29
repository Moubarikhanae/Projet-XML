package fr.univrouen.rss22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {


    @GetMapping("/")
    public String homePage(Model model){
        return "Index";
    }

    @GetMapping("/help")
    public String helpPage(Model model){
        return "Help";
    }
}
