package com.example.LordsOfThePlanets;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumTest {
    protected WebDriver driver;

    @BeforeAll
    public void gotest() {
        driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

    }

    @Test
    public void controlTest() {
        String baseUrl = "http://localhost:8080/lords";
        String expTitle = "Lords";
        String actualTitle = "";

        driver.get(baseUrl);

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed:(");
        }

        driver.close();

    }
}
