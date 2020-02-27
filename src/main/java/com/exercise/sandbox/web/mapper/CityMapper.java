package com.exercise.sandbox.web.mapper;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.web.dto.CityDTO;
import com.exercise.sandbox.web.dto.CityDTOResults;
import com.exercise.sandbox.web.webservices.CityWS;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

/**
 * Mapper to {@link City} <-> {@link CityDTO} or related objects to City
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CityMapper {

    /**
     * Map {@link City} element into {@link CityDTO}.
     *
     * @param city {@link City}
     * @return {@link CityDTO}
     */
    public abstract CityDTO fromEntity(City city);

    /**
     * Map {@link Page<City>} elements paginated into {@link CityDTOResults} to be used as response at {@link CityWS}
     *
     * @param pageResult {@link Page<City>} elements paginated
     * @return {@link CityDTOResults}
     */
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
