package com.exercise.sandbox.service;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service to manage City
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    /**
     * @see CityService#searchByPage(Pageable) for more information
     */
    @Override
    public Page<City> searchByPage(Pageable pageConfiguration) {
        return cityRepository.findAll(pageConfiguration);
    }
}
