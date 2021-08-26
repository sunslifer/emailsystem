package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.EmailsRepo;
import org.perscholas.emailsystem.models.Emails;
import org.perscholas.emailsystem.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;

@Slf4j
@Service
public class EmailsServices {
    private EmailsRepo emailsRepo;

    @Autowired
    public EmailsServices(EmailsRepo emailsRepo){
        this.emailsRepo = emailsRepo;
    }

    public void addEmail(String title, String body) {
        Emails email = new Emails();
        email.setTitle(title);
        email.setBody(body);

        emailsRepo.save(email);
    }

    public List<Emails> getAllEmails(){ return emailsRepo.findAll(); }



}
