package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.DateProducer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_FROM_LIST_DROPDOWN;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_NEW_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_TABS;

public class SingleEventViewSpeakersTab extends BasicTestCase {
    private static final DateProducer      dateProducer          = Fairy.create().dateProducer();
    private static final DateTimeFormatter formatter             = DateTimeFormat.forPattern("dd-MMM-yyyy");
    private static       DateTime          randomDateInThePast   = dateProducer.randomDateInThePast(1);
    private static       DateTime          randomDateInTheFuture = dateProducer.randomDateInTheFuture(1);

    protected static String eventDescription = "This is the description for \n";
    protected static String eventStartDate   = randomDateInThePast.toString(formatter);
    protected static String eventEndDate     = randomDateInTheFuture.toString(formatter);
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
        $(EVENT_TABS).find(Selectors.byText("Speakers")).click();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void addNewSpeakerButtonVisible() throws Exception {
        $(ADD_NEW_BUTTON).shouldBe(visible);
    }

    @Test
    public void addFromListDropdownVisible() throws Exception {
        $(ADD_FROM_LIST_DROPDOWN).shouldBe(visible);
    }
}
