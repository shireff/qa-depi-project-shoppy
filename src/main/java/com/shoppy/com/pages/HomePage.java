package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {

    private final Driver driver;

    // **Locators**
    private final By homePageHeader = By.xpath("//span[text()='Shoppy']");
    private final By categoryButtons = By.cssSelector(".grid.grid-cols-2 div.rounded-lg span.font-bold");
    private final By featuredProductsSection = By.xpath("//h2[@class=\"text-3xl font-bold text-center mb-8\" and text()=\"Feature products\"]\n");
    private final By featuredProductImages = By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm img");
    private final By brandButtons = By.xpath("//h2[contains(text(), 'Shop by Brand')]/following-sibling::div//span[contains(@class, 'font-bold')]");
    private final By featuredProducts = By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm");
    private final By productModal = By.cssSelector("div[role='dialog']");
    private final By productTitle = By.cssSelector(".text-xl.sm\\:text-2xl.font-bold");
    private final By productPrice = By.cssSelector(".text-xl.font-bold.text-primary");
    private final By customerReviews = By.cssSelector(".grid > div.rounded-lg.border");
    private final By noProductsMessage = By.xpath("//h2[text()='No Products Found']");
    private final By footerLinks = By.cssSelector("footer a");

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /***************************************** Validation Methods  ******************************************/
    @Step("Verify if the home page header is displayed")
    public boolean isHomePageHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageHeader));
            return headerElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    @Step("Select category")
    public void selectCategory(String category) {
        try {
            driver.element().selectItem(categoryButtons, category, "category");
        } catch (Exception e) {
            Assert.fail("\n ❌ Failed to select category '" + category + "': " + e.getMessage() + "\n");
        }

    }
    @Step("Select brand")
    public void selectBrand(String brand) {
        try {
            driver.element().selectItem(brandButtons, brand, "brand");
        } catch (Exception e) {
            Assert.fail("\n ❌ Failed to select brand '" + brand + "': " + e.getMessage() + "\n");
        }
    }
    @Step("Click the first featured product")
    public void clickFirstFeaturedProduct() {
        try {
            driver.element().scrollToElement(featuredProductsSection);
            driver.element().click(featuredProductImages);
        } catch (Exception e) {
            Assert.fail("\n ❌ Failed to click first featured product: " + e.getMessage() + "\n");
        }
    }

    /***************************************** General Element Visibility Checks  ******************************************/
    @Step("Check if featured products are displayed")
    public boolean isFeaturedProductDisplayed() {
        return isElementVisible(featuredProducts);
    }
    @Step("Check if product modal is displayed")
    public boolean isProductModalDisplayed() {
        return isElementVisible(productModal);
    }
    @Step("Check if product title is visible")
    public boolean isProductTitleVisible() {
        return isElementVisible(productTitle);
    }
    @Step("Check if product price is visible")
    public boolean isProductPriceVisible() {
        return isElementVisible(productPrice);
    }
    @Step("Check if 'No Products Found' message is displayed")
    public boolean isNoProductsMessageDisplayed() {
        return isElementVisible(noProductsMessage);
    }
    @Step("Check if customer reviews are displayed")
    public boolean isCustomerReviewsDisplayed() {
        return isElementVisible(customerReviews);
    }
    @Step("Check if footer links are working")
    public boolean areFooterLinksWorking() {
        List<WebElement> links = driver.get().findElements(footerLinks);
        return links.stream().allMatch(WebElement::isDisplayed);
    }

    private boolean isElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /***************************************** Assertions  ******************************************/
    @Step("Validate product visibility for hasProducts: {0}")
    public void validateProductVisibility(boolean hasProducts, String errorMessage) {
        if (hasProducts) {
            driver.assertion().assertElementDisplayed(featuredProducts, "\n ❌ " + errorMessage + " \n");
        } else {
            driver.assertion().assertElementDisplayed(noProductsMessage, "\n ❌ " + errorMessage + " \n");
        }
    }

    @Step("Assert home page header is displayed")
    public void assertHomePageHeaderDisplayed() {
        driver.assertion().assertElementDisplayed(homePageHeader, "\n ❌ Home page header is not displayed! \n");
    }

    @Step("Assert featured products are displayed")
    public void assertFeatureProductsDisplayed() {
        driver.assertion().assertElementDisplayed(featuredProducts, "\n ❌ Featured products are not displayed! \n");
    }

    @Step("Assert product modal is displayed")
    public void assertProductModalDisplayed() {
        driver.assertion().assertElementDisplayed(productModal, "\n ❌ Product modal did not appear! \n");
    }

    @Step("Assert product title is visible")
    public void assertProductTitleVisible() {
        driver.assertion().assertElementDisplayed(productTitle, "\n ❌ Product title is missing! \n");
    }

    @Step("Assert product price is visible")
    public void assertProductPriceVisible() {
        driver.assertion().assertElementDisplayed(productPrice, "\n ❌ Product price is missing! \n");
    }

    @Step("Assert customer reviews are displayed")
    public void assertCustomerReviewsDisplayed() {
        driver.assertion().assertElementDisplayed(customerReviews, "\n ❌ Customer reviews section is missing! \n");
    }

    @Step("Assert footer links are working")
    public void assertFooterLinksWorking() {
        List<WebElement> links = driver.get().findElements(footerLinks);
        Assert.assertTrue(links.stream().allMatch(WebElement::isDisplayed), "\n ❌ Footer links are not working! \n");
    }
}
