package com.example.demo.controller;


import com.example.demo.model.EmailSenderService;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/{id}")
    public String showPersonDetails(@PathVariable("id") String id, Model model) {
        // Vérifier si l'id est un nombre
        if(!id.matches("\\d+")) {
            return "error"; // renvoyer une page d'erreur si l'id n'est pas un nombre
        }
        Long personId = Long.parseLong(id);
        Person person = personRepository.findById(personId).orElse(null);
        model.addAttribute("person", person);
        return "personDetail";
    }



    @GetMapping("/all")
    public String getAllPersons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }




    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Optional<Person> personOptional = personRepository.findByEmail(userDetails.getUsername());
        if (personOptional.isPresent()) {

            Person person = personOptional.get();
            model.addAttribute("person", person);
            return "personEdit";
        } else {
            System.out.println("redirection");
            return "redirect:/error";
        }
    }


    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person) throws ParseException {
        Optional<Person> personOnDb = personRepository.findById(person.getId());
        Person personOnBrowser = personOnDb.get();



        System.out.println("THISSSSSSSS");


        personOnBrowser.setFirstName(person.getFirstName());
        personOnBrowser.setLastName(person.getLastName());
        personOnBrowser.setWebsite(person.getWebsite());



        personRepository.save(personOnBrowser);
        return "redirect:/persons/all";
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

//    @RequestMapping("/reset")
//    public String reset() {
//        return "reset";
//    }
//
//    @PostMapping("/resetPassword")
//    public String resetPasswordByEmail(@ModelAttribute("person") Person person) {
////        Optional<Person> personOptional = personRepository.findByEmail(email);
////        if (personOptional.isPresent()) {
////            Person person = personOptional.get();
//        String subject = "Reset Password";
//        String body = "Your password is: " ;//+ person.getPassword();
////            model.addAttribute("person", person);
//        emailSenderService.sendSimpleEmail(person.getWebsite(),
//                "This is email body",
//                "This is email subject");
//
//        System.out.println("Done-----------");
//
////        }
//        return "redirect:/persons/all";
//
//    }


}
