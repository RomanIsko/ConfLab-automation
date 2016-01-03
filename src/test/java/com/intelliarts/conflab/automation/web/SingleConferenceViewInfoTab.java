package com.intelliarts.conflab.automation.web;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.EDIT_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;

public class SingleConferenceViewInfoTab extends BasicTestCase {
    protected static String randomEventName  = UUID.randomUUID().toString();
    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = "2016-01-03";
    protected static String eventEndDate     = "2016-01-04";

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
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void eventNameVisible() throws Exception {
        $(EVENT_NAME).shouldBe(visible);
    }

    @Test
    public void editButtonVisible() throws Exception {
        $(EDIT_BUTTON).shouldBe(visible);
    }

    @Test
    public void eventNameCorrect() throws Exception {
        $(EVENT_NAME).shouldHave(text(randomEventName));
    }

    @Test
    public void eventDescriptionVisible() throws Exception {
        $(EVENT_DESCRIPTION).shouldBe(visible);
    }

    @Test
    public void eventDescriptionCorrect() throws Exception {
        $(EVENT_DESCRIPTION).shouldHave(text(eventDescription));
    }

    @Test
    public void eventStartDateVisible() throws Exception {
        $(EVENT_START_DATE).shouldBe(visible);
    }

    @Test
    public void eventStartDateCorrect() throws Exception {
        $(EVENT_START_DATE).shouldHave(text(eventStartDate));
    }

    @Test
    public void eventEndDateVisible() throws Exception {
        $(EVENT_END_DATE).shouldBe(visible);
    }

    @Test
    public void eventEndDateCorrect() throws Exception {
        $(EVENT_END_DATE).shouldHave(text(eventEndDate));
    }
}
