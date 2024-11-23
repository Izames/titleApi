package com.example.titleapi.repository;

import com.example.titleapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByLogin(String login);
}
