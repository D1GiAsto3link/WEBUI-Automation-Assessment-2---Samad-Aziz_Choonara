package org.Magneto.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Base64;

public class ScreenshotUtils {
    public static String captureScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        return convertToBase64(screenshotBytes);
    }

    private static String convertToBase64(byte[] screenshotBytes) {
        return Base64.getEncoder().encodeToString(screenshotBytes);
    }
}
