package com.shoppy.com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
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
                LogHelper.logInfo(logger, String.format(GREEN + "✅ Found visible element: %s" + RESET, locator.toString()));
                return element;
            }
        }

        throw new RuntimeException("❌ No visible element found for: " + locator.toString());
    }

    public ElementActions set(By locator, String text) {
        try {
            WebElement element = find(driver, locator);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            LogHelper.logInfo(logger,GREEN + "✅ Scrolled to visible element." + RESET);

            element.click();
            LogHelper.logInfo(logger,GREEN + "✅ Clicked element to ensure focus." + RESET);

            element.clear();
            element.sendKeys(text);
            LogHelper.logInfo(logger,GREEN + "✅ Successfully set text: " + CYAN + text + RESET);

        } catch (Exception e) {
            LogHelper.logWarn(logger,BOLD + RED + "⚠️ ERROR: Unable to set text normally. Using JavaScript as fallback." + RESET);

            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, text);
            LogHelper.logInfo(logger,BLUE + "ℹ️ Fallback JavaScript set text: " + CYAN + text + RESET);
        }
        return this;
    }

    public ElementActions click(By locator) {
        LogHelper.logInfo(logger,BLUE + "🖱️ Click on: " + locator.toString() + RESET);
        try {
            //    isClickable(locator);
            find(driver, locator).click();
        } catch (ElementClickInterceptedException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException exception) {
            LogHelper.logError(logger,RED + BOLD + "❌ ERROR From click method: " + exception.getMessage() + RESET);
            scrollToElement(locator);
            clickUsingJs(locator);
        }
        return this;
    }

    public ElementActions type(By locator, String text) {
        clearField(locator);
        LogHelper.logInfo(logger,GREEN + "⌨️ Fill field: " + locator.toString() + " with: " + text + RESET);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clearField(By locator) {
        LogHelper.logInfo(logger,YELLOW + "❌ Clear field with locator: " + locator.toString() + RESET);
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions scrollToElement(By locator) {
        LogHelper.logInfo(logger,CYAN + "🔽 Scrolling to element: " + locator.toString() + RESET);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        return this;
    }

    // Unified method for selecting category or brand
    public ElementActions selectItem(By itemLocator, String item, String itemType) {
        String typeLabel = itemType.equalsIgnoreCase("category") ? "category" : "brand";
        LogHelper.logInfo(logger,BLUE + "🔍 Selecting " + typeLabel + ": " + CYAN + item + RESET);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemLocator));
            LogHelper.logInfo(logger,GREEN + "✅ Found " + items.size() + " " + typeLabel + " elements" + RESET);

            for (WebElement element : items) {
                String itemText = element.getText().trim();
                if (itemText.equalsIgnoreCase(item)) {
                    LogHelper.logInfo(logger,GREEN + "✅ Found matching " + typeLabel + ": " + CYAN + itemText + RESET);

                    // Scroll behavior: smooth for brands, basic for categories
                    String scrollScript = itemType.equalsIgnoreCase("brand")
                            ? "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});"
                            : "arguments[0].scrollIntoView(true);";
                    js.executeScript(scrollScript, element);
                    LogHelper.logInfo(logger,GREEN + "✅ Scrolled to " + typeLabel + ": " + CYAN + item + RESET);

                    // Click: JS for brands, regular for categories
                    if (itemType.equalsIgnoreCase("brand")) {
                        js.executeScript("arguments[0].click();", element);
                    } else {
                        element.click();
                    }
                    LogHelper.logInfo(logger,GREEN + "✅ Clicked " + typeLabel + ": " + CYAN + item + RESET);

                    // URL check: category= for categories, brand= with encoding for brands
                    String urlFragment;
                    if (itemType.equalsIgnoreCase("brand")) {
                        String encodedItem = item.toLowerCase().replace("'s", "").replace("&", "%26");
                        urlFragment = "brand=" + encodedItem;
                    } else {
                        urlFragment = "category=" + item.toLowerCase();
                    }
                    wait.until(ExpectedConditions.urlContains(urlFragment));
                    LogHelper.logInfo(logger,GREEN + "✅ URL updated to include: " + CYAN + urlFragment + RESET);
                    return this;
                }
            }
            LogHelper.logError(logger,RED + BOLD + "❌ " + typeLabel + " '" + item + "' not found in the list!" + RESET);
            throw new AssertionError("❌ " + typeLabel + " '" + item + "' not found!");

        } catch (TimeoutException e) {
            LogHelper.logError(logger,RED + BOLD + "❌ Timeout waiting for " + typeLabel + " elements or URL update: " + e.getMessage() + RESET);
            throw new RuntimeException("❌ Failed to select " + typeLabel + " '" + item + "' due to timeout", e);
        } catch (Exception e) {
            LogHelper.logError(logger,RED + BOLD + "❌ Unexpected error selecting " + typeLabel + ": " + e.getMessage() + RESET);
            throw new RuntimeException("❌ Failed to select " + typeLabel + " '" + item + "'", e);
        }
    }

    public ElementActions selectByIndex(By locator, int index) {
        LogHelper.logInfo(logger,BLUE + "🔘 Selecting Option " + index + " from dropdown: " + locator.toString() + RESET);
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public ElementActions selectByValue(By locator, String value) {
        LogHelper.logInfo(logger,BLUE + "🔘 Selecting Value: " + value + " from dropdown: " + locator.toString() + RESET);
        new Select(driver.findElement(locator)).selectByValue(value);
        return this;
    }

    public ElementActions selectByVisibleText(By locator, String value) {
        LogHelper.logInfo(logger,BLUE + "🔘 Selecting Value: " + value + " from dropdown: " + locator.toString() + RESET);
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
        LogHelper.logInfo(logger,GREEN + "✔️ Checking " + locator.toString().split(":", 2)[1] + " if Selected" + RESET);
        return driver.findElement(locator).isSelected();
    }

    public Boolean isClickable(By locator) {
        LogHelper.logInfo(logger,GREEN + "👆 Checking " + locator.toString().split(":", 2)[1] + " if Clickable" + RESET);
        return driver.findElement(locator).isEnabled();
    }

    public ElementActions clickUsingJs(By locator) {
        LogHelper.logInfo(logger,BLUE + "🖱️ Click on: " + locator.toString() + RESET);
        try {
            isClickable(locator);
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (ElementClickInterceptedException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException exception) {
            LogHelper.logError(logger,RED + BOLD + "❌ ERROR From click method: " + exception.getMessage() + RESET);
            scrollToElement(locator);
            js.executeScript("arguments[0].click();", driver.findElement(locator));
        }
        return this;
    }

    public static List<By> getAllElementsLocators(WebDriver driver, By locator, String commonXpath) {
        List<WebElement> allElementsList = driver.findElements(locator);
        List<By> allElementsLocators = new ArrayList<>();
        int i;
        for (i = 1; i <= allElementsList.size(); i++) ;
        {
            allElementsLocators.add(By.xpath(commonXpath + "[" + i + "]"));
        }
        return allElementsLocators;
    }

    public void setNumberField(WebDriver driver, By locator, int number) {
        try {
            WebElement element = find(driver, locator);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            LogHelper.logInfo(logger,GREEN + "✅ Scrolled to visible element." + RESET);

            element.submit();
            LogHelper.logInfo(logger,GREEN + "✅ Clicked element to ensure focus." + RESET);

            element.clear();
            element.sendKeys(String.valueOf(number), Keys.TAB);
            LogHelper.logInfo(logger,GREEN + "✅ Successfully set number: " + CYAN + number + RESET);

        } catch (Exception e) {
            logger.warn(BOLD + RED + "⚠️ ERROR: Unable to set number normally. Using JavaScript as fallback." + RESET);
            WebElement element = driver.findElement(locator);
            element.sendKeys(Keys.TAB);
            element.sendKeys(Keys.ENTER);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, number);
            LogHelper.logInfo(logger,BLUE + "ℹ️ Fallback JavaScript set number: " + CYAN + number + RESET);
        }

    }
}