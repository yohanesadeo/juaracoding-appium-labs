package com.juaracoding.labs.screens;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ShippingScreen {
    private AndroidDriver driver;

    private By headerTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: INFORMATION\"]");
    private By firstName = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    private By lastName = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    private By zipCode = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    private By buttonContinue = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");

    public ShippingScreen(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public void inputInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.zipCode).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(buttonContinue).click();
    }

    public void fillShippingInformation(String firstName, String lastName, String zipCode) {
        inputInformation(firstName, lastName, zipCode);
        clickContinue();
    }

}
