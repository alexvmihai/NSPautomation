import com.nsp.base.BaseTest;
import com.nsp.pages.CapsulePageObject;
import com.nsp.pages.HomepageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/24/2017.
 */
public class HomepageButtonTest extends BaseTest {
    @Test
    public void HomepageButtonTest() throws InterruptedException {
        HomepageObject homePage = new HomepageObject(driver);
        homePage.openHomePage();
        homePage.acceptPrompt();
        homePage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homePage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();
        System.out.println("Capsule page loaded !");
        HomepageObject homePage2 = capsulePage.clickHomepageLogo();
        homePage2.waitForHomepageToLoad();
        System.out.println("Homepage loaded !");
        String expectedPageTitle = "Nespresso: кофе-капсулы и кофемашины. Официальный сайт в России.";
        String actualPageTitle = homePage2.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle), "Page title not correct !" + "\nExpected: " + expectedPageTitle + "\nActual title: " + actualPageTitle);
        System.out.println("Test Passed !");
    }
}
