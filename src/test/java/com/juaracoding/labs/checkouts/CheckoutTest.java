package com.juaracoding.labs.checkouts;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.labs.screens.CheckoutScreen;
import com.juaracoding.labs.screens.FinalCheckoutInformation;
import com.juaracoding.labs.screens.InventoryScreen;
import com.juaracoding.labs.screens.LoginScreen;
import com.juaracoding.labs.screens.OverviewScreen;
import com.juaracoding.labs.screens.ShippingScreen;
import com.juaracoding.labs.services.DriverService;

import io.appium.java_client.android.AndroidDriver;

public class CheckoutTest {
    
    @Test
    public void testCheckout() throws MalformedURLException {
        AndroidDriver driver = DriverService.buildDriver();
        
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login();

        InventoryScreen inventoryScreen = new InventoryScreen(driver);
        inventoryScreen.addToCartBy(0);

        CheckoutScreen checkoutScreen = new CheckoutScreen(driver);
        checkoutScreen.cart();
        checkoutScreen.checkout();


        ShippingScreen shippingScreen = new ShippingScreen(driver);
        shippingScreen.inputInformation("Maharani", "Andika", "91010");
        shippingScreen.clickContinue();

        OverviewScreen overviewScreen = new OverviewScreen(driver);
        overviewScreen.scrollToBottom();
        overviewScreen.clickFinish();

        FinalCheckoutInformation finalCheckoutInformation = new FinalCheckoutInformation(driver);
        Assert.assertEquals(finalCheckoutInformation.getHeaderTitle(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(finalCheckoutInformation.getThankYouText(), "THANK YOU FOR YOU ORDER");

        driver.quit();

    }


}
