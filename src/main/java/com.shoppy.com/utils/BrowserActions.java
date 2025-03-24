package com.shoppy.com.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions openUrl(WebDriver driver, String url) {
        driver.get(url);
        return this;
    }

    public BrowserActions closeBrowser(WebDriver driver) {
        driver.quit();
        return this;
    }
}
