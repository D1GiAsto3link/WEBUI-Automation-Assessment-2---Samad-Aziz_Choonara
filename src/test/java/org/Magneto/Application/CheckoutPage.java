package org.Magneto.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email");
    private By placeOrderButton = By.cssSelector(".action.primary.checkout");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterShippingDetails(String firstName, String lastName, String email) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        WebElement emailFieldElement = driver.findElement(emailField);

        firstNameFieldElement.sendKeys(firstName);
        lastNameFieldElement.sendKeys(lastName);
        emailFieldElement.sendKeys(email);
    }

    public void clickPlaceOrderButton() {
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButton);
        placeOrderButtonElement.click();
    }

    // Other methods specific to the checkout page

}
