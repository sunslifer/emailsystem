package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentsRepo extends JpaRepository<Attachments, Long>{
}
