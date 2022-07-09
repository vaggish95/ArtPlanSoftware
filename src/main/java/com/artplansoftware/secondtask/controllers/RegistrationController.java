package com.artplansoftware.secondtask.controllers;

import com.artplansoftware.secondtask.entity.User;
import com.artplansoftware.secondtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public void addUser (@RequestBody User user,  HttpServletRequest request) {
        userService.addNewUser(user, request);
    }


}
