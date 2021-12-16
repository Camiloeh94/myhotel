package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jobs")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobModel {

    @Id
    @Column(name = "JOB_ID")
    private String id;

    @Column(name = "JOB_TITLE")
    private String title;

    @Column(name = "MIN_SALARY")
    private Double minSalary;

    @Column(name = "MAX_SALARY")
    private Double maxSalary;
}
