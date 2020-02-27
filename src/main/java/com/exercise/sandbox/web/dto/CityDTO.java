package com.exercise.sandbox.web.dto;

import com.exercise.sandbox.entity.City;

import java.io.Serializable;

/**
 * Data transfer object for {@link City} entity
 */
public class CityDTO implements Serializable {
    private Integer id;
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
