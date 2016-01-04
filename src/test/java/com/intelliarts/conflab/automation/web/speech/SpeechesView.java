package com.intelliarts.conflab.automation.web.speech;

import com.codeborne.selenide.Condition;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_PAGE_HEADER;

public class SpeechesView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(SPEECHES_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speechesHeader() throws Exception {
        $(SPEECHES_PAGE_HEADER).shouldHave(Condition.text("Speeches"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(Condition.visible);
    }
}
