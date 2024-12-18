package com.spotflow.regionaltaxcalculator.service;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;



public interface RegionalServiceTaxManagementService {



    CalculateTaxResponse calculateTax(CalculateTaxRequest calculateTaxRequest, Long regionId);
}
