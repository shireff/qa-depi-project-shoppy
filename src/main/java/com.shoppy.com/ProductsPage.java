package com.shoppy.com;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    private By productsHeader = By.xpath("//span[text()='Shoppy']");

    public  boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }
}
