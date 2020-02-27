package com.exercise.sandbox.web.dto;

import com.exercise.sandbox.web.webservices.CityWS;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Object used as response of {@link CityWS#getCities(Integer, Integer)}
 */
@ApiModel(description = "Data transfer object with the content elements  {CityDTO} paginated and complementary information about pagination.")
public class CityDTOResults implements Serializable {
    @ApiModelProperty(value = "Returns a new 'page' with the content of the current {CityDTO}")
    private List<CityDTO> results;
    @ApiModelProperty(value = "the number of total pages")
    private int totalPages;
    @ApiModelProperty(value = "The total amount of elements paginated.")
    private long totalElements;

    public List<CityDTO> getResults() {
        return results;
    }

    public void setResults(List<CityDTO> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
