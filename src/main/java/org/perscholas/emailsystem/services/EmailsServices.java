package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.EmailsRepo;
import org.perscholas.emailsystem.models.Emails;
import org.perscholas.emailsystem.models.Folders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class EmailsServices {
    private EmailsRepo emailsRepo;
    private FoldersServices foldersServices;

    @Autowired
    public EmailsServices(EmailsRepo emailsRepo, FoldersServices foldersServices){
        this.emailsRepo = emailsRepo;
        this.foldersServices = foldersServices;
    }

    public void addEmail(Long userId, String title, String body, String sender, List<Folders> folders) {
        Emails email = new Emails();
        email.setUserId(userId);
        email.setTitle(title);
        email.setBody(body);
        email.setSender(sender);
        email.setDateReceived(getCurrentTimeUsingCalendar());
        email.setFolders(folders);

        emailsRepo.save(email);
    }

    public static String getCurrentTimeUsingCalendar() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.toString();
        return formattedDate;
    }

    public List<Emails> getAllEmails(){ return emailsRepo.findAll(); }

    public List<Emails> getEmailsById(Long userId){ return emailsRepo.getEmailsByUserId(userId); }

}
