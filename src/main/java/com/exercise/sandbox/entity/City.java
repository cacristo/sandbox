package com.exercise.sandbox.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Entity City linked to table 'eurovisiondb'.'cities'.
 */
@Entity(name = "cities")
public class City implements Serializable {
    @Id
    private Integer id;
    private String name;

    /**
     * Empty default constructor.
     */
    public City() {
        /*empty constructor*/
    }

    /**
     * Constructor with attributes.
     *
     * @param id   Specifies the primary key of an entity
     * @param name Specifies the name of an entity
     */
    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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