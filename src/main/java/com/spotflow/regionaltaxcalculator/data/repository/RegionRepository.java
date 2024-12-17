package com.spotflow.regionaltaxcalculator.data.repository;

import com.spotflow.regionaltaxcalculator.data.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
