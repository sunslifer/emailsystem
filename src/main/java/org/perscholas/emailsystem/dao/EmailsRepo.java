package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Emails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailsRepo extends JpaRepository<Emails, Long>{
    List<Emails> getAllByFolderOrderByDateReceivedAsc(String name);
    List<Emails> getAllByFolderOrderByDateReceivedDesc(String name);
    List<Emails> getAllByFolderOrderByTitleAsc(String name);
    List<Emails> getAllByFolderOrderByTitleDesc(String name);
    List<Emails> getAllByFolderOrderBySenderAsc(String name);
    List<Emails> getAllByFolderOrderBySenderDesc(String name);
}
