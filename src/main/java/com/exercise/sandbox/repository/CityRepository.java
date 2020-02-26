package com.exercise.sandbox.repository;

import com.exercise.sandbox.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link City} entity
 */
public interface CityRepository extends JpaRepository<City, Integer> {
}
