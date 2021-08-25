package org.perscholas.emailsystem;

import lombok.extern.java.Log;
import org.perscholas.emailsystem.dao.UsersRepo;
import org.perscholas.emailsystem.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Log
@Transactional
public class AppRunner implements CommandLineRunner {
    UsersRepo usersRepo;
    UsersServices usersServices;

    @Autowired
    public AppRunner(UsersRepo usersRepo, UsersServices usersServices){
        this.usersRepo = usersRepo;
        this.usersServices = usersServices;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("--------------START--------------");
        log.info("--------------ADDING INFO--------------");

        usersServices.registerUser("admin", "pass", "Kyle", "Wilson");
        usersServices.registerUser("123", "123", "Bob", "Smith");

    }
}
