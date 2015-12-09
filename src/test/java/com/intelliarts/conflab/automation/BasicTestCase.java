package com.intelliarts.conflab.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.intelliarts.conflab.automation.utils.ResourcesData.DEPLOYMENT_URL;

public class BasicTestCase {
    protected static WebDriver driver;

    protected static void basicSetUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DEPLOYMENT_URL);
    }

    protected static void basicTearDown() {
        driver.quit();
    }
}