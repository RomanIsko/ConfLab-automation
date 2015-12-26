package com.intelliarts.conflab.automation.web.selenide;

import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION;

public class AddSpeakerViewSelenide extends BasicTestCaseSelenide {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(SPEAKERS_LINK).click();
        $(ADD_SPEAKER_BUTTON).click();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        $(SPEAKER_NAME).shouldBe(visible);
    }

    @Test
    public void emailFieldIsDisplayed() throws Exception {
        $(SPEAKER_EMAIL).shouldBe(visible);
    }

    @Test
    public void emailFieldHasEmailType() throws Exception {
        $(SPEAKER_EMAIL).shouldHave(type("email"));
    }

    @Test
    public void positionFieldIsDisplayed() throws Exception {
        $(SPEAKER_POSITION).shouldBe(visible);
    }

    @Test
    public void aboutTextareaIsDisplayed() throws Exception {
        $(SPEAKER_ABOUT).shouldBe(visible);
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