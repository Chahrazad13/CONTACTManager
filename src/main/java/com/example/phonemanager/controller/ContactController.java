package com.example.phonemanager.controller;

import com.example.phonemanager.entities.Contact;
import com.example.phonemanager.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ContactController {

    ContactRepository contactRepository;

    @GetMapping("/contact_register")
    public String contactRegister() {
        return "registerContact";
    }
    @PostMapping("/save")
    public void saveContact(@ModelAttribute Contact contact){
        contactRepository.save(contact);
    }
}
