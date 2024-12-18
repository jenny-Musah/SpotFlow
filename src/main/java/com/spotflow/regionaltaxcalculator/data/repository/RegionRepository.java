package com.spotflow.regionaltaxcalculator.data.repository;

import com.spotflow.regionaltaxcalculator.data.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findByRegionId(Long id);


}
