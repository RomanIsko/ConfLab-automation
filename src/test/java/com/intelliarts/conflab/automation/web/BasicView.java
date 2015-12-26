package com.intelliarts.conflab.automation.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.intelliarts.conflab.utils.ElementLocatorData.LOGO;
import static com.intelliarts.conflab.utils.ElementLocatorData.NAV_BAR;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BasicView extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void pageTitle() throws Exception {
        assertThat(title(), is("ConfLab main page"));
    }

    @Test
    public void brandHasAppropriateCssStyle() throws Exception {
        $(LOGO).shouldHave(attribute("class", "navbar-brand"));
    }

    @Test
    public void brandIsCorrect() throws Exception {
        $(LOGO).shouldHave(text("ConfLabs"));
    }

    @Test
    public void loginLink() throws Exception {
        $(SIGN_IN_LINK).shouldBe(visible);
    }

    @Test
    public void navbarHasNotLinksForLoggedOutUser() throws Exception {
        $(NAV_BAR).findAll(By.xpath(".//li")).shouldHaveSize(0);
    }
}
