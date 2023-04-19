package org.example.controller;


import org.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    public void add(){
        userService.addService();
    }

    @Test
    public void addd(){
        userService.addService();
    }
}
