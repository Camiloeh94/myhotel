package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "locations")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class LocationModel {

    @Id
    @Column(name = "LOCATION_ID")
    private Double id;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @Column(name = "COUNTRY_ID")
    private String country;
}
