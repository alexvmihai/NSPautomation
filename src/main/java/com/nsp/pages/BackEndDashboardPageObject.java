package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndDashboardPageObject extends BasePageObject<BackEndDashboardPageObject> {
    private By mgmPrompt = By.xpath(".//*[@id='message-popup-window']/div[1]/a");
    private By dashboardText = By.xpath(".//*[@id='page:main-container']/div[2]/table/tbody/tr/td/h3");
    private By interfaceLocale = By.xpath(".//*[@id='interface_locale']");
    private By customers = By.xpath(".//*[@id='nav']/li[6]/a/span");
    private By manageCustomers = By.xpath(".//*[@id='nav']/li[6]/ul/li[1]/a/span");



    protected BackEndDashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public void closeMGMPopup(){
        clickOn(mgmPrompt);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(dashboardText);
    }

    public void setEnglish(){
        WebElement interfaceLocale = driver.findElement(By.xpath(".//*[@id='interface_locale']"));
        Select dropdown = new Select(interfaceLocale);
        dropdown.selectByValue("en_US");
    }

    public BackEndManageCustomersPageObject manageCustomers(){
        clickOn(customers);
        clickOn(manageCustomers);
        return new BackEndManageCustomersPageObject(driver);
    }


}
