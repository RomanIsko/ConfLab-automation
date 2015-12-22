package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddSpeakerView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        driver.findElement(SPEAKERS_LINK).click();
        driver.findElement(ADD_SPEAKER_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(SPEAKER_NAME).isDisplayed(), is(true));
    }

    @Test
    public void emailFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(SPEAKER_EMAIL).isDisplayed(), is(true));
    }

    @Test
    public void emailFieldHasEmailType() throws Exception {
        assertThat(driver.findElement(SPEAKER_EMAIL).getAttribute("type"), is("email"));
    }

    @Test
    public void positionFieldIsDisplayed() throws Exception {
        assertThat(driver.findElement(SPEAKER_POSITION).isDisplayed(), is(true));
    }

    @Test
    public void aboutTextareaIsDisplayed() throws Exception {
        assertThat(driver.findElement(SPEAKER_ABOUT).isDisplayed(), is(true));
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
