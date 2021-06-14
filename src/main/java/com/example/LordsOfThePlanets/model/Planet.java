package com.example.LordsOfThePlanets.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "planet")
@JsonIgnoreProperties(value = { "lord" })
@NamedQueries({@NamedQuery(query = "delete from Planet where id=:id", name = Planet.DELETE_QUERY)})
public class Planet {

    public static final String DELETE_QUERY = "delete.planet";

    private Long id;

    private String planetName;

    private Lord lord;

    public Planet(String planetName, Lord lord) {
        this.planetName = planetName;
        this.lord = lord;
    }

    public Planet() {
    }

    @Id
    @GeneratedValue
    @Column(name="planetId")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "planet_name")
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lordId")
    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }
}
