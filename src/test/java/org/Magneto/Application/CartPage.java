package org.Magneto.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By checkoutButton = By.cssSelector(".action.primary.checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        WebElement checkoutButtonElement = driver.findElement(checkoutButton);
        checkoutButtonElement.click();
    }

    // Other methods specific to the cart page
}







