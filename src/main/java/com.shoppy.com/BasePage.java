package com.shoppy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    protected WebElement find(By locator) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }


    protected WebElement find(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        // Step 1: Find the first visible element
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                System.out.println("✅ Found VISIBLE element: " + locator.toString());
                return element;
            }
        }

        throw new RuntimeException("❌ No visible element found for: " + locator.toString());
    }


    //    protected void set(By locator, String text) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        element.clear();
//        element.sendKeys(text);
//    }
    protected void set(By locator, String text) {
        try {
            WebElement element = find(locator);

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

    protected void click(By locator) {
        find(locator).click();
        System.out.println("✅ Clicked element: " + locator.toString());
    }
}
