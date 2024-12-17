package com.spotflow.regionaltaxcalculator.data.dto.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculateTaxResponse {
    private double servicePrice;
    private double governmentTax;
    private double importDuty;
    private double totalPrice;
}
