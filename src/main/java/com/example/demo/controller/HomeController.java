package com.example.demo.controller;


import com.example.demo.model.EmailSenderService;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            return "redirect:/persons/all";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/";
        }
    }



    @PostMapping("/LoginPage")
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            Optional<Person> personOptional = personRepository.findByEmail(auth.getName());
            if (personOptional.isPresent()) {
                Person person = personOptional.get();
                String redirectUrl = "/";
                String refererUrl = request.getHeader("Referer");
                if (refererUrl != null) {
                    if (refererUrl.contains("/persons/edit")) {
                        redirectUrl = "/persons/edit";
                    } else if (refererUrl.contains("/persons/")) {
                        redirectUrl = "/home";
                    }
                }
                return "redirect:" + redirectUrl;
            }
        }
        return "redirect:/loginPage?error";
    }





}