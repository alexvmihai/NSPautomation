import com.nsp.base.BaseTest;
import com.nsp.pages.CapsulePageObject;
import com.nsp.pages.HomepageObject;
import com.nsp.pages.KazaarPDPObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 10/31/2017.
 */
public class AddToCartFromPDP extends LoginTest{
//    @Override
//    public void positiveLogInTest(){};

    @Override
    public void negativeLogInTest(){};

    @Test(priority=1)
    public void AddToCartFromPDP() throws InterruptedException {
        driver.manage().deleteAllCookies();
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        KazaarPDPObject kazaarPage = capsulePage.openKazaarPDP();
        kazaarPage.waitForPageToLoad();
        kazaarPage.addToCart();
        System.out.println(kazaarPage.getCartStatus());
        String actualCart = kazaarPage.getCartStatus();
        String expectedCart = "100 items: RUB 3,600.00";
        Assert.assertTrue(actualCart.equals(expectedCart), "Cart header does not match !" + "\nExpected: " + expectedCart + "\nActual: " + actualCart);
    }
    @Test(priority=3)
    public void AddToCartFromPDPLogged() throws InterruptedException{
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.waitForHomepageToLoad();
        homepage.emptyCart();
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        KazaarPDPObject kazaarPage = capsulePage.openKazaarPDP();
        kazaarPage.waitForPageToLoad();
        kazaarPage.addToCart();
        System.out.println(kazaarPage.getCartStatus());
        String actualCart = kazaarPage.getCartStatus();
        String expectedCart = "100 items: RUB 3,600.00";
        Assert.assertTrue(actualCart.equals(expectedCart), "Cart header does not match !" + "\nExpected: " + expectedCart + "\nActual: " + actualCart);
        System.out.println("Test passed !");
    }
}

