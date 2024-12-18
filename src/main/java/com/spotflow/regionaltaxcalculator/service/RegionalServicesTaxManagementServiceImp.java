package com.spotflow.regionaltaxcalculator.service;


import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;
import com.spotflow.regionaltaxcalculator.data.models.Region;
import com.spotflow.regionaltaxcalculator.data.models.Services;
import com.spotflow.regionaltaxcalculator.data.repository.RegionRepository;
import com.spotflow.regionaltaxcalculator.data.repository.ServicesRepository;
import com.spotflow.regionaltaxcalculator.util.RegionalTaxCalculatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalServicesTaxManagementServiceImp implements RegionalServiceTaxManagementService {

    @Autowired
    ServicesRepository servicesRepository;

    @Autowired
    RegionRepository regionRepository;




    @Override
    public CalculateTaxResponse calculateTax(CalculateTaxRequest calculateTaxRequest, Long regionId) throws RegionalTaxCalculatorException {
        if(isCalculateTaxRequestValid(calculateTaxRequest, regionId)) {
            Services services = findService(calculateTaxRequest.getServiceCode(),regionId);
            double price = services.getServicePrice();
            return calculatedTaxResponse(price,calculateGovernmentTax(price));
        }
        throw new RegionalTaxCalculatorException("Invalid Input");
    }

    private CalculateTaxResponse calculatedTaxResponse(double price, double governmentTax) {
        CalculateTaxResponse calculateTaxResponse = new CalculateTaxResponse();
        calculateTaxResponse.setServicePrice("$"+price);
        calculateTaxResponse.setGovernmentTax("$"+governmentTax);
        calculateTaxResponse.setTotalPrice("$"+ (price + governmentTax + 0.5));
        return calculateTaxResponse;
    }



    private double calculateGovernmentTax(Double price){
        return price * 0.05;
    }

    private Services findService(Long serviceCode, Long regionId) throws RegionalTaxCalculatorException {
        return  servicesRepository.findServiceByServiceCodeAndRegion(serviceCode,findRegion(regionId));


    }

    private Region findRegion(Long regionId) {
        return regionRepository.findByRegionId(regionId);
    }

    private boolean isCalculateTaxRequestValid(CalculateTaxRequest calculateTaxRequest,Long regionId) throws RegionalTaxCalculatorException {
        if(calculateTaxRequest == null) return false;
        if(regionRepository.findById(regionId).isEmpty()) return false;
        if(!servicesRepository.existsByRegionAndServiceCode(findRegion(regionId), calculateTaxRequest.getServiceCode())) return false;
        else return true;
    }



}
