package com.example.LordsOfThePlanets.repository.impl;

import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.model.Planet;
import com.example.LordsOfThePlanets.repository.IPlanetDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PlanetDAO implements IPlanetDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Planet planet) {
        manager.persist(planet);
    }

    @Override
    public Optional<Planet> getById(Long id) {
        return Optional.of(manager.find(Planet.class, id));
    }

    @Override
    public List<Planet> findAll() {
        TypedQuery<Planet> query = manager.createQuery("SELECT p FROM Planet p", Planet.class);
        List<Planet> planets = query.getResultList();
        return planets;
    }

    @Override
    public void delete(Long id) {
        manager.createNamedQuery(Planet.DELETE_QUERY).setParameter("id", id).executeUpdate();
    }
}
