import com.nsp.base.BaseTest;
import com.nsp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 9/19/2017.
 */
public class BackEndRegisterTest extends BaseTest {
    @Test
    public void BackEndRegisterTest() throws InterruptedException {
        driver.manage().deleteAllCookies();
        String username = "amihai";
        String password = "H.A.M.15:45Icarus1545!!";
        BackEndHomepageObject backEndHomepage = new BackEndHomepageObject(driver);
        backEndHomepage.openHomepage();
        backEndHomepage.waitForPageToLoad();
        BackEndDashboardPageObject dashboard = backEndHomepage.login(username, password);
        dashboard.waitForPageToLoad();
        dashboard.closeMGMPopup();
        dashboard.setEnglish();
        dashboard.waitForPageToLoad();
        BackEndManageCustomersPageObject manageCustomers = dashboard.manageCustomers();
        manageCustomers.waitForPageToLoad();
        BackEndRegisterPageObject registerPage = manageCustomers.createCustomer();
        registerPage.waitForPageToLoad();

        String firstname = "Alex";
        String lastname = "BackEnd";
        String password1 = "Password123";
        String civility = "Mr";
        String aFirstName = "Alex";
        String aLastName = "BackEnd";
        String aStreet = "Backer Street 221";
        String aCity = "Moscow";
        String postal = "105005";
        String remark = "This account is created from Back-End";
        String duplicatePhone = "2551692811";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);

        //Generate random email
        long Random = Math.round(Math.random() * 1357987.0D);
        String email = "amihai_test" + Random + "@mailinator.com";

        registerPage.fillInAccountInfo(firstname,lastname,email,password1);
        registerPage.fillInAddresses(civility,aFirstName,aLastName,aStreet,aCity,postal, phone);
        BackEndCustomerInfoPageObject customerInfoPage = registerPage.saveCustomer();
        customerInfoPage.waitForPageToLoad();
        System.out.println("Customer Created successfully ! \n" + customerInfoPage.getMemberId());
        //Validations
        String expectedSuccessMessage = "The customer has been saved.";
        String actualSuccessMessage = customerInfoPage.getDefaultSuccessMessage();

        //Validate default position success message when the phone is not duplicate, or else the success message that appears below when there is a duplicate phone
        if(customerInfoPage.secondMessage()){
            String actualSecondSuccessMessage = customerInfoPage.getSecondSuccessMessage();
            Assert.assertTrue(expectedSuccessMessage.equals(actualSecondSuccessMessage), "Second success message doesn't match, \nExpected: " + expectedSuccessMessage + "\nActual: " + actualSecondSuccessMessage);
            System.out.println("Second success message matches ! \nExpected: " + expectedSuccessMessage + "\nActual: " + actualSecondSuccessMessage);
        } else {
            Assert.assertTrue(expectedSuccessMessage.equals(actualSuccessMessage), "Success message doesn't match, \nExpected: " + expectedSuccessMessage + "\nActual: " + actualSuccessMessage);
            System.out.println("Success message matches ! \nExpected: " + expectedSuccessMessage + "\nActual: " + actualSuccessMessage);
        }





    }
}
