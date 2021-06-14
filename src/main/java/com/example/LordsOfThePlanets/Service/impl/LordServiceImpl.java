package com.example.LordsOfThePlanets.Service.impl;

import com.example.LordsOfThePlanets.Service.ILordService;
import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.repository.ILordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class LordServiceImpl implements ILordService {

    private final ILordDAO lordDAO;

    @Autowired
    public LordServiceImpl(ILordDAO lordDAO) {
        this.lordDAO = lordDAO;
    }

    @Override
    public Lord createLord(String name, Integer age) {
        Lord lord = new Lord();
        lord.setName(name);
        lord.setAge(age);
        lordDAO.createLord(lord);
        return lord;
    }

    @Override
    public List<Lord> findAll() {
        List<Lord> lords = lordDAO.findAll();
        return lords;
    }


    @Override
    public List<Lord> findAllFreeLords() {
        List<Lord> lords = lordDAO.findAll();
        for (Lord lord: lords){
            if (lord.getPlanets()==null){
            }
            else{
                return null;
            }
        }return lords;
    }

    @Override
    public List<Lord> findTop10ByYoungLords(Integer age, boolean initLazyObjects) {
        List<Lord> lord = lordDAO.getLordByAge(age, initLazyObjects);
        return lord;
    }

}