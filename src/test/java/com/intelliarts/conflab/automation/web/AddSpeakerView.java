package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_SPEAKER_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION_LABEL;

public class AddSpeakerView extends BasicTestCase {

    private final String required = "required";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(SPEAKERS_LINK).click();
        $(ADD_SPEAKER_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        $(SPEAKER_NAME).shouldBe(visible);
    }

    @Test
    public void nameLabelHasRequiredClass() throws Exception {
        $(SPEAKER_NAME_LABEL).shouldHave(cssClass(required));
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
    public void emailLabelHasRequiredClass() throws Exception {
        $(SPEAKER_EMAIL_LABEL).shouldHave(cssClass(required));
    }

    @Test
    public void positionFieldIsDisplayed() throws Exception {
        $(SPEAKER_POSITION).shouldBe(visible);
    }

    @Test
    public void positionLabelHasNotRequiredClass() throws Exception {
        $(SPEAKER_POSITION_LABEL).shouldNotHave(cssClass(required));
    }

    @Test
    public void aboutTextareaIsDisplayed() throws Exception {
        $(SPEAKER_ABOUT).shouldBe(visible);
    }

    @Test
    public void aboutTextareaLabelHasNotRequiredClass() throws Exception {
        $(SPEAKER_ABOUT_LABEL).shouldNotHave(cssClass(required));
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
