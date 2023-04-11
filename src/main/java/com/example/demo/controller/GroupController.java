package com.example.demo.controller;

import com.example.demo.model.GroupTable;
import com.example.demo.model.Person;
import com.example.demo.repository.GroupTableRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/groups")

public class GroupController {
    @Autowired
    private GroupTableRepository groupRepository;
    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/all")
    public String getGroups(Model model) {
        Iterable<GroupTable> groups = groupRepository.findAll();
        model.addAttribute("groups", groups);
        model.addAttribute("personRepository", personRepository);
        return "group";
    }


    @GetMapping("/{id}")
    public String showGroupDetails(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        GroupTable group = groupRepository.findById(id).orElse(null);
        List<Person> persons = personRepository.findByGroup(group);
        model.addAttribute("group", group);
        model.addAttribute("persons", persons);
        return "groupDetail";
    }


}









