package com.spotflow.regionaltaxcalculator.util;


import com.spotflow.regionaltaxcalculator.data.models.Region;
import com.spotflow.regionaltaxcalculator.data.models.Services;
import com.spotflow.regionaltaxcalculator.data.repository.RegionRepository;
import com.spotflow.regionaltaxcalculator.data.repository.ServicesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataGenerator {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ServicesRepository servicesRepository;


    @PostConstruct
    public void init() {
        Region regionOne = regionRepository.save(createRegion(1,"Lagos"));
        Region regionTwo = regionRepository.save(createRegion(2,"Abuja"));
        Region regionThree = regionRepository.save(createRegion(3,"Osun"));

        servicesRepository.save(createService(1,5888,"Netflix Streaming Subscription ",600.00,regionOne));
        servicesRepository.save(createService(2,1000,"Udemy Course Payment",20.00,regionOne));
        servicesRepository.save(createService(3,5888,"Netflix Streaming Subscription",15.00,regionThree));
        servicesRepository.save(createService(4,1000,"Udemy Course Payment",5.10,regionTwo));

    }



    public Region createRegion(long regionId, String regionName ) {
            return   new Region(regionId, regionName);
    }

    public Services createService(long id,long serviceCode,String serviceName, double servicePrice, Region region) {

        return new Services(id,serviceCode,serviceName,servicePrice,region);
    }

}
