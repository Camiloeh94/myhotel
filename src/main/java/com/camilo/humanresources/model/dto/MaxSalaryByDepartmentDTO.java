package com.camilo.humanresources.model.dto;

import com.camilo.humanresources.model.EmployeeModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaxSalaryByDepartmentDTO {

    private Double departmentId;
    private String name;
    private Double managerId;
    private Double location;
    private EmployeeModel maxSalaryEmployee;
}
