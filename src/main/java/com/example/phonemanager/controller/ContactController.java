package com.example.phonemanager.controller;

import com.example.phonemanager.entities.Contact;
import com.example.phonemanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/all_Contacts")//DONE
    public ModelAndView getAllContacts() {
        List<Contact> list = new ArrayList<>();
        list = contactService.findAll();
        return new ModelAndView("allContacts", "contact", list);
    }

    @GetMapping("/save")
    public String addContact(Model model) {
        Contact contact;
        model.addAttribute("contact", new Contact());

        return "registerContact";
    }

    @PostMapping("/save")
    public String SaveContact(@ModelAttribute Contact contact) {
        System.out.println("Contact: "+contact.getFirstname());
        contactService.save(contact);

        return "redirect:/all_Contacts";
    }

    @RequestMapping(value = "/{id}")
    public Optional<Contact> getContactbyId(@PathVariable Long id) {
        return contactService.findbyId(id);
    }

    @RequestMapping("/editContact/{id}")//DONE
    public String editContact(@PathVariable("id") Long id, Model model) {
        Optional<Contact> contact = contactService.findbyId(id);
        model.addAttribute("contact", contact);
        return "editContact";
    }

    @GetMapping("/deleteContact/{id}")//DONE
    public String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteById(id);
        return "redirect:/all_Contacts";
    }
}
