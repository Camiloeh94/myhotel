package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "departments")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class DepartmentModel {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private Double id;

    @Column(name = "DEPARTMENT_NAME")
    private String name;

    @Column(name = "MANAGER_ID")
    private Double managerId;

    @Column(name = "LOCATION_ID")
    private Double location;
}
