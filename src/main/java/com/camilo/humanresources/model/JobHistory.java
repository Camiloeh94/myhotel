package com.camilo.humanresources.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "job_history")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class JobHistory implements Serializable{

    private static final long serialVersionUID = 5056538563998852048L;

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Double id;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "JOB_ID")
    private String job;

    @Column(name = "DEPARTMENT_ID")
    private Double department;
}
