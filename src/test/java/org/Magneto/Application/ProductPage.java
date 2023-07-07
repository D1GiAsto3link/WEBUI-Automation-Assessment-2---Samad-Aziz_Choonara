package org.Magneto.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private final By addToCartButton = By.cssSelector(".action.tocart.primary");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        WebElement addToCartButtonElement = driver.findElement(addToCartButton);
        addToCartButtonElement.click();
    }

    // Other methods specific to the product page
}
