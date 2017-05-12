package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by alex.mihai on 5/11/2017.
 */
public class RegisterPageObject extends BasePageObject<RegisterPageObject>{
    private static final String URL = "https://www-pprd-ru.nespresso.com/ru/en/customer/account/create/";
    //General Info
    private By firstNameField = By.cssSelector("#firstname");
    private By lastNameField = By.cssSelector("#lastname");
    private By emailField = By.cssSelector("#email_address");
    private By emailConfField = By.cssSelector("#email_address_confirmation");
    private By passwordField = By.cssSelector("#password");
    private By passwordConfField = By.cssSelector("#confirmation");
    //Address fields
    private By civilityField = By.xpath(".//*[@id='shipping:prefix']");
    private By firstNameAddressField = By.xpath(".//*[@id='shipping:firstname']");
    private By lastNameAddressField = By.xpath(".//*[@id='shipping:lastname']");
    private By cityField = By.xpath(".//*[@id='shipping:city']");
    private By streetField = By.xpath(".//*[@id='shipping:street_1']");
    private By buildingField = By.xpath(".//*[@id='shipping:street_2']");
    private By postalCodeField = By.xpath(".//*[@id='shipping:postcode']");
    private By remarkField = By.xpath(".//*[@id='shipping:remark']");
    private By phoneField = By.xpath(".//*[@id='shipping:telephone_number_0']");
    private By registerButtonField = By.xpath(".//*[@id='form-validate']/div[6]/div[2]/button");


    public RegisterPageObject(WebDriver driver) {
        super(driver);
    }

    public void openRegisterPage(){
        System.out.println("Opening the register page...");
        getPage(URL);
    }

    public void fillInRegisterForm(String firstName, String lastName, String email, String password, String civility, String city,
                                   String street, String building, String postalCode, String remark, String phone){

        System.out.println("Filling in the register form...");
        //General Info
        type(firstName, firstNameField);
        type(lastName, lastNameField);
        type(email, emailField);
        type(email, emailConfField);
        type(password, passwordField);
        type(password, passwordConfField);
        //Address
        type(civility, civilityField);
        type(firstName, firstNameAddressField);
        type(lastName, lastNameAddressField);
        type(city, cityField);
        type(street, streetField);
        type(building, buildingField);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(postalCode, postalCodeField);
        type(remark, remarkField);
        type(phone, phoneField);

    }

    public MyAccountPageObject clickRegisterButton(){
        System.out.println("Clicking on Register button...");
        clickOn(registerButtonField);
        return new MyAccountPageObject(driver);
    }



}
