package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class MyAccountPageObject extends BasePageObject<MyAccountPageObject> {
    private By memberNumber = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div[2]/div/div[3]");
    private By myAccount = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/strong/span");
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


}
