package com.nsp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void methodSetUp(){
        System.out.println("Test set up !");
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void methodTearDown(){
        System.out.println("Test clean up !");
        driver.quit();
    }

//    @BeforeMethod
//    public void clearCookies(){
//        System.out.println("Cleaning cookies !");
//        driver.manage().deleteAllCookies();
//    }

}
