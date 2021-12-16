package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Double> {
}
