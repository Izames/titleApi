package com.example.titleapi.repository;

import com.example.titleapi.models.FioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FioRepository extends JpaRepository<FioModel, Long> {
}
