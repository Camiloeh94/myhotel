package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel, Double> {
}
