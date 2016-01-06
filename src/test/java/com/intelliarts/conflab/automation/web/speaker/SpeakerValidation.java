package com.intelliarts.conflab.automation.web.speaker;

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
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EDIT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME_FIELD_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION_VALIDATION_MESSAGE;

public class SpeakerValidation extends BasicTestCase {

    private final String NAME_REQUIRED         = "Name is required";
    private final String LONGER_NAME_REQUIRED  = "Name must be at least 2 characters";
    private final String SHORTER_NAME_REQUIRED = "Name must be at most 40 characters";

    private final String VALID_EMAIL_REQUIRED = "Email must be a valid email";
    private final String EMAIL_REQUIRED       = "Email is required";

    private final String SHORT_NAME          = "Q";
    private final String TWO_CHAR_NAME       = "Li";
    private final String POSSIBLE_NAME       = "John Smith";
    private final String LONG_NAME           = "John Smith, James Johnson, Robert Williams, Michael Jones";
    private final String FORTY_CHARS_NAME    = "John Smith James Johnson Robert Williams";
    private final String SHORT_INVALID_EMAIL = SHORT_NAME;
    private final String INVALID_EMAIL       = "some@invalid@email@address";
    private final String VALID_EMAIL         = "valid.email-100500@address.com";

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

    @Before
    public void setUpTest() throws Exception {
        refresh();
        $(ADD_BUTTON).click();
    }

    @Test
    public void nameValidationMessageIsNotShownOnPageOpen() throws Exception {
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyForm() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(visible);
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void correctValidationMessageOnEmptyNameSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldHave(text(NAME_REQUIRED));
    }

    @Test
    public void correctValidationMessageOnShortNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(SHORT_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldHave(text(LONGER_NAME_REQUIRED));
    }


    @Test
    public void noValidationMessageOnTwoCharsNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(TWO_CHAR_NAME);
        $(SPEAKER_EMAIL).val(VALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnPossibleNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(POSSIBLE_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void correctValidationMessageOnLongNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(LONG_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldHave(text(SHORTER_NAME_REQUIRED));
    }

    @Test
    public void noValidationMessageOnFortyCharsNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(FORTY_CHARS_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    // Email field tests
    @Test
    public void emailValidationMessageIsNotShownOnPageOpen() throws Exception {
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void correctValidationMessageOnEmptyEmailSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldHave(text(EMAIL_REQUIRED));
    }

    @Test
    public void correctValidationMessageOnShortInvalidEmailSubmit() throws Exception {
        $(SPEAKER_EMAIL).val(SHORT_INVALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldHave(text(VALID_EMAIL_REQUIRED));
    }

    @Test
    public void correctValidationMessageOnInvalidEmailSubmit() throws Exception {
        $(SPEAKER_EMAIL).val(INVALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldHave(text(VALID_EMAIL_REQUIRED));
    }

    @Test
    public void noValidationMessageOnValidEmailSubmit() throws Exception {
        $(SPEAKER_EMAIL).val(VALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void validationMessageHiddenForPositionOnEmptyNameEmailSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_POSITION_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void validationMessageHiddenForAboutOnEmptyNameEmailSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_ABOUT_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnCorrectDataSubmit() throws Exception {
        $(SPEAKER_NAME).val(POSSIBLE_NAME);
        $(SPEAKER_EMAIL).val(VALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_FIELD_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEAKER_EDIT_REGION).shouldBe(hidden);
    }
}
