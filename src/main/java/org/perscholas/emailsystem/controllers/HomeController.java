package org.perscholas.emailsystem.controllers;

import org.perscholas.emailsystem.services.EmailsServices;
import org.perscholas.emailsystem.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private UsersServices usersServices;
    private EmailsServices emailsServices;


    @Autowired
    public HomeController (UsersServices usersServices, EmailsServices emailsServices) {
        this.emailsServices = emailsServices;
        this.usersServices = usersServices;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("emails", emailsServices.getEmailsById(usersServices.getUserByUserName("admin").getUserId()));
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        
        return "login";
    }

}
