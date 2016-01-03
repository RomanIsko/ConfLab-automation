package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_TABS;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_TITLE;
import static com.intelliarts.conflab.utils.ElementLocatorData.INFO_TAB;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_TAB;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_TAB;

public class SingleConferenceView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        ConfLabEvent confLabEvent = new ConfLabEvent(UUID.randomUUID().toString());
        confLabEvent.addViaWeb();
        ElementsCollection eventsList = $(EVENTS_LIST).findAll(".list-group-item");
        eventsList.last().click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void eventTitleVisible() throws Exception {
        $(EVENT_TITLE).shouldBe(visible);
    }

    @Test
    public void eventHasThreeTabs() throws Exception {
        $(EVENT_TABS).findAll("li").shouldHaveSize(3);
    }

    @Test
    public void infoTabActive() throws Exception {
        $(INFO_TAB).shouldHave(cssClass("active"));
    }

    @Test
    public void infoTabHasCorrectName() throws Exception {
        $(INFO_TAB).shouldHave(text("INFO"));
    }

    @Test
    public void speakersTabUnactive() throws Exception {
        $(SPEAKERS_TAB).shouldHave(text("Speakers"));
    }

    @Test
    public void speechesTabUnactive() throws Exception {
        $(SPEECHES_TAB).shouldHave(text("Speeches"));
    }
}
