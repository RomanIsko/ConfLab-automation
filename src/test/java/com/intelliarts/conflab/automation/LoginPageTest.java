package com.intelliarts.conflab.automation;

import com.intelliarts.conflab.automation.utils.ScreenShotOnFailure;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPageTest extends BasicTestCase {

    private final WebElement loginField    = driver.findElement(By.id("username"));
    private final WebElement passwordField = driver.findElement(By.id("password"));
    private final WebElement signInButton  = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a"));

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a")).click();
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
