package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "regions")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegionModel {

    @Id
    @Column(name = "REGION_ID")
    private Double id;

    @Column(name = "REGION_NAME")
    private String name;
}
