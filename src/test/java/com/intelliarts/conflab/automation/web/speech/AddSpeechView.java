package com.intelliarts.conflab.automation.web.speech;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_LANGUAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE;

public class AddSpeechView extends BasicTestCase {

    private final String required = "required";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(SPEECHES_LINK).click();
        $(ADD_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void titleFieldIsDisplayed() throws Exception {
        $(SPEECH_TITLE).shouldBe(visible);
    }

    @Test
    public void descriptionTextareaIsDisplayed() throws Exception {
        $(SPEECH_DESCRIPTION).shouldBe(visible);
    }

    @Test
    public void descriptionTextareaLabelHasNotRequiredClass() throws Exception {
        $(SPEECH_DESCRIPTION).shouldNotHave(cssClass(required));
    }

    @Test
    public void languageFieldIsDisplayed() throws Exception {
        $(SPEECH_LANGUAGE).shouldBe(visible);
    }

    @Test
    public void languageFieldHasNotRequiredClass() throws Exception {
        $(SPEECH_LANGUAGE).shouldNotHave(cssClass(required));
    }

    @Test
    public void okButtonIsDisplayed() throws Exception {
        $(OK_BUTTON).shouldBe(visible);
    }

    @Test
    public void okButtonHasTypeSubmit() throws Exception {
        $(OK_BUTTON).shouldHave(type("submit"));
    }

    @Test
    public void cancelButtonIsDisplayed() throws Exception {
        $(CANCEL_BUTTON).shouldBe(visible);
    }
}
