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

    private final By addToCartButton = By.xpath("(//div[@class=\"flex items-center p-6 pt-0\"])[7]");
    private final By ProductsName = By.xpath("//h2[@class=\"text-xl font-bold mb-2\" and text()= \"Nike Precision ...\"]");
    private final By productSuccessfullyAddedToCartMessage = By.xpath("//div[@class=\"text-sm font-semibold\" and text()=\"Product added to cart successfully!\"]");
    private final By cartIcon = By.xpath("//div[@class=\"relative\"]");
    private final By productImage = By.xpath("//img[@class=\"w-16 h-16 sm:w-20 sm:h-20 object-cover rounded\"]");
    private final By productPriceInCart = By.xpath("//p[@class=\"font-semibold text-sm sm:text-base\"]");
    private final By productQuantityInCart = By.xpath("//span[@class=\"font-semibold text-sm\"]");
    private final By productTotalInCart = By.xpath("(//div[@class='flex justify-between']//span[@class='font-bold'])[2]");
    private final By productcart = By.xpath("(//h3[@class=\"font-extrabold text-sm sm:text-base\"])[1]");
    private final By deleteIcon = By.cssSelector("svg[class=\"lucide lucide-trash cursor-pointer mt-1 text-red-500\"]");
    private final By cartEmptyMessage = By.xpath("//div[@class='mt-8 space-y-4']//p[text()='Your cart is empty']");
    private final By cartDeletedMessage = By.xpath("//div[@class=\"text-sm font-semibold\"]");
    private final By closeIcon = By.xpath("//button[@class=\"absolute right-4 top-4 rounded-sm opacity-70 ring-offset-background transition-opacity hover:opacity-100 focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2 disabled:pointer-events-none data-[state=open]:bg-secondary\"]");
    private final By yourCartMessage = By.xpath("//h2[@id=\"radix-:r4:\"]");
    private final By productQuantityPlusIcon = By.xpath("//div[@class='flex justify-center sm:justify-start items-center mt-1 gap-2']//button[2]");
    private final By productQuantityMinusIcon = By.xpath("//div[@class='flex justify-center sm:justify-start items-center mt-1 gap-2']//button[1]");
    private final By cartUpdatedSuccessfullyMessage = By.xpath("//div[@class=\"text-sm font-semibold\" and text()= \"Card item updated successfully\"]");
    private final By checkoutButton = By.xpath("//button[text()='Checkout']");
    private final By cartNumber = By.xpath("//span[@class=\"absolute -top-1 -right-1 flex h-4 w-4 items-center justify-center rounded-full bg-red-500 text-white text-xs font-bold\"]");


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
      //  Assert.assertEquals(driver.get().findElement(productImage).getAttribute("src"), "http://res.cloudinary.com/dhz0pkov6/image/upload/v1734705102/ecommerce/rshhdelbx0midngaglbi.jpg");
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

        // Assert.assertTrue(driver.get().findElement(cartEmptyMessage).isDisplayed());
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
        Assert.assertFalse(driver.element().isClickable(checkoutButton));
        return this;

    }

    public CartPage checkThatTheUrlChangedToTheCheckoutPage() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), "https://shoppy-ochre.vercel.app/shop/checkout");
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
//        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.element().click(deleteIcon);
        return this;
    }

    public CartPage clickOnCloseIcon()  {
//        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.element().click(closeIcon);
        return this;
    }

    public CartPage clickOnQuantityPlusIcon()  {
//        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.element().click(productQuantityPlusIcon);
        return this;
    }

    public CartPage clickOnQuantityMinusIcon()  {
//        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.element().click(productQuantityMinusIcon);
        return this;
    }

    public CartPage clickOnCheckoutButton()  {
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(checkoutButton);
        return this;
    }



}


