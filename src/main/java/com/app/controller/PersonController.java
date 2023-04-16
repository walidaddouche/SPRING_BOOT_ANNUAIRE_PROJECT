package com.app.controller;


import com.app.model.Person;
import com.app.repository.PersonRepository;
import com.app.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getAllPersons(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name != null && !name.trim().isEmpty()) {
            Optional<Person> persons;
            persons = personRepository.findByFirstNameContainingIgnoreCase(name.trim());
            model.addAttribute("persons", persons);

        } else {
            Iterable<Person> persona;


            persona = personRepository.findAll();
            model.addAttribute("persons", persona);

        }
        return "persons";
    }




    @PostMapping("/edit")
    public String savePerson(@ModelAttribute("person") Person person) {
        Optional<Person> personOnDb = personRepository.findById(person.getId());
        Person personOnBrowser = personOnDb.get();

        personOnBrowser.setFirstName(person.getFirstName());
        personOnBrowser.setLastName(person.getLastName());
        personOnBrowser.setWebsite(person.getWebsite());

        personRepository.save(personOnBrowser);

        return "redirect:/persons/all";



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
