package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.RegionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionModel, Double> {
}
