package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Double> {
}
