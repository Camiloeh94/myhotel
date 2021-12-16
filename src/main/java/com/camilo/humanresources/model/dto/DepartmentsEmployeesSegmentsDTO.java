package com.camilo.humanresources.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentsEmployeesSegmentsDTO {

    private Double departmentId;
    private String name;
    private Double managerId;
    private Double location;
    private EmployeesSegmentsDTO segments;
}
