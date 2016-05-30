package com.intelliarts.conflab.automation.web.event;

import com.codeborne.selenide.Selectors;
import com.intelliarts.conflab.automation.web.BasicTestCase;
import com.intelliarts.conflab.utils.ConfLabEvent;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.DateProducer;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_ADDRESS;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CITY;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CONTACTS;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_COUNTRY;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.FORM_EDIT_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.INFO_FORM;

public class SingleEventViewInfoTab extends BasicTestCase {
    private static final TextProducer textProducer = Fairy.create().textProducer();

    private static final DateProducer      dateProducer          = Fairy.create().dateProducer();
    private static final DateTimeFormatter formatter             = DateTimeFormat.forPattern("dd-MMM-yyyy");
    private static       DateTime          randomDateInThePast   = dateProducer.randomDateInThePast(1);
    private static       DateTime          randomDateInTheFuture = dateProducer.randomDateInTheFuture(1);

    private static final Person  person  = Fairy.create().person();
    private static final Address address = person.getAddress();

    private static final String eventDescription = textProducer.paragraph(3);
    private static final String eventStartDate   = randomDateInThePast.toString(formatter);
    private static final String eventEndDate     = randomDateInTheFuture.toString(formatter);
    private static final String eventCountry     = "Switzerland";
    private static final String eventCity        = address.getCity();
    private static final String eventAddress     = address.street() + " " + address.streetNumber();
    private static       String email            = person.email();
    private static       String username         = person.username();
    private static       String telephoneNumber  = person.telephoneNumber();
    private static       String fullName         = person.fullName();
    private static final String eventContacts    = telephoneNumber + "\n" +
                                                   fullName + "\n" +
                                                   "skype:  " + username + "\n" +
                                                   "mailto: " + email;

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
    }

    @AfterClass
    public static void tearDown() throws Exception {
        basicTearDown();
    }

    @Test
    public void editButtonVisible() throws Exception {
        $(INFO_FORM).hover();
        $(FORM_EDIT_BUTTON).shouldBe(visible);
    }

    @Test
    public void eventDescriptionVisible() throws Exception {
        $(EVENT_DESCRIPTION).shouldBe(visible);
    }

    @Test
    public void eventDescriptionCorrect() throws Exception {
        $(EVENT_DESCRIPTION).shouldHave(text(eventDescription));
    }

    @Test
    public void eventStartDateVisible() throws Exception {
        $(EVENT_START_DATE).shouldBe(visible);
    }

    @Test
    public void eventStartDateCorrect() throws Exception {
        $(EVENT_START_DATE).shouldHave(text(eventStartDate));
    }

    @Test
    public void eventEndDateVisible() throws Exception {
        $(EVENT_END_DATE).shouldBe(visible);
    }

    @Test
    public void eventEndDateCorrect() throws Exception {
        $(EVENT_END_DATE).shouldHave(text(eventEndDate));
    }

    @Test
    public void eventCountryVisible() throws Exception {
        $(EVENT_COUNTRY).shouldBe(visible);
    }

    @Test
    public void eventCountryCorrect() throws Exception {
        $(EVENT_COUNTRY).shouldHave(text(eventCountry));
    }

    @Test
    public void eventCityVisible() throws Exception {
        $(EVENT_CITY).shouldBe(visible);
    }

    @Test
    public void eventCityCorrect() throws Exception {
        $(EVENT_CITY).shouldHave(text(eventCity));
    }

    @Test
    public void eventAddressVisible() throws Exception {
        $(EVENT_ADDRESS).shouldBe(visible);
    }

    @Test
    public void eventAddressCorrect() throws Exception {
        $(EVENT_ADDRESS).shouldHave(text(eventAddress));
    }

    @Test
    public void eventContactsVisible() throws Exception {
        $(EVENT_CONTACTS).shouldBe(visible);
    }

    @Test
    public void eventContactsCorrect() throws Exception {
        $(EVENT_CONTACTS).shouldHave(text(eventContacts));
    }
}
