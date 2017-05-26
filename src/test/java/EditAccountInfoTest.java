import com.nespresso.base.BaseTest;
import com.nespresso.pages.AccountInformationPageObject;
import com.nespresso.pages.MyAccountPageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/19/2017.
 */
public class EditAccountInfoTest extends LoginTest {
    public String random = RandomStringUtils.randomAlphabetic(5);
    @Test (priority = 3)
    public void EditAccount() throws InterruptedException {
        MyAccountPageObject accountPage = new MyAccountPageObject(driver);
        String expectedSuccessMessage = "The account information has been saved.";
        AccountInformationPageObject accountInfoPage = accountPage.clickPersonalInfo();
        accountInfoPage.clearFields();
        accountInfoPage.changeFirstName(random);
        accountInfoPage.changeLastName(random);
        accountInfoPage.checkConsentBox();
        accountInfoPage.checkTermsBox();
        accountInfoPage.saveTheChanges();
        String actualSuccessMessage = accountInfoPage.getAccountSavedMessage();
        Assert.assertTrue(expectedSuccessMessage.equals(actualSuccessMessage), "Success message is not correct.." + "\nExpected: "+ expectedSuccessMessage + "\nActual: "+ actualSuccessMessage);
        System.out.println("Test Passed !");
    }
}
