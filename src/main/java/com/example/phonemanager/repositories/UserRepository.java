package com.example.phonemanager.repositories;

import com.example.phonemanager.entities.Contact;
import com.example.phonemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
