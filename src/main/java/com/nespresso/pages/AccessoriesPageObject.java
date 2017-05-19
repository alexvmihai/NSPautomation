package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/12/2017.
 */
public class AccessoriesPageObject extends BasePageObject<AccessoriesPageObject> {
    private By accessoriesAddressTree = By.cssSelector(".category5>strong");
    private By espressoSpoonAdd = By.xpath(".//*[@id='add-to-cart-40']/div/div/button");
    private By espressoSpoonQty = By.xpath(".//*[@id='add-to-cart-40']/div/div/div/div[1]/table/tbody/tr[1]/td[1]");
    private By bonbonniereAdd = By.xpath(".//*[@id='add-to-cart-65']/div/div/button");
    private By bonbonniereQty = By.xpath(".//*[@id='add-to-cart-65']/div/div/div/div[1]/table/tbody/tr[1]/td[1]");


    public AccessoriesPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForAccessoriesPageToLoad(){
        waitForVisibilityOf(accessoriesAddressTree);
    }

    public void addEspressoSpoon() throws InterruptedException {
        clickOn(espressoSpoonAdd);
        Thread.sleep(2000);
        clickOn(espressoSpoonQty);
        System.out.println("Espresso Spoon added to cart !");
    }

    public void addBonbonniere() throws InterruptedException {
        clickOn(bonbonniereAdd);
        Thread.sleep(2000);
        clickOn(bonbonniereQty);
        System.out.println("Bonbonniere added to cart !");
    }


}
