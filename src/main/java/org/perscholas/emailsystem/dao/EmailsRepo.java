package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailsRepo extends JpaRepository<Emails, Long>{
}
