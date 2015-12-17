package com.intelliarts.conflab.automation.web;

import com.intelliarts.conflab.utils.ScreenShotOnFailure;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPageTest extends BasicTestCase {

    private final WebElement loginField    = driver.findElement(USERNAME_FIELD);
    private final WebElement passwordField = driver.findElement(PASSWORD_FIELD);
    private final WebElement signInButton  = driver.findElement(SIGN_IN_BUTTON);

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void loginFieldVisible() throws Exception {
        assertThat(loginField.isDisplayed(), is(true));
    }

    @Test
    public void passwordFieldVisible() throws Exception {
        assertThat(passwordField.isDisplayed(), is(true));
    }

    @Test
    public void passwordFieldHasPasswordType() throws Exception {
        assertThat(passwordField.getAttribute("type"), is("password"));
    }

    @Test
    public void loginButtonVisible() throws Exception {
        assertThat(signInButton.isDisplayed(), is(true));
    }
}
