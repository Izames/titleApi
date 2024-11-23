package com.example.titleapi.repository;

import com.example.titleapi.models.AnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnimeRepository extends JpaRepository<AnimeModel, Long> {
}
