package com.shoppy.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementActions {
    protected WebDriverWait wait;

    public ElementActions(WebDriver driver) {
        throw new UnsupportedOperationException("Utility class - Cannot be instantiated.");
    }

//    public static WebElement find(WebDriver driver, By locator) {
//        WebElement element = driver.findElement(locator);
//        return element;
//    }


    public static WebElement find(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);

        // Step 1: Find the first visible element
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                System.out.println("✅ Found visible element: " + locator.toString());
                return element;
            }
        }

        throw new RuntimeException("❌ No visible element found for: " + locator.toString());
    }

    public static void set(WebDriver driver, By locator, String text) {
        try {
            WebElement element = find(driver, locator);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("✅ Scrolled to visible element.");

            element.click();
            System.out.println("✅ Clicked element to ensure focus.");

            element.clear();
            element.sendKeys(text);
            System.out.println("✅ Successfully set text: " + text);

        } catch (Exception e) {
            System.out.println("⚠️ ERROR: Unable to set text normally. Using JavaScript as fallback.");

            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, text);
        }
    }

    public static void click(WebDriver driver, By locator) {
        find(driver, locator).click();
        System.out.println("✅ Clicked element: " + locator.toString());
    }

    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        return driver.findElement(locator).getText();
    }

}
