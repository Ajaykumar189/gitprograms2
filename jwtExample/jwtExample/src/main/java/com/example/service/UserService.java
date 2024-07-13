package com.example.service;

import com.example.models.User;

import java.util.List;

public interface UserService {
     public User addUser(User user);

     public List<User> getAllUsers();
}
