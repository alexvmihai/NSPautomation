import com.nespresso.base.BaseTest;
import com.nespresso.pages.CapsulePageObject;
import com.nespresso.pages.HomepageObject;
import com.nespresso.pages.ShoppingCartPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 8/1/2017.
 */
public class CouponCodeTest extends BaseTest {
    @Test
    public void CouponCodeTest () throws InterruptedException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();
        capsulePage.addRoma();
        ShoppingCartPageObject shoppingCart = capsulePage.openShoppingCart();
        shoppingCart.waitForCartPageToLoad();
        shoppingCart.typeCouponCode("MOA-AP-AO-AB2");
        shoppingCart.clickApply();
        String expectedMessage = "Coupon code \"MOA-AP-AO-AB2\" was applied.";
        String actualMessage = shoppingCart.getCouponMsg();
        String expectedDiscount = "-RUB 1,000.00";
        String actualDiscount = shoppingCart.getDiscountText();

        //Check if the coupon was applied successfully
        Assert.assertTrue(expectedMessage.equals(actualMessage), "The expected message is not correct !" + "\nExpected: " + expectedMessage + "\nActual: " + actualMessage );
        System.out.println("Correct success message !\nExpected: " + expectedMessage + "\nActual: " + actualMessage);
        Assert.assertTrue(expectedDiscount.equals(actualDiscount), "The expected discount is not correct !" + "\nExpected: " + expectedDiscount + "\nActual: " + actualDiscount);
        System.out.println("Correct discount applied !\nExpected: " + expectedDiscount + "\nActual: " + actualDiscount);
        shoppingCart.clickEmptyCartButton();
    }

    @Test
    public void CancelCouponTest () throws InterruptedException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();
        capsulePage.addRoma();
        ShoppingCartPageObject shoppingCart = capsulePage.openShoppingCart();
        shoppingCart.waitForCartPageToLoad();
        shoppingCart.typeCouponCode("MOA-AP-AO-AB2");
        String noDiscount1 = shoppingCart.getGrandTotalText();
        shoppingCart.clickApply();
        String discountIncluded = shoppingCart.getGrandTotalText();
        shoppingCart.clickCancel();
        String noDiscount2 = shoppingCart.getGrandTotalText();
        String expectedCouponMsg = "Coupon code was canceled.";
        String actualCouponMsg = shoppingCart.getCouponMsg();

        //Check that the coupon was correctly removed
        Assert.assertTrue(noDiscount1.equals(noDiscount2), "Discount was not removed !\nPrice before coupon: " + noDiscount1 + "\nPrice after cancelling coupon: " + noDiscount2);
        System.out.println("Discount correctly removed !\nTotal price before coupon: " + noDiscount1 + "\nTotal price after canceling coupon: " + noDiscount2);
        Assert.assertTrue(expectedCouponMsg.equals(actualCouponMsg), "Coupon message wrong! \nExpected: " + expectedCouponMsg + "\nActual: " + actualCouponMsg);
        System.out.println("Success message is correct !\nExpected: " + expectedCouponMsg + "\nActual: " + actualCouponMsg);
        shoppingCart.clickEmptyCartButton();

    }

    @Test
    public void NegativeCouponCodeTest () throws InterruptedException {
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.waitForHomepageToLoad();
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();
        capsulePage.addRoma();
        ShoppingCartPageObject shoppingCart = capsulePage.openShoppingCart();
        shoppingCart.waitForCartPageToLoad();
        String grandTotal = shoppingCart.getGrandTotalText();
        String code = "Gibberish code";
        shoppingCart.typeCouponCode(code);
        shoppingCart.clickApply();
        String grandTotal2 = shoppingCart.getGrandTotalText();
        String expectedErrorMessage = "Coupon code \"" + code + "\" is not valid.";
        String actualErrorMessage = shoppingCart.getCouponMsg();

        //Check that the code was rejected and no discount was applied
        Assert.assertTrue(grandTotal.equals(grandTotal2), "The grand total is not the same ! \nExpected: " + grandTotal + "\nActual: " + grandTotal2 );
        System.out.println("Price matches !\nExpected: " + grandTotal + "\nActual: " + grandTotal2);
        Assert.assertTrue(expectedErrorMessage.equals(actualErrorMessage), "Error message doesn't match !\nExpected: " + expectedErrorMessage + "\nActual: " + actualErrorMessage);
        System.out.println("Error msg matches !\nExpected: " + expectedErrorMessage + "\nActual: " + actualErrorMessage);
        shoppingCart.clickEmptyCartButton();

    }
}
