package com.example.phonemanager.service;

import com.example.phonemanager.entities.User;
import com.example.phonemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userDB;


    public List<User> getAllUsers(){
        return userDB.findAll();
    }

    public Optional<User> verifyUser(String email, String password){
        List<User> users = getAllUsers();
        User validUser = new User();
        for (int i = 0; i <users.size(); i++) {
            if(email.equals(users.get(i).getEmail()) && password.equals(users.get(i).getPassword())){
                validUser = users.get(i);
                break;
            }
        }
        return Optional.of(validUser);
    }

    public User createUser(User user){
        return userDB.save(user);
    }

    public User editUser(User updateUser){
        return userDB.save(updateUser);
    }

    public Optional<User> findbyId(Long id) {
        return null;
    }
}
