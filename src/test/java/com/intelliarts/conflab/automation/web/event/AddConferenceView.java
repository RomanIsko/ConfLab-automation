package com.intelliarts.conflab.automation.web.event;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_CONFERENCE_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCE_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCE_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCE_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCE_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddConferenceView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(CONFERENCES_LINK).click();
        $(ADD_CONFERENCE_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        $(CONFERENCE_NAME).shouldBe(visible);
    }

    @Test
    public void conferenceDescriptionIsDisplayed() throws Exception {
        $(CONFERENCE_DESCRIPTION).shouldBe(visible);
    }

    @Test
    public void startDateFieldIsDisplayed() throws Exception {
        $(CONFERENCE_START_DATE).shouldBe(visible);
    }

    // enable after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Ignore
    @Test
    public void startDateFieldHasTypeDate() throws Exception {
        $(CONFERENCE_START_DATE).shouldHave(type("date"));
    }

    // TODO: 26.12.15 Remove after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Test
    public void startDateFieldHasTypeDateWithJs() throws Exception {
        String elementType =
                executeJavaScript("return document.getElementById('event-start-date').getAttribute('type')").toString();
        assertThat(elementType, is("date"));
    }

    @Test
    public void endDateFieldIsDisplayed() throws Exception {
        $(CONFERENCE_END_DATE).shouldBe(visible);
    }

    // enable after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Ignore
    @Test
    public void endDateFieldHasTypeDate() throws Exception {
        $(CONFERENCE_END_DATE).shouldHave(type("date"));
    }

    // TODO: 26.12.15 Remove after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Test
    public void endDateFieldHasTypeDateWithJs() throws Exception {
        String elementType =
                executeJavaScript("return document.getElementById('event-end-date').getAttribute('type')").toString();
        assertThat(elementType, is("date"));
    }

    @Test
    public void okButtonIsDisplayed() throws Exception {
        $(OK_BUTTON).shouldBe(visible);
    }

    @Test
    public void okButtonHasTypeSubmit() throws Exception {
        $(OK_BUTTON).shouldHave(type("submit"));
    }

    @Test
    public void cancelButtonIsDisplayed() throws Exception {
        $(CANCEL_BUTTON).shouldBe(visible);
    }
}
