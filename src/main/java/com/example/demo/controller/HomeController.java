package com.example.demo.controller;


import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {


    @Autowired
    PersonRepository personRepository;

    @GetMapping("")
    public String home() {
        return "home";
    }


    @PostMapping(" ")
    public String login(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        Optional<Person> person = personRepository.findByEmail(email);
        if (person.isPresent() && person.get().getPassword().equals(password)) {
            redirectAttributes.addAttribute("personId", person.get().getId());
            return "redirect:/persons";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/";
        }
    }






}