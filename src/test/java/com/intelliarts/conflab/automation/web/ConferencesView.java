package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_CONFERENCE_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.CONFERENCES_PAGE_HEADER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConferencesView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        driver.findElement(CONFERENCES_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void conferencesHeader() throws Exception {
        assertThat(driver.findElement(CONFERENCES_PAGE_HEADER).getText(), is("Conferences"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        assertThat(driver.findElement(ADD_CONFERENCE_BUTTON).isDisplayed(), is(true));
    }
}
