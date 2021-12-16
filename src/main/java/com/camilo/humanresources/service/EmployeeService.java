package com.camilo.humanresources.service;

import com.camilo.humanresources.model.EmployeeModel;
import com.camilo.humanresources.model.dto.EmployeesSegmentsDTO;
import com.camilo.humanresources.model.dto.MaxSalaryByDepartmentDTO;

import java.util.List;

public interface EmployeeService {

    EmployeesSegmentsDTO findSegments();

    List<MaxSalaryByDepartmentDTO> maxSalaryByDepartment();

    List<EmployeeModel> ManagersOlderThan15Years();
}
