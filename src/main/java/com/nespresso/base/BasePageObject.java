package com.nespresso.base;

import com.nespresso.pages.AccessoriesPageObject;
import com.nespresso.pages.CapsulePageObject;
import com.nespresso.pages.MachinePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex.mihai on 5/8/2017.
 */
public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;



    protected BasePageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    protected T getPage(String url){
        driver.get(url);
        return (T) this;
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

    public String getSource(){
        return driver.getPageSource();
    }

    public void acceptPrompt() throws InterruptedException{
        Thread.sleep(4000);
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
    }










}
