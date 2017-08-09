import com.nsp.base.BaseTest;
import com.nsp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/12/2017.
 */
public class LoginPurchaseTest extends BaseTest{
   @Test(priority = 1)
    public void simpleLogIn() throws InterruptedException {
        LoginPageObject loginPage = new LoginPageObject(driver);
        // Open Nespresso Login page
        loginPage.openLogInPage();
        loginPage.acceptPrompt();

        // Fill in email and password
        loginPage.fillInEmailAndPassword("smoke_test2@mailinator.com", "Password123");

        // Click on Log In button and wait for account page to load
        MyAccountPageObject accountPage = loginPage.clickLoginButton();
        accountPage.waitForAccountPageToLoad();
        System.out.println("Test Passed !");
    }

    @Test(priority = 2)
    public void addProductsToCart() throws InterruptedException {
        HomepageObject homePage = new HomepageObject(driver);
        homePage.openHomePage();
        homePage.acceptPrompt();

        //Open the capsules page
        CapsulePageObject capsulePage = homePage.clickCapsuleButton();
        capsulePage.waitForCapsulePageToLoad();

        //Add capsules to cart
        capsulePage.addLivanto();
        capsulePage.addRoma();


        //Open the machine page
        MachinePageObject machinePage = capsulePage.clickMachineButton();
        machinePage.waitForMachinePageToLoad();

        //Add machines to cart
        machinePage.addUMilkBlack();
        System.out.println("Machines added !!!!!");

        //Open the accessories page
        AccessoriesPageObject accessoriesPage = machinePage.clickAccessoriesButton();
        accessoriesPage.waitForAccessoriesPageToLoad();

        //Add accessories to the cart
        accessoriesPage.addBonbonniere();
        accessoriesPage.addEspressoSpoon();
        System.out.println("Accessories added !");
    }
    @Test(priority = 3)
    public void placeOrder() throws InterruptedException {
        HomepageObject homePage = new HomepageObject(driver);
        String expectedOrderSuccessMessage = "Your order has been received.";
        String expectedThankYouMessage = "THANK YOU FOR YOUR PURCHASE!";
        homePage.openHomePage();
        homePage.acceptPrompt();

        //Go inside the shopping cart
        ShoppingCartPageObject shoppingCart = homePage.openShoppingCart();
        shoppingCart.waitForCartPageToLoad();

        //Proceed to checkout
        CheckoutPageObject checkoutPage = shoppingCart.proceedToCheckout();
        checkoutPage.waitForCheckoutPageToLoad();

        //Go through the form, select delivery address, payment methods, shipping methods
        checkoutPage.clickOnBillingContinueButton();
        checkoutPage.selectStandardShipping();
        checkoutPage.clickOnShippingContinueButton();
        checkoutPage.selectCashOnDelivery();
        checkoutPage.clickOnPaymentContinueButton();
        checkoutPage.writeOrderRemark("This is a test remark written by the automated test suite.");
        OrderSuccessPageObject orderSuccessPage = checkoutPage.placeOrder();
        orderSuccessPage.waitForOrderSuccessPageToLoad();

        //Validate the order success page
        String orderNumber = orderSuccessPage.getOrderNumber();
        String actualOrderSuccessMessage = orderSuccessPage.getOrderReceivedMessage();
        String actualThankYouMessage = orderSuccessPage.getThankYouMessage();
        Assert.assertTrue(expectedOrderSuccessMessage.equals(actualOrderSuccessMessage), "Order received message not correct !" + "\nExpected message: " + expectedOrderSuccessMessage + "\nActual message: "+ actualOrderSuccessMessage);
        Assert.assertTrue(expectedThankYouMessage.equals(actualThankYouMessage), "Thank you message incorrect !" + "\nExpected message: " + expectedThankYouMessage + "\nActual message: " + actualThankYouMessage);
        System.out.println("Order number is " + orderNumber);
        System.out.println("Test Passed !");
    }

}
