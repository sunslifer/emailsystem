package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.EmailsRepo;
import org.perscholas.emailsystem.dao.UsersRepo;
import org.perscholas.emailsystem.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Service
public class UsersServices{

    private UsersRepo usersRepo;
    private EmailsRepo emailsRepo;

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

    public String getFirstNameByUserName(String username, @NotNull @NotBlank String password) {
        return usersRepo.getByUserName(username).getFirstName();
    }

    public List<Users> getAllUsers(){ return usersRepo.findAll(); }

    public void updateUserFirstName(String username, String fname) {
        usersRepo.getByUserName(username).setFirstName(fname);
        log.info("update successful");
    }

    public Users getUserByUserNameAndPassword(String name, String pass) {
        return usersRepo.findByUserNameAndPassword(name, pass);
    }

}
