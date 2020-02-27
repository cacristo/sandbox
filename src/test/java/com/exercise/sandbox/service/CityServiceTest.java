package com.exercise.sandbox.service;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Test the business logic inside the {@link CityService}.
 * /!\ The tests below is a sample how to manage the elements for testing /!\
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.exercise.sandbox")
@ActiveProfiles("test")
public class CityServiceTest {

    @InjectMocks
    private CityServiceImpl cityService;

    @Mock
    private CityRepository mockCityRepository;

    @Test
    public void searchByPageNull() {
        Pageable pageConfiguration = PageRequest.of(0, 25);
        when(mockCityRepository.findAll(pageConfiguration)).thenReturn(null);
        Page<City> cities = cityService.searchByPage(pageConfiguration);
        assertNull(cities);
    }

    @Test
    public void searchByPage() {
        Pageable pageConfiguration = PageRequest.of(0, 25);
        Page<City> cityPageEmpty = Page.empty();
        when(mockCityRepository.findAll(pageConfiguration)).thenReturn(cityPageEmpty);
        Page<City> cities = cityService.searchByPage(pageConfiguration);
        assertNotNull(cities);
        assertEquals(1, cityPageEmpty.getTotalPages());
        assertEquals(0, cityPageEmpty.getTotalElements());
    }
}
