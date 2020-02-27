package com.exercise.sandbox.web.mapper;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.web.dto.CityDTO;
import com.exercise.sandbox.web.dto.CityDTOResults;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper to {@link City} <-> {@link CityDTO} or related objects to City
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CityMapper {

    public abstract CityDTO fromEntity(City city);

    public CityDTOResults toDTOResults(Page<City> pageResult) {
        CityDTOResults cityDTOResults = new CityDTOResults();
        if (pageResult == null) {
            return cityDTOResults;
        }
        cityDTOResults.setResults(pageResult.getContent().stream().map(this::fromEntity).collect(Collectors.toList()));
        cityDTOResults.setTotalPages(pageResult.getTotalPages());
        cityDTOResults.setTotalElements(pageResult.getTotalElements());
        return cityDTOResults;
    }
}
