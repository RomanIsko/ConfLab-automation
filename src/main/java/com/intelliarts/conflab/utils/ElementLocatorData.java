package com.intelliarts.conflab.utils;

import org.openqa.selenium.By;

public class ElementLocatorData {

    public static final By SIGN_IN_LINK   = By.xpath("/html/body/nav/div/div[2]/ul/li/a");
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON   = By.id("login");
    public static final By LOGO           = By.xpath("html/body/nav/div/div[1]/a");
    public static final By NAV_BAR        = By.xpath("html/body/div[1]/div/div[1]/ul");

    //Conferences view
    public static final By CONFERENCES_LINK        = By.xpath("html/body/div[1]/div/div[1]/ul/li[1]/a");
    public static final By CONFERENCES_PAGE_HEADER = By.id("table-title");
    public static final By ADD_CONFERENCE_BUTTON   = By.id("add-button");
    public static final By CONFERENCE_NAME         = By.id("event-name");
    public static final By CONFERENCE_DESCRIPTION  = By.id("event-description");
    public static final By CONFERENCE_START_DATE   = By.id("event-start-date");
    public static final By CONFERENCE_END_DATE     = By.id("event-end-date");

    //Speakers view
    public static final By SPEAKERS_LINK        = By.xpath("html/body/div[1]/div/div[1]/ul/li[2]/a");
    public static final By SPEAKERS_PAGE_HEADER = By.id("table-title");
    public static final By ADD_SPEAKER_BUTTON   = By.id("add-button");
    public static final By SPEAKER_NAME         = By.id("name");
    public static final By SPEAKER_EMAIL        = By.id("email");
    public static final By SPEAKER_POSITION     = By.id("position");
    public static final By SPEAKER_ABOUT        = By.id("about");

    // Common locators
    public static final By OK_BUTTON     = By.cssSelector(".btn.btn-success");
    public static final By CANCEL_BUTTON = By.cssSelector(".btn.btn-default");
}
