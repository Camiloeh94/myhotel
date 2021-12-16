package com.camilo.humanresources.controller;

import com.camilo.humanresources.model.EmployeeModel;
import com.camilo.humanresources.model.dto.EmployeesSegmentsDTO;
import com.camilo.humanresources.model.dto.MaxSalaryByDepartmentDTO;
import com.camilo.humanresources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/segments")
    public ResponseEntity<EmployeesSegmentsDTO> segments() {
        return ResponseEntity.ok(employeeService.findSegments());
    }

    @GetMapping("/departments/max-salary")
    public ResponseEntity<List<MaxSalaryByDepartmentDTO>> maxSalaryByDepartment() {
        return ResponseEntity.ok(employeeService.maxSalaryByDepartment());
    }

    @GetMapping("/managers")
    public ResponseEntity<List<EmployeeModel>> oldersManagers() {
        return ResponseEntity.ok(employeeService.ManagersOlderThan15Years());
    }
}
