import com.nsp.pages.CustomerAddressPageObject;
import com.nsp.pages.MyAccountPageObject;
import com.nsp.pages.NewAddressPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/26/2017.
 */
public class AddNewAddressTest extends LoginTest{
    @Test (priority = 3)
    public void AddNewAddress() throws InterruptedException {
        MyAccountPageObject accountPage = new MyAccountPageObject(driver);
        CustomerAddressPageObject myAddressesPage = accountPage.clickMyAddresses();
//        myAddressesPage.ClosePopUp();
        myAddressesPage.waitForAddressPageToLoad();
        NewAddressPageObject newAddressFormPage = myAddressesPage.clickAddNewAddress();
        newAddressFormPage.waitForAddressFormToLoad();
        String civility = "Mr";
        String firstName = "Smoke";
        String lastName = "Smoke";
        String city = "Seoul";
        String street = "Street 10";
        String building = "building 1234 bloc 2";
        String zipCode = "105005";
        String remark = "This is an address added by TestNG.";

        //Generate random phone
        long number1 = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone1 = Long.toString(number1);

        //Generate random phone
        long number2 = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone2 = Long.toString(number2);

        //Filling in the address form
        newAddressFormPage.fillInAddressForm(civility, firstName, lastName, city, street, building, zipCode, remark, phone1, phone2);
        CustomerAddressPageObject successPage = newAddressFormPage.saveForm();

        //Waiting for the address to be saved
        successPage.waitForAddressPageToLoad();
        String actualMessage = successPage.getSuccessMessage();
        String expectedMessage = "The address has been saved.";
        String presentPhoneOnPage = successPage.getSource();
        System.out.println(phone1);

        //Check if the addresss has been saved
        Assert.assertTrue(actualMessage.equals(expectedMessage),"\nExpected message: " + expectedMessage + "\nActual message: " + actualMessage);
        Assert.assertTrue(presentPhoneOnPage.contains(phone1), "Phone from address added is not present on the page !");
        System.out.println("Address saved ! \nTest Passed !");
    }
}
