package com.shoppy.com;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends BasePage {
    private By homePageHeader = By.xpath("//span[text()='Shoppy']");
    private By categoryButtons = By.cssSelector(".grid.grid-cols-2 div.rounded-lg span.font-bold");
    private By brandSectionHeader = By.xpath("//h2[contains(text(), 'Shop by Brand')]");
    private By brandButtons = By.xpath("//h2[contains(text(), 'Shop by Brand')]/following-sibling::div//span[contains(@class, 'font-bold')]");
    private By featuredProductsSection = By.xpath("//h2[contains(text(), 'Feature products')]");
    private By featuredProductImages = By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm img");
    private By featuredProducts = By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm");
    private By productModal = By.cssSelector("div[role='dialog']");
    private By productTitle = By.cssSelector(".text-xl.sm\\:text-2xl.font-bold");
    private By productPrice = By.cssSelector(".text-xl.font-bold.text-primary");
    private By customerReviews = By.cssSelector(".grid > div.rounded-lg.border");
    private By noProductsMessage = By.xpath("//h2[text()='No Products Found']");
    private By footerLinks = By.cssSelector("footer a");

    public boolean isHomePageHeaderDisplayed() {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))  // Maximum wait time
                    .pollingEvery(Duration.ofSeconds(1))  // Check every second
                    .ignoring(NoSuchElementException.class); // Ignore if not found initially

            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageHeader));
            return headerElement.isDisplayed();
        } catch (Exception e) {
            return false;  // Handle timeout case gracefully
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
        throw new RuntimeException("❌ Category '" + category + "' not found!");
    }

    public void selectBrand(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement brandSection = wait.until(ExpectedConditions.presenceOfElementLocated(brandSectionHeader));
        List<WebElement> brands = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandButtons));

        for (WebElement brd : brands) {
            String brandText = brd.getText().trim();
            if (brandText.equalsIgnoreCase(brand)) {
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", brd);
                js.executeScript("arguments[0].click();", brd);
                String encodedBrand = brand.toLowerCase().replace("'s", "").replace("&", "%26");
                wait.until(ExpectedConditions.urlContains("brand=" + encodedBrand));
                System.out.println("✅ Brand '" + brand + "' selected successfully.");
                return;
            }
        }
        throw new RuntimeException("❌ Brand '" + brand + "' not found!");
    }

    public void clickFirstFeaturedProduct() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement featureSection = wait.until(ExpectedConditions.presenceOfElementLocated(featuredProductsSection));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", featureSection);
        System.out.println("✅ Scrolled to 'Feature products' section.");

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(featuredProductImages));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstProduct);
        Thread.sleep(500);
        firstProduct.click();
        System.out.println("✅ Clicked on the first featured product.");
    }

    public boolean isFeaturedProductDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(featuredProducts));
        return !products.isEmpty();
    }

    public boolean isProductTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
            return title.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isProductPriceVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
            return price.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isProductModalDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int attempts = 3;
        for (int i = 0; i < attempts; i++) {
            try {
                WebElement modal = wait.until(ExpectedConditions.presenceOfElementLocated(productModal));
                wait.until(ExpectedConditions.visibilityOf(modal));
                return modal.isDisplayed();
            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ Stale Element! Retrying... Attempt: " + (i + 1));
            } catch (TimeoutException e) {
                return false;
            }
        }
        return false;
    }

    public boolean isNoProductsMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement noProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(noProductsMessage));
            return noProducts.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isCustomerReviewsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> reviews = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(customerReviews));
        return !reviews.isEmpty();
    }

    public boolean areFooterLinksWorking() {
        List<WebElement> links = driver.findElements(footerLinks);
        for (WebElement link : links) {
            if (!link.isDisplayed() || !link.isEnabled()) {
                return false;
            }
        }
        return true;
    }
}
