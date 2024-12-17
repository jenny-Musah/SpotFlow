package com.spotflow.regionaltaxcalculator.controller;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;
import com.spotflow.regionaltaxcalculator.data.dto.response.ListOfServicesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("regional-tax/")
public class RegionalTaxCalculatorController {


    @PostMapping("calculate-tax")
    public ResponseEntity<CalculateTaxResponse> calculateTax(CalculateTaxRequest request) {
        return null;
    }

    @GetMapping("regional-services")
    public ResponseEntity<List<ListOfServicesResponse>> listOfRegionalServices(){

        return null;
    }



}
