package com.intelliarts.conflab.utils;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_ADDRESS;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CITY;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_CONTACTS;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_COUNTRY;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME_LABEL;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ResourcesData.EVENTS_URL;

public class ConfLabEvent {
    private String name;
    private String description;
    //TODO: convert to Date
    private String startDate;
    private String endDate;
    private String country;
    private String city;
    private String address;
    private String contacts;

    public ConfLabEvent(String name) {
        this.name = name;
    }

    public ConfLabEvent() {
        Faker faker = new Faker();
        this.name = faker.lorem().fixedString(24);

        DateAndTime dateAndTime = faker.date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date randomDateInThePast = dateAndTime.past(10, TimeUnit.DAYS);
        Date randomDateInTheFuture = dateAndTime.future(10, TimeUnit.DAYS);

        this.startDate = dateFormat.format(randomDateInThePast);
        this.endDate = dateFormat.format(randomDateInTheFuture);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public void addViaWeb() {
        open(EVENTS_URL);
        sleep(1000);
        $(ADD_BUTTON).click();
        $(EVENT_NAME).val(name);
        $(EVENT_DESCRIPTION).val(description);
        if (startDate != null && endDate != null) {
            $(EVENT_START_DATE).val(startDate);
            $(EVENT_END_DATE).val(endDate);
        }
        $(EVENT_COUNTRY).val(country);
        $(EVENT_CITY).val(city);
        $(EVENT_ADDRESS).val(address);
        $(EVENT_CONTACTS).val(contacts);
        $(EVENT_NAME_LABEL).click();
        $(OK_BUTTON).click();
    }
}
