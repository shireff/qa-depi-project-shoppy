package com.shoppy.com.pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

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

    @Step("Check Products Page Url")
    public AdminProductsPage checkProductsPageUrl() {
        driver.validations().validateEquals(driver.browser().getCurrentURL(driver.get()), URL, "❌ Product Page URL Is Not Correct!");
        return this;
    }

    @Step("Check Add Product Btn Is Displayed")
    public AdminProductsPage checkAddProductBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(addProductBtn, "❌ addProductBtn is not displayed!");
        return this;
    }


    @Step("Check Add Product Btn Text")
    public AdminProductsPage checkAddProductBtnText() {
        driver.assertion().assertElementTextContains(addProductBtn, "Add Product", "❌ addProductBtn is not correct!");
        return this;
    }

    @Step("Check Products Are Displayed")
    public AdminProductsPage checkProductsAreDisplayed() {
        driver.assertion().assertElementDisplayed(firstProduct, "❌ firstProduct is not displayed!");
        return this;
    }

    @Step("Check Product Card Is Displayed")
    public AdminProductsPage checkProductCardIsDisplayed() {
        driver.assertion().assertElementDisplayed(card, "❌ card is not displayed!");
        return this;
    }

    @Step("Check Product Card Image Is Displayed")
    public AdminProductsPage checkProductCardImageIsDisplayed() {
        driver.assertion().assertElementDisplayed(cardImage, "❌ cardImage is not displayed!");
        return this;
    }

    @Step("Check Product Card Title Is Displayed")
    public AdminProductsPage checkProductCardTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(cardTitle, "❌ cardTitle is not displayed!");
        return this;
    }

    @Step("Check Product Card Price Is Displayed")
    public AdminProductsPage checkProductCardPriceIsDisplayed() {
        driver.assertion().assertElementDisplayed(cardPrice, "❌ cardPrice is not displayed!");
        return this;
    }

    @Step("Check Product Card Edit Btn Is Displayed")
    public AdminProductsPage checkProductCardEditBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(cardEditBtn, "❌ cardEditBtn is not displayed!");
        return this;
    }

    @Step("Check Product Card Delete Btn Is Displayed")
    public AdminProductsPage checkProductCardDeleteBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(cardDeleteBtn, "❌ cardDeleteBtn is not displayed!");
        return this;
    }

    @Step("Click On Add Product Btn")
    public AdminAddProductPage clickOnAddProductBtn() {
        driver.element().click(addProductBtn);
        return new AdminAddProductPage(driver);
    }
}
