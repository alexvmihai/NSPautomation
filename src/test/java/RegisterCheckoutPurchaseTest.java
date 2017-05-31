import com.nespresso.base.BaseTest;
import com.nespresso.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 5/30/2017.
 */
public class RegisterCheckoutPurchaseTest extends BaseTest {
    @Test (priority = 1)
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

    @Test (priority = 2)
    public void registerCheckout () throws InterruptedException{
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        ShoppingCartPageObject cartPage = homepage.openShoppingCart();
        cartPage.waitForCartPageToLoad();
        CheckoutPageObject checkoutLoginPage = cartPage.proceedToLogInRegister();
        checkoutLoginPage.waitForCheckoutLoginPageToLoad();
        RegisterPageObject registerCheckoutPage = checkoutLoginPage.clickRegisterButtonCheckout();
        registerCheckoutPage.waitForRegisterPageToLoad();

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
        String expectedOrderSuccessMessage = "Your order has been received.";
        String expectedThankYouMessage = "THANK YOU FOR YOUR PURCHASE!";
        registerCheckoutPage.fillInRegisterFormCheckout(firstName, lastName, email, password, civility, city, street, building, postalCode, remark, phone);
        CheckoutPageObject checkoutPage = registerCheckoutPage.clickBillingContinueButton();
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
        System.out.println("Order number is : "+ orderNumber);
        System.out.println("Test Passed !");
    }
}
