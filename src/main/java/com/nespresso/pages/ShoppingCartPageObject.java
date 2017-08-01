package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by alex.mihai on 5/17/2017.
 */
public class ShoppingCartPageObject extends BasePageObject<ShoppingCartPageObject>{
    private By shoppingCartHeader = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/h1");
    private By proceedToCheckoutButton = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[2]/button");
    private By emptyCartButton = By.xpath(".//*[@id='empty_cart_button']");
    private By updateCartButton = By.xpath(".//*[@id='shopping-cart-table']/tfoot/tr/td/button[3]");
    private By continueButton = By.xpath(".//*[@id='shopping-cart-table']/tfoot/tr/td/button[4]");
    private By inputQty = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
    private By grandTotal = By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr[1]/td[2]/strong/span");
    private By checkoutButton = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/ul/li[2]/button");
    private By productImg = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[1]/a/img");
    private By productName = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/h2/a");
    private By productSKU = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/div");
    private By productPrice = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[3]/span/span");
    private By productSubtotal = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[5]/span/span");
    private By couponBox = By.xpath(".//*[@id='coupon_code']");
    private By applyButton = By.xpath(".//*[@id='discount-coupon-form']/div/div/div[2]/div/button");
    private By discountCodes = By.xpath(".//*[@id='discount-coupon-form']/div/strong");
    private By tax = By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr[2]/td[2]/span");
    private By emptyCartHeader = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/h1");
    private By emptyCartP1 = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[3]/p[1]");
    private By emptyCartP2 = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[3]/p[2]");
    private By couponSuccessMessage = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/ul/li/ul/li/span");
    private By discountText = By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span");
    private By cancelButton = By.xpath(".//*[@id='discount-coupon-form']/div/div/div[2]/div/button[2]");


    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForCartPageToLoad(){
        waitForVisibilityOf(shoppingCartHeader);
    }

    public void waitForEmptyCartPageToLoad(){
        waitForVisibilityOf(emptyCartHeader);
    }

    public CheckoutPageObject proceedToCheckout(){
        clickOn(proceedToCheckoutButton);
        System.out.println("Proceeding to checkout...");
        return new CheckoutPageObject(driver);
    }

    public CheckoutPageObject proceedToLogInRegister(){
        clickOn(proceedToCheckoutButton);
        System.out.println("Proceeding to the register/login page...");
        return new CheckoutPageObject(driver);
    }

    public String getProductPrice(){
        return getText(productPrice);
    }

    public String getQty(){
        return getValue(inputQty);
    }

    public String getSubtotal(){
        return getText(productSubtotal);
    }

    public String calculateSubtotal(){
        String basePrice = getProductPrice();
        int qty = Integer.parseInt(getQty());
        String numbers = basePrice.substring(4);
        double basePriceInt = Double.parseDouble(numbers);
        double subtotal = qty * basePriceInt;
//        System.out.println("QTY is : " + qty);
//        System.out.println("Base price is : " + basePriceInt);
//        System.out.println("Subtotal is: " + subtotal);
        String finalSubtotal = String.valueOf(subtotal);
        String cleanSubtotal = finalSubtotal.substring(0,finalSubtotal.indexOf("."));
//        System.out.println(cleanSubtotal);
        return cleanSubtotal;
    }

    public String parseSubtotal(){
//        System.out.println("The subtotal is: " + parseSubtotal(productSubtotal));
        return parseSubtotal(productSubtotal);
    }

    public void typeQty(String num){
        driver.findElement(inputQty).clear();
        type(num, inputQty);
    }

    public void updateCart(){
        clickOn(updateCartButton);
    }

    public boolean checkVisibleProductImg(){
        if(driver.findElement(productImg).isDisplayed()) {
            System.out.println("Product image is visible !");
            return true;
        }else{
            System.out.println("Product image is NOT visible !");
            return false;
        }
    }

    public boolean checkVisibleEmptyCartButton(){
        if(driver.findElement(emptyCartButton).isDisplayed()) {
            System.out.println("Empty cart button is visible !");
            return true;
        }else{
            System.out.println("Empty cart button is NOT visible !");
            return false;
        }
    }

    public boolean checkVisibleContinueShoppingButton(){
        if(driver.findElement(continueButton).isDisplayed()) {
            System.out.println("Continue shopping button is displayed !");
            return true;
        }else{
            System.out.println("Continue shopping button is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleCheckoutButton(){
        if(driver.findElement(checkoutButton).isDisplayed()) {
            System.out.println("The checkout button is displayed !");
            return true;
        }else{
            System.out.println("The checkout button is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleUpdateCartButton(){
        if(driver.findElement(updateCartButton).isDisplayed()){
            System.out.println("The update cart button is displayed !");
            return true;
        }else{
            System.out.println("The update cart button is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleProductName(){
        if(driver.findElement(productName).isDisplayed()){
            System.out.println("The product name is displayed !");
            return true;
        }else{
            System.out.println("The product name is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleProductSKU(){
        if(driver.findElement(productSKU).isDisplayed()){
            System.out.println("The product SKU is displayed !");
            return true;
        }else{
            System.out.println("The product SKU is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleCouponField(){
        if(driver.findElement(couponBox).isDisplayed()){
            System.out.println("The coupon field is displayed !");
            return true;
        }else{
            System.out.println("The coupon field is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleDiscountHeader(){
        if(driver.findElement(discountCodes).isDisplayed()){
            System.out.println("The discount codes header is displayed !");
            return true;
        }else{
            System.out.println("The discount codes header is NOT displayed !");
            return false;
        }
    }

    public boolean checkVisibleTax(){
        if(driver.findElement(tax).isDisplayed()){
            System.out.println("The tax is displayed !");
            return true;
        }else{
            System.out.println("The tax is NOT displayed !");
            return false;
        }
    }

    public void clickEmptyCartButton(){
        System.out.println("Clicking on the \"Empty Cart\" Button...");
        clickOn(emptyCartButton);
    }

    public String getTextEmptyCartHeader(){
        return getText(emptyCartHeader);
    }

    public String getTextEmptyCartP1(){
        return getText(emptyCartP1);
    }

    public String getTextEmptyCartP2(){
        return getText(emptyCartP2);
    }

    public String getGrandTotalText(){
        return getText(grandTotal);
    }

    public HomepageObject clickContinueShopping(){
        System.out.println("Clicking on \"Continue shopping\"...");
        clickOn(continueButton);
        return new HomepageObject(driver);
    }

    public String constructMiniCartStatus (){
        String grandTotalText = getGrandTotalText();
        String qty = getQty();
        String finalMsg = qty + " items: " + grandTotalText;
        return finalMsg;
    }

    public void typeCouponCode(String code){
        System.out.println("Typing coupon code...");
        driver.findElement(couponBox).clear();
        type(code, couponBox);
    }

    public void clickApply() throws InterruptedException {
        System.out.println("Clicking on apply...");
        clickOn(applyButton);
        Thread.sleep(15000);
    }

    public String getCouponMsg(){
        return getText(couponSuccessMessage);
    }

    public String getDiscountText(){
        return getText(discountText);
    }

    public void clickCancel() throws InterruptedException {
        System.out.println("Clicking on cancel...");
        clickOn(cancelButton);
        Thread.sleep(15000);
    }









}
