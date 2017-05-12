import com.nespresso.base.BaseTest;
import com.nespresso.pages.MyAccountPageObject;
import com.nespresso.pages.RegisterPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/11/2017.
 */
public class RegisterTest extends BaseTest {

    @Test
    public void Register(){

        String firstName = "Smoke";
        String lastName = "Smoke";
        //Generate random email
        long Random = Math.round(Math.random() * 1357987.0D);
        String email = "amihai_test" + Random + "@mailinator.com";

        //Generate random phone
        long number = (long)Math.floor(Math.random() * 9.0E9D) + 1000000000L;
        String phone = Long.toString(number);

        String password = "Password123";
        String civility = "Mr";
        String city = "Seoul";
        String street = "Street 10";
        String building = "building 1234";
        String postalCode = "105005";
        String remark = "This is a test remark.";
        String expectedTitle = "Nespresso RU - Coffee and Espresso Machines";
        String expectedSuccessMsg = "Thank you for registering with Nespresso RU.";


        RegisterPageObject registerPage = new RegisterPageObject(driver);

        //Open Register Page
        registerPage.openRegisterPage();

        //Fill in the register form
        registerPage.fillInRegisterForm(firstName, lastName, email, password, civility, city, street, building, postalCode, remark, phone );

        //Click on Register
        final MyAccountPageObject accountPage = registerPage.clickRegisterButton();
        accountPage.waitForRegisteredAccountPageToLoad();
        String actualSuccessMsg = accountPage.getSuccessMsg();

        String actualTitle = accountPage.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle), "Page title is not correct, \nExpected Title : " + expectedTitle + "\nActual Title: " + actualTitle);
        Assert.assertTrue(expectedSuccessMsg.equals(actualSuccessMsg), "Success message not correct, \nExpected Message : " + expectedSuccessMsg + "\nActual message: " + actualSuccessMsg);
        System.out.println("Test passed !");
        System.out.println("The registered account is : \nEmail: " + email + "\nPassword: " + password);
    }

}
