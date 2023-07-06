package org.WebUI.Listeners;

import org.WebUI.Tests.AddToCartTest;
import org.WebUI.Tests.CheckoutTest;
import org.testng.TestNG;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {AddToCartTest.class, CheckoutTest.class});
        testng.addListener(new TestListener());
        testng.setParallel("classes");
        testng.setThreadCount(2);
        testng.run();
    }
}
