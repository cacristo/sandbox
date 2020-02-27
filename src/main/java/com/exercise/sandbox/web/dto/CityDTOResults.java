package com.exercise.sandbox.web.dto;

import com.exercise.sandbox.web.webservices.CityWS;

import java.io.Serializable;
import java.util.List;

/**
 * Object used as response of {@link CityWS#getCities(Integer, Integer)}
 */
public class CityDTOResults implements Serializable {
    private List<CityDTO> results;
    private int totalPages;
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
