package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminProductsPage {
    private final Driver driver;
    private final String cardXpath = "//div[@class=\"grid gap-4 md:grid-cols-3 ls:grid-cols-4\"]/div";
    private final String URL = "https://shoppy-ochre.vercel.app/admin/products";

    private final By firstProduct = By.xpath(cardXpath);
    private final By addProductBtn = By.xpath("//main/div/button");

    // Card Components

    private final By card = By.xpath(cardXpath + "[1]/div");
    private final By cardImage = By.xpath(cardXpath + "[1]/div/div/img");
    private final By cardTitle = By.xpath(cardXpath + "[1]/div/div/h2");
    private final By cardPrice = By.xpath(cardXpath + "[1]/div/div/div/span[1]");
    private final By cardEditBtn = By.xpath(cardXpath + "[1]/div/div[3]/button[contains(text(),\"Edit\")]");
    private final By cardDeleteBtn = By.xpath(cardXpath + "[1]/div/div[3]/button[contains(text(),\"Delete\")]");

    public AdminProductsPage(Driver driver) {
        this.driver = driver;
    }

    public AdminProductsPage checkProductsPageUrl() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
//        driver.assertion().assertElementTextEquals()
        return this;
    }

    public AdminProductsPage checkAddProductBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductBtn));
        driver.assertion().assertElementDisplayed(addProductBtn, "❌ addProductBtn is not displayed!");
        return this;
    }

    public AdminProductsPage checkAddProductBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), addProductBtn).contains("Add Product"));
        driver.assertion().assertElementTextContains(addProductBtn,"Add Product","❌ addProductBtn is not correct!");
        return this;
    }

    public AdminProductsPage checkProductsAreDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), firstProduct));
        driver.assertion().assertElementDisplayed(firstProduct, "❌ firstProduct is not displayed!");
        return this;
    }

    public AdminProductsPage checkProductCardIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), card));
        driver.assertion().assertElementDisplayed(card, "❌ card is not displayed!");

        return this;
    }

    public AdminProductsPage checkProductCardImageIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardImage));
        driver.assertion().assertElementDisplayed(cardImage, "❌ cardImage is not displayed!");

        return this;
    }

    public AdminProductsPage checkProductCardTitleIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardTitle));
        driver.assertion().assertElementDisplayed(cardTitle, "❌ cardTitle is not displayed!");

        return this;
    }

    public AdminProductsPage checkProductCardPriceIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardPrice));
        driver.assertion().assertElementDisplayed(cardPrice, "❌ cardPrice is not displayed!");

        return this;
    }

    public AdminProductsPage checkProductCardEditBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardEditBtn));
        driver.assertion().assertElementDisplayed(cardEditBtn, "❌ cardEditBtn is not displayed!");

        return this;
    }

    public AdminProductsPage checkProductCardDeleteBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardDeleteBtn));
//        assertElementDisplayed(cardDeleteBtn, "❌ cardDeleteBtn is not displayed!");
        driver.assertion().assertElementDisplayed(cardDeleteBtn, "❌ cardDeleteBtn is not displayed!");
        return this;
    }

    public AdminAddProductPage clickOnAddProductBtn() {
        driver.element().click(addProductBtn);
        return new AdminAddProductPage(driver);
    }

//    private void assertElementDisplayed(By locator, String errorMessage) {
//        WebElement element = Waits.waitForElementVisible(driver.get(), locator);
//        if (element == null || !element.isDisplayed()) {
//            throw new AssertionError(errorMessage);
//        }
//    }
}
