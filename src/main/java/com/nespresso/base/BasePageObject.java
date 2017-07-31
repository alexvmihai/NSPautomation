package com.nespresso.base;

import com.nespresso.pages.AccessoriesPageObject;
import com.nespresso.pages.CapsulePageObject;
import com.nespresso.pages.MachinePageObject;
import com.nespresso.pages.ShoppingCartPageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By cartStatus = By.xpath(".//*[@id='header']/div/div[3]/div[3]/div[2]/div[1]/span");
    protected By cartHeader = By.xpath(".//*[@id='header-cart']/div[3]");
    protected By cartButtonArrow = By.xpath(".//*[@id='header']/div/div[3]/div[3]/div[2]/div[1]/em[2]");
    protected By viewShoppingCart = By.xpath(".//*[@id='header-cart']/div[3]/div[4]/ul/li/a");

    protected BasePageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    protected T getPage(String url){
        driver.get(url);
        return (T) this;
    }

    public boolean isAlertPresent(){
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException Ex){
            return false;
        }
    }
    public void acceptPrompt() throws InterruptedException {
        if (isAlertPresent()){
            driver.switchTo().alert().accept();
        }
        Thread.sleep(6000);
    }

    protected void type(String text, By element){
        find(element).sendKeys(text);
    }

    protected void deleteText(By element){
        find(element).clear();
    }

    protected void clickOn (By element){
        find(element).click();
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void waitForVisibilityOf (By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while (attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length >0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e){
            }
            attempts++;
        }
    }

    private void waitFor (ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    protected String getText(By element) {
        return find(element).getText();
    }

    protected String parseSubtotal(By element){
        String a = find(element).getText();
        String[] b = a.split(",");
        String c = b[0] + b[1];
        String d = c.substring(0, c.indexOf("."));
        String e = d.substring(4);
        return e;
    }

    protected String getValue(By element){
        return find(element).getAttribute("value");
    }

    public String getSource(){
        return driver.getPageSource();
    }


    public String getCartHeaderText(){
        return getText(cartStatus);
    }

    public String getCartBodyText(){
        clickOn(cartButtonArrow);
        return getText(cartHeader);
    }

    public ShoppingCartPageObject openShoppingCart() throws InterruptedException{
        clickOn(cartButtonArrow);
        Thread.sleep(2000);
        clickOn(viewShoppingCart);
        return new ShoppingCartPageObject(driver);
    }

}
