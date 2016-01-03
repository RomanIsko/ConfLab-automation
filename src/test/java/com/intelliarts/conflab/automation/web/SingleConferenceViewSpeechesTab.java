package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_SPEECH_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_TAB;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_TITLE;

public class SingleConferenceViewSpeechesTab extends BasicTestCase {
    protected static String randomEventName  = UUID.randomUUID().toString();
    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = "2016-01-08";
    protected static String eventEndDate     = "2016-01-12";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        ConfLabEvent confLabEvent = new ConfLabEvent(randomEventName);
        confLabEvent.setDescription(eventDescription);
        confLabEvent.setStartDate(eventStartDate);
        confLabEvent.setEndDate(eventEndDate);
        confLabEvent.addViaWeb();
        ElementsCollection eventsList = $(EVENTS_LIST).findAll(".list-group-item");
        eventsList.last().click();
        $(SPEECHES_TAB).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speechesTitleVisible() throws Exception {
        $(SPEECHES_TITLE).shouldBe(visible);
    }

    @Test
    public void addNewSpeechButtonVisible() throws Exception {
        $(ADD_NEW_SPEECH_BUTTON).shouldBe(visible);
    }
}
