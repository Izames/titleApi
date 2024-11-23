package com.example.titleapi.repository;

import com.example.titleapi.models.MangaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<MangaModel, Long> {
}
