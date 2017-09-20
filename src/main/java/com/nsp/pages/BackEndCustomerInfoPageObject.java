package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndCustomerInfoPageObject extends BasePageObject<BackEndCustomerInfoPageObject> {
    private By firstMessage = By.xpath(".//*[@id='messages']/ul/li[1]/ul/li/span");
    private By secondMessage = By.xpath(".//*[@id='messages']/ul/li[2]/ul/li/span");
    private By singleMessage = By.xpath(".//*[@id='messages']/ul/li/ul/li/span");
    private By memberID = By.xpath(".//*[@id='content']/div/div[2]/h3");
    private By orders = By.xpath(".//*[@id='customer_info_tabs_orders']/span");

    protected BackEndCustomerInfoPageObject(WebDriver driver) {
        super(driver);
    }

    public String getMemberId(){
        return getText(memberID);
    }

    public String getDefaultSuccessMessage(){
        return getText(singleMessage);
    }

    public String getSecondSuccessMessage(){
        return getText(secondMessage);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(memberID);
        waitForVisibilityOf(orders);
    }

    public boolean secondMessage() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements( By.xpath(".//*[@id='messages']/ul/li[2]/ul/li/span") ).size() != 0;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (exists){
            return true;
        } else {
            return false;
        }
    }
}
