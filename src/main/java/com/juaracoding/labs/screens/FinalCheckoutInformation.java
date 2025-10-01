package com.juaracoding.labs.screens;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class FinalCheckoutInformation {
    private AndroidDriver driver;

    private By headerTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    private By thankYouText = AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR SWAG LABS\"]");

    public FinalCheckoutInformation(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public String getThankYouText() {
        return driver.findElement(thankYouText).getText();
    }

}
