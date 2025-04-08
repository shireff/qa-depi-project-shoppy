package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    private Driver driver;

    By addToCartButton = By.xpath("(//div[@class=\"flex items-center p-6 pt-0\"])[3]");
    By ProductsName = By.xpath("//h2[@class=\"text-xl font-bold mb-2\" and text()= \"test\"]");
    By productSuccessfullyAddedToCartMessage = By.xpath("//div[@class=\"text-sm font-semibold\" and text()=\"Product added to cart successfully!\"]");
    By cartIcon = By.xpath("//div[@class=\"relative\"]");
    By productImage = By.xpath("//img[@class=\"w-16 h-16 sm:w-20 sm:h-20 object-cover rounded\"]");
    By productPriceInCart =  By.xpath("//p[@class=\"font-semibold text-sm sm:text-base\"]");
    By productQuantityInCart = By.xpath("//span[@class=\"font-semibold text-sm\"]");
    By productcart = By.xpath("(//h3[@class=\"font-extrabold text-sm sm:text-base\"])[1]");
    By deleteIcon = By.cssSelector("svg[class=\"lucide lucide-trash cursor-pointer mt-1 text-red-500\"]");
    By cartEmptyMessage = By.cssSelector("div[class=\"mt-8 space-y-4\"] p");

    String ProductsSectionName = "test";
    String productNameInCartTitle = "test";
    String productSuccessfullyAddedToCartTitle= "Product added to cart successfully!";
    String ProductPrice= "$10.00";
    String CartEmptyMessageTitle = "Your cart is empty";


    public CartPage(Driver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/
    public CartPage checkThatTheProductNameIsDisable(){
        Assert.assertEquals(driver.element().getTextOf(ProductsName),ProductsSectionName);
        return this;
    }

    public CartPage checkThatTheProductMessageAddedSuccesfullyIsDisable(){
        Assert.assertEquals(driver.element().getTextOf(productSuccessfullyAddedToCartMessage),productSuccessfullyAddedToCartTitle);
        return this;
    }

    public CartPage checkThatTheProductNameInCartIsDisable(){
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productcart));
        System.out.println("Name is: " + productElement.getText());

        WebElement productElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceInCart));
        System.out.println("Price is: " + productElement2.getText());

        WebElement productElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity is: " + productElement3.getText());

        Assert.assertEquals(productElement.getText(), productNameInCartTitle);

        return this;
    }


    public CartPage checkThatTheProductImageIsDisable(){
        Assert.assertTrue(driver.get().findElement(productImage).isEnabled());
        return this;
    }


    public CartPage checkThatTheProductPriceIsDisable(){
        Assert.assertEquals(driver.element().getTextOf(productPriceInCart),ProductPrice);
        return this;
    }


    public CartPage checkThatTheProductQuantityIsDisable(){
        Assert.assertEquals(driver.element().getTextOf(productQuantityInCart),"1");
        return this;
    }

    public CartPage checkThatTheProductIsDeletedFromCart(){
        Assert.assertEquals(driver.element().getTextOf(cartEmptyMessage),CartEmptyMessageTitle);
        return this;
    }

    /************************************** Actions ********************************************/
   public CartPage clickOnAddToCartButton()  {
     driver.element().click(addToCartButton);
     return this;
   }

    public CartPage clickOnCartIcon(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(cartIcon);
        return this;
    }


    public CartPage clickOnDeleteIcon()  {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(deleteIcon);
        return this;
    }

}

