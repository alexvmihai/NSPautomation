package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class LoginPageObject extends BasePageObject<LoginPageObject> {
    private static final String URL = "https://nespresso-admin:o123123@www-pprd-ru.nespresso.com/ru/en/customer/account/login/";
    private static final String prodURL = "https://www.nespresso.com/ru/en/customer/account/login/";
    private static final String intURL = "https://nespresso-admin:o123123@www-int-ru.nespresso.com/ru/en/customer/account/login/";
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='pass']");
    private By logInButton = By.xpath(".//*[@id='send2']");
    private By errorMsg = By.cssSelector(".error-msg>ul>li>span");


    public LoginPageObject(WebDriver driver){
        super(driver);
    }

    public void openLogInPage(){
        getPage(URL);
    }

    public void fillInEmailAndPassword(String email, String password){
        System.out.println("Typing email and password...");
        type(email, emailField);
        type(password, passwordField);
    }

    public MyAccountPageObject clickLoginButton (){
        System.out.println("Clicking on login button...");
        clickOn(logInButton);
        return new MyAccountPageObject(driver);
    }
    public String getLogInErrorMsg(){
        waitForVisibilityOf(errorMsg, 10);
        return getText(errorMsg);
    }

}
