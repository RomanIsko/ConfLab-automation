package com.intelliarts.conflab.automation.web.event;

import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_FROM_LIST_DROPDOWN;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENTS_LIST;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_TABS;

public class SingleEventViewSpeechesTab extends BasicTestCase {
    private static final SimpleDateFormat dateFormat            = new SimpleDateFormat("dd-MMM-yyyy");
    private static       Date             randomDateInThePast   = dateAndTime.past(100, TimeUnit.DAYS);
    private static       Date             randomDateInTheFuture = dateAndTime.future(100, TimeUnit.DAYS);

    protected static String eventDescription = lorem.paragraph(3);
    protected static String eventStartDate   = dateFormat.format(randomDateInThePast);
    protected static String eventEndDate     = dateFormat.format(randomDateInTheFuture);
    protected static String eventCountry     = address.country();
    protected static String eventCity        = address.city();
    protected static String eventAddress     = address.streetAddress();
    protected static String eventContacts    = "+41 44 444 44 44\n" +
                                               name.fullName() + "\n" +
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
        $(EVENTS_LIST).find(withText(confLabEvent.getName())).click();
        $(EVENT_TABS).find(byText("Speeches")).click();
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
