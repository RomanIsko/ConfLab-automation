package com.intelliarts.conflab.automation.web.speaker;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabSpeaker;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_PAGE_HEADER;

public class SpeakersView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        addMultipleSpeakers(2);
        $(SPEAKERS_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speakersHeader() throws Exception {
        $(SPEAKERS_PAGE_HEADER).shouldHave(text("Speakers"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(visible);
    }

    @Test
    public void speakersSectionVisible() throws Exception {
        $(SPEAKERS_LIST).shouldBe(visible);
    }

    @Test
    public void justAddedSpeakerVisibleInList() throws Exception {
        ConfLabSpeaker confLabSpeaker = new ConfLabSpeaker();
        confLabSpeaker.addViaWeb();
        String speakerName = confLabSpeaker.getName();
        ElementsCollection speakersList = $(SPEAKERS_LIST).findAll(".list-group-item");
        speakersList.contains($(By.partialLinkText(speakerName)));
    }
}
