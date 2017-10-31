package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/26/2017.
 */
public class CustomerAddressPageObject extends BasePageObject<CustomerAddressPageObject> {
    private By addNewAddressButton = By.xpath("//button[@title='Add New Address']");
    private By successAddress = By.xpath(".//*[@id='top']/body/div[2]/div/div[2]/div/div[3]/div/ul/li/ul/li/span");
    private By deleteAddressButton = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div/div[2]/div[2]/ol/li[1]/p/a[2]");
    private By deleteAddressMsg = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div/ul/li/ul/li/span");
    private By firstAddressDetails = By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div/div[2]/div[2]/ol/li[1]/address");
    private By popUpClose = By.xpath("html/body/div[1]/div[3]/input");
    private By iframe = By.cssSelector("css=.dbck_overlay");


    protected CustomerAddressPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForAddressPageToLoad(){
        waitForVisibilityOf(addNewAddressButton);
        System.out.println("Address Page Loaded !");
    }

    public NewAddressPageObject clickAddNewAddress(){
        System.out.println("Clicking on Add New Address...");
        clickOn(addNewAddressButton);
        return new NewAddressPageObject(driver);
    }

    public String getSuccessMessage(){
        return getText(successAddress);
    }

    public CustomerAddressPageObject clickDeleteAddress(){
        System.out.println("Deleting the first address in the list...");
        clickOn(deleteAddressButton);
        return new CustomerAddressPageObject(driver);
    }

    public String getDeletedMessage(){
        return getText(deleteAddressMsg);
    }

    public String getFirstAddress(){
        return getText(firstAddressDetails);
    }

//    public void ClosePopUp(){
//        clickOn(popUpClose);
//    }


}
