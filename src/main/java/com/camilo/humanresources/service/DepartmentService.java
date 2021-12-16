package com.camilo.humanresources.service;

import com.camilo.humanresources.model.dto.AverageSalaryByDepartmentDTO;
import com.camilo.humanresources.model.dto.DepartmentsEmployeesSegmentsDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentsEmployeesSegmentsDTO> segmentsByDepartment();

    List<AverageSalaryByDepartmentDTO> averageSalaryByDepartment();
}
