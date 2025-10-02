package com.juaracoding.labs.screens;
  
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class OverviewScreen {
    private AndroidDriver driver;

    private By headerTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]");
    private By buttonFinish = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    private By contentDescription = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup");
    private WebDriverWait wait;

    public OverviewScreen(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(contentDescription));

        Map<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("elementId", ((RemoteWebElement) el).getId());
        scrollObject.put("direction", "down");
        scrollObject.put("percent", 0.7);
        scrollObject.put("speed", 1000);
        js.executeScript("mobile: scrollGesture", scrollObject);
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonFinish)).click();
    }
}


