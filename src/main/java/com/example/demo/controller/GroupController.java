package com.example.demo.controller;

import com.example.demo.model.GroupTable;
import com.example.demo.repository.GroupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")

public class GroupController {
    @Autowired
    private GroupTableRepository groupRepository;


    @GetMapping("/groups")
    public String showAllGroups(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "group";
    }

    @GetMapping("/groups/{id}")
    public String showGroupDetails(@PathVariable Long id, Model model) {
        GroupTable group = groupRepository.findById(id).orElse(null);
        if (group == null) {
            return "redirect:/groups";
        }
        model.addAttribute("group", group);
        return "group-details";
    }
}



