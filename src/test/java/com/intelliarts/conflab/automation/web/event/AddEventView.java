package com.intelliarts.conflab.automation.web.event;

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
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_COUNTRY;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_COUNTRY_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;

public class AddEventView extends BasicTestCase {

    private final String required = "required";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(EVENTS_LINK).click();
        $(ADD_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void nameFieldIsDisplayed() throws Exception {
        $(EVENT_NAME).shouldBe(visible);
    }

    @Test
    public void nameLabelHasRequiredClass() throws Exception {
        $(EVENT_NAME_LABEL).shouldHave(cssClass(required));
    }

    @Test
    public void eventDescriptionIsDisplayed() throws Exception {
        $(EVENT_DESCRIPTION).shouldBe(visible);
    }

    @Test
    public void eventDescriptionLabelHasNotRequiredClass() throws Exception {
        $(EVENT_DESCRIPTION_LABEL).shouldNotHave(cssClass(required));
    }

    @Test
    public void startDateFieldIsDisplayed() throws Exception {
        $(EVENT_START_DATE).shouldBe(visible);
    }

    @Test
    public void startDateLabelHasNotRequiredClass() throws Exception {
        $(EVENT_START_DATE_LABEL).shouldNotHave(cssClass(required));
    }

    @Test
    public void endDateFieldIsDisplayed() throws Exception {
        $(EVENT_END_DATE).shouldBe(visible);
    }

    @Test
    public void endDateLabelHasNotRequiredClass() throws Exception {
        $(EVENT_END_DATE_LABEL).shouldNotHave(cssClass(required));
    }

    @Test
    public void countryFieldIsDisplayed() throws Exception {
        $(EVENT_COUNTRY).shouldBe(visible);
    }

    @Test
    public void countryLabelHasNotRequiredClass() throws Exception {
        $(EVENT_COUNTRY_LABEL).shouldNotHave(cssClass(required));
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
