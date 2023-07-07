package org.WebUI.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.Magneto.Application.BasePage;
import org.Magneto.Data.TestData;
import org.Magneto.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest extends BasePage {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private ExcelUtils readTestData;

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com ");

        readTestData = new ExcelUtils();
        ExcelUtils.readTestData();
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
        return ExcelUtils.readTestData(Luna_Test_cases_1);
    }
}