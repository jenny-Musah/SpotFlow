package com.spotflow.regionaltaxcalculator.data.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
public class Service {
    @Id
    private long serviceCode;
    private String serviceName;
    private double servicePrice;
}
