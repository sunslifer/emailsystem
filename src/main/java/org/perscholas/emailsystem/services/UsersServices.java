package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.UsersRepo;
import org.perscholas.emailsystem.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsersServices{

    private UsersRepo usersRepo;

    @Autowired
    public UsersServices(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public void registerUser(String username, String password, String firstname, String lastname){
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);

        usersRepo.save(user);
    }

    public Users getUserByUserName(String username) {
        return usersRepo.getByUserName(username);
    }

}
