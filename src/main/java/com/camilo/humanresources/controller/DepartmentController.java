package com.camilo.humanresources.controller;

import com.camilo.humanresources.model.dto.AverageSalaryByDepartmentDTO;
import com.camilo.humanresources.model.dto.DepartmentsEmployeesSegmentsDTO;
import com.camilo.humanresources.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/segments")
    public ResponseEntity<List<DepartmentsEmployeesSegmentsDTO>> departmentsSegments() {
        return ResponseEntity.ok(departmentService.segmentsByDepartment());
    }

    @GetMapping("average-salaries")
    public ResponseEntity<List<AverageSalaryByDepartmentDTO>> averageSalary() {
        return ResponseEntity.ok(departmentService.averageSalaryByDepartment());
    }
}
