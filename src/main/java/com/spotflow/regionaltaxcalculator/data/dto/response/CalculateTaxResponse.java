package com.spotflow.regionaltaxcalculator.data.dto.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculateTaxResponse {
    private String servicePrice;
    private String governmentTax;
final private String importDuty = "$0.5";
    private String totalPrice;
}
