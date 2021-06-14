package com.example.LordsOfThePlanets.Service.impl;

import com.example.LordsOfThePlanets.Service.IPlanetService;
import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.model.Planet;
import com.example.LordsOfThePlanets.repository.IPlanetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements IPlanetService {

    private final IPlanetDAO planetDAO;

    @Autowired
    public PlanetServiceImpl(IPlanetDAO planetDAO) {
        this.planetDAO = planetDAO;
    }

    @Override
    public Planet createPlanet(Lord lord, String name) {
        Planet planet = new Planet();
        planet.setPlanetName(name);
        planet.setLord(lord);
        planetDAO.save(planet);
        return planet;
    }

    @Override
    public List<Planet> findAll() {
        List<Planet> planets = planetDAO.findAll();
        return planets;
    }


    @Override
    public void delete(Long id) {
        planetDAO.delete(id);
    }
}
