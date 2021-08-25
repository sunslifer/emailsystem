package org.perscholas.emailsystem.dao;

import org.perscholas.emailsystem.models.AuthGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupsRepo extends JpaRepository<AuthGroups, Long>{
    public AuthGroups getByUsername(String name);
}
