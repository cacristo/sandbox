package com.exercise.sandbox.web.webservices;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.repository.CityRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityWSTest extends AbstractRestTest {
    private static final String JSON_ATTRIBUTE_TOTAL_PAGES = "$.totalPages";
    private static final String JSON_ATTRIBUTE_TOTAL_ELEMENTS = "$.totalElements";

    @Autowired
    private CityRepository cityRepository;

    /**
     * Test to validate the default configuration with NO data.
     *
     * @throws {@link Exception}
     */
    @Test
    public void given01SimpleUrlWhenCallQueryByPageWSThenOK() throws Exception {
        String expectedJsonResult = loadResourceJson("json/EmptyResults.json");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/cities/queryByPage");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedJsonResult))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_PAGES).value(0))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_ELEMENTS).value(0))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Test to validate the specific configuration after have data.
     *
     * @throws {@link Exception}
     */
    @Test
    public void given02ComposedUrlWhenCallQueryByPageWSThenOK() throws Exception {
        String expectedJsonResult = loadResourceJson("json/SpecificConfigurationResults.json");

        insertDataH2Database();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/cities/queryByPage?page=1&size=2");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedJsonResult))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_PAGES).value(3))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_ELEMENTS).value(6))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Test to validate the default configuration after have data.
     *
     * @throws {@link Exception}
     */
    @Test
    public void given03SimpleUrlWhenCallQueryByPageWSThenOK() throws Exception {
        String expectedJsonResult = loadResourceJson("json/DefaultConfigurationResults.json");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/cities/queryByPage");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedJsonResult))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_PAGES).value(2))
                .andExpect(MockMvcResultMatchers.jsonPath(JSON_ATTRIBUTE_TOTAL_ELEMENTS).value(6))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Insert data for testing.
     */
    private void insertDataH2Database() {
        cityRepository.save(new City(1, "Faro"));
        cityRepository.save(new City(2, "Coimbra"));
        cityRepository.save(new City(3, "Lisboa"));
        cityRepository.save(new City(4, "Porto"));
        cityRepository.save(new City(5, "Aveiro"));
        cityRepository.save(new City(6, "Evora"));
    }

}
