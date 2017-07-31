package com.nespresso.pages;

import com.nespresso.base.BasePageObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex.mihai on 5/12/2017.
 */
public class CapsulePageObject extends BasePageObject<CapsulePageObject> {
    private By capsuleAddressTree = By.cssSelector(".category3>strong");
    protected By machineButton = By.xpath(".//*[@id='nav']/ol/li[2]/a");
    private By livantoAdd = By.xpath(".//*[@id='add-to-cart-273']/div/div/button");
    private By livantoQty = By.xpath(".//*[@id='add-to-cart-273']/div/div/div/div[1]/table/tbody/tr[2]/td[5]");
    private By romaAdd = By.xpath(".//*[@id='add-to-cart-272']/div/div/button");
    private By romaQty = By.xpath(".//*[@id='add-to-cart-272']/div/div/div/div[1]/table/tbody/tr[2]/td[5]");
    private By homepageButton = By.xpath(".//*[@id='header']/div/a/img");
    private By livantoPrice = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[4]/div[3]/ul/li[14]/div/div[1]");

    public CapsulePageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForCapsulePageToLoad(){
        waitForVisibilityOf(capsuleAddressTree);
    }

    public HomepageObject clickHomepageLogo(){
        clickOn(homepageButton);
        System.out.println("Clicked homepage Button !");
        return new HomepageObject(driver);
    }

    public MachinePageObject clickMachineButton() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,-700)");
        Thread.sleep(500);
        System.out.println("Clicking on machine button...");
        clickOn(machineButton);
        return new MachinePageObject(driver);
    }

    public void addLivanto() throws InterruptedException {
        System.out.println("Adding 100 Livanto capsules to cart...");
        clickOn(livantoAdd);
        Thread.sleep(2000);
        clickOn(livantoQty);
        Thread.sleep(2000);
        System.out.println("Capsules added !");
    }

    public void addRoma() throws InterruptedException {
        System.out.println("Adding 100 Roma capsules to cart...");
        clickOn(romaAdd);
        Thread.sleep(2000);
        clickOn(romaQty);
        Thread.sleep(2000);
        System.out.println("Capsules added !");
    }

    public String getLivantoPrice(){
        return getText(livantoPrice);
    }

}
