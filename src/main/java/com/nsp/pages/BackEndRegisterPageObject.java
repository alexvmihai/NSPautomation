package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndRegisterPageObject extends BasePageObject<BackEndRegisterPageObject> {
    private By newCustomerText = By.xpath(".//*[@id='content']/div/div[2]/h3");
    private By addreses = By.xpath(".//*[@id='customer_info_tabs_addresses']/span");
    private By addNewAddress = By.xpath(".//*[@id='add_address_button']");
    private By saveContinue = By.cssSelector("button[title=\"Save and Continue Edit\"]");
    //Account info fields
    private By associate = By.xpath(".//*[@id='_accountwebsite_id']");
    private By group = By.xpath(".//*[@id='_accountgroup_id']");
    private By firstNameField = By.xpath(".//*[@id='_accountfirstname']");
    private By lastNameField = By.xpath(".//*[@id='_accountlastname']");
    private By emailField = By.xpath(".//*[@id='_accountemail']");
    private By passwordField = By.xpath(".//*[@id='_accountpassword']");
    //Address fields
    private By aCivility = By.xpath(".//*[@id='_item1prefix']");
    private By aFirstName = By.xpath(".//*[@id='_item1firstname']");
    private By aLastName = By.xpath(".//*[@id='_item1lastname']");
    private By aStreet = By.xpath(".//*[@id='_item1street0']");
    private By aCity = By.xpath(".//*[@id='_item1city']");
    private By aPostalCode = By.xpath(".//*[@id='_item1postcode']");
    private By aPhone = By.xpath(".//*[@id='_template_nesoa_telephonetelephone_row_0_number']");

    protected BackEndRegisterPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad(){
        waitForVisibilityOf(newCustomerText);
    }

    public void fillInAccountInfo (String firstname, String lastname, String email, String password){
        type(firstname, firstNameField);
        type(lastname, lastNameField);
        type(email, emailField);
        type(password, passwordField);
    }

    public void fillInAddresses (String civility, String firstname, String lastname, String street, String city, String postalCode, String phone) throws InterruptedException {
        clickOn(addreses);
        clickOn(addNewAddress);
        type(civility, aCivility);
        type(firstname, aFirstName);
        type(lastname, aLastName);
        type(street, aStreet);
        Thread.sleep(3000);
        driver.findElement(aStreet).sendKeys((Keys.ARROW_DOWN));
        driver.findElement(aStreet).sendKeys((Keys.RETURN));
        type(postalCode, aPostalCode);
        type(phone, aPhone);
    }

    public BackEndCustomerInfoPageObject saveCustomer(){
        clickOn(saveContinue);
        return new BackEndCustomerInfoPageObject(driver);
    }


}
