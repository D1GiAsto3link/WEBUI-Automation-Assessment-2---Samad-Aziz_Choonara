package org.Magneto.Application;

import org.Magneto.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Common methods for interacting with web elements

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    // Common methods for capturing screenshots

    public String captureScreenshot() {
        try {
            return ScreenshotUtils.captureScreenshot(driver);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }

    // Other common methods for page actions, navigation, etc.

    // ...
}



