package org.WebUI.Tests;

import org.Magneto.Application.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest extends BasePage {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name provided: " + browser);
        }

        driverThreadLocal.set(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
        driverThreadLocal.remove();
    }

    protected Object[][] getTestData(String sheetName) throws IOException {
        return ExcelUtils.getTestData(sheetName);
    }
}