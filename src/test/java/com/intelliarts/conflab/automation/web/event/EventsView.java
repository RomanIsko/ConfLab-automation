package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_PAGE_HEADER;

public class EventsView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        addMultipleEvents(2);
        $(EVENTS_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void eventHeader() throws Exception {
        $(EVENTS_PAGE_HEADER).shouldHave(text("Conferences"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(visible);
    }

    @Test
    public void eventsSectionVisible() throws Exception {
        $(EVENTS_LIST).shouldBe(visible);
    }

    @Test
    public void justAddedEventVisibleInList() throws Exception {
        ConfLabEvent confLabEvent = new ConfLabEvent();
        confLabEvent.addViaWeb();
        String eventName = confLabEvent.getName();
        ElementsCollection eventsList = $(EVENTS_LIST).findAll(".list-group-item");
        sleep(1);
        eventsList.contains($(By.partialLinkText(eventName)));
    }
}
