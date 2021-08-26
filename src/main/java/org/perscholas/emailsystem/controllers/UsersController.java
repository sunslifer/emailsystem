package org.perscholas.emailsystem.controllers;

import org.perscholas.emailsystem.models.Users;
import org.perscholas.emailsystem.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UsersController {

    private UsersServices usersServices;

    @Autowired
    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping("/listusers")
    public String listUsers(Model model) {
        model.addAttribute("users", usersServices.getAllUsers());
        return "listusers";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        return "/adduser";
    }
}
