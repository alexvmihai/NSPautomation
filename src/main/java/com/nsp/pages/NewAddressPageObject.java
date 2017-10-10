package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/26/2017.
 */
public class NewAddressPageObject extends BasePageObject<NewAddressPageObject> {
    private By civilityField = By.xpath(".//*[@id='prefix']");
    private By firstNameField = By.xpath(".//*[@id='firstname']");
    private By lastNameField = By.xpath(".//*[@id='lastname']");
    private By cityField = By.xpath(".//*[@id='city']");
    private By streetField = By.xpath(".//*[@id='street_1']");
    private By buildingField = By.xpath(".//*[@id='street_2']");
    private By zipcodeField = By.xpath(".//*[@id='postcode']");
    private By remarkField = By.xpath(".//*[@id='remark']");
    private By phone1Field = By.xpath(".//*[@id='telephone_number_1']");
    private By phone2Field = By.xpath(".//*[@id='telephone_number_2']");
    private By saveButton = By.xpath(".//*[@id='form-validate']/div[2]/button");


    protected NewAddressPageObject(WebDriver driver) {
        super(driver);
    }

    public void fillInAddressForm(String civility, String firstName, String lastName, String city, String street, String building, String zipcode, String remark, String phone1, String phone2) throws InterruptedException {
        System.out.println("Filling in the address form...");
        type(civility, civilityField);
        type(firstName, firstNameField);
        type(lastName, lastNameField);
        type(city, cityField);
        Thread.sleep(4000);
        type(street, streetField);
        type(building, buildingField);
        Thread.sleep(7000);
        type(zipcode, zipcodeField);
        type(remark, remarkField);
        type(phone1, phone1Field);
        type(phone2, phone2Field);
    }

    public CustomerAddressPageObject saveForm(){
        System.out.println("Saving Form...");
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,400)");
        clickOn(saveButton);
        return new CustomerAddressPageObject(driver);
    }

    public void waitForAddressFormToLoad(){
        waitForVisibilityOf(cityField);
        System.out.println("Address Form Loaded !");
    }
}
