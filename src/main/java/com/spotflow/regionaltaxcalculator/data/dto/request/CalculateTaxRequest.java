package com.spotflow.regionaltaxcalculator.data.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculateTaxRequest {
    private long serviceCode;
    private long regionId;
}
