package org.WebUI.Tests;

import org.Magneto.Application.CartPage;
import org.Magneto.Application.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

    @Test(dataProvider = "testData")
    public void checkoutTest(String productName, String firstName, String lastName, String email) {
        WebDriver driver = getDriver();
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Perform test steps
        // ... steps for adding product to cart
        cartPage.clickCheckoutButton();
        checkoutPage.enterShippingDetails(firstName, lastName, email);
        // ... additional steps for checkout process
    }

    @DataProvider(name = "testData")
    public Object[][] getTestData() throws IOException {
        return getTestData("Luma Test Cases");
    }
    }
