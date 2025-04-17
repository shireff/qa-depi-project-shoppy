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
    private final By featuredProductImages = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/section[5]/div/div/div[1]/div/div[1]/img");
    private final By brandButtons = By.xpath("//h2[contains(text(), 'Shop by Brand')]/following-sibling::div//span[contains(@class, 'font-bold')]");
    private final By featuredProducts = By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm");
    private final By productModal = By.cssSelector("div[role='dialog']");
    private final By customerReviews = By.cssSelector(".grid > div.rounded-lg.border");
    private final By noProductsMessage = By.xpath("//h2[text()='No Products Found']");
    private final By footerLinks = By.cssSelector("footer a");
    private final By userHeader = By.xpath("//span[text()='Shoppy']");
    private final By clickOnAddToCardFirstProduct = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/section[5]/div/div/div[1]/div/div[3]/button");
    private final String url ="https://shoppy-ochre.vercel.app/shop/home";
    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /***************************************** Validation Methods  ******************************************/

    @Step("Select category")
    public HomePage selectCategory(String category) {
        try {
            driver.element().selectItem(categoryButtons, category, "category");
        } catch (Exception e) {
            driver.validations().validateFail("\n ❌ Failed to select category '" + category + "': " + e.getMessage() + "\n");
        }
        return this;
    }

    @Step("Select brand")
    public HomePage selectBrand(String brand) {
        try {
            driver.element().selectItem(brandButtons, brand, "brand");
        } catch (Exception e) {
            driver.validations().validateFail("\n ❌ Failed to select brand '" + brand + "': " + e.getMessage() + "\n");
        }
        return this;
    }

    @Step("Click the first featured product")
    public HomePage clickFirstFeaturedProduct() {
        try {
            driver.element().scrollToElement(featuredProductsSection);
            driver.element().click(featuredProductImages);
        } catch (Exception e) {
            driver.validations().validateFail("\n ❌ Failed to click first featured product: " + e.getMessage() + "\n");
        }
        return this;
    }

    @Step("Click on the add to card on first featured product")
    public CartPage clickAddToCardFirstFeaturedProduct() {
        try {
            driver.element().scrollToElement(featuredProductsSection);
            driver.element().click(clickOnAddToCardFirstProduct);
        } catch (Exception e) {
            driver.validations().validateFail("\n ❌ Failed to click first featured product: " + e.getMessage() + "\n");
        }
        return new CartPage(driver);
    }


    /***************************************** Assertions  ******************************************/
    @Step("Assert login successful as user")
    public HomePage assertLoginSuccessfulAsUser() {
        driver.assertion().assertElementDisplayed(userHeader, "❌ User login failed!");
        String expectedUserURL = "https://shoppy-ochre.vercel.app/shop/home";
        String actualURL = driver.get().getCurrentUrl();
        driver.validations().validateEquals(actualURL, expectedUserURL, "User URL mismatch!");
        return this;
    }
    public HomePage checkHomePageUrl()
    {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()),url);
        return this;
    }


    @Step("Validate product visibility for hasProducts: {0}")
    public HomePage validateProductVisibility(boolean hasProducts, String errorMessage) {
        if (hasProducts) {
            driver.assertion().assertElementDisplayed(featuredProducts, "\n ❌ " + errorMessage + " \n");
        } else {
            driver.assertion().assertElementDisplayed(noProductsMessage, "\n ❌ " + errorMessage + " \n");
        }
        return this;
    }

    @Step("Assert home page header is displayed")
    public HomePage assertHomePageHeaderDisplayed() {
        driver.assertion().assertElementDisplayed(homePageHeader, "\n ❌ Home page header is not displayed! \n");
        return this;
    }

    @Step("Assert featured products are displayed")
    public HomePage assertFeatureProductsDisplayed() {
        driver.assertion().assertElementDisplayed(featuredProducts, "\n ❌ Featured products are not displayed! \n");
        return this;
    }

    @Step("Assert product modal is displayed")
    public HomePage assertProductModalDisplayed() {
        driver.assertion().assertElementDisplayed(productModal, "\n ❌ Product modal did not appear! \n");
        return this;
    }

    @Step("Assert customer reviews are displayed")
    public HomePage assertCustomerReviewsDisplayed() {
        driver.assertion().assertElementDisplayed(customerReviews, "\n ❌ Customer reviews section is missing! \n");
        return this;
    }

    @Step("Assert footer links are working")
    public HomePage assertFooterLinksWorking() {
        List<WebElement> links = driver.get().findElements(footerLinks);
        driver.validations().validateTrue(links.stream().allMatch(WebElement::isDisplayed), "\n ❌ Footer links are not working! \n");
        return this;
    }
}
