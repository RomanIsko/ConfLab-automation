package com.intelliarts.conflab.automation.web.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_PASSWORD;
import static com.intelliarts.conflab.utils.ResourcesData.DEFAULT_USERNAME;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;

public class BasicTestCaseSelenide {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    protected static void basicSetUp() {
        Configuration.baseUrl = DEPLOYMENT_URL;
        open("/");
    }

    protected static void login() {
        $(SIGN_IN_LINK).click();
        $(USERNAME_FIELD).val(DEFAULT_USERNAME);
        $(PASSWORD_FIELD).val(DEFAULT_PASSWORD).pressEnter();
    }
}