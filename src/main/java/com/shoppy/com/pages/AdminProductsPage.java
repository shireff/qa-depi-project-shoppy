package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminProductsPage {
    private final Driver driver;
    private final By allProducts = By.xpath("//div[@class=\"grid gap-4 md:grid-cols-3 ls:grid-cols-4\"]/div");
    private final By addProductBtn = By.xpath("//main/div/button");
    private final String URL = "https://shoppy-ochre.vercel.app/admin/products";

    public AdminProductsPage(Driver driver) {
        this.driver = driver;
    }

    public AdminProductsPage checkProductsPageUrl() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }
    public AdminProductsPage checkAddProductBtnIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductBtn));
        return this;
    }
    public AdminProductsPage checkAddProductBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addProductBtn).contains("Add Product"));
        return this;
    }
    public AdminProductsPage checkAllProductsAreDisplayed()
    {
        ElementActions.find(driver.get(),allProducts);
        return this;
    }

}
