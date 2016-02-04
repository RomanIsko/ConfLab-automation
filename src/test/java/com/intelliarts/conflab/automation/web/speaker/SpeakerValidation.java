package com.intelliarts.conflab.automation.web.speaker;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabSpeaker;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKERS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EDIT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME_VALIDATION_MESSAGE;
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
    private final String POSSIBLE_COMPANY    = "Super Awesome inc.";
    private final String POSSIBLE_POSITION   = "Chief Executive Officer";
    private final String POSSIBLE_ABOUT      =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eget pretium nulla. Etiam eu risus ut " +
            "felis laoreet fermentum id a arcu. Donec lectus ex, gravida eget luctus non, molestie et nisi. Fusce " +
            "faucibus sodales nisl lobortis facilisis. Etiam ut diam a nibh tempus ultricies. Donec nec velit non " +
            "justo blandit imperdiet. Aenean consectetur, est id vestibulum luctus, lorem felis tristique sapien, id " +
            "maximus felis nibh eu orci. Praesent rutrum leo at facilisis laoreet. Sed sed ligula vitae dolor " +
            "fermentum tempus. Phasellus mattis, sem a rutrum dignissim, magna libero consectetur turpis, non " +
            "facilisis metus enim quis odio. Nulla nunc libero, dignissim placerat commodo eget, accumsan ac est. " +
            "Nullam ac feugiat lectus, vitae tempor quam. Sed non diam sodales, pretium est at, efficitur diam. Fusce" +
            " cursus tortor sed venenatis cursus. Nullam ullamcorper nunc porttitor, eleifend tortor eu, sagittis " +
            "sapien.";

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
        sleep(500);
        $(ADD_BUTTON).click();
    }

    @Test
    public void nameValidationMessageIsNotShownOnPageOpen() throws Exception {
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyForm() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(visible);
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void correctValidationMessageOnEmptyNameSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldHave(text(NAME_REQUIRED));
    }

    @Test
    public void correctValidationMessageOnShortNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(SHORT_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldHave(text(LONGER_NAME_REQUIRED));
    }


    @Test
    public void noValidationMessageOnTwoCharsNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(TWO_CHAR_NAME);
        $(SPEAKER_EMAIL).val(VALID_EMAIL);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnPossibleNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(POSSIBLE_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void correctValidationMessageOnLongNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(LONG_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldHave(text(SHORTER_NAME_REQUIRED));
    }

    @Test
    public void noValidationMessageOnFortyCharsNameSubmit() throws Exception {
        $(SPEAKER_NAME).val(FORTY_CHARS_NAME);
        $(OK_BUTTON).click();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
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
        ConfLabSpeaker speaker = new ConfLabSpeaker();
        speaker.setCompany(POSSIBLE_COMPANY);
        speaker.setPosition(POSSIBLE_POSITION);
        speaker.setAbout(POSSIBLE_ABOUT);
        speaker.addViaWeb();
        $(SPEAKER_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEAKER_EMAIL_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEAKER_EDIT_REGION).shouldBe(hidden);
    }
}
