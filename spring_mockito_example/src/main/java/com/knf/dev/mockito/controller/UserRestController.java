package com.knf.dev.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.mockito.entity.User;
import com.knf.dev.mockito.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getAllEmployees() {
        return userService.getUserByName("sibin");
    }

}