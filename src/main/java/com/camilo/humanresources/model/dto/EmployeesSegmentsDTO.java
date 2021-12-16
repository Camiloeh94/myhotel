package com.camilo.humanresources.model.dto;

import com.camilo.humanresources.model.EmployeeModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EmployeesSegmentsDTO {

    private List<EmployeeModel> segmentA;
    private List<EmployeeModel> segmentB;
    private List<EmployeeModel> segmentC;
}
