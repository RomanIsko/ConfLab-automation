package com.intelliarts.conflab.automation.web.speech;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabSpeech;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_PAGE_HEADER;

public class SpeechesView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        addMultipleSpeeches(2);
        $(SPEECHES_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void speechesHeader() throws Exception {
        $(SPEECHES_PAGE_HEADER).shouldHave(text("Speeches"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(visible);
    }

    @Test
    public void speechesSectionVisible() throws Exception {
        $(SPEECHES_LIST).shouldBe(visible);
    }

    @Test
    public void justAddedSpeechVisibleInList() throws Exception {
        ConfLabSpeech confLabSpeech = new ConfLabSpeech();
        confLabSpeech.addViaWeb();
        String confLabSpeechTitle = confLabSpeech.getTitle();
        ElementsCollection speechesList = $(SPEECHES_LIST).findAll(".list-group-item");
        speechesList.contains($(By.partialLinkText(confLabSpeechTitle)));
    }
}
