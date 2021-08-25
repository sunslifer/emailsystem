package org.perscholas.emailsystem;

import lombok.extern.java.Log;
import org.perscholas.emailsystem.dao.UsersRepo;
import org.perscholas.emailsystem.models.*;
import org.perscholas.emailsystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@Component
@Log
@Transactional
public class AppRunner implements CommandLineRunner {
    UsersServices usersServices;
    EmailsServices emailsServices;
    ContactsServices contactsServices;
    FoldersServices foldersServices;
    AttachmentsServices attachmentsServices;

    @Autowired
    public AppRunner(UsersServices usersServices,
                     EmailsServices emailsServices,
                     ContactsServices contactsServices,
                     FoldersServices foldersServices,
                     AttachmentsServices attachmentsServices
    ){
        this.usersServices = usersServices;
        this.emailsServices = emailsServices;
        this.contactsServices = contactsServices;
        this.foldersServices = foldersServices;
        this.attachmentsServices = attachmentsServices;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("--------------START--------------");
        log.info("--------------ADDING INFO--------------");

        usersServices.registerUser("admin", "pass", "Kyle", "Wilson");
        usersServices.registerUser("123", "123", "Bob", "Smith");

        emailsServices.addEmail("Hello", "Lets have lunch.");
        emailsServices.addEmail("Steve Blake", "I saw Steve Blake at a grocery store in Los Angeles yesterday.");
        emailsServices.addEmail("Goodbye", "I will miss you.");

        contactsServices.addContact("abc", "Dan", "Theman");
        contactsServices.addContact("123", "Frank", "Thetank");

        foldersServices.addFolder("Main");
        foldersServices.addFolder("Spam");

        attachmentsServices.addAttachment("thing.txt", "file");
        attachmentsServices.addAttachment("thing2.txt", "file2");

        log.info("---------------TESTING-----------------");

        log.info(usersServices.getFirstNameByUserName("admin"));

        for(Users users : usersServices.getAllUsers()) {
            log.info(users.getFirstName());
        }

        for(Emails emails : emailsServices.getAllEmails()){
            log.info(emails.getTitle());
        }

        for(Contacts contacts: contactsServices.getAllContacts()){
            log.info(contacts.getFirstName() + " " + contacts.getLastName());
        }

        for(Folders folders: foldersServices.getAllFolders()){
            log.info(folders.getName());
        }

        for(Attachments attachments: attachmentsServices.getAllAttachments()) {
            log.info(attachments.getFile());
        }











    }
}
