package com.intelliarts.conflab.automation.web.selenide;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;
import static com.intelliarts.conflab.utils.ResourcesData.EVENTS_URL;
import static com.intelliarts.conflab.utils.ResourcesData.SPEAKERS_URL;
import static com.intelliarts.conflab.utils.ResourcesData.SPEECHES_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequireLoginSelenide extends BasicTestCaseSelenide {
    private final String singleEntityUrl = "/100500";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Before
    public void setUpTest() throws Exception {
        open(DEPLOYMENT_URL);
    }

    @Test
    public void conferencesLinkRequireLogin() throws Exception {
        open(EVENTS_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void singleConferenceLinkRequireLogin() throws Exception {
        open(EVENTS_URL + singleEntityUrl);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void speakersLinkRequireLogin() throws Exception {
        open(SPEAKERS_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void singleSpeakerLinkRequireLogin() throws Exception {
        open(SPEAKERS_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void speechesLinkRequireLogin() throws Exception {
        open(SPEECHES_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void singleSpeechLinkRequireLogin() throws Exception {
        open(SPEECHES_URL + singleEntityUrl);
        assertThat(loginRequired(), is(true));
    }

    private static boolean loginRequired() {
        return ($(USERNAME_FIELD).isDisplayed() && $(PASSWORD_FIELD).isDisplayed());
    }
}
