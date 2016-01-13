package com.intelliarts.conflab.automation.web.login;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.intelliarts.conflab.utils.ElementLocatorData.CANCEL_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.LOGIN_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.PASSWORD_FIELD;
import static com.intelliarts.conflab.utils.ElementLocatorData.SIGN_IN_LINK;
import static com.intelliarts.conflab.utils.ElementLocatorData.USERNAME_FIELD;

public class LoginPageTest extends BasicTestCase {

    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        $(SIGN_IN_LINK).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void usernameFieldVisible() throws Exception {
        $(USERNAME_FIELD).shouldBe(visible);
    }

    @Test
    public void passwordFieldVisible() throws Exception {
        $(PASSWORD_FIELD).shouldBe(visible);
    }

    @Test
    public void passwordFieldHasPasswordType() throws Exception {
        $(PASSWORD_FIELD).shouldHave(type("password"));
    }

    @Test
    public void loginButtonVisible() throws Exception {
        $(SIGN_IN_LINK).shouldBe(visible);
    }

    @Test
    public void loginButtonHasTypeSubmit() throws Exception {
        $(LOGIN_BUTTON).shouldHave(type("submit"));
    }

    @Test
    public void cancelButtonVisible() throws Exception {
        $(CANCEL_BUTTON).shouldBe(visible);
    }
}
