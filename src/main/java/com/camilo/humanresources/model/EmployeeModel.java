package com.camilo.humanresources.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "employees")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeModel {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Double id;

    @Column(name = "FIRST_NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phone;

    @Column(name = "HIRE_DATE")
    private LocalDateTime hireDate;

    @Column(name = "JOB_ID")
    private String job;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "COMMISSION_PCT")
    private Double commission;

    @Column(name = "MANAGER_ID")
    private Double managerId;

    @Column(name = "DEPARTMENT_ID")
    private Double department;
}
