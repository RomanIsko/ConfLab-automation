package com.intelliarts.conflab.automation.web.company;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
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
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_EDIT_REGION;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME_VALIDATION_MESSAGE;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;

public class CompanyValidation extends BasicTestCase {

    private final String SHORT_NAME      = lorem.characters(2);
    private final String THREE_CHAR_NAME = lorem.characters(3);
    private final String POSSIBLE_NAME   = company.name();

    private final String NAME_REQUIRED = "Name is required";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(COMPANIES_LINK).click();
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
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
    }

    @Test
    public void submitEmptyNameField() throws Exception {
        $(OK_BUTTON).click();
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldBe(visible);
    }

    @Test
    public void correctValidationMessageOnEmptyNameSubmit() throws Exception {
        $(OK_BUTTON).click();
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldHave(text(NAME_REQUIRED));
    }

    @Test
    public void noValidationMessageOnShortNameSubmit() throws Exception {
        $(COMPANY_NAME).val(SHORT_NAME);
        $(OK_BUTTON).click();
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
        $(COMPANY_EDIT_REGION).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnThreeCharNameSubmit() throws Exception {
        $(COMPANY_NAME).val(THREE_CHAR_NAME);
        $(OK_BUTTON).click();
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
        $(COMPANY_EDIT_REGION).shouldBe(hidden);
    }

    @Test
    public void noValidationMessageOnPossibleNameSubmit() throws Exception {
        $(COMPANY_NAME).val(POSSIBLE_NAME);
        $(OK_BUTTON).click();
        $(COMPANY_NAME_VALIDATION_MESSAGE).shouldBe(hidden);
        $(COMPANY_EDIT_REGION).shouldBe(hidden);
    }
}
