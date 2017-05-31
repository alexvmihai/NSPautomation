package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/17/2017.
 */
public class ShoppingCartPageObject extends BasePageObject<ShoppingCartPageObject>{
    private By shoppingCartHeader = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/h1");
    private By proceedToCheckoutButton = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[2]/button");

    protected ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForCartPageToLoad(){
        waitForVisibilityOf(shoppingCartHeader);
    }

    public CheckoutPageObject proceedToCheckout(){
        clickOn(proceedToCheckoutButton);
        System.out.println("Proceeding to checkout...");
        return new CheckoutPageObject(driver);
    }

    public CheckoutPageObject proceedToLogInRegister(){
        clickOn(proceedToCheckoutButton);
        System.out.println("Proceeding to the register/login page...");
        return new CheckoutPageObject(driver);
    }


}
