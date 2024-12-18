package com.spotflow.regionaltaxcalculator.controller;

import com.spotflow.regionaltaxcalculator.data.dto.request.CalculateTaxRequest;
import com.spotflow.regionaltaxcalculator.data.dto.response.CalculateTaxResponse;
import com.spotflow.regionaltaxcalculator.data.dto.response.ListOfServicesResponse;
import com.spotflow.regionaltaxcalculator.service.RegionalServiceTaxManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regional/")
public class RegionalTaxCalculatorController {


    @Autowired
    RegionalServiceTaxManagementService regionalServiceTaxManagementService;


    @PostMapping("calculate-tax")
    public ResponseEntity<CalculateTaxResponse> calculateTax(@RequestBody CalculateTaxRequest request, @RequestParam(value = "region-id") Long regionId) {
        return ResponseEntity.ok(regionalServiceTaxManagementService.calculateTax(request, regionId));
    }

    @GetMapping("services")
    public ResponseEntity<List<ListOfServicesResponse>> listOfRegionalServices(@RequestParam(name = "region-id") Long regionId) {

        return ResponseEntity.ok(regionalServiceTaxManagementService.getAllServicesInARegion(regionId));
    }



}
