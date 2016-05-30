package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.intelliarts.conflab.utils.ConfLabCompany;
import com.intelliarts.conflab.utils.ConfLabEvent;
import com.intelliarts.conflab.utils.ConfLabSpeaker;
import com.intelliarts.conflab.utils.ConfLabSpeech;
import org.junit.Rule;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_OUT_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_OUT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_PASSWORD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_USERNAME;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;

public class BasicTestCase {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    private   Faker   faker   = new Faker();
    protected Lorem   lorem   = faker.lorem();
    protected Company company = faker.company();

    protected static void basicSetUp() {
        Configuration.baseUrl = DEPLOYMENT_URL;
        //        Configuration.clickViaJs = true;
        Configuration.browserSize = "1920x1080";
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

    protected static void addMultipleCompanies(int count) {
        for (int i = 0; i < count; i++) {
            new ConfLabCompany().addViaWeb();
        }
    }

    protected static void logout() {
        $(SIGN_OUT_REGION).click();
        $(SIGN_OUT_LINK).click();
    }
}
