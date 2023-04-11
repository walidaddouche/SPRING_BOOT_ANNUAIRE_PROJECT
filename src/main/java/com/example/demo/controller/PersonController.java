package com.example.demo.controller;


import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public String showPersonDetails(@PathVariable("id") Long id, Model model) {
        Person person = personRepository.findById(id).orElse(null);
        model.addAttribute("person", person);
        return "personDetail";

    }


    @GetMapping("/all")
    public String getAllPersons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }



    @PostMapping("/")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        if (personRepository.existsById(id)) {
            person.setId(id);
            return personRepository.save(person);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }





}
