package com.intelliarts.conflab.automation.utils;

import org.openqa.selenium.By;

public class ElementLocatorData {

    public static final By SIGN_IN_BUTTON = By.xpath("/html/body/nav/div/div[2]/ul/li/a");
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGO           = By.xpath("html/body/nav/div/div[1]/a");
    public static final By NAV_BAR        = By.xpath("html/body/div[1]/div/div[1]/ul");
}
