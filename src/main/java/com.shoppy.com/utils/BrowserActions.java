package com.shoppy.com.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions navigateToURL(String url) {
        driver.navigate().to(url);
        return this;
    }


    public BrowserActions openUrl(WebDriver driver, String url) {
        driver.get(url);
        return this;
    }

    public BrowserActions closeBrowser(WebDriver driver) {
        driver.quit();
        return this;
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public BrowserActions navigateForward() {
        driver.navigate().forward();
        return this;
    }

    public BrowserActions navigateBack() {
        driver.navigate().back();
        return this;
    }

    public BrowserActions refreshCurrentPage() {
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions scrollToBottom() {
        new Actions(driver).scrollByAmount(0, 2500).build().perform();
        return this;
    }

    public BrowserActions scrollToAmount(int width, int height) {
        new Actions(driver).scrollByAmount(width, height).build().perform();
        return this;
    }
    public BrowserActions smallerBrowser()
    {
        Dimension newSize = new Dimension(800, 600); // Width: 800, Height: 600
        driver.manage().window().setSize(newSize);
        return this;
    }

    /****************************************** Cookies ****************************************/

    public BrowserActions addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }


    public BrowserActions deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookieWithName(String name) {
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    public BrowserActions deleteAllCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }
}
