package com.example.phonemanager.controller;

import com.example.phonemanager.dto.LoginDto;
import com.example.phonemanager.entities.User;
import com.example.phonemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController  {

    @Autowired
    UserService userService;

    @GetMapping("/create-user")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "loginUser";
    }

    @PostMapping("/save-user")
    public String addUser(@ModelAttribute User user) {
       userService.createUser(user);
       return "redirect:/all_Contacts";
    }

    @PostMapping("/verify-user")
    public String verifyUser(@ModelAttribute LoginDto loginDto) {
        if(userService.verifyUser(loginDto.getEmail(), loginDto.getPassword()).isEmpty()){
            User user = userService.verifyUser(loginDto.getEmail(), loginDto.getPassword()).get();
            System.out.println("Connected User: "+user.getFirstname());
            return "redirect:/all_Contacts";
        }else {
            return "redirect:/";
        }
    }



    @RequestMapping("/editUser/{id}")//DONE
    public String editUser(@PathVariable("id") Long id, Model model) {
        Optional<User> updatedUser = userService.findbyId(id);
        model.addAttribute("user", updatedUser);
        return "editUser";
    }


}
