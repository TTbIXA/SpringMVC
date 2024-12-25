package com.example.userlist.controller;

import com.example.userlist.model.User;
import com.example.userlist.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        userService.getAllUsers().add(new User("Alice", "alice@example.com"));
        userService.getAllUsers().add(new User("Bob", "bob@example.com"));
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userlist";
    }
}