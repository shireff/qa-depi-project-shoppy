package com.shoppy.com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ElementActions {
    private WebDriver driver;
    private JavascriptExecutor js;
    private static final Logger logger = LoggerFactory.getLogger(ElementActions.class); // Create logger instance
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLUE = "\u001B[34m";
    private static final String BOLD = "\u001B[1m";

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }


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
            logger.info(GREEN + "✅ Scrolled to visible element." + RESET);

            element.click();
            logger.info(GREEN + "✅ Clicked element to ensure focus." + RESET);

            element.clear();
            element.sendKeys(text);
            logger.info(GREEN + "✅ Successfully set text: " + CYAN + text + RESET);

        } catch (Exception e) {
            logger.warn(BOLD + RED + "⚠️ ERROR: Unable to set text normally. Using JavaScript as fallback." + RESET);

            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, text);
            logger.info(BLUE + "ℹ️ Fallback JavaScript set text: " + CYAN + text + RESET);
        }
    }

    public ElementActions click(By locator) {
        logger.info(BLUE + "🖱️ Click on: " + locator.toString() + RESET);
        try {
            isClickable(locator);
            find(driver, locator).click();
        } catch (ElementClickInterceptedException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException exception) {
            logger.error(RED + BOLD + "❌ ERROR From click method: " + exception.getMessage() + RESET);
            scrollToElement(locator);
            clickUsingJs(locator);
        }
        return this;
    }

    public ElementActions type(By locator, String text) {
        clearField(locator);
        logger.info(GREEN + "⌨️ Fill field: " + locator.toString() + " with: " + text + RESET);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clearField(By locator) {
        logger.info(YELLOW + "❌ Clear field with locator: " + locator.toString() + RESET);
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions scrollToElement(By locator) {
        logger.info(CYAN + "🔽 Scrolling to element: " + locator.toString() + RESET);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        return this;
    }

    public ElementActions selectByIndex(By locator, int index) {
        logger.info(BLUE + "🔘 Selecting Option " + index + " from dropdown: " + locator.toString() + RESET);
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public ElementActions selectByValue(By locator, String value) {
        logger.info(BLUE + "🔘 Selecting Value: " + value + " from dropdown: " + locator.toString() + RESET);
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public ElementActions selectByVisibleText(By locator, String value) {
        logger.info(BLUE + "🔘 Selecting Value: " + value + " from dropdown: " + locator.toString() + RESET);
        new Select(driver.findElement(locator)).selectByVisibleText(value);
        return this;
    }


    public static String getText(WebDriver driver, By locator) {
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        System.out.println("✅Getting text from locator: " + locator.toString());
        return driver.findElement(locator).getText();
    }

    public static boolean isDisplayed(WebDriver driver, By locator) {
        System.out.println("🔎Check if Displayed or not locator: " + locator.toString());
        return find(driver, locator).isDisplayed();
    }

//    public void selectByValue(By locator, String value) {
//        System.out.println("✅`Selecting value " + value + "from dropdown: " + locator.toString());
//        new Select(driver.findElement(locator)).selectByValue(value);
//    }

    public void selectByText(By locator, String text) {
        System.out.println("✅`Select element with text: " + text + "from dropdown: " + locator);
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public String getTextOf(By locator) {
        System.out.println("✅Getting text from locator: " + locator.toString());
        return driver.findElement(locator).getText();
    }

    public String getElementAttribute(By locator, String attributeName) {
        System.out.println("🔎 finding element attribute");
        return driver.findElement(locator).getAttribute(attributeName);
    }

    public Boolean isSelected(By locator) {
        logger.info(GREEN + "✔️ Checking " + locator.toString().split(":", 2)[1] + " if Selected" + RESET);
        return driver.findElement(locator).isSelected();
    }

    public Boolean isClickable(By locator) {
        logger.info(GREEN + "👆 Checking " + locator.toString().split(":", 2)[1] + " if Clickable" + RESET);
        return driver.findElement(locator).isEnabled();
    }

    public ElementActions clickUsingJs(By locator) {
        logger.info(BLUE + "🖱️ Click on: " + locator.toString() + RESET);
        try {
            isClickable(locator);
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (ElementClickInterceptedException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException exception) {
            logger.error(RED + BOLD + "❌ ERROR From click method: " + exception.getMessage() + RESET);
            scrollToElement(locator);
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        }
        return this;
    }

}
