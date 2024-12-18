package com.spotflow.regionaltaxcalculator.data.repository;

import com.spotflow.regionaltaxcalculator.data.models.Region;
import com.spotflow.regionaltaxcalculator.data.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    boolean existsByRegionAndServiceCode(Region region, long serviceCode);

    Services findServiceByServiceCodeAndRegion(long serviceCode, Region region);
}
