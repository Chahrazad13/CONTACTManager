package com.example.phonemanager;

import com.example.phonemanager.entities.Contact;
import com.example.phonemanager.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PhoneManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneManagerApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ContactRepository contactRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Contact contact=new Contact();
                        contact.setId(contact.getId());
                        contact.setFirstname(name);
                        contact.setLastname("test");
                        contactRepository.save(contact);
                    });
        };}

}
