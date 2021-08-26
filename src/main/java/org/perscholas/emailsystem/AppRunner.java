package org.perscholas.emailsystem;

import lombok.extern.java.Log;
import org.perscholas.emailsystem.models.*;
import org.perscholas.emailsystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Log
@Transactional
public class AppRunner implements CommandLineRunner {

    public static Users currUser = new Users();

    private UsersServices usersServices;
    private EmailsServices emailsServices;
    private ContactsServices contactsServices;
    private FoldersServices foldersServices;
    private AttachmentsServices attachmentsServices;

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

        emailsServices.addEmail(usersServices.getUserByUserName("admin").getUserId(), "Hello", "Lets have lunch.","Mom", foldersServices.getFolderByName("Main"));
        emailsServices.addEmail(usersServices.getUserByUserName("admin").getUserId(), "Steve Blake", "I saw Steve Blake at a grocery store in Los Angeles yesterday.","Mom", foldersServices.getFolderByName("Main"));
        emailsServices.addEmail(usersServices.getUserByUserName("admin").getUserId(), "Goodbye", "I will miss you.","Mom", foldersServices.getFolderByName("Main"));

        contactsServices.addContact("abc", "Dan", "Theman");
        contactsServices.addContact("123", "Frank", "Thetank");

        foldersServices.addFolder("Main");
        foldersServices.addFolder("Spam");

        attachmentsServices.addAttachment("thing.txt", "file");
        attachmentsServices.addAttachment("thing2.txt", "file2");

        log.info("---------------TESTING-----------------");

        log.info(usersServices.getFirstNameByUserName("admin", currUser.getPassword()));

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

        usersServices.updateUserFirstName("123", "Chuck");
        log.info(usersServices.getFirstNameByUserName("123", currUser.getPassword()));


    }
}
