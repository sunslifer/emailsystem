package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.AuthGroupsRepo;
import org.perscholas.emailsystem.models.AuthGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthGroupsServices {

    private AuthGroupsRepo authGroupsRepo;

    @Autowired
    public AuthGroupsServices(AuthGroupsRepo authGroupsRepo) {
        this.authGroupsRepo = authGroupsRepo;
    }

    public void save(AuthGroups authGroups){
        authGroupsRepo.save(authGroups);
    }

    public AuthGroups getByName(String name) {
        return authGroupsRepo.getByUsername(name);
    }
}
