package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactsRepo extends JpaRepository<Contacts, Long>{
    List<Contacts> findAll();
}
