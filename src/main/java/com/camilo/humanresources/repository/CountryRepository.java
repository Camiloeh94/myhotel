package com.camilo.humanresources.repository;

import com.camilo.humanresources.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryModel, String> {
}
