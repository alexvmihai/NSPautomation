package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

/**
 * Created by alex.mihai on 5/12/2017.
 */
public class HomepageObject extends BasePageObject<HomepageObject> {
    private String homePageURL = "https://www-pprd-ru.nespresso.com/ru/en/";
    protected By capsuleButton = By.cssSelector(".level0.has-children.color-blue.icon-capsule");
    protected By cartButtonArrow = By.xpath(".//*[@id='header']/div/div[3]/div[3]/div[2]/div[1]/em[2]");
    protected By viewCartButton = By.xpath(".//*[@id='header-cart']/div[3]/div[4]/ul/li/a");

    public HomepageObject(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
        getPage(homePageURL);
    }
    public CapsulePageObject clickCapsuleButton() {
        System.out.println("Clicking on capsules button...");
        clickOn(capsuleButton);
        return new CapsulePageObject(driver);
    }

    public ShoppingCartPageObject openShoppingCart() throws InterruptedException{
        clickOn(cartButtonArrow);
        Thread.sleep(2000);
        clickOn(viewCartButton);
        return new ShoppingCartPageObject(driver);
    }





}