package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myaccount")

public class MyAccountController {

    @GetMapping("/logedin")
    public String showMyAccount(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");
        if (userObj == null) {
            // Redirect to login page if user is not logged in
            return "redirect:/login";
        }
        // User is logged in, retrieve user object from session and add to model
        Person user = (Person) userObj;
        model.addAttribute("user", user);
        return "afterLogin";
    }

    @GetMapping("")
    public String home() {
        return "afterLogin";
    }

}
