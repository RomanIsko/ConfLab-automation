package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.intelliarts.conflab.utils.ConfLabEvent;
import com.intelliarts.conflab.utils.ConfLabSpeaker;
import com.intelliarts.conflab.utils.ConfLabSpeech;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_OUT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_PASSWORD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_USERNAME;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;

public class BasicTestCase {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    protected static void basicSetUp() {
        Configuration.baseUrl = DEPLOYMENT_URL;
        open("/");
    }

    protected static void basicTearDown() {
        close();
    }

    protected static void login() {
        $(SIGN_IN_LINK).click();
        $(USERNAME_FIELD).val(DEFAULT_USERNAME);
        $(PASSWORD_FIELD).val(DEFAULT_PASSWORD).pressEnter();
    }

    protected static void addMultipleEvents(int count) {
        for (int i = 0; i < count; i++) {
            new ConfLabEvent().addViaWeb();
        }
    }

    protected static void addMultipleSpeakers(int count) {
        for (int i = 0; i < count; i++) {
            new ConfLabSpeaker().addViaWeb();
        }
    }

    protected static void addMultipleSpeeches(int count) {
        for (int i = 0; i < count; i++) {
            new ConfLabSpeech().addViaWeb();
        }
    }

    protected static void logout() {
        $(SIGN_OUT_REGION).click();
        $(By.linkText("Sign Out")).click();
    }
}