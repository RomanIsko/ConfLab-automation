package com.intelliarts.conflab.automation.web.speech;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

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
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_LANGUAGE_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE_VALIDATION_MESSAGE;

public class SpeechValidation extends BasicTestCase {

    public static final String POSSIBLE_LANGUAGE    = "English";
    private final       String TITLE_REQUIRED       = "Title is required";
    private final       String POSSIBLE_TITLE       = UUID.randomUUID().toString();
    private final       String POSSIBLE_DESCRIPTION =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur mauris odio, suscipit vitae faucibus " +
            "sed, efficitur ut magna. Vestibulum vestibulum felis ac magna mattis aliquet. Nam sed mauris tempor " +
            "sapien ullamcorper posuere. Donec sodales magna rutrum felis hendrerit placerat. Etiam viverra ultricies" +
            " mi id tempor. Donec dapibus lectus lectus, in volutpat ex eleifend maximus. Suspendisse sagittis magna " +
            "turpis, in dignissim nunc placerat vitae. Donec ultrices non tortor eu sodales. Praesent fermentum odio " +
            "ut mauris scelerisque, at egestas ex pulvinar. Donec gravida, mauris vel gravida cursus, massa quam " +
            "congue tortor, id egestas purus magna ut nibh.\n" +
            "\n" +
            "Aenean molestie feugiat elit in fringilla. Cras eget mauris vel libero consectetur pulvinar. Aenean " +
            "euismod nulla ut quam vehicula, eget mollis mi tristique. In hac habitasse platea dictumst. Fusce " +
            "convallis ut mauris ut venenatis. Cras urna nisl, facilisis quis sem at, pellentesque bibendum dui. " +
            "Suspendisse fringilla mi vitae quam sodales, non commodo ex pellentesque. Duis maximus augue sem, " +
            "imperdiet pharetra dui iaculis eget. Fusce in velit ac diam condimentum mattis laoreet feugiat magna. " +
            "Sed luctus, libero non vehicula auctor, lectus lorem vestibulum nisl, in mattis nisl augue nec augue. " +
            "Suspendisse vestibulum ante elit, nec pretium nibh malesuada vitae.";

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
        $(SPEECH_TITLE_FIELD).val(POSSIBLE_TITLE);
        $(SPEECH_DESCRIPTION).val(POSSIBLE_DESCRIPTION);
        $(SPEECH_LANGUAGE_FIELD).selectOption(ENGLISH);
        $(OK_BUTTON).click();
        $(SPEECH_TITLE_VALIDATION_MESSAGE).shouldBe(hidden);
        $(SPEECH_EDIT_REGION).shouldBe(hidden);
    }
}
