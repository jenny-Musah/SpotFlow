package com.spotflow.regionaltaxcalculator.service;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;
import com.spotflow.regionaltaxcalculator.data.dto.response.ListOfServicesResponse;
import com.spotflow.regionaltaxcalculator.data.models.Services;

import java.security.Provider;
import java.util.List;


public interface RegionalServiceTaxManagementService {



    CalculateTaxResponse calculateTax(CalculateTaxRequest calculateTaxRequest, Long regionId);

    List<ListOfServicesResponse> getAllServicesInARegion(Long regionId);
}
