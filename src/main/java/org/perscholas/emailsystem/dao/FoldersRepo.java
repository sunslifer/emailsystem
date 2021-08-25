package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoldersRepo extends JpaRepository<Folders, Long>{
}
