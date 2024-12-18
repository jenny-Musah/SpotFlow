package com.spotflow.regionaltaxcalculator.data.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOfServicesResponse {
    private String serviceName;
    private long serviceCode;
    private String servicePrice;
    private Long  RegionId;
}
