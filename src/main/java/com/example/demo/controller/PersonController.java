package com.example.demo.controller;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Persons List");
        model.addAttribute("view", "person/index");
        model.addAttribute("persons", personService.findAll());
        return "layout";
//        return "person/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "person/create";
    }

//    @GetMapping("/update")
//    public String update(Model model) {
//        return "person/update";
//    }
//
//    @GetMapping("/delete")
//    public String delete(Model model) {
//        return "person/delete";
//    }



//    public List<PersonModel> findAllStudents() {
//        return List.of(
//                PersonModel.builder()
//                        .id(1)
//                        .name("Nikita")
//                        .address("Sakarya, Sardivan").build()
//        );
//    }
}
