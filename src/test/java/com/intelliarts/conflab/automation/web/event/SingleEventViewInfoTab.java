package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.FORM_EDIT_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.INFO_FORM;

public class SingleEventViewInfoTab extends BasicTestCase {
    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = "2016-01-03";
    protected static String eventEndDate     = "2016-01-04";

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
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void editButtonVisible() throws Exception {
        $(INFO_FORM).hover();
        $(FORM_EDIT_BUTTON).shouldBe(visible);
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
