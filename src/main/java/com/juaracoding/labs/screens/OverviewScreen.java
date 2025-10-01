package com.juaracoding.labs.screens;
  
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class OverviewScreen {
    private AndroidDriver driver;

    private By headerTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]");
    private By buttonFinish = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");

    public OverviewScreen(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public void clickFinish() {
        driver.findElement(buttonFinish).click();
    }
}


