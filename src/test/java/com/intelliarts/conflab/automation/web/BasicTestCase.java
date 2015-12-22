package com.intelliarts.conflab.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.intelliarts.conflab.utils.ElementLocatorData.LOGIN_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_PASSWORD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_USERNAME;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;

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
        driver.findElement(SIGN_IN_LINK).click();
        driver.findElement(USERNAME_FIELD).sendKeys(DEFAULT_USERNAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(DEFAULT_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }
}