package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "countries")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CountryModel {

    @Id
    @Column(name = "COUNTRY_ID")
    private String id;

    @Column(name = "COUNTRY_NAME")
    private String name;

    @Column(name = "REGION_ID")
    private Double region;
}
