package com.intelliarts.conflab.automation.web.speaker;

import com.codeborne.selenide.Condition;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_PAGE_HEADER;

public class SpeakersView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(SPEAKERS_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speakersHeader() throws Exception {
        $(SPEAKERS_PAGE_HEADER).shouldHave(Condition.text("Speakers"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_SPEAKER_BUTTON).shouldBe(Condition.visible);
    }
}
