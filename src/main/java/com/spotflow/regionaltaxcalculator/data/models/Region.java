package com.spotflow.regionaltaxcalculator.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class Region {
    @Id
    private long regionId;
    private String regionName;
}
