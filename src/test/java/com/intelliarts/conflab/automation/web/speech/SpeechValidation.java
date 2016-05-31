package com.intelliarts.conflab.automation.web.speech;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.ENGLISH;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECHES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_EDIT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_LANGUAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE_VALIDATION_MESSAGE;

public class SpeechValidation extends BasicTestCase {

    public static final String POSSIBLE_LANGUAGE    = "English";
    private final       String TITLE_REQUIRED       = "Title is required";
    private             String POSSIBLE_TITLE       = lorem.sentence(4);
    private             String POSSIBLE_DESCRIPTION = lorem.paragraph(10);

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

    @Before
    public void setUpTest() throws Exception {
        refresh();
        $(ADD_BUTTON).click();
    }

    @Test
    public void titleValidationMessageIsNotShownOnPageOpen() throws Exception {
        $(SPEECH_TITLE_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyForm() throws Exception {
        $(OK_BUTTON).click();
        $(SPEECH_TITLE_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void correctValidationMessageOnEmptyTitleSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEECH_TITLE_VALIDATION_MESSAGE).shouldHave(text(TITLE_REQUIRED));
    }

    @Test
    public void noValidationMessageOnCorrectDataSubmit() throws Exception {
        $(SPEECH_TITLE).val(POSSIBLE_TITLE);
        $(SPEECH_DESCRIPTION).val(POSSIBLE_DESCRIPTION);
        $(SPEECH_LANGUAGE).selectOption(ENGLISH);
        $(OK_BUTTON).click();
        $(SPEECH_TITLE_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEECH_EDIT_REGION).shouldBe(hidden);
    }
}
