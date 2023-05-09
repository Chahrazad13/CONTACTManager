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
    @ManyToOne
    @JoinTable(
            name = "contact_users",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private User user;
}
