package com.intelliarts.conflab.automation.web.company;

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
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_URL;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_URL_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;

public class AddCompanyView extends BasicTestCase {

    private final String required = "required";

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        $(COMPANIES_LINK).click();
        $(ADD_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void companyNameFieldIsDisplayed() throws Exception {
        $(COMPANY_NAME).shouldBe(visible);
    }

    @Test
    public void companyNameLabelHasRequiredClass() throws Exception {
        $(COMPANY_NAME_LABEL).shouldHave(cssClass(required));
    }

    @Test
    public void companyUrlFieldIsDisplayed() throws Exception {
        $(COMPANY_URL).shouldBe(visible);
    }

    @Test
    public void companyUrlLabelHasNotRequiredClass() throws Exception {
        $(COMPANY_URL_LABEL).shouldNotHave(cssClass(required));
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
