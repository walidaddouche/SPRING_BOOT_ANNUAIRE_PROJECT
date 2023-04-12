package com.example.demo.controller;


import com.example.demo.model.EmailSenderService;
import com.example.demo.model.ResetPasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResetPasswordController {
    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public String resetPassword(Model model) {
        model.addAttribute("resetPasswordForm", new ResetPasswordForm());
        return "reset-password";
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute("resetPasswordForm") ResetPasswordForm resetPasswordForm, Model model) {
        // Check if the passwords match
        if (!resetPasswordForm.getPassword().equals(resetPasswordForm.getConfirmPassword())) {
            model.addAttribute("errorMessage", "Passwords do not match");
            return "reset-password";
        }

        // Implement password reset logic here
        // ...

        // Send email
        String toEmail = resetPasswordForm.getEmail();
        String subject = "Password Reset Confirmation";
        String body = "Your password has been reset successfully.";
        emailSenderService.sendSimpleEmail(toEmail, subject, body);

        model.addAttribute("message", "Password reset successful. Check your email for confirmation.");
        return "reset-password";
    }

}
