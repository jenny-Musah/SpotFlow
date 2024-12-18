package com.spotflow.regionaltaxcalculator.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    private long id;
    private long serviceCode;
    private String serviceName;
    private double servicePrice;
    @ManyToOne
    private Region region;
}
