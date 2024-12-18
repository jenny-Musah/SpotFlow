package com.spotflow.regionaltaxcalculator.service;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;


public interface RegionalServicesManagementService {



    CalculateTaxResponse calculateTax(CalculateTaxRequest calculateTaxRequest);
}
