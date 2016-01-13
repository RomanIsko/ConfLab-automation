package com.intelliarts.conflab.utils;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_END_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.EVENT_START_DATE;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ResourcesData.EVENTS_URL;

public class ConfLabEvent {
    private String name;
    private String description;
    //TODO: convert to Date
    private String startDate;
    private String endDate;

    public ConfLabEvent(String name) {
        this.name = name;
    }

    public ConfLabEvent() {
        this.name = UUID.randomUUID().toString();
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

    public void addViaWeb() {
        open(EVENTS_URL);
        $(ADD_BUTTON).click();
        $(EVENT_NAME).val(name);
        $(EVENT_DESCRIPTION).val(description);
        $(EVENT_START_DATE).val(startDate);
        $(EVENT_END_DATE).val(endDate);
        $(OK_BUTTON).click();
    }
}
