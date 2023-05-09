package com.example.phonemanager.service;

import com.example.phonemanager.entities.Contact;
import com.example.phonemanager.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public Optional<Contact> findbyId(Long id){
        return contactRepository.findById(id);
    }

    public Contact save(Contact contact){
      return contactRepository.save(contact);

    }

    public List<Contact> findAll(){
        List<Contact> contacts = new ArrayList<>();
        return contacts = contactRepository.findAll();}

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
    }

