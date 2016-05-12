package com.intelliarts.conflab.automation.web.company;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabCompany;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_URL;

public class SingleCompanyView extends BasicTestCase {

    private static ConfLabCompany confLabCompany = new ConfLabCompany();

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        confLabCompany.addViaWeb();
        ElementsCollection companiesList = $(COMPANIES_LIST).findAll(".list-group-item");
        companiesList.last().click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void companyNameVisible() throws Exception {
        $(COMPANY_NAME).shouldBe(visible);
    }

    @Test
    public void companyNameIsCorrect() throws Exception {
        $(COMPANY_NAME).shouldHave(text(confLabCompany.getName()));
    }

    @Test
    public void companyUrlVisible() throws Exception {
        $(COMPANY_URL).shouldBe(visible);
    }

    @Test
    public void companyUrlIsCorrect() throws Exception {
        $(COMPANY_URL).shouldHave(text(confLabCompany.getUrl()));
    }
}
