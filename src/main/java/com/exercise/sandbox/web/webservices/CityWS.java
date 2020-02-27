package com.exercise.sandbox.web.webservices;

import com.exercise.sandbox.entity.City;
import com.exercise.sandbox.service.CityService;
import com.exercise.sandbox.web.dto.CityDTOResults;
import com.exercise.sandbox.web.mapper.CityMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Api(value = "/cities")
@RestController
@RequestMapping(value = "/cities")
public class CityWS {
    private static final Logger LOG = LoggerFactory.getLogger(CityWS.class);

    @Autowired
    private CityService cityService;
    @Autowired
    private CityMapper cityMapper;

    /**
     * Retrieve list of {@link City} according the pagination parameter.
     *
     * @param page the page location
     * @param size the {@link City} elements page size
     * @return {@link Page<City>}
     */
    @ApiOperation(value = "City list.",
            notes = "Retrieve list of 'City' according the pagination parameter.")
    @GetMapping(value = "/queryByPage")
    @CrossOrigin(origins = "*")
    public CityDTOResults getCities(
            //@ApiParam(value = "Page Id location", required = true,  defaultValue = "0")
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            //@ApiParam(value = "The city elements page size", required = true, defaultValue = "5")
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        LOG.info("GET /queryByPage");
        Pageable pageConfiguration = PageRequest.of(page, size);
        return cityMapper.toDTOResults(cityService.searchByPage(pageConfiguration));
    }
}
