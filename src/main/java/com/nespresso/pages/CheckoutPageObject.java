package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/17/2017.
 */
public class CheckoutPageObject extends BasePageObject<CheckoutPageObject>{
    private By billingHeader = By.xpath(".//*[@id='opc-billing']/div[1]/h2");
    private By billingContinueButton = By.xpath(".//*[@id='billing-buttons-container']/button");
    private By standardShipping = By.xpath(".//*[@id='checkout-shipping-method-load']/dl/dd[1]/ul/li/label");
    private By shippingContinueButton= By.xpath(".//*[@id='shipping-method-buttons-container']/button");
    private By cashOnDelivery = By.xpath(".//*[@id='dt_method_CA']/label");
    private By paymentContinueButton = By.xpath(".//*[@id='payment-buttons-container']/button");
    private By orderRemark = By.xpath(".//*[@id='remark']");
    private By placeOrderButton = By.xpath(".//*[@id='review-buttons-container']/button");


    protected CheckoutPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForCheckoutPageToLoad(){
        waitForVisibilityOf(billingHeader);
    }

    public void clickOnBillingContinueButton() throws InterruptedException{
        clickOn(billingContinueButton);
        System.out.println("Clicking on continue button from Billing section...");
        Thread.sleep(4000);
    }

    public void selectStandardShipping(){
        clickOn(standardShipping);
        System.out.println("Selecting Standard Shipping...");
    }

    public void clickOnShippingContinueButton() throws InterruptedException{
        clickOn(shippingContinueButton);
        System.out.println("Clicking on continue button from Shipping method section...");
        Thread.sleep(4000);
    }

    public void selectCashOnDelivery(){
        clickOn(cashOnDelivery);
        System.out.println("Selecting Cash On Delivery...");
    }

    public void clickOnPaymentContinueButton() throws InterruptedException{
        clickOn(paymentContinueButton);
        System.out.println("Clicking on continue button from the Payment info section...");
        Thread.sleep(4000);
    }

    public void writeOrderRemark(String remark){
        System.out.println("Writing an order remark...");
        type(remark, orderRemark);
    }

    public OrderSuccessPageObject placeOrder(){
        clickOn(placeOrderButton);
        System.out.println("Placing order...");
        return new OrderSuccessPageObject(driver);
    }







}
