package com.example.controller;

import com.example.models.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
   private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    //http://localhost:/9090/home/users
    @GetMapping("/getAllusers")
    public List<User> getUser(){
        System.out.println("getting users");
        return userRepository.findAll();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }



}
