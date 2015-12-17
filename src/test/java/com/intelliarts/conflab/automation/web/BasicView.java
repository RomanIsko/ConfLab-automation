package com.intelliarts.conflab.automation.web;

import com.intelliarts.conflab.utils.ScreenShotOnFailure;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.intelliarts.conflab.utils.ElementLocatorData.LOGO;
import static com.intelliarts.conflab.utils.ElementLocatorData.NAV_BAR;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_BUTTON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class BasicView extends BasicTestCase {
    private final WebElement logo         = driver.findElement(LOGO);
    private final WebElement signInButton = driver.findElement(SIGN_IN_BUTTON);
    private final WebElement navbar       = driver.findElement(NAV_BAR);

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

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
        assertThat(driver.getTitle(), is("ConfLab main page"));
    }

    @Test
    public void brandHasAppropriateCssStyle() throws Exception {
        assertThat(logo.getAttribute("class"), is("navbar-brand"));
    }

    @Test
    public void brandIsCorrect() throws Exception {
        assertThat(logo.getText(), is("ConfLabs"));
    }

    @Test
    public void loginLink() throws Exception {
        assertThat(signInButton.isDisplayed(), is(true));
    }

    //TODO fix timeout check child for navbar
    @Test
    public void navbarHasNotLinksForLoggedOutUser() throws Exception {
        int expectedLinksCount = 0;
        assertThat(navbar.findElements(By.xpath(".//li")).size(), equalTo(expectedLinksCount));
    }
}