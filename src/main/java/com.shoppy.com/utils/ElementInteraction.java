package com.shoppy.com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;

public class ElementInteraction {

    // Retry mechanism for interacting with WebElements (click, sendKeys, etc.)
    public static void interactWithElement(WebDriver driver, WebElement element, ElementAction action, int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                // Perform the action (click, etc.)
                action.perform(element);
                return;  // Exit if the action was successful
            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ Stale Element! Retrying... Attempt: " + (i + 1));
                if (i == attempts - 1) {
                    throw e;  // Rethrow the exception if all attempts fail
                }
            }
        }
    }

    // Functional interface for element actions (like clicking or sending keys)
    @FunctionalInterface
    public interface ElementAction {
        void perform(WebElement element);
    }
}
