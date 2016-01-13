package com.intelliarts.conflab.utils;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_ABOUT;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_EMAIL;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEAKER_POSITION;
import static com.intelliarts.conflab.utils.ResourcesData.SPEAKERS_URL;

public class ConfLabSpeaker {
    private String name;
    private String email;
    private String position;
    private String about;

    public ConfLabSpeaker(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ConfLabSpeaker() {
        this.name = UUID.randomUUID().toString();
        this.email = this.name + "@email.com";
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void addViaWeb() {
        open(SPEAKERS_URL);
        $(ADD_BUTTON).click();
        sleep(1000);
        $(ADD_BUTTON).click();
        $(SPEAKER_NAME).val(name);
        $(SPEAKER_EMAIL).val(email);
        $(SPEAKER_POSITION).val(position);
        $(SPEAKER_ABOUT).val(about);
        $(OK_BUTTON).click();
        refresh();
    }
}
