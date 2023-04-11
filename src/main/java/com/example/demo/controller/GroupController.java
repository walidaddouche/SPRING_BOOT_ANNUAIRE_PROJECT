package com.example.demo.controller;

import com.example.demo.model.GroupTable;
import com.example.demo.repository.GroupTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")

public class GroupController {
    @Autowired
    private GroupTableRepository groupRepository;


    @GetMapping("/all")
    public String showAllGroups(Model model) {
        //model.addAttribute("groups", groupRepository.findAll());
        System.out.println(groupRepository.findAll());
        System.out.println("HERE");
        return "groups";
    }
}



