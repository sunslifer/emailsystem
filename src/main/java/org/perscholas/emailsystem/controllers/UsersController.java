package org.perscholas.emailsystem.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.UsersRepo;
import org.perscholas.emailsystem.models.Users;
import org.perscholas.emailsystem.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UsersController {

    private UsersServices usersServices;
    private UsersRepo usersRepo;

    @Autowired
    public UsersController(UsersServices usersServices, UsersRepo usersRepo) {
        this.usersServices = usersServices;
        this.usersRepo = usersRepo;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") Users user) {
        usersRepo.save(user);
        return "register_success";
    }

    @RequestMapping("/listusers")
    public String listUsers(Model model) {
        model.addAttribute("users", usersServices.getAllUsers());
        return "listusers";
    }

    @RequestMapping("/account")
    public String updateAccount(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "account";
    }

    @PostMapping("/account")
    public String submitUpdate(@ModelAttribute("user")Users user) {
        usersServices.updateUserFirstName("admin", user.getFirstName());
        return "accountupdated";
    }
}
