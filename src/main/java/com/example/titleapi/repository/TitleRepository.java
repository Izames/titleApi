package com.example.titleapi.repository;

import com.example.titleapi.models.TitleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<TitleModel, Long> {
}
