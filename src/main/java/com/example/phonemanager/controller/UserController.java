package com.example.phonemanager.controller;

import com.example.phonemanager.entities.User;
import com.example.phonemanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController extends ContactController {
    @Autowired
    ContactService contactService;


}
