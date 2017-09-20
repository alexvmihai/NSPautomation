package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndManageCustomersPageObject extends BasePageObject<BackEndManageCustomersPageObject>{
    private By manageCustomersText = By.xpath(".//*[@id='page:main-container']/div[2]/table/tbody/tr/td[1]/h3");
    private By addNewCustomer = By.cssSelector("button[title=\"Add New Customer\"]");



    protected BackEndManageCustomersPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(manageCustomersText);
        waitForVisibilityOf(addNewCustomer);
    }

    public BackEndRegisterPageObject createCustomer(){
        clickOn(addNewCustomer);
        return new BackEndRegisterPageObject(driver);
    }
}
