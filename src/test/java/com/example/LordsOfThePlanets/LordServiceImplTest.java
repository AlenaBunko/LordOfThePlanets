package com.example.LordsOfThePlanets;

import com.example.LordsOfThePlanets.Service.impl.LordServiceImpl;
import com.example.LordsOfThePlanets.model.Lord;
import com.example.LordsOfThePlanets.repository.impl.LordDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LordServiceImplTest {

    @Autowired
    private LordServiceImpl lordService;

    @MockBean
    private LordDAO lordDAO;


    @Test
    public void addLordTest() {
        Lord lord = new Lord();
        lord = lordService.createLord("Igor", 65);

        Assert.assertNotNull(lord);
        Mockito.verify(lordDAO, Mockito.times(1)).createLord(lord);

    }

}
