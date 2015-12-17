package com.intelliarts.conflab.utils;

import org.openqa.selenium.By;

public class ElementLocatorData {

    public static final By SIGN_IN_BUTTON = By.xpath("/html/body/nav/div/div[2]/ul/li/a");
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON   = By.id("login");
    public static final By LOGO           = By.xpath("html/body/nav/div/div[1]/a");
    public static final By NAV_BAR        = By.xpath("html/body/div[1]/div/div[1]/ul");

    //Conferences view
    public static final By CONFERENCES_LINK        = By.xpath("html/body/div[1]/div/div[1]/ul/li[1]/a");
    public static final By CONFERENCES_PAGE_HEADER = By.xpath("html/body/div[1]/div/div[2]/div/h1");

    //Speakers view
    public static final By SPEAKERS_LINK        = By.xpath("html/body/div[1]/div/div[1]/ul/li[2]/a");
    public static final By SPEAKERS_PAGE_HEADER = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/h1");
    public static final By ADD_SPEAKER_BUTTON   = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/a");
}
