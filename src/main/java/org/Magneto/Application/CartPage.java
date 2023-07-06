package org.Magneto.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By checkoutButton = By.cssSelector(".action.primary.checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        WebElement checkoutButtonElement = driver.findElement(checkoutButton);
        checkoutButtonElement.click();
    }

    // Other methods specific to the cart page
}







