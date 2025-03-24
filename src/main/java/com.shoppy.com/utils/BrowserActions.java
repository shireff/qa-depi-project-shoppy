package com.shoppy.com.utils;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    public BrowserActions(WebDriver driver) {
    }

    public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
