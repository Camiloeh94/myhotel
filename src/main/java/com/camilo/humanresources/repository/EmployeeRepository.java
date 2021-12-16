package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Double> {

    List<EmployeeModel> findByDepartment(Double departmentId);
}
