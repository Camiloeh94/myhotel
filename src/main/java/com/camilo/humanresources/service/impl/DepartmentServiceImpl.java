package com.camilo.humanresources.service.impl;

import com.camilo.humanresources.model.DepartmentModel;
import com.camilo.humanresources.model.EmployeeModel;
import com.camilo.humanresources.model.dto.AverageSalaryByDepartmentDTO;
import com.camilo.humanresources.model.dto.DepartmentsEmployeesSegmentsDTO;
import com.camilo.humanresources.model.dto.EmployeesSegmentsDTO;
import com.camilo.humanresources.repository.DepartmentRepository;
import com.camilo.humanresources.repository.EmployeeRepository;
import com.camilo.humanresources.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentsEmployeesSegmentsDTO> segmentsByDepartment() {
        List<DepartmentModel> departments = departmentRepository.findAll();
        List<DepartmentsEmployeesSegmentsDTO> departmentsSegments = new ArrayList<>();

        departments.stream().forEach(d -> {
            DepartmentsEmployeesSegmentsDTO department = new DepartmentsEmployeesSegmentsDTO();
            department.setDepartmentId(d.getId());
            department.setName(d.getName());
            department.setManagerId(d.getManagerId());
            department.setLocation(d.getLocation());

            EmployeesSegmentsDTO segments = new EmployeesSegmentsDTO();
            List<EmployeeModel> employees = employeeRepository.findByDepartment(d.getId());
            List<EmployeeModel> a = new ArrayList<>();
            List<EmployeeModel> b = new ArrayList<>();
            List<EmployeeModel> c = new ArrayList<>();
            employees.stream().forEach(e -> {
                if(e.getSalary() < Double.valueOf(3500)) {
                    a.add(e);
                } else if (e.getSalary() >= Double.valueOf(3500) && e.getSalary() < Double.valueOf(8000)) {
                    b.add(e);
                } else if (e.getSalary() >= Double.valueOf(8000)) {
                    c.add(e);
                }
            } );
            segments.setSegmentA(a);
            segments.setSegmentB(b);
            segments.setSegmentC(c);
            department.setSegments(segments);

            departmentsSegments.add(department);
        });

        return departmentsSegments;
    }

    @Override
    public List<AverageSalaryByDepartmentDTO> averageSalaryByDepartment() {
        List<AverageSalaryByDepartmentDTO> averageSalaryByDepartmentList = new ArrayList<>();
        List<DepartmentModel> allDepartments = departmentRepository.findAll();

        allDepartments.stream().forEach(d -> {
            AverageSalaryByDepartmentDTO department = new AverageSalaryByDepartmentDTO();
            department.setDepartmentId(d.getId());
            department.setName(d.getName());
            department.setManagerId(d.getManagerId());
            department.setLocation(d.getLocation());

            List<EmployeeModel> employeesByDepartment = employeeRepository.findByDepartment(d.getId());

            Double salaries = 0.0;
            for(EmployeeModel e : employeesByDepartment) {
                salaries = salaries + e.getSalary();
            }
            Double averageSalaries = salaries / Double.valueOf(employeesByDepartment.size());
            department.setAverageSalary(averageSalaries);

            averageSalaryByDepartmentList.add(department);
        });
        return  averageSalaryByDepartmentList;
    }
}
