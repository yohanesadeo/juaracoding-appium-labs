package com.juaracoding.labs;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppTest {
    private AndroidDriver driver;
    private UiAutomator2Options options;

    @BeforeClass
    public void test01() throws MalformedURLException {
        options = new UiAutomator2Options();
        options.setCapability("appium:deviceName", "RR8T90084BR");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:appPackage", "com.google.android.calculator");
        options.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.hideKeyboard();
    }

    @Test
    public void additionalTest() throws InterruptedException {
        WebElement button9 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9"));
        WebElement buttonPlus = driver.findElement(AppiumBy.accessibilityId("plus"));
        WebElement button5 = driver.findElement(AppiumBy.accessibilityId("5"));
        WebElement buttonEq = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));

        button9.click();
        Thread.sleep(1000);
        buttonPlus.click();
        Thread.sleep(1000);
        button5.click();
        Thread.sleep(1000);
        buttonEq.click();
        Thread.sleep(1000);

        WebElement result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));

        Assert.assertEquals(result.getText(), "14");

    }

    @AfterClass
    public void test02() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
