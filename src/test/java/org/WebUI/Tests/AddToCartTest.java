package org.WebUI.Tests;

import org.Magneto.Application.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test(dataProvider = "testData")
    public void addToCartTest(String productName) {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        // Perform test steps
        homePage.searchProduct(productName);
        // ... additional steps for adding product to cart
    }

    @DataProvider(name = "testData")
    public Object[][] getTestData() throws IOException {
        return getTestData("Luma Test Cases");
    }
}
