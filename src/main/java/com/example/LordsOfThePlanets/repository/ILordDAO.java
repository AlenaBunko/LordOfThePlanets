package com.example.LordsOfThePlanets.repository;

import com.example.LordsOfThePlanets.model.Lord;

import java.util.List;

public interface ILordDAO {

    void createLord(Lord lord);

    List<Lord> findAll();

    List<Lord> getLordByAge(Integer age, boolean initLazyObjects);

}
