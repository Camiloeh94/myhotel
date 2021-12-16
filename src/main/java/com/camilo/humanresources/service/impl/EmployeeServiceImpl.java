package com.camilo.humanresources.service.impl;

import com.camilo.humanresources.model.DepartmentModel;
import com.camilo.humanresources.model.dto.EmployeesSegmentsDTO;
import com.camilo.humanresources.model.EmployeeModel;
import com.camilo.humanresources.model.dto.MaxSalaryByDepartmentDTO;
import com.camilo.humanresources.repository.DepartmentRepository;
import com.camilo.humanresources.repository.EmployeeRepository;
import com.camilo.humanresources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeesSegmentsDTO findSegments() {
        EmployeesSegmentsDTO segments = new EmployeesSegmentsDTO();
        List<EmployeeModel> allEmployees = employeeRepository.findAll();
        List<EmployeeModel> a = new ArrayList<>();
        List<EmployeeModel> b = new ArrayList<>();
        List<EmployeeModel> c = new ArrayList<>();

        allEmployees.stream().forEach(e -> {
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

        return segments;
    }

    @Override
    public List<MaxSalaryByDepartmentDTO> maxSalaryByDepartment() {
        List<MaxSalaryByDepartmentDTO> list = new ArrayList<>();
        List<DepartmentModel> departments = departmentRepository.findAll();

        departments.stream().forEach(d -> {
            MaxSalaryByDepartmentDTO department = new MaxSalaryByDepartmentDTO();
            department.setDepartmentId(d.getId());
            department.setName(d.getName());
            department.setManagerId(d.getManagerId());
            department.setLocation(d.getLocation());

            List<EmployeeModel> employees = employeeRepository.findByDepartment(d.getId());
            EmployeeModel maxSaLaryEmployee = new EmployeeModel();
            maxSaLaryEmployee.setSalary(0.0);
            for(EmployeeModel e : employees) {
                if(maxSaLaryEmployee.getSalary() < e.getSalary()) {
                    maxSaLaryEmployee = e;
                }
            }
            department.setMaxSalaryEmployee(maxSaLaryEmployee);
            list.add(department);
        });
        return list;
    }

    @Override
    public List<EmployeeModel> ManagersOlderThan15Years() {
        List<EmployeeModel> managers = new ArrayList<>();
        List<EmployeeModel> allEmployees = employeeRepository.findAll();
        List<EmployeeModel> uniqueManagerId = allEmployees.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingDouble(EmployeeModel::getManagerId))),
                ArrayList::new
        ));

        uniqueManagerId.stream().forEach(e -> {
            if(e.getManagerId() == null || e.getManagerId() == 0.0) {
                managers.add(e);
            } else {
                managers.add(employeeRepository.findById(e.getManagerId()).get());
            }
        });

        managers.removeIf(m -> m.getHireDate().compareTo(LocalDateTime.now().minusYears(15L)) > 0);

        return managers;
    }
}
