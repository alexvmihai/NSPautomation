package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 10/31/2017.
 */
public class KazaarPDPObject extends BasePageObject<KazaarPDPObject> {
    private By title = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span");
    private By description = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div");
    private By addToCart = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/form/div[2]/div/div[1]/div/button");
    private By qty = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/form/div[2]/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[5]");
    private By cartHeader = By.xpath("html/body/div[2]/div/div[1]/header/div/div[3]/div[3]/div[2]/div[1]/span");

    protected KazaarPDPObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(title);
        waitForVisibilityOf(description);
    }

    public void addToCart() throws InterruptedException {
        clickOn(addToCart);
        Thread.sleep(3000);
        clickOn(qty);
        Thread.sleep(20000);
        System.out.println("100 capsules added successfully !");
    }

    public String getCartStatus(){
        return getText(cartHeader);
    }

}
