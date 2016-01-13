package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_FROM_LIST_DROPDOWN;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_TAB;

public class SingleEventViewSpeakersTab extends BasicTestCase {
    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = "2016-01-08";
    protected static String eventEndDate     = "2016-01-12";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        ConfLabEvent confLabEvent = new ConfLabEvent();
        confLabEvent.setDescription(eventDescription);
        confLabEvent.setStartDate(eventStartDate);
        confLabEvent.setEndDate(eventEndDate);
        confLabEvent.addViaWeb();
        refresh();
        $(Selectors.withText(confLabEvent.getName())).click();
        $(SPEAKERS_TAB).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void addNewSpeakerButtonVisible() throws Exception {
        $(ADD_NEW_BUTTON).shouldBe(visible);
    }

    @Test
    public void addFromListDropdownVisible() throws Exception {
        $(ADD_FROM_LIST_DROPDOWN).shouldBe(visible);
    }
}
