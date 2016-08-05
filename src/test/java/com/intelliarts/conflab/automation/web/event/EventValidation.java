package com.intelliarts.conflab.automation.web.event;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_ADDRESS_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CITY_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CONTACTS_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_COUNTRY_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;

public class EventValidation extends BasicTestCase {

    private final String NAME_REQUIRED         = "Name is required";
    private final String LONGER_NAME_REQUIRED  = "Name must be at least 3 characters";
    private final String SHORTER_NAME_REQUIRED = "Name must be at most 40 characters";

    private final String SHORT_NAME       = lorem.characters(2);
    private final String THREE_CHAR_NAME  = lorem.characters(3);
    private final String POSSIBLE_NAME    = lorem.characters(20);
    private final String LONG_NAME        = lorem.characters(50);
    private final String FORTY_CHARS_NAME = lorem.characters(40);

    private static final SimpleDateFormat dateFormat            = new SimpleDateFormat("dd-MMM-yyyy");
    private static       Date             randomDateInThePast   = dateAndTime.past(10, TimeUnit.DAYS);
    private static       Date             randomDateInTheFuture = dateAndTime.future(10, TimeUnit.DAYS);

    private static String eventStartDate = dateFormat.format(randomDateInThePast);
    private static String eventEndDate   = dateFormat.format(randomDateInTheFuture);

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(EVENTS_LINK).click();
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
    public void validationMessageIsNotShownOnPageOpen() throws Exception {
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
        $(EVENT_START_DATE_VALIDATION_MESSAGE).shouldBe(hidden);
        $(EVENT_END_DATE_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyNameField() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldBe(visible);
        $(EVENT_START_DATE_VALIDATION_MESSAGE).shouldBe(visible);
        $(EVENT_END_DATE_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void correctValidationMessageOnEmptyNameSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldHave(text(NAME_REQUIRED));
    }

    @Test
    public void correctValidationMessageOnShortNameSubmit() throws Exception {
        $(EVENT_NAME).val(SHORT_NAME);
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldHave(text(LONGER_NAME_REQUIRED));
    }

    @Test
    public void noValidationMessageOnThreeCharNameSubmit() throws Exception {
        $(EVENT_NAME).val(THREE_CHAR_NAME);
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnPossibleNameSubmit() throws Exception {
        $(EVENT_NAME).val(POSSIBLE_NAME);
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void correctValidationMessageOnLongNameSubmit() throws Exception {
        $(EVENT_NAME).val(LONG_NAME);
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldHave(text(SHORTER_NAME_REQUIRED));
    }

    @Test
    public void noValidationMessageOnFortyCharsNameSubmit() throws Exception {
        $(EVENT_NAME).val(FORTY_CHARS_NAME);
        $(OK_BUTTON).click();
        $(EVENT_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageForDescription() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_DESCRIPTION_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyStartDateField() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_START_DATE_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void noValidationMessageOnCorrectStartDateSubmit() throws Exception {
        $(EVENT_START_DATE).val(eventStartDate);
        $(OK_BUTTON).click();
        $(EVENT_START_DATE_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyEndDateField() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_END_DATE_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void noValidationMessageOnCorrectEndDateSubmit() throws Exception {
        $(EVENT_END_DATE).val(eventEndDate);
        $(OK_BUTTON).click();
        $(EVENT_END_DATE_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageForCountry() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_COUNTRY_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageForCity() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_CITY_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageForAddress() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_ADDRESS_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageForContacts() throws Exception {
        $(OK_BUTTON).click();
        $(EVENT_CONTACTS_VALIDATION_MESSAGE).shouldBe(hidden);
    }
}
