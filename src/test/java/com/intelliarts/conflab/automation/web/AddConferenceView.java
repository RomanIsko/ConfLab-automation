package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

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
        driver.findElement(CONFERENCES_LINK).click();
        driver.findElement(ADD_CONFERENCE_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(CONFERENCE_NAME).isDisplayed(), is(true));
    }

    @Test
    public void conferenceDescriptionIsDisplayed() throws Exception {
        assertThat(driver.findElement(CONFERENCE_DESCRIPTION).isDisplayed(), is(true));
    }

    @Test
    public void startDateFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(CONFERENCE_START_DATE).isDisplayed(), is(true));
    }

    // enable after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Ignore
    @Test
    public void startDateFieldHasTypeDate() throws Exception {
        assertThat(driver.findElement(CONFERENCE_START_DATE).getAttribute("type"), is("date"));
    }

    // TODO: 22.12.15 Remove after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Test
    public void startDateFieldHasTypeDateWithJs() throws Exception {
        String elementType = ((JavascriptExecutor) driver).executeScript(
                "return document.getElementById('event-start-date').getAttribute('type')").toString();
        assertThat(elementType, is("date"));
    }

    @Test
    public void endDateFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(CONFERENCE_END_DATE).isDisplayed(), is(true));
    }

    // enable after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Ignore
    @Test
    public void endDateFieldHasTypeDate() throws Exception {
        assertThat(driver.findElement(CONFERENCE_END_DATE).getAttribute("type"), is("date"));
    }

    // TODO: 22.12.15 Remove after https://code.google.com/p/selenium/issues/detail?id=7650 is fixed
    @Test
    public void endDateFieldIsDisplayedWithJs() throws Exception {
        String elementType = ((JavascriptExecutor) driver).executeScript(
                "return document.getElementById('event-end-date').getAttribute('type')").toString();
        assertThat(elementType, is("date"));
    }

    @Test
    public void okButtonIsDisplayed() throws Exception {
        assertThat(driver.findElement(OK_BUTTON).isDisplayed(), is(true));
    }

    @Test
    public void okButtonHasTypeSubmit() throws Exception {
        assertThat(driver.findElement(OK_BUTTON).getAttribute("type"), is("submit"));
    }

    @Test
    public void cancelButtonIsDisplayed() throws Exception {
        assertThat(driver.findElement(CANCEL_BUTTON).isDisplayed(), is(true));
    }
}
