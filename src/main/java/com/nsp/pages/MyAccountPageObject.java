package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class MyAccountPageObject extends BasePageObject<MyAccountPageObject> {
    private By memberNumber = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[4]/div/div/div[3]");
    private By myAccount = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div/div[1]/strong/span");
    private By personalInfo = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/a");
    private By contactPreferences = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[5]/a");
    private By myAddresses = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div/div[2]/ul/li[3]/a/span");

    public By registerSuccess = By.cssSelector(".success-msg>ul>li>span");

    public MyAccountPageObject(WebDriver driver){
        super(driver);
    }

    public void waitForAccountPageToLoad(){
        waitForVisibilityOf(memberNumber);
        waitForVisibilityOf(myAccount, 10);
    }

    public void waitForRegisteredAccountPageToLoad(){
        waitForVisibilityOf(registerSuccess);
    }

    public boolean isCorrectAccountLoaded(String correctMemberNumber){
        if (getText(memberNumber).equals(correctMemberNumber)){
            System.out.println(getText(memberNumber));
            return true;
        }else{
            return false;
        }
    }

    public String getSuccessMsg(){
        return getText(registerSuccess);
    }

    public AccountInformationPageObject clickPersonalInfo() throws InterruptedException {
        System.out.println("Clicking on Personal Info...");
        clickOn(personalInfo);
        Thread.sleep(5000);
        return new AccountInformationPageObject(driver);
    }

    public CustomerAddressPageObject clickMyAddresses() throws InterruptedException {
        System.out.println("Clicking on My Addresses...");
        clickOn(myAddresses);
        Thread.sleep(5000);
        return new CustomerAddressPageObject(driver);
    }








}
