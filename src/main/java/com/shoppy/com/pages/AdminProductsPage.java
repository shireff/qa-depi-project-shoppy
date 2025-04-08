package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
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
        return this;
    }

    public AdminProductsPage checkAddProductBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductBtn));
        return this;
    }

    public AdminProductsPage checkAddProductBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addProductBtn).contains("Add Product"));
        return this;
    }

    public AdminProductsPage checkProductsAreDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), firstProduct));
        return this;
    }

    public AdminProductsPage checkProductCardIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), card));
        return this;
    }

    public AdminProductsPage checkProductCardImageIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardImage));
        return this;
    }

    public AdminProductsPage checkProductCardTitleIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardTitle));
        return this;
    }

    public AdminProductsPage checkProductCardPriceIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardPrice));
        return this;
    }

    public AdminProductsPage checkProductCardEditBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardEditBtn));
        return this;
    }

    public AdminProductsPage checkProductCardDeleteBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), cardDeleteBtn));
        return this;
    }
    public AdminAddProductPage clickOnAddProductBtn()
    {
        ElementActions.click(driver.get(),addProductBtn);
        return new AdminAddProductPage(driver);
    }

}
