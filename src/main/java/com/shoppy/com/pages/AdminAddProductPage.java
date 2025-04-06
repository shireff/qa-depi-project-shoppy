package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminAddProductPage {

    private final Driver driver;

    private final By addProductForm = By.xpath("//div[@role=\"dialog\"]");
    private final By addProductFormTitle = By.xpath("//div[@role=\"dialog\"]/div/h2");

    //    form elements
    // *************** Labels ************* //
    private final By uploadImageLabel = By.xpath("//div[@role=\"dialog\"]/div[2]/label");
    private final By uploadImageFieldLabel = By.xpath("//label[@for=\"image-upload\"]");
    private final By titleLabel = By.xpath("//label[@for=\"title\"]");
    private final By descriptionLabel = By.xpath("//label[@for=\"description\"]");
    private final By categoryLabel = By.xpath("//label[@for=\"category\"]");
    private final By brandLabel = By.xpath("//label[@for=\"brand\"]");
    private final By priceLabel = By.xpath("//label[@for=\"price\"]");
    private final By salePriceLabel = By.xpath("//label[@for=\"salePrice\"]");
    private final By totalStockLabel = By.xpath("//label[@for=\"totalStock\"]");

    // *************** Fields ************* //
    private final By uploadImageField = By.id("image-upload");
    private final By titleField = By.id("title");
    private final By descriptionField = By.id("description");
    // category
    private final By categoryBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/button");
    private final By categorySelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select");
    // options????????????

    // brand
    private final By brandBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/button");
    private final By brandSelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select");
    private final By priceField = By.id("price");
    private final By salePriceField = By.id("salePrice");
    private final By totalStockField = By.id("totalStock");

    private final By closeAddProductFormBtn = By.xpath("//div[@role=\"dialog\"]/button");
    private final By addBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/button");

    public AdminAddProductPage(Driver driver) {
        this.driver = driver;
    }

    public AdminAddProductPage checkAddProductFormIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductForm));
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductFormTitle));
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addProductFormTitle).contains("Add New Product"));
        return this;
    }
}
