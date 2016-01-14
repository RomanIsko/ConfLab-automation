package com.intelliarts.conflab.utils;

public enum ConfLabSpeechLanguage {
    ENGLISH("English"),
    UKRAINIAN("Ukrainian"),
    RUSSIAN("Russian");
    private String value;

    ConfLabSpeechLanguage(String lang) {
        this.value = lang;
    }

    public String getValue() {
        return value != null ? value : "";
    }
}