package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/17/2017.
 */
public class OrderSuccessPageObject extends BasePageObject<OrderSuccessPageObject>{
    private By orderReceivedHeader = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/h1");
    private By thankYouHeader = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/h2");
    private By orderNumber = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/p[1]/a");
    private By continueShoppingButton = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[3]/button");

    protected OrderSuccessPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForOrderSuccessPageToLoad(){
        waitForVisibilityOf(orderReceivedHeader);
    }

    public String getOrderReceivedMessage(){
        return getText(orderReceivedHeader);
    }

    public String getThankYouMessage(){
        return getText(thankYouHeader);
    }

    public String getOrderNumber(){
        return getText(orderNumber);
    }

}
