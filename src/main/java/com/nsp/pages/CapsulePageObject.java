package com.nsp.pages;

import com.nsp.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
    private By kazaarPDP = By.xpath("html/body/div[2]/div/div[2]/div/div[4]/div[2]/ul/li[12]/a/img");

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
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,-1200)");
        Thread.sleep(5000);
        System.out.println("Clicking on machine button...");
        clickOn(machineButton);
        return new MachinePageObject(driver);
    }

    public void addLivanto() throws InterruptedException {
        System.out.println("Adding 100 Livanto capsules to cart...");
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,1000)");
        clickOn(livantoAdd);
        Thread.sleep(10000);
        clickOn(livantoQty);
        Thread.sleep(15000);
        System.out.println("Capsules added !");
    }

    public void addRoma() throws InterruptedException {
        System.out.println("Adding 100 Roma capsules to cart...");
        clickOn(romaAdd);
        Thread.sleep(10000);
        clickOn(romaQty);
        Thread.sleep(15000);
        System.out.println("Capsules added !");
    }

    public KazaarPDPObject openKazaarPDP (){
        System.out.println("Clicking on Kazaar...");
        clickOn(kazaarPDP);
        return new KazaarPDPObject(driver);
    }



}
