package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/11/2017.
 */
public class RegisterPageObject extends BasePageObject<RegisterPageObject>{
    private static final String URL = "https://nsp-admin:o123123@www-pprd-ru.nsp.com/ru/en/customer/account/create/";
    private static final String intURL = "https://nsp-admin:o123123@www-int-ru.nsp.com/ru/en/customer/account/create/";
    private static final String prodURL = "https://www.nsp.com/ru/en/customer/account/create/";
    //General Info
    private By firstNameField = By.cssSelector("#firstname");
    private By lastNameField = By.cssSelector("#lastname");
    private By emailField = By.cssSelector("#email_address");
    private By emailConfField = By.cssSelector("#email_address_confirmation");
    private By passwordField = By.cssSelector("#password");
    private By passwordConfField = By.cssSelector("#confirmation");
    //Address fields - shipping
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
    //General Info - register checkout
    private By billingEmail = By.xpath(".//*[@id='billing:email']");
    private By billingEmailConfirm = By.xpath(".//*[@id='billing:email_address_confirmation']");
    private By billingPassword = By.xpath(".//*[@id='billing:customer_password']");
    private By billingPasswordConf = By.xpath(".//*[@id='billing:confirm_password']");
    //Address fields - billing
    private By billingCivilityField = By.xpath(".//*[@id='billing:prefix']");
    private By billingFirstNameField = By.xpath(".//*[@id='billing:firstname']");
    private By billingLastNameField = By.xpath(".//*[@id='billing:lastname']");
    private By billingCityField = By.xpath(".//*[@id='billing:city']");
    private By billingStreetField = By.xpath(".//*[@id='billing:street1']");
    private By billingBuildingField = By.xpath(".//*[@id='billing:street2']");
    private By billingPostalCodeField = By.xpath(".//*[@id='billing:postcode']");
    private By billingRemarkField = By.xpath(".//*[@id='billing:remark']");
    private By billingPhoneField = By.xpath(".//*[@id='billing:telephone_number_1']");
    private By billingContinueButton = By.xpath(".//*[@id='billing-buttons-container']/button");
    private By billingHeader = By.xpath(".//*[@id='opc-billing']/div[1]/h2");

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

    public void fillInRegisterFormCheckout(String firstName, String lastName, String email, String password, String civility, String city,
                                           String street, String building, String postalCode, String remark, String phone){
        System.out.println("Filling in the register form...");
        //General Info
        type(firstName, firstNameField);
        type(lastName, lastNameField);
        type(email, billingEmail);
        type(email, billingEmailConfirm);
        type(password, billingPassword);
        type(password, billingPasswordConf);
        //Address
        type(civility, billingCivilityField);
        type(firstName, billingFirstNameField);
        type(lastName, billingLastNameField);
        type(city, billingCityField);
        type(street, billingStreetField);
        type(building, billingBuildingField);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(postalCode, billingPostalCodeField);
        type(remark, billingRemarkField);
        type(phone, billingPhoneField);
    }

    public MyAccountPageObject clickRegisterButton(){
        System.out.println("Clicking on Register button...");
        clickOn(registerButtonField);
        return new MyAccountPageObject(driver);
    }

    public void waitForRegisterPageToLoad(){
        waitForVisibilityOf(billingHeader);
    }

    public CheckoutPageObject clickBillingContinueButton() throws InterruptedException{
        System.out.println("Clicking on Billing Continue button...");
        clickOn(billingContinueButton);
        Thread.sleep(6000);
        return new CheckoutPageObject(driver);
    }
}
