package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_PAGE_HEADER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SpeakersView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        driver.findElement(SPEAKERS_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speakersHeader() throws Exception {
        assertThat(driver.findElement(SPEAKERS_PAGE_HEADER).getText(), is("Speakers"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        assertThat(driver.findElement(ADD_SPEAKER_BUTTON).isDisplayed(), is(true));
    }
}
