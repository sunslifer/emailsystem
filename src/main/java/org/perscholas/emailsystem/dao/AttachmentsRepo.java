package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentsRepo extends JpaRepository<Attachments, Long>{
    List<Attachments> findAll();
}
