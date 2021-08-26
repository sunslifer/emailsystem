package org.perscholas.emailsystem.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.EmailsRepo;
import org.perscholas.emailsystem.models.Emails;
import org.perscholas.emailsystem.models.Users;
import org.perscholas.emailsystem.services.EmailsServices;
import org.perscholas.emailsystem.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class EmailsController {

    private EmailsServices emailsServices;
    private EmailsRepo emailsRepo;
    private UsersServices userServices;

    @Autowired
    public EmailsController(EmailsServices emailsServices, EmailsRepo emailsRepo, UsersServices userServices){
        this.emailsServices = emailsServices;
        this.emailsRepo = emailsRepo;
        this.userServices = userServices;
    }

    @GetMapping("/showemails")
    public String showEmails(Model model){
        model.addAttribute("emails", emailsServices.getAllEmails());
        return "showemails";
    }

    @GetMapping("/compose")
    public String composeEmail(Model model){
        Emails email = new Emails();
        model.addAttribute("email", email);
        return "compose";
    }

    @PostMapping("/compose")
    public String submitCompose(@ModelAttribute("email") Emails email){
        log.info(email.toString());
        email.setUserId(userServices.getUserByUserName("admin").getUserId());
        email.setDateReceived(emailsServices.getCurrentTimeUsingCalendar());
        emailsRepo.save(email);
        return "composed";
    }
}
