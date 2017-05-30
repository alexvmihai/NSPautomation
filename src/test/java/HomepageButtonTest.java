import com.nespresso.base.BaseTest;
import com.nespresso.pages.CapsulePageObject;
import com.nespresso.pages.HomepageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/24/2017.
 */
public class HomepageButtonTest extends BaseTest {
    @Test
    public void HomepageButtonTest() {
        HomepageObject homePage = new HomepageObject(driver);
        homePage.openHomePage();
        homePage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homePage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();
        System.out.println("Capsule page loaded !");
        HomepageObject homePage2 = capsulePage.clickHomepageLogo();
        homePage2.waitForHomepageToLoad();
        System.out.println("Homepage loaded !");
        String expectedPageTitle = "Home page";
        String actualPageTitle = homePage2.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle), "Page title not correct !" + "\nExpected: " + expectedPageTitle + "\nActual title: " + actualPageTitle);
        System.out.println("Test Passed !");
    }
}