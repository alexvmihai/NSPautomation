package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/19/2017.
 */
public class AccountInformationPageObject extends BasePageObject<AccountInformationPageObject> {
    private By firstName = By.xpath(".//*[@id='firstname']");
    private By lastName = By.xpath(".//*[@id='lastname']");
    private By terms = By.xpath (".//*[@id='form-validate']/div[1]/ul/li[3]/label");
    private By consent = By.xpath (".//*[@id='form-validate']/div[1]/ul/li[4]/label");
    private By saveButton = By.xpath (".//*[@id='form-validate']/div[3]/button");
    private By successMessage = By.cssSelector(".success-msg>ul>li>span");

    protected AccountInformationPageObject(WebDriver driver) {
        super(driver);
    }

    public void changeFirstName (String randomFirstName){
        System.out.println("Changing first name...");
        type(randomFirstName, firstName);
    }

    public void changeLastName (String randomLastName){
        System.out.println("Changing last name...");
        type(randomLastName, lastName);
    }

    public void checkTermsBox(){
        System.out.println("Clicking on Terms Box...");
        clickOn(terms);
    }

    public void checkConsentBox(){
        System.out.println("Clicking on Consent Box...");
        clickOn(consent);
    }

    public void saveTheChanges() throws InterruptedException {
        System.out.println("Saving the changes...");
        clickOn(saveButton);
        Thread.sleep(4000);
    }

    public void clearFields(){
        deleteText(firstName);
        deleteText(lastName);
        System.out.println("First Name deleted !");
    }

    public String getAccountSavedMessage(){
        waitForVisibilityOf(successMessage);
        return getText(successMessage);
    }


}
