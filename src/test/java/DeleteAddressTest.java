import com.nsp.pages.CustomerAddressPageObject;
import com.nsp.pages.MyAccountPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/29/2017.
 */
public class DeleteAddressTest extends LoginTest {
    @Test (priority = 3)
    public void DeleteAddress() throws InterruptedException {
        MyAccountPageObject accountPage = new MyAccountPageObject(driver);

        //Click on My addresses from My Account
        CustomerAddressPageObject myAddressesPage = accountPage.clickMyAddresses();
        myAddressesPage.closeiFrame();
        myAddressesPage.waitForAddressPageToLoad();

        //Save the first address in the list - to be deleted
        String firstAddress = myAddressesPage.getFirstAddress();

        //Delete the Address
        CustomerAddressPageObject deletedAddressPage = myAddressesPage.clickDeleteAddress();
        deletedAddressPage.acceptPrompt();
        deletedAddressPage.waitForAddressPageToLoad();

        //Check if the address was deleted
        String expectedMessage = "The address has been deleted.";
        String actualMessage = deletedAddressPage.getDeletedMessage();
        String deletedAddresPage = deletedAddressPage.getSource();

        Assert.assertTrue(expectedMessage.equals(actualMessage), "The message is not correct: " + "\nExpected: " + expectedMessage +"\nActual: " + actualMessage);
        Assert.assertFalse(deletedAddresPage.contains(firstAddress), "The address is still present on the page");
        System.out.println("Address deleted ! \nTest Passed !");
    }
}
