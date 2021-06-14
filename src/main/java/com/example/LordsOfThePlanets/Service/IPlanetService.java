package com.example.LordsOfThePlanets.Service;

import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.model.Planet;

import java.util.List;

public interface IPlanetService {

    public Planet createPlanet(Lord lord, String name);

    List<Planet> findAll();

    void delete(Long id);

}
