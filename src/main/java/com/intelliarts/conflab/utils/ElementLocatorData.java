package com.intelliarts.conflab.utils;

import org.openqa.selenium.By;

public class ElementLocatorData {

    public static final By SIGN_IN_LINK    = By.xpath("/html/body/nav/div/div[2]/ul/li/a");
    public static final By SIGN_OUT_REGION = By.id("account-menu-region");
    public static final By SIGN_OUT_LINK   = By.xpath("html/body/nav/div/div[2]/ul/li/ul/li[3]");
    public static final By USERNAME_FIELD  = By.id("username");
    public static final By PASSWORD_FIELD  = By.id("password");
    public static final By LOGIN_BUTTON    = By.id("login");
    public static final By LOGO            = By.xpath("html/body/nav/div/div[1]/a");
    public static final By NAV_BAR         = By.id("app-manu-region");

    //Events view
    public static final By EVENTS_LINK             = By.xpath("(//*[@id='app-manu-region']/ul/li//a)[1]");
    public static final By EVENTS_PAGE_HEADER      = By.id("table-title");
    public static final By EVENTS_LIST             = By.id("list-region");
    public static final By EVENT_EDIT_REGION       = By.id("edit-region");
    public static final By EVENT_TITLE             = By.id("page-title");
    public static final By EVENT_TABS              = By.cssSelector(".nav.nav-tabs");
    public static final By INFO_FORM               = By.xpath("html/body/div[1]/div/div[2]/div/div[2]");
    public static final By FORM_EDIT_BUTTON        = By.cssSelector(".glyphicon.glyphicon-pencil.edit");
    public static final By INFO_TAB                = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/ul/li[1]");
    public static final By SPEAKERS_TAB            = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/ul/li[2]");
    public static final By SPEECHES_TAB            = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/ul/li[3]");
    public static final By PARTNERS_TAB            = By.xpath("html/body/div[1]/div/div[2]/div/div[1]/ul/li[4]");
    public static final By EVENT_NAME              = By.id("name");
    public static final By EVENT_NAME_LABEL        = By.xpath("//label[@for='name']");
    public static final By EVENT_DESCRIPTION       = By.id("description");
    public static final By EVENT_DESCRIPTION_LABEL = By.xpath("//label[@for='description']");
    public static final By EVENT_START_DATE        = By.id("startDate");
    public static final By EVENT_START_DATE_LABEL  = By.xpath("//label[@for='startDate']");
    public static final By EVENT_END_DATE          = By.id("endDate");
    public static final By EVENT_END_DATE_LABEL    = By.xpath("//label[@for='endDate']");
    public static final By EVENT_COUNTRY           = By.id("eventCountry");
    public static final By EVENT_COUNTRY_LABEL     = By.xpath("//label[@for='eventCountry']");
    public static final By EVENT_CITY              = By.id("eventCity");
    public static final By EVENT_CITY_LABEL        = By.xpath("//label[@for='eventCity']");
    public static final By EVENT_ADDRESS           = By.id("eventAddress");
    public static final By EVENT_ADDRESS_LABEL     = By.xpath("//label[@for='eventAddress']");
    public static final By EVENT_CONTACTS          = By.id("eventContacts");
    public static final By EVENT_CONTACTS_LABEL    = By.xpath("//label[@for='eventContacts']");
    public static final By ADD_NEW_BUTTON          = By.id("new-button");
    public static final By ADD_FROM_LIST_DROPDOWN  = By.id("select2-selected-item-container");
    public static final By SPEECHES_TITLE          = By.id("page-title");

    public static final By EVENT_NAME_VALIDATION_MESSAGE        =
            By.xpath("//input[@id='name']/following-sibling::span");
    public static final By EVENT_DESCRIPTION_VALIDATION_MESSAGE =
            By.xpath("//textarea[@id='description']/following-sibling::span");
    public static final By EVENT_START_DATE_VALIDATION_MESSAGE  =
            By.xpath("//input[@id='startDate']/following-sibling::span");
    public static final By EVENT_END_DATE_VALIDATION_MESSAGE    =
            By.xpath("//input[@id='endDate']/following-sibling::span");
    public static final By EVENT_COUNTRY_VALIDATION_MESSAGE     =
            By.xpath("//input[@id='eventCountry']/following-sibling::span");
    public static final By EVENT_CITY_VALIDATION_MESSAGE        =
            By.xpath("//input[@id='eventCity']/following-sibling::span");
    public static final By EVENT_ADDRESS_VALIDATION_MESSAGE     =
            By.xpath("//input[@id='eventAddress']/following-sibling::span");
    public static final By EVENT_CONTACTS_VALIDATION_MESSAGE    =
            By.xpath("//input[@id='eventContacts']/following-sibling::span");

    //Speakers view
    public static final By SPEAKERS_LINK          = By.xpath("(//*[@id='app-manu-region']/ul/li//a)[2]");
    public static final By SPEAKERS_PAGE_HEADER   = By.id("table-title");
    public static final By SPEAKERS_LIST          = By.id("list-region");
    public static final By SPEAKER_EDIT_REGION    = By.id("edit-region");
    public static final By SPEAKER_NAME           = By.id("name");
    public static final By SPEAKER_NAME_LABEL     = By.xpath("//label[@for='name']");
    public static final By SPEAKER_EMAIL          = By.id("email");
    public static final By SPEAKER_EMAIL_LABEL    = By.xpath("//label[@for='email']");
    public static final By SPEAKER_POSITION       = By.id("position");
    public static final By SPEAKER_POSITION_LABEL = By.xpath("//label[@for='position']");
    public static final By SPEAKER_ABOUT          = By.id("about");
    public static final By SPEAKER_ABOUT_LABEL    = By.xpath("//label[@for='about']");

    public static final By SPEAKER_NAME_VALIDATION_MESSAGE     =
            By.xpath("//input[@id='name']/following-sibling::span");
    public static final By SPEAKER_EMAIL_VALIDATION_MESSAGE    =
            By.xpath("//input[@id='email']/following-sibling::span");
    public static final By SPEAKER_POSITION_VALIDATION_MESSAGE =
            By.xpath("//input[@id='position']/following-sibling::span");
    public static final By SPEAKER_ABOUT_VALIDATION_MESSAGE    =
            By.xpath("//textarea[@id='about']/following-sibling::span");

    //Speeches view
    public static final By SPEECHES_LINK                   = By.xpath("(//*[@id='app-manu-region']/ul/li//a)[3]");
    public static final By SPEECHES_PAGE_HEADER            = By.id("table-title");
    public static final By SPEECHES_LIST                   = By.id("list-region");
    public static final By SPEECH_EDIT_REGION              = By.id("edit-region");
    public static final By SPEECH_TITLE                    = By.id("title");
    public static final By SPEECH_DESCRIPTION              = By.id("description");
    public static final By SPEECH_LANGUAGE                 = By.id("lang");
    public static final By SPEECH_TITLE_VALIDATION_MESSAGE = By.xpath("//input[@id='title']/following-sibling::span");

    public static final String ENGLISH   = "English";
    public static final String UKRAINIAN = "Ukrainian";
    public static final String RUSSIAN   = "Russian";

    // Common locators
    public static final By OK_BUTTON     = By.cssSelector(".btn.btn-success");
    public static final By CANCEL_BUTTON = By.cssSelector(".btn.btn-default");
    public static final By EDIT_BUTTON   = By.id("edit-button");
    public static final By ADD_BUTTON    = By.id("add-button");
}
