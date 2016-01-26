package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_FROM_LIST_DROPDOWN;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_TABS;

public class SingleEventViewSpeechesTab extends BasicTestCase {
    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = "23-Jan-2016";
    protected static String eventEndDate     = "25-Jan-2016";
    protected static String eventCountry     = "Switzerland";
    protected static String eventCity        = "Zürich";
    protected static String eventAddress     = "Neugasse 57-63, 8005";
    protected static String eventContacts    = "+41 44 444 44 44\n" +
                                               "John Smith\n" +
                                               "skype:  john.smith\n" +
                                               "mailto: john-100.smith-500@email.com";


    @BeforeClass
    public static void setUp() throws Exception {
        basicSetUp();
        login();
        ConfLabEvent confLabEvent = new ConfLabEvent();
        confLabEvent.setDescription(eventDescription);
        confLabEvent.setStartDate(eventStartDate);
        confLabEvent.setEndDate(eventEndDate);
        confLabEvent.setCountry(eventCountry);
        confLabEvent.setCity(eventCity);
        confLabEvent.setAddress(eventAddress);
        confLabEvent.setContacts(eventContacts);
        confLabEvent.addViaWeb();
        refresh();
        $(Selectors.withText(confLabEvent.getName())).click();
        $(EVENT_TABS).find(Selectors.byText("Speeches")).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void addNewSpeechButtonVisible() throws Exception {
        $(ADD_NEW_BUTTON).shouldBe(visible);
    }

    @Test
    public void addFromListDropdownVisible() throws Exception {
        $(ADD_FROM_LIST_DROPDOWN).shouldBe(visible);
    }
}
