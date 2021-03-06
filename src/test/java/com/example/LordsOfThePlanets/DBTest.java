package com.example.LordsOfThePlanets;

import com.example.LordsOfThePlanets.controller.LordController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DBTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LordController lordController;

    @Test
    public void test() throws Exception {
        
        this.mockMvc.perform(get("/page"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content()
               .string(containsString("page")));
    }

    @Test
    public void addLordTest() throws Exception{
        this.mockMvc.perform(post("/addLord").param("lord","Joy,10"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }


}
