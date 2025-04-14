package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CartPage {
    private final Driver driver;

    private final By addToCartButton = By.xpath("//div[7]//button");
    private final By ProductsName = By.xpath("//div[7]//h2");
    private final By productSuccessfullyAddedToCartMessage = By.xpath("//li/div/div[contains(text(),'Product added to cart successfully!')]");
    //private final By productSuccessfullyAddedToCartMessage = By.xpath("//div[@class=\"text-sm font-semibold\" and text()=\"Product added to cart successfully!\"]");
    private final By cartIcon = By.xpath("(//div//div/div/button)[1]");
    private final By productImage = By.xpath("//div[@role=\"dialog\"]//img");
    private final By productPriceInCart = By.xpath("//div[@role=\"dialog\"]//p");
    private final By productQuantityInCart = By.xpath("(//div[@role=\"dialog\"]//span)[1]");
    private final By productTotalInCart = By.xpath("(//div[@role=\"dialog\"]//span)[1]");
    private final By productcart = By.xpath("(//div[@role=\"dialog\"]//h3)[1]");
    private final By deleteIcon = By.xpath("//div[@class='flex flex-col items-center sm:items-end']/*[2]");
    //private final By deleteIcon = By.xpath("//*[@id=\"radix-:rb:\"]/div[2]/div/div[2]");
    private final By cartEmptyMessage = By.xpath("//div[@role=\"dialog\"]//p[contains(text(),'Your cart is empty')]");
    private final By cartDeletedMessage = By.xpath("//li/div/div");
    private final By closeIcon = By.xpath("(//div[@role=\"dialog\"]/button)[2]");
    private final By yourCartMessage = By.xpath("//div[@role=\"dialog\"]/div/h2");
    private final By productQuantityPlusIcon = By.xpath("(//div[@role=\"dialog\"]//button[2])[1]");
    private final By productQuantityMinusIcon = By.xpath("(//div[@role=\"dialog\"]//button[1])[1]");
    private final By cartUpdatedSuccessfullyMessage = By.xpath("//li/div/div[contains(text(),'Card item updated successfully')]");
    private final By checkoutButton = By.xpath("(//div[@role=\"dialog\"]/button)[1]");
    private final By cartOpen = By.xpath("//div[@role=\"dialog\"]");
    private final By cartNumber = By.xpath("(//div//div/div/span)[1]");


    String ProductsSectionName = "Nike Precision ...";
    String productSuccessfullyAddedToCartTitle = "Product added to cart successfully!";
    String CartEmptyMessageTitle = "Your cart is empty";
    String cartDeletedMessageTitle = "Card item deleted successfully";
    String yourCartTitle = "Your Cart";
    String cartUpdatedSuccessfullyMessageTitle = "Card item updated successfully";


    public CartPage(Driver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/
    public CartPage checkThatTheProductNameIsDisable() {
        Assert.assertEquals(driver.element().getTextOf(ProductsName), ProductsSectionName);
        //Assert.assertEquals(driver.element().getTextOf(ProductsName), ProductsSectionName);
        return this;
    }

    public CartPage checkThatTheProductMessageAddedSuccesfullyIsDisable() {
        Assert.assertEquals(driver.element().getTextOf(productSuccessfullyAddedToCartMessage), productSuccessfullyAddedToCartTitle);
        return this;
    }

    public CartPage checkThatTheNumberOnCartIsDisable() {
        Assert.assertTrue(driver.get().findElement(cartNumber).isDisplayed());
        System.out.println("The Product Number On Cart is: " + driver.get().findElement(cartNumber).getText());
        return this;
    }

    public CartPage checkThatTheProductNameInCartIsDisable() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productcart));
        System.out.println("Name is: " + productElement.getText());

        WebElement productElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceInCart));
        System.out.println("Price is: " + productElement2.getText());

        WebElement productElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity is: " + productElement3.getText());

        WebElement productElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(productTotalInCart));
        System.out.println("Total is: " + productElement4.getText());

        Assert.assertTrue(driver.get().findElement(productcart).isDisplayed());

        return this;
    }

    public CartPage checkThatTheProductImageIsDisable() {
        Assert.assertTrue(driver.get().findElement(productImage).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductImageSrcIsDisable() {
        Assert.assertEquals(driver.get().findElement(productImage).getAttribute("src"), "http://res.cloudinary.com/dhz0pkov6/image/upload/v1735932881/ecommerce/ubbmqjalem2fi0wmyvbt.png");
        return this;
    }

    public CartPage checkThatTheProductPriceIsDisable() {
        Assert.assertTrue(driver.get().findElement(productPriceInCart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductQuantityIsDisable() {
        Assert.assertTrue(driver.get().findElement(productQuantityInCart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductTotalIsDisable() {
        Assert.assertTrue(driver.get().findElement(productTotalInCart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductIsDeletedFromCart() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        WebElement productElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(cartEmptyMessage));
        System.out.println("Card Empty message is: " + productElement5.getText());

        Assert.assertEquals(driver.element().getTextOf(cartEmptyMessage), CartEmptyMessageTitle);
        return this;
    }

    public CartPage checkThatTheProductMessageDeletedSuccesfullyIsDisable() {
        Assert.assertEquals(driver.element().getTextOf(cartDeletedMessage), cartDeletedMessageTitle);
        return this;
    }

    public CartPage checkThatTheCartIsClosedAfterClickingOnCloseIcon() {
    WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
    boolean isCartGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(yourCartMessage));

    Assert.assertTrue(isCartGone, "❌ yourCartMessage is still visible or didn't disappear.");
    return this;
}

    public CartPage checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity() {
        WebDriverWait wait2 = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement productElement5 = wait2.until(ExpectedConditions.visibilityOfElementLocated(productcart));

        WebElement productElement6 = wait2.until(ExpectedConditions.visibilityOfElementLocated(productPriceInCart));
        System.out.println("Price After Update is: " + productElement6.getText());

        WebElement productElement7 = wait2.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity After Update is: " + productElement7.getText());

        WebElement productElement8 = wait2.until(ExpectedConditions.visibilityOfElementLocated(productTotalInCart));
        System.out.println("Total After Update is: " + productElement8.getText());

        Assert.assertTrue(driver.get().findElement(productcart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProducDataIsUpdatedWhenDecreasingTheQuantity() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(productQuantityInCart, "1")); // افتراضًا إنك بتقلل للـ 1

        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceInCart));
        System.out.println("Price After Update is: " + productPrice.getText()); // ✅ تمت الإضافة هنا

        WebElement productQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity After Update is: " + productQuantity.getText());

        WebElement productTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(productTotalInCart));
        System.out.println("Total After Update is: " + productTotal.getText());

        Assert.assertTrue(driver.get().findElement(productcart).isDisplayed());
        return this;
    }

    public CartPage checkThatTheProductMessageUpdatedSuccesfullyIsDisable() {
        Assert.assertEquals(driver.element().getTextOf(cartUpdatedSuccessfullyMessage), cartUpdatedSuccessfullyMessageTitle);
        return this;
    }

    public CartPage checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne() {
        WebDriverWait wait4 = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        WebElement productElement13 = wait4.until(ExpectedConditions.visibilityOfElementLocated(productcart));

        WebElement productElement14 = wait4.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));
        System.out.println("Quantity is: " + productElement14.getText());

        Assert.assertEquals(productElement14.getText(),"1");
        Assert.assertFalse(driver.get().findElement(productQuantityMinusIcon).isEnabled());
        System.out.println("Minus Icon is disapled");
        return this;

    }

    public CartPage checkThatTheCheckoutButtonIsClickable() {
        Assert.assertTrue(driver.element().isClickable(checkoutButton));
        return this;
    }

    public CartPage checkThatTheCartIsDisplayed() {
        Assert.assertTrue(driver.get().findElement(cartOpen).isDisplayed());
        return this;
    }

    /************************************** Actions ********************************************/
   public CartPage clickOnAddToCartButton()  {
     driver.element().click(addToCartButton);
     return this;
   }

    public CartPage clickOnCartIcon(){
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(cartIcon);
        return this;
    }

    public CartPage clickOnDeleteIcon()  {
        driver.element().click(deleteIcon);
        return this;
    }

    public CartPage clickOnCloseIcon()  {
        driver.element().click(closeIcon);
        return this;
    }

    public CartPage clickOnQuantityPlusIcon()  {
        driver.element().click(productQuantityPlusIcon);
        return this;
    }

    public CartPage clickOnQuantityMinusIcon()  {
        driver.element().click(productQuantityMinusIcon);
        return this;
    }

    public CheckoutPageUser clickOnCheckoutButton()  {
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(checkoutButton);
        return new CheckoutPageUser(driver);

    }



}


