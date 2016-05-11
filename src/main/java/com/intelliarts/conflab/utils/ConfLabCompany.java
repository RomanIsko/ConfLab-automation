package com.intelliarts.conflab.utils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.intelliarts.conflab.utils.ElementLocatorData.ADD_BUTTON;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_NAME;
import static com.intelliarts.conflab.utils.ElementLocatorData.COMPANY_URL;
import static com.intelliarts.conflab.utils.ElementLocatorData.OK_BUTTON;
import static com.intelliarts.conflab.utils.ResourcesData.COMPANIES_URL;

public class ConfLabCompany {
    private String name;
    private String url;

    public ConfLabCompany() {
    }

    public ConfLabCompany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void addViaWeb() {
        open(COMPANIES_URL);
        sleep(1000);
        $(ADD_BUTTON).click();
        $(COMPANY_NAME).val(name);
        $(COMPANY_URL).val(url);
        $(OK_BUTTON).click();
    }
}
