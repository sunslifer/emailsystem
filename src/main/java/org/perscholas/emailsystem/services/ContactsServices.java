package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.ContactsRepo;
import org.perscholas.emailsystem.models.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContactsServices {
    private ContactsRepo contactsRepo;

    @Autowired
    public ContactsServices(ContactsRepo contactsRepo) { this.contactsRepo = contactsRepo; }

    public void addContact(String email, String firstName, String lastName) {
        Contacts contact = new Contacts();
        contact.setEmail(email);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);

        contactsRepo.save(contact);
    }

    public List<Contacts> getAllContacts(){ return contactsRepo.findAll(); }
}
