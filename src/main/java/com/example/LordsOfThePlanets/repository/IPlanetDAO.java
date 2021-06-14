package com.example.LordsOfThePlanets.repository;

import com.example.LordsOfThePlanets.model.Planet;

import java.util.List;
import java.util.Optional;

public interface IPlanetDAO {

    void save(Planet planet);

    Optional<Planet> getById(Long id);

    List<Planet> findAll();

    void delete(Long id);
}
