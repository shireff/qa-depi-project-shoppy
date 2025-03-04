package com.shoppy.com.pages;

import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {

    private final WebDriver driver;

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

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // **Validation Methods**
    public boolean isHomePageHeaderDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageHeader));
            return headerElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> categories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoryButtons));

        for (WebElement cat : categories) {
            if (cat.getText().trim().equalsIgnoreCase(category)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cat);
                cat.click();
                wait.until(ExpectedConditions.urlContains("category=" + category.toLowerCase()));
                return;
            }
        }
        Assert.fail("\n ❌ Category '" + category + "' not found! \n");
    }

    public void selectBrand(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> brands = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandButtons));

        for (WebElement brd : brands) {
            if (brd.getText().trim().equalsIgnoreCase(brand)) {
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", brd);
                js.executeScript("arguments[0].click();", brd);
                String encodedBrand = brand.toLowerCase().replace("'s", "").replace("&", "%26");
                wait.until(ExpectedConditions.urlContains("brand=" + encodedBrand));
                System.out.println("✅ Brand '" + brand + "' selected successfully.");
                return;
            }
        }
        Assert.fail("\n ❌ Brand '" + brand + "' not found! \n");
    }

    public void clickFirstFeaturedProduct() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement featureSection = wait.until(ExpectedConditions.presenceOfElementLocated(featuredProductsSection));
        js.executeScript("arguments[0].scrollIntoView(true);", featureSection);
        System.out.println("✅ Scrolled to 'Feature products' section.");

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(featuredProductImages));

        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstProduct);
        Thread.sleep(500);

        firstProduct.click();
        System.out.println("✅ Clicked on the first featured product.");
    }

    // **General Element Visibility Checks**
    public boolean isFeaturedProductDisplayed() {
        return isElementVisible(featuredProducts);
    }

    public boolean isProductModalDisplayed() {
        return isElementVisible(productModal);
    }

    public boolean isProductTitleVisible() {
        return isElementVisible(productTitle);
    }

    public boolean isProductPriceVisible() {
        return isElementVisible(productPrice);
    }

    public boolean isNoProductsMessageDisplayed() {
        return isElementVisible(noProductsMessage);
    }

    public boolean isCustomerReviewsDisplayed() {
        return isElementVisible(customerReviews);
    }

    public boolean areFooterLinksWorking() {
        List<WebElement> links = driver.findElements(footerLinks);
        return links.stream().allMatch(WebElement::isDisplayed);
    }

    private boolean isElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /*   ------------------------------------------- Assertions Section -----------------------------------------------  */

    /**
     * **Reusable Assertion Method**
     * Validates whether products are displayed or not based on the expected outcome.
     *
     * @param hasProducts  Expected outcome (true if products should be visible, false otherwise)
     * @param errorMessage Custom error message for assertion failure
     */
    public void validateProductVisibility(boolean hasProducts, String errorMessage) {
        if (hasProducts) {
            Assert.assertTrue(this.isFeaturedProductDisplayed(), "\n ❌ " + errorMessage + " \n");
        } else {
            Assert.assertTrue(this.isNoProductsMessageDisplayed(), "\n ❌ " + errorMessage + " \n");
        }
    }

    public void assertHomePageHeaderDisplayed() {
        Assert.assertTrue(this.isHomePageHeaderDisplayed(), "\n ❌ Home page header is not displayed! \n");
    }

    public void assertFeatureProductsDisplayed() {
        Assert.assertTrue(this.isFeaturedProductDisplayed(), "\n ❌ Featured products are not displayed! \n");
    }

    public void assertProductModalDisplayed() {
        Assert.assertTrue(this.isProductModalDisplayed(), "\n ❌ Product modal did not appear! \n");
    }

    public void assertProductTitleVisible() {
        Assert.assertTrue(this.isProductTitleVisible(), "\n ❌ Product title is missing! \n");
    }

    public void assertProductPriceVisible() {
        Assert.assertTrue(this.isProductPriceVisible(), "\n ❌ Product price is missing! \n");
    }

    public void assertCustomerReviewsDisplayed() {
        Assert.assertTrue(this.isCustomerReviewsDisplayed(), "\n ❌ Customer reviews section is missing! \n");
    }

    public void assertFooterLinksWorking() {
        Assert.assertTrue(this.areFooterLinksWorking(), "\n ❌ Footer links are not working! \n");
    }
}
