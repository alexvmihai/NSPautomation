import com.nsp.base.BaseTest;
import com.nsp.pages.LoginPageObject;
import com.nsp.pages.MyAccountPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class LoginTest extends BaseTest{
    @Test (priority = 2)
    public void positiveLogInTest() throws InterruptedException {
        LoginPageObject loginPage = new LoginPageObject(driver);
        String expectedTitle = "My Account";
        String expectedMemberNumber = "Your member number is: 1269998";

        // Open Nespresso Login page
        loginPage.openLogInPage();
        loginPage.acceptPrompt();

        // Fill in email and password
        loginPage.fillInEmailAndPassword("smoke_test2@mailinator.com", "Password123");

        // Click on Log In button and wait for account page to load
        MyAccountPageObject accountPage = loginPage.clickLoginButton();
        accountPage.waitForAccountPageToLoad();
        String actualTitle = accountPage.getTitle();

        // Verify if the title of the page is correct
        // Verify if the correct account name is on the profile page
        Assert.assertTrue(expectedTitle.equals(actualTitle), "Page title is not correct. \nExpected: " + expectedTitle + "\nActual: " +actualTitle );
        Assert.assertTrue(accountPage.isCorrectAccountLoaded(expectedMemberNumber), "Profile name is not correct.");
        System.out.println("Successfully logged in ! \nTest passed !");
    }
    @Test (priority = 1)
    public void negativeLogInTest() throws InterruptedException {
        LoginPageObject loginPage = new LoginPageObject(driver);
        String expectedErrorMsg = "Invalid login or password.";

        // Open Nespresso Login page
        loginPage.openLogInPage();
        loginPage.acceptPrompt();

        // Fill in email and password
        loginPage.fillInEmailAndPassword("incorrect@email.com", "Password123");
        loginPage.clickLoginButton();

        String errorMsg = loginPage.getLogInErrorMsg();
        Assert.assertTrue(errorMsg.contains(expectedErrorMsg), "Error message is not correct. Expected: " + expectedErrorMsg + "\nActual: " + errorMsg);
        System.out.println("Expected error message is correct !\nTest passed !");
    }
}
