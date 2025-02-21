package com.example.demo.controller;

import com.example.demo.form.PersonForm;
import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("title", "Create Person");
        model.addAttribute("view", "person/create");
        model.addAttribute("type", "create");
        model.addAttribute("personForm", new PersonForm());

        return "layout";
    }

    @PostMapping("/create")
    public String savePerson(@ModelAttribute("personForm") PersonForm personForm) {
        PersonModel person = new PersonModel();
        person.setName(personForm.getName());
        person.setAddress(personForm.getAddress());

        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        PersonModel person = personService.findById(id);
        PersonForm personForm = new PersonForm();
        personForm.setId(person.getId());
        personForm.setName(person.getName());
        personForm.setAddress(person.getAddress());

        model.addAttribute("title", "Update Person");
        model.addAttribute("view", "person/update");
        model.addAttribute("type", "update");

        model.addAttribute("personForm", personForm);
        return "layout";
    }

    @PostMapping("/update")
    public String updatePerson(@ModelAttribute("personForm") PersonForm personForm) {
        PersonModel person = personService.findById(personForm.getId());
        person.setName(personForm.getName());
        person.setAddress(personForm.getAddress());

        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.delete(id);
        return "redirect:/person";
    }
}
