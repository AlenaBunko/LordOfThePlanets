package com.example.LordsOfThePlanets.Service;

import com.example.LordsOfThePlanets.model.Lord;

import java.util.List;

public interface ILordService {

    Lord createLord (String name, Integer age);

    List<Lord> findAll();

    List<Lord> findAllFreeLords ();

    List<Lord> findTop10ByYoungLords (Integer age, boolean initLazyObjects);
}
