package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {

    @PostMapping("/submitEmail")
    public String submitEmail(@ModelAttribute("person") Person person) {
        System.out.println("Submitted email: " );
        return "redirect:/persons/all";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/reset")
    public String send() {
        return "reset";
    }

}