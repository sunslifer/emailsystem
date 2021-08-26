package org.perscholas.emailsystem.controllers;

import org.perscholas.emailsystem.services.EmailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailsController {

    private EmailsServices emailsServices;

    @Autowired
    public EmailsController(EmailsServices emailsServices){
        this.emailsServices = emailsServices;
    }

    @GetMapping("/showemails")
    public String showEmails(Model model){
        model.addAttribute("emails", emailsServices.getAllEmails());
        return "showemails";
    }
}
