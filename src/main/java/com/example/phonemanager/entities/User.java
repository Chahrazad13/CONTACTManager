package com.example.phonemanager.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String imageURL;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Collection<Contact> contacts;
}
