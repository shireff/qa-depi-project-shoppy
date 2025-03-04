package com.shoppy.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scrolling {
    // prevent instantiation
    private Scrolling() {
    }


    public static void scrollToElement(WebDriver driver, By locator) {
        try {
        //    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
        } catch (Exception e) {
            System.out.println("⚠️ Scroll failed: " + e.getMessage());
        }
    }
}
