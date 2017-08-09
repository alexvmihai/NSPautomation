package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by alex.mihai on 5/12/2017.
 */
public class MachinePageObject extends BasePageObject <MachinePageObject> {
    private By machineAddressTree = By.cssSelector(".category4>strong");
    private By uMilkBlackAdd = By.xpath(".//*[@id='add-to-cart-202']/div/div/button");
    private By uMilkBlackQty = By.xpath(".//*[@id='add-to-cart-202']/div/div/div/div[1]/table/tbody/tr[1]/td[1]");
    private By accessoriesButton = By.xpath(".//*[@id='nav']/ol/li[3]/a");


    public MachinePageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForMachinePageToLoad(){
        waitForVisibilityOf(machineAddressTree);
    }

    public void addUMilkBlack() throws InterruptedException{
        clickOn(uMilkBlackAdd);
        Thread.sleep(2000);
        clickOn(uMilkBlackQty);
        System.out.println("UMilk Black added to cart !");
        Thread.sleep(6000);
    }

    public AccessoriesPageObject clickAccessoriesButton(){
        System.out.println("Opening the accessories page...");
        clickOn(accessoriesButton);
        return new AccessoriesPageObject(driver);
    }


}
