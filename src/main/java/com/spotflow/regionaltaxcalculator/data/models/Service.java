package com.spotflow.regionaltaxcalculator.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Service {
    @Id
    private long id;
    private long serviceCode;
    private String serviceName;
    private double servicePrice;
    @OneToOne
    private Region region;
}
