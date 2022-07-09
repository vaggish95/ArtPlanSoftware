package com.artplansoftware.secondtask.controllers;

import com.artplansoftware.secondtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {
    UserService userService;

    @Autowired
    public ValidationController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/name_validation")
    public String nameValidation (String name ) {
        return userService.validateName(name);
    }

}
