package com.nespresso.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void methodSetUp(){
        System.out.println("Test set up !");
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void methodTearDown(){
        System.out.println("Test clean up !");
        driver.quit();
    }
}
