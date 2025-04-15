package com.shoppy.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ElementAssertions {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ElementAssertions.class);
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLUE = "\u001B[34m";
    private static final String BOLD = "\u001B[1m";

    public ElementAssertions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Asserts that an element is displayed on the page.
     */
    public ElementAssertions assertElementDisplayed(By locator, String errorMessage) {
        LogHelper.logInfo(GREEN + "🔍 Asserting element is displayed: " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + RESET);
            throw new AssertionError(errorMessage);
        }
        LogHelper.logInfo(GREEN + "✅ Element is displayed: " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that an element is not displayed on the page.
     */
    public ElementAssertions assertElementNotDisplayed(By locator, String errorMessage) {
        LogHelper.logInfo(YELLOW + "🔍 Asserting element is not displayed: " + locator.toString() + RESET);
        try {
            WebElement element = Waits.waitForElementVisible(driver, locator);
            if (element != null && element.isDisplayed()) {
                LogHelper.logError(RED + BOLD + "❌ " + errorMessage + RESET);
                throw new AssertionError(errorMessage);
            }
        } catch (Exception e) {
            LogHelper.logInfo(GREEN + "✅ Element is not displayed as expected: " + locator.toString() + RESET);
            return this;
        }
        LogHelper.logError(RED + BOLD + "❌ " + errorMessage + RESET);
        throw new AssertionError(errorMessage);
    }

    /**
     * Asserts that an element's text matches the expected value (case-insensitive).
     */
    public ElementAssertions assertElementTextEquals(By locator, String expectedText, String errorMessage) {
        LogHelper.logInfo(BLUE + "🔍 Asserting element text equals: '" + expectedText + "' for " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ Element not found or not displayed: " + locator.toString() + RESET);
            throw new AssertionError("❌ Element not found or not displayed: " + locator.toString());
        }
        String actualText = element.getText().trim();
        if (!actualText.equalsIgnoreCase(expectedText)) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + " (Expected: '" + expectedText + "', Actual: '" + actualText + "')" + RESET);
            throw new AssertionError(errorMessage + " (Expected: '" + expectedText + "', Actual: '" + actualText + "')");
        }
        LogHelper.logInfo(GREEN + "✅ Element text matches: '" + expectedText + "' for " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that an element's text contains the expected substring (case-insensitive).
     */
    public ElementAssertions assertElementTextContains(By locator, String expectedSubstring, String errorMessage) {
        LogHelper.logInfo(BLUE + "🔍 Asserting element text contains: '" + expectedSubstring + "' for " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ Element not found or not displayed: " + locator.toString() + RESET);
            throw new AssertionError("❌ Element not found or not displayed: " + locator.toString());
        }
        String actualText = element.getText().trim();
        if (!actualText.toLowerCase().contains(expectedSubstring.toLowerCase())) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + " (Expected to contain: '" + expectedSubstring + "', Actual: '" + actualText + "')" + RESET);
            throw new AssertionError(errorMessage + " (Expected to contain: '" + expectedSubstring + "', Actual: '" + actualText + "')");
        }
        LogHelper.logInfo(GREEN + "✅ Element text contains: '" + expectedSubstring + "' for " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that an element's attribute matches the expected value.
     */
    public ElementAssertions assertElementAttributeEquals(By locator, String attributeName, String expectedValue, String errorMessage) {
        LogHelper.logInfo(CYAN + "🔍 Asserting element attribute '" + attributeName + "' equals: '" + expectedValue + "' for " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ Element not found or not displayed: " + locator.toString() + RESET);
            throw new AssertionError("❌ Element not found or not displayed: " + locator.toString());
        }
        String actualValue = element.getAttribute(attributeName);
        if (actualValue == null || !actualValue.equals(expectedValue)) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + " (Expected: '" + expectedValue + "', Actual: '" + actualValue + "')" + RESET);
            throw new AssertionError(errorMessage + " (Expected: '" + expectedValue + "', Actual: '" + actualValue + "')");
        }
        LogHelper.logInfo(GREEN + "✅ Element attribute '" + attributeName + "' matches: '" + expectedValue + "' for " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that an element is enabled.
     */
    public ElementAssertions assertElementEnabled(By locator, String errorMessage) {
        LogHelper.logInfo(GREEN + "🔍 Asserting element is enabled: " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ Element not found or not displayed: " + locator.toString() + RESET);
            throw new AssertionError("❌ Element not found or not displayed: " + locator.toString());
        }
        if (!element.isEnabled()) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + RESET);
            throw new AssertionError(errorMessage);
        }
        LogHelper.logInfo(GREEN + "✅ Element is enabled: " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that an element is selected (e.g., checkbox or radio button).
     */
    public ElementAssertions assertElementSelected(By locator, String errorMessage) {
        LogHelper.logInfo(GREEN + "🔍 Asserting element is selected: " + locator.toString() + RESET);
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            LogHelper.logError(RED + BOLD + "❌ Element not found or not displayed: " + locator.toString() + RESET);
            throw new AssertionError("❌ Element not found or not displayed: " + locator.toString());
        }
        if (!element.isSelected()) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + RESET);
            throw new AssertionError(errorMessage);
        }
        LogHelper.logInfo(GREEN + "✅ Element is selected: " + locator.toString() + RESET);
        return this;
    }

    /**
     * Asserts that all elements matching a locator are displayed.
     */
    public ElementAssertions assertAllElementsDisplayed(By locator, String errorMessage) {
        LogHelper.logInfo(GREEN + "🔍 Asserting all elements are displayed: " + locator.toString() + RESET);
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty() || !elements.stream().allMatch(WebElement::isDisplayed)) {
            LogHelper.logError(RED + BOLD + "❌ " + errorMessage + " (Found: " + elements.size() + " elements)" + RESET);
            throw new AssertionError(errorMessage + " (Found: " + elements.size() + " elements)");
        }
        LogHelper.logInfo(GREEN + "✅ All " + elements.size() + " elements are displayed: " + locator.toString() + RESET);
        return this;
    }
}