import com.nespresso.base.BaseTest;
import com.nespresso.pages.CapsulePageObject;
import com.nespresso.pages.HomepageObject;
import com.nespresso.pages.ShoppingCartPageObject;
import org.apache.xpath.SourceTree;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alex.mihai on 6/9/2017.
 */
public class CartValidationTest extends BaseTest {
    @Test
    public void validateCart() throws InterruptedException {
        //open homepage
        HomepageObject homepage = new HomepageObject(driver);
        homepage.openHomePage();
        homepage.acceptPrompt();
        //check if the cart is empty
        String emptyCartStatus = homepage.getCartHeaderText();
        String expectedEmptyCartStatus = "Your cart is empty";
        Assert.assertTrue(emptyCartStatus.equals(expectedEmptyCartStatus), "The cart status is not correct ! \nExpected: " + expectedEmptyCartStatus + "\nActual: "+ emptyCartStatus);
        System.out.println("Cart text correct: " + emptyCartStatus);
        //expand the cart and check if the correct text is present
        String emptyExpandedCartStatus = homepage.getCartBodyText();
        String expectedEmptyExpandedCartStatus = "Recently added item(s)\n" +
                "You have no items in your shopping cart.";
        Assert.assertTrue(emptyExpandedCartStatus.equals(expectedEmptyExpandedCartStatus), "The cart status is not correct ! \nExpected: " + expectedEmptyExpandedCartStatus + "\nActual: " + emptyExpandedCartStatus);
        System.out.println("Cart text correct : " + emptyExpandedCartStatus);

        //add some products
        CapsulePageObject capsulePage = homepage.clickCapsuleButton();
        capsulePage.addLivanto();
        String livantoPrice = capsulePage.getLivantoPrice();
        Thread.sleep(10000);
        String cartWithItems = capsulePage.getCartHeaderText();
        Assert.assertFalse(expectedEmptyCartStatus.equals(cartWithItems), "The cart is still empty ! ");
        System.out.println("Products added correctly ! \n" + cartWithItems);
        ShoppingCartPageObject shoppingCart = capsulePage.openShoppingCart();
        shoppingCart.waitForCartPageToLoad();

        //Check item base price
        String actualPrice = shoppingCart.getProductPrice();
        Assert.assertTrue(livantoPrice.equals(actualPrice), "The price is wrong ! " + "\nExpected: " + livantoPrice + "\nActual: " + actualPrice);
        System.out.println("Prices match ! \nExpected : " + livantoPrice + "\nActual: " + actualPrice);

        //Check that the total price is calculated correctly against selected qty
        String calculatedPrice = shoppingCart.calculateSubtotal();
        String subtotalFromCart = shoppingCart.parseSubtotal();
        Assert.assertTrue(calculatedPrice.equals(subtotalFromCart), "The price is wrong !" + "\nExpected: " + calculatedPrice + "\nActual: " + subtotalFromCart);
        System.out.println("Price calculated correctly ! \nExpected: " + calculatedPrice + "\nActual: " + subtotalFromCart);

        //Modify the QTY of the products
        shoppingCart.typeQty("150");
        shoppingCart.updateCart();

        //Check again that the total price is calculated correctly against selected qty
        String calculatedPrice2 = shoppingCart.calculateSubtotal();
        String subtotalFromCart2 = shoppingCart.parseSubtotal();
        Assert.assertTrue(calculatedPrice2.equals(subtotalFromCart2), "The price is wrong !" + "\nExpected: " + calculatedPrice2 + "\nActual: " + subtotalFromCart2);
        System.out.println("Price calculated correctly ! \nExpected: " + calculatedPrice2 + "\nActual: " + subtotalFromCart2);
        String minicartStatus = shoppingCart.constructMiniCartStatus();

        //Check if elements are visible in the cart page
        Assert.assertTrue(shoppingCart.checkVisibleProductImg());
        Assert.assertTrue(shoppingCart.checkVisibleContinueShoppingButton());
        Assert.assertTrue(shoppingCart.checkVisibleEmptyCartButton());
        Assert.assertTrue(shoppingCart.checkVisibleCheckoutButton());
        Assert.assertTrue(shoppingCart.checkVisibleUpdateCartButton());
        Assert.assertTrue(shoppingCart.checkVisibleProductSKU());
        Assert.assertTrue(shoppingCart.checkVisibleProductName());
        Assert.assertTrue(shoppingCart.checkVisibleCouponField());
        Assert.assertTrue(shoppingCart.checkVisibleDiscountHeader());
        Assert.assertTrue(shoppingCart.checkVisibleTax());

        //Check if "Continue Shopping" button works and products are still in cart
        HomepageObject homepage2 = shoppingCart.clickContinueShopping();
        homepage2.waitForHomepageToLoad();
        String actualMiniCartText = homepage2.getCartHeaderText();
        Assert.assertTrue(minicartStatus.equals(actualMiniCartText), "The minicart status is correct!" + "\nExpected: " + minicartStatus + "\nActual: " + actualMiniCartText);
        System.out.println("Minicart status correct ! \nExpected: " + minicartStatus + "\nActual: " + actualMiniCartText);

        //Open the cart again and empty it
        ShoppingCartPageObject shoppingCart2 = homepage2.openShoppingCart();
        shoppingCart2.waitForCartPageToLoad();

        //Check again that the total price is calculated correctly against selected qty
        String calculatedPrice3 = shoppingCart2.calculateSubtotal();
        String subtotalFromCart3 = shoppingCart2.parseSubtotal();
        Assert.assertTrue(calculatedPrice2.equals(subtotalFromCart3), "The price is wrong !" + "\nExpected: " + calculatedPrice3 + "\nActual: " + subtotalFromCart2);
        System.out.println("Price calculated correctly ! \nExpected: " + calculatedPrice3 + "\nActual: " + subtotalFromCart3);

        //Check if elements are visible in the cart page
        Assert.assertTrue(shoppingCart2.checkVisibleProductImg());
        Assert.assertTrue(shoppingCart2.checkVisibleContinueShoppingButton());
        Assert.assertTrue(shoppingCart2.checkVisibleEmptyCartButton());
        Assert.assertTrue(shoppingCart2.checkVisibleCheckoutButton());
        Assert.assertTrue(shoppingCart2.checkVisibleUpdateCartButton());
        Assert.assertTrue(shoppingCart2.checkVisibleProductSKU());
        Assert.assertTrue(shoppingCart2.checkVisibleProductName());
        Assert.assertTrue(shoppingCart2.checkVisibleCouponField());
        Assert.assertTrue(shoppingCart2.checkVisibleDiscountHeader());
        Assert.assertTrue(shoppingCart2.checkVisibleTax());

        //Empty cart and validate
        shoppingCart2.clickEmptyCartButton();
        shoppingCart2.waitForEmptyCartPageToLoad();

        String expectedHeader = "Shopping Cart is Empty";
        String expectedP1 = "You have no items in your shopping cart.";
        String expectedP2 = "Click here to continue shopping.";
        String expectedStatus = "Your cart is empty";
        String actualHeader = shoppingCart2.getTextEmptyCartHeader();
        String actualP1 = shoppingCart2.getTextEmptyCartP1();
        String actualP2 = shoppingCart2.getTextEmptyCartP2();
        String actualStatus = shoppingCart2.getCartHeaderText();

        Assert.assertTrue(expectedHeader.equals(actualHeader), "Cart Header mismatch !" + "\nExpected: " + expectedHeader + "\nActual: " + actualHeader);
        Assert.assertTrue(expectedP1.equals(actualP1), "Cart paragraph mismatch !" + "\nExpected: " + expectedP1 + "\nActual: " + actualP1);
        Assert.assertTrue(expectedP2.equals(actualP2), "Cart paragraph mismatch !" + "\nExpected: " + expectedP2 + "\nActual: " + actualP2);
        Assert.assertTrue(expectedStatus.equals(actualStatus), "Cart status mismatch !" + "\nExpected: " + expectedStatus + "\nActual: " + actualStatus);





    }
}
