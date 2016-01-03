package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_FROM_LIST_DROPDOWN;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_TAB;

public class SingleConferenceViewSpeakersTab extends BasicTestCase {
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
        refresh();
        $(Selectors.withText(randomEventName)).click();
        $(SPEAKERS_TAB).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void addNewSpeakerButtonVisible() throws Exception {
        $(ADD_NEW_SPEAKER_BUTTON).shouldBe(visible);
    }

    @Test
    public void addFromListDropdownVisible() throws Exception {
        $(ADD_FROM_LIST_DROPDOWN).shouldBe(visible);
    }
}
