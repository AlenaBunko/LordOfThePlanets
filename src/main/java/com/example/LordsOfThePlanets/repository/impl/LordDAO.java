package com.example.LordsOfThePlanets.repository.impl;

import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.model.Planet;
import com.example.LordsOfThePlanets.repository.ILordDAO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class LordDAO implements ILordDAO {

    @PersistenceContext
    private EntityManager manager;

    private Session getSession() {
        return manager.unwrap(Session.class);
    }

    @Override
    public void createLord(Lord lord) {
        getSession().saveOrUpdate(lord);
    }

    @Override
    public List<Lord> findAll() {
        TypedQuery<Lord> query = manager.createQuery("SELECT l FROM Lord l", Lord.class);
        List<Lord> lords = query.getResultList();
        return lords;
    }

    @Override
    public List<Lord> getLordByAge(Integer age, boolean initLazyObjects) {
        TypedQuery<Lord> query = manager.createQuery("SELECT l FROM Lord l ORDER BY Age limit 10", Lord.class);
        query.setParameter("age", age);
        List<Lord> lords = query.getResultList();
        if(lords.isEmpty()){
            return null;
        }
        if (initLazyObjects){
            initLazyPlanets(lords);
        }
        return lords;
 //       return Optional.of(lords.get(10));
    }


    private void initLazyPlanets(List<Lord> lords) {
        for (Lord lord : lords) {
            for (Planet planet : lord.getPlanets()) {
                Hibernate.initialize(planet);
            }
        }
    }
}
