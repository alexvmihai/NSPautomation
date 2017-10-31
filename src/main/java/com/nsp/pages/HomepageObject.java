package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by alex.mihai on 5/12/2017.
 */
public class HomepageObject extends BasePageObject<HomepageObject> {
    private String homePageURL = "https://www-pprd-ru.nespresso.com/ru/en/";
    protected By capsuleButton = By.cssSelector(".level0.has-children.color-blue.icon-capsule");
    protected By homepageButton = By.xpath(".//*[@id='header']/div/a/img");
    protected By footer = By.xpath(".//*[@id='top']/body/div[2]/div/div[3]/div");
    protected By carousel = By.cssSelector(".slider-item.cycle-slide.cycle-slide-active>a>img");
    protected By cartButtonArrow = By.xpath(".//*[@id='header']/div/div[3]/div[3]/div[2]/div[1]/em[2]");
    protected By viewCartButton = By.xpath(".//*[@id='header-cart']/div[3]/div[4]/ul/li/a");
    protected By removeButton = By.xpath("html/body/div[2]/div/div[1]/header/div/div[3]/div[3]/div[2]/div[2]/div[3]/div[1]/ul/li/div/a[2]");


    public HomepageObject(WebDriver driver){
        super(driver);
    }

    public void openHomePage(){
        getPage(homePageURL);
    }
    public void waitForHomepageToLoad(){
        waitForVisibilityOf(homepageButton);
        waitForVisibilityOf(footer);
        waitForVisibilityOf(carousel);
    }
    public CapsulePageObject clickCapsuleButton() {
        System.out.println("Clicking on capsules button...");
        clickOn(capsuleButton);
        return new CapsulePageObject(driver);
    }

    public void emptyCart() throws InterruptedException {
        clickOn(cartButtonArrow);
        Thread.sleep(3000);
        clickOn(removeButton);
        Thread.sleep(2000);
        acceptPrompt();
        Thread.sleep(9000);
    }






}
