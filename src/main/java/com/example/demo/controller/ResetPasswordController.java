package com.example.demo.controller;


import com.example.demo.model.EmailSenderService;
import com.example.demo.model.Person;
import com.example.demo.model.ResetPasswordForm;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ResetPasswordController {
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String resetPassword(Model model) {
        model.addAttribute("resetPasswordForm", new ResetPasswordForm());
        return "reset-password";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute("resetPasswordForm") ResetPasswordForm resetPasswordForm, Model model) {


        // Send email
        String toEmail = resetPasswordForm.getEmail();
        Optional<Person> personOptional = personRepository.findByEmail(resetPasswordForm.getEmail());
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            String subject = "Reset Password";
            String body = "Your password is: " + person.getPassword();
            emailSenderService.sendSimpleEmail(person.getEmail(), body, subject);}
        return "reset-password";
    }

}
