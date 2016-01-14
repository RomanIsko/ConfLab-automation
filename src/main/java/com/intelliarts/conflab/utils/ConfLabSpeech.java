package com.intelliarts.conflab.utils;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_DESCRIPTION;
import static com.intelliarts.conflab.utils.ElementLocatorData.SPEECH_TITLE;
import static com.intelliarts.conflab.utils.ResourcesData.SPEECHES_URL;

public class ConfLabSpeech {
    private String title;
    private String description;
    private String language;

    public ConfLabSpeech(String title) {
        this.title = title;
    }

    public ConfLabSpeech() {
        this.title = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void addViaWeb() {
        open(SPEECHES_URL);
        sleep(1000);
        $(ADD_BUTTON).click();
        $(SPEECH_TITLE).val(title);
        $(SPEECH_DESCRIPTION).val(description);
        $(SPEECH_DESCRIPTION).val(language);
        $(OK_BUTTON).click();
    }
}
