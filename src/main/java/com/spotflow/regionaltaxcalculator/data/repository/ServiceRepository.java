package com.spotflow.regionaltaxcalculator.data.repository;

import com.spotflow.regionaltaxcalculator.data.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
