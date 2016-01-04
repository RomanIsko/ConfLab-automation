package com.intelliarts.conflab.automation.web.event;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_PAGE_HEADER;

public class ConferencesView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(EVENTS_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void conferencesHeader() throws Exception {
        $(EVENTS_PAGE_HEADER).shouldHave(text("Conferences"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(visible);
    }
}
