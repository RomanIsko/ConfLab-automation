package com.intelliarts.conflab.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.intelliarts.conflab.automation.utils.ElementLocatorData.LOGIN_BUTTON;
import static com.intelliarts.conflab.automation.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.automation.utils.ElementLocatorData.SIGN_IN_BUTTON;
import static com.intelliarts.conflab.automation.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.automation.utils.ResourcesData.DEFAULT_PASSWORD;
import static com.intelliarts.conflab.automation.utils.ResourcesData.DEFAULT_USERNAME;
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

    protected static void login() {
        driver.findElement(SIGN_IN_BUTTON).click();
        driver.findElement(USERNAME_FIELD).sendKeys(DEFAULT_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(DEFAULT_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }
}