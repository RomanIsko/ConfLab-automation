package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
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
        refresh();
        $(Selectors.withText(randomEventName)).click();
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
        $(ADD_BUTTON).shouldBe(visible);
    }
}
