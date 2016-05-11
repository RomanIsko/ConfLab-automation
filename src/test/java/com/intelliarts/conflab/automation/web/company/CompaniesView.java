package com.intelliarts.conflab.automation.web.company;

import com.codeborne.selenide.ElementsCollection;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabCompany;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANIES_PAGE_HEADER;

public class CompaniesView extends BasicTestCase {
    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        addMultipleCompanies(2);
        $(COMPANIES_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void companyHeader() throws Exception {
        $(COMPANIES_PAGE_HEADER).shouldHave(text("Companies"));
    }

    @Test
    public void addButtonVisible() throws Exception {
        $(ADD_BUTTON).shouldBe(visible);
    }

    @Test
    public void companiesSectionVisible() throws Exception {
        $(COMPANIES_LIST).shouldBe(visible);
    }

    @Test
    public void justAddedCompanyVisibleInList() throws Exception {
        ConfLabCompany confLabCompany = new ConfLabCompany();
        confLabCompany.addViaWeb();
        String companyName = confLabCompany.getName();
        ElementsCollection companiesList = $(COMPANIES_LIST).findAll(".list-group-item");
        companiesList.contains($(By.linkText(companyName)));
    }
}
