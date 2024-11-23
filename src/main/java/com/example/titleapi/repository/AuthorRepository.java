package com.example.titleapi.repository;

import com.example.titleapi.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
}
