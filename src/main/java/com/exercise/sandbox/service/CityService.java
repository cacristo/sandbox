package com.exercise.sandbox.service;

import com.exercise.sandbox.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface City
 */
@FunctionalInterface
public interface CityService {

    /**
     * Retrieve list according the pagination parameter.
     *
     * @param pageConfiguration the configuration related to the pagination
     * @return {@link Page<City>}
     */
    Page<City> searchByPage(Pageable pageConfiguration);
}
