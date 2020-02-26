package com.exercise.sandbox.web.mapper;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.web.dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper to {@link City} <-> {@link CityDTO}
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CityMapper {
}
