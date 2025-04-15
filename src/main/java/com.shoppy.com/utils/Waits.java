package com.shoppy.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits() {
    }

    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver1.findElement(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> {
            WebElement element = waitForElementPresent(driver, locator);
            return element.isDisplayed() ? element : null;
        });
    }


    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> {
            WebElement element = waitForElementVisible(driver, locator);
            return element.isEnabled() ? element : null;
        });
    }

    public static boolean waitForElementToBeInvisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    try {
                        WebElement element = driver1.findElement(locator);
                        return !element.isDisplayed();
                    } catch (Exception e) {
                        return true; // If it's gone from DOM, it's definitely invisible
                    }
                });
    }

    public static WebElement waitForElementTextToBe(WebDriver driver, By locator, String expectedText) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element = driver1.findElement(locator);
                    return expectedText.equals(element.getText()) ? element : null;
                });
    }


    public static boolean waitForUrlToContain(WebDriver driver, String expectedSubstring) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> {
                    String currentUrl = d.getCurrentUrl();
                    return currentUrl != null && currentUrl.contains(expectedSubstring);
                });
    }
}
