package com.exercise.sandbox.web.mapper;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.web.dto.CityDTOResults;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;

/**
 * Test class for {@link CityMapper}
 */
@RunWith(PowerMockRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityMapperTest {
    @InjectMocks
    private CityMapperImpl mockCityMapper;

    /**
     * Test the given the {@link Page< City>} transform it into the {@link CityDTOResults}
     */
    @Test
    public void givenPageCityWhenRemapToDTOResultsThenOk() {
        // complete the test
    }
}
