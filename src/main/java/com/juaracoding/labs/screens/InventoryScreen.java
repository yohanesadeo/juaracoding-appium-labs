package com.juaracoding.labs.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InventoryScreen {
    private AndroidDriver driver;
    private By header = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");

    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

}
