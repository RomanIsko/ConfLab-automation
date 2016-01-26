package com.intelliarts.conflab.automation.web.login;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static com.intelliarts.conflab.utils.ResourcesData.COMPANIES_URL;
import static com.intelliarts.conflab.utils.ResourcesData.DEPLOYMENT_URL;
import static com.intelliarts.conflab.utils.ResourcesData.EVENTS_URL;
import static com.intelliarts.conflab.utils.ResourcesData.EVENT_INFO_URL;
import static com.intelliarts.conflab.utils.ResourcesData.EVENT_SPEAKERS_URL;
import static com.intelliarts.conflab.utils.ResourcesData.EVENT_SPEECHES_URL;
import static com.intelliarts.conflab.utils.ResourcesData.SPEAKERS_URL;
import static com.intelliarts.conflab.utils.ResourcesData.SPEECHES_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequireLogin extends BasicTestCase {
    private static String eventUrl;
    private final String singleEntityUrl = "/100500";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        addMultipleEvents(2);
        ElementsCollection eventsList = $$(".list-group-item");
        eventsList.last().click();
        eventUrl = url();
        close();
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
    public void eventsLinkRequireLogin() throws Exception {
        open(EVENTS_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void singleEventLinkRequireLogin() throws Exception {
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

    @Test
    public void companiesLinkRequireLogin() throws Exception {
        open(COMPANIES_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void singleCompanyLinkRequireLogin() throws Exception {
        open(COMPANIES_URL + singleEntityUrl);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void eventInfoRequireLogin() throws Exception {
        open(eventUrl + EVENT_INFO_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void eventSpeakersRequireLogin() throws Exception {
        open(eventUrl + EVENT_SPEAKERS_URL);
        assertThat(loginRequired(), is(true));
    }

    @Test
    public void eventSpeechesRequireLogin() throws Exception {
        open(eventUrl + EVENT_SPEECHES_URL);
        assertThat(loginRequired(), is(true));
    }

    private static boolean loginRequired() {
        sleep(1000);
        return ($(USERNAME_FIELD).is(visible) && $(PASSWORD_FIELD).is(visible));
    }
}
