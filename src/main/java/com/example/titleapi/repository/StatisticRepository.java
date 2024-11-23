package com.example.titleapi.repository;

import com.example.titleapi.models.StatisticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StatisticRepository extends JpaRepository<StatisticModel, Long> {

}
