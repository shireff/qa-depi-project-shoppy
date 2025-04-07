package com.shoppy.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;


    By addToCartButton = By.xpath("(//div[@class=\"flex items-center p-6 pt-0\"])[3]");
    By ProductsName = By.xpath("//h2[@class=\"text-xl font-bold mb-2\" and text()= \"test\"]");
    By productSuccessfullyAddedToCartMessage = By.xpath("//div[@class=\"text-sm font-semibold\" and text()=\"Product added to cart successfully!\"]");
    By cartIcon = By.xpath("//div[@class=\"relative\"]");
    By productImage = By.xpath("//img[@class=\"w-16 h-16 sm:w-20 sm:h-20 object-cover rounded\"]");
    By productPriceInCart = By.xpath("//p[@class=\"font-semibold text-sm sm:text-base\"]");
    By productQuantityInCart = By.xpath("//span[@class=\"font-semibold text-sm\"]");
    By productcart = By.xpath("(//h3[@class=\"font-extrabold text-sm sm:text-base\"])[1]");
    By Total = By.xpath("//span[@class='font-bold' and contains(text(), '$')]");
    //By deleteIcon = By.cssSelector("svg[class=\"lucide lucide-trash cursor-pointer mt-1 text-red-500\"]");
    //By cartEmptyMessage = By.cssSelector("div[class=\"mt-8 space-y-4\"] p");
    By closeIcon = By.cssSelector("svg[class=\"lucide lucide-x h-4 w-4\"]");
    By counter = By.cssSelector("svg.lucide.lucide-plus");
    By cartItemUpdatedSuccessfullyMessage = By.xpath("//li[@class=\"group pointer-events-auto relative flex w-full items-center justify-between space-x-4 overflow-hidden rounded-md p-6 pr-8 shadow-lg transition-all data-[swipe=cancel]:translate-x-0 data-[swipe=end]:translate-x-[var(--radix-toast-swipe-end-x)] data-[swipe=move]:translate-x-[var(--radix-toast-swipe-move-x)] data-[swipe=move]:transition-none data-[state=open]:animate-in data-[state=closed]:animate-out data-[swipe=end]:animate-out data-[state=closed]:fade-out-80 data-[state=closed]:slide-out-to-right-full data-[state=open]:slide-in-from-top-full data-[state=open]:sm:slide-in-from-bottom-full border border-green bg-background text-foreground\"]");


    String ProductsSectionName = "test";
    String productNameInCartTitle = "test";
    String productSuccessfullyAddedToCartTitle = "Product added to cart successfully!";
    String cartItemUpdatedSuccessfullyTitle ="Card item updated successfully";
   // String CartEmptyMessageTitle = "Your cart is empty";


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/
    public CartPage checkThatTheProductNameIsDisable() {
        Assert.assertEquals(driver.findElement(ProductsName).getText(), ProductsSectionName);
        return this;
    }

    public CartPage checkThatTheProductMessageAddedSuccesfullyIsDisable() {
        Assert.assertEquals(driver.findElement(productSuccessfullyAddedToCartMessage).getText(), productSuccessfullyAddedToCartTitle);
        return this;
    }

    public CartPage checkThatTheProductNameInCartIsDisable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productcart));
        System.out.println("Name is: " + productElement.getText());

        WebElement productElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceInCart));
        System.out.println("Price is: " + productElement2.getText());

        WebElement productElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity is: " + productElement3.getText());

        WebElement productElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(Total));
        System.out.println("Total is: " + productElement4.getText());

        Assert.assertEquals(productElement.getText(), productNameInCartTitle);

        return this;
    }

    public CartPage checkThatTheProductImageIsDisable() {
        Assert.assertTrue(driver.findElement(productImage).isEnabled());
        return this;
    }

    public CartPage checkThatTheProductPriceIsDisable() {
        Assert.assertTrue(driver.findElement(productPriceInCart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductQuantityIsDisable() {
        Assert.assertTrue(driver.findElement(productQuantityInCart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheTotalIsDisable() {
        Assert.assertTrue(driver.findElement(Total).isDisplayed());
        return this;
    }

    public CartPage checkThatTheCartItemMessageUpdatedSuccesfullyIsDisable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement productElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemUpdatedSuccessfullyMessage));
        Assert.assertEquals(driver.findElement(cartItemUpdatedSuccessfullyMessage).getText(), cartItemUpdatedSuccessfullyTitle);
        return this;
    }
/*
    public CartPage checkThatTheProductIsDeletedFromCart() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(cartEmptyMessage).getText(), CartEmptyMessageTitle);
        return this;
    }
*/
    public CartPage checkThatTheCartIsClosedAfterClickingOnCloseIcon() {
        Assert.assertTrue(driver.findElement(cartIcon).isDisplayed());
        return this;
    }

    /************************************** Actions ********************************************/
    public CartPage clickOnAddToCartButton() throws InterruptedException {
        driver.findElement(addToCartButton).click();
        Thread.sleep(100);
        return this;
    }

    public CartPage clickOnCartIcon() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(cartIcon).click();
        return this;
    }

    public CartPage clickOnCounterIcon() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(counter).click();
        return this;
    }
/*
    public CartPage clickOnDeleteIcon() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(deleteIcon).click();
        return this;
    }
*/
    public CartPage clickOnCloseIcon() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(closeIcon).click();
        return this;
    }



}

