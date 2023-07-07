package org.Magneto.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = createInstance();
        }
        return extentReports;
    }

    private static ExtentReports createInstance() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }
}
