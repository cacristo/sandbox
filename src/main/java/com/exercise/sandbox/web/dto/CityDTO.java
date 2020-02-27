package com.exercise.sandbox.web.dto;

import com.exercise.sandbox.entity.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Data transfer object for {@link City} entity
 */
@ApiModel(description = "Data transfer object of City.")
public class CityDTO implements Serializable {
    @ApiModelProperty(value = "Specifies the unique identifier (primary key) of a City entity")
    private Integer id;
    @ApiModelProperty(value = "Specifies the name of a City entity")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
