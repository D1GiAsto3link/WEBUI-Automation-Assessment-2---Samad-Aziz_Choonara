package org.Magneto.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By searchField = By.id("search");
    private By searchButton = By.cssSelector(".action.search");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(searchField);
        WebElement searchButtonElement = driver.findElement(searchButton);

        searchInput.sendKeys(productName);
        searchButtonElement.click();
    }

    // Other methods specific to the home page


    // Add more methods specific to the home page if needed


}
