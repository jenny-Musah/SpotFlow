package com.spotflow.regionaltaxcalculator.data.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Table
public class Region {
    @Id
    private long regionId;
    private String regionName;
    private List<Service> services;
}
