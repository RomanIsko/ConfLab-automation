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
    protected static String eventDescription =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam iaculis, massa ut viverra accumsan, nunc" +
            " massa rutrum orci, eu pulvinar felis dui non purus. Etiam vel sem ac mi dapibus tempus a tempus erat. " +
            "Sed ut diam iaculis, sodales ipsum et, vehicula tortor. Donec aliquam felis at lorem tincidunt malesuada" +
            ". Ut sagittis justo turpis, sed laoreet libero mollis non. Vestibulum non malesuada eros. Duis lacinia " +
            "ex et justo aliquam porta. In finibus nulla lorem, id vulputate lectus sodales id. Pellentesque " +
            "ullamcorper massa nec maximus laoreet. Proin sit amet est neque. Etiam placerat massa vel porta pharetra" +
            ". Aenean sollicitudin leo orci, vitae tristique mi commodo et. Nunc commodo, felis vel finibus " +
            "ultricies, nisi lorem mollis lacus, eget dictum ligula tellus sit amet nisl. Quisque iaculis consequat " +
            "augue, a ultricies quam viverra a. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
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
