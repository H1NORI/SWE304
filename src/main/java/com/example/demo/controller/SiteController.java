package com.example.demo.controller;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class SiteController {

//    @Autowired
//    public SiteController() {
//
//    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "SWE 304");
        model.addAttribute("view", "site/index");
        return "layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "person/create";
    }

}
