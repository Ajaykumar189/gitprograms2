package com.example.service;

import com.example.models.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<User> store = new ArrayList<>();


//    public UserServiceImpl(){
//       store.add(new User(UUID.randomUUID().toString(),"Ajay","ajay@dev.in"));
//       store.add(new User(UUID.randomUUID().toString(),"Ramesh","ramu@dev.in"));
//       store.add(new User(UUID.randomUUID().toString(),"Arjun","arjun@dev.in"));
//       store.add(new User(UUID.randomUUID().toString(),"Pramod","pramod@dev.in"));
//
//    }



    public List<User> getUsers(){
        return this.store;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
