package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobModel, String> {
}
