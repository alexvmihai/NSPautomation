package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndHomepageObject extends BasePageObject<BackEndHomepageObject> {
    private String homePageURL = "https://www-pprd-ru.nespresso.com/index.php/admin/admin/";
    private By userName = By.xpath(".//*[@id='username']");
    private By passWord = By.xpath(".//*[@id='login']");
    private By loginButton = By.xpath(".//*[@id='loginForm']/div/div[5]/input");
    private By headerText = By.xpath(".//*[@id='loginForm']/div/h2");

    public BackEndHomepageObject(WebDriver driver) {
        super(driver);
    }

    public void openHomepage(){
        getPage(homePageURL);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(headerText);
        waitForVisibilityOf(loginButton);
        waitForVisibilityOf(userName);
    }

    public BackEndDashboardPageObject login (String username, String password){
        type(username, userName);
        type(password, passWord);
        clickOn(loginButton);
        return new BackEndDashboardPageObject(driver);
    }


}
