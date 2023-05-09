package com.example.phonemanager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String imageURL;
    @ManyToMany
    private Collection<User> users;
}
