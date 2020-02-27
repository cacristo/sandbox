package com.exercise.sandbox.repository;

import com.exercise.sandbox.entity.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test to validate the database configuration
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CityRepositoryIntegrationTest {
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void whenCalledSaveThenCorrectNumberOfCities() {
        cityRepository.save(new City(1, "Madrid"));
        List<City> cities = cityRepository.findAll();

        Assert.assertEquals(1, cities.size());
    }
}
