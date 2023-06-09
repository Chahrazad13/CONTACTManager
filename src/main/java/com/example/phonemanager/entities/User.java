package com.example.phonemanager.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String imageURL;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinTable(
            name = "contact_users",
           joinColumns = @JoinColumn(name = "users_id"),
           inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Collection<Contact> contactsList;

}
