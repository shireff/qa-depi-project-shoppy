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
        driver.validations().validateEquals(driver.element().getTextOf(ProductsName), ProductsSectionName,
                "Product name in the section should be the same as the expected one");
        return this;
    }

    public CartPage checkThatTheProductMessageAddedSuccesfullyIsDisable() {
        driver.validations().validateEquals(
                driver.element().getTextOf(productSuccessfullyAddedToCartMessage),
                productSuccessfullyAddedToCartTitle,
                "Ensure that the 'Product Added Successfully' message appears and matches the expected text."
        );
        return this;
    }


    public CartPage checkThatTheNumberOnCartIsDisable() {
        driver.validations().validateTrue(
                driver.get().findElement(cartNumber).isDisplayed(),
                "Ensure that the number of items in the cart is displayed as expected."
        );
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

        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "Ensure that the product cart is displayed on the page."
        );
        return this;
    }

    public CartPage checkThatTheProductImageIsDisable() {
        driver.validations().validateTrue(
                driver.get().findElement(productImage).isDisplayed(),
                "Ensure that the product image is displayed on the page."
        );
        return this;
    }

    public CartPage checkThatTheProductImageSrcIsDisable() {
        driver.validations().validateEquals(
                driver.get().findElement(productImage).getAttribute("src"),
                "http://res.cloudinary.com/dhz0pkov6/image/upload/v1735932881/ecommerce/ubbmqjalem2fi0wmyvbt.png",
                "Ensure that the product image source is correct."
        );
        return this;
    }

    public CartPage checkThatTheProductPriceIsDisable() {
        driver.validations().validateTrue(
                driver.get().findElement(productPriceInCart).isDisplayed(),
                "Ensure that the product price is displayed in the cart."
        );

        return this;
    }

    public CartPage checkThatTheProductQuantityIsDisable() {
        driver.validations().validateTrue(
                driver.get().findElement(productQuantityInCart).isDisplayed(),
                "Ensure that the product quantity is displayed in the cart."
        );
        return this;
    }

    public CartPage checkThatTheProductTotalIsDisable() {
        driver.validations().validateTrue(
                driver.get().findElement(productTotalInCart).isDisplayed(),
                "Ensure that the product total is displayed in the cart."
        );
        return this;
    }

    public CartPage checkThatTheProductIsDeletedFromCart() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
        WebElement productElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(cartEmptyMessage));
        System.out.println("Card Empty message is: " + productElement5.getText());

        driver.validations().validateEquals(
                driver.element().getTextOf(cartEmptyMessage),
                CartEmptyMessageTitle,
                "Ensure that the 'Cart Empty' message is displayed correctly."
        );
        return this;
    }

    public CartPage checkThatTheProductMessageDeletedSuccesfullyIsDisable() {
        driver.validations().validateEquals(
                driver.element().getTextOf(cartDeletedMessage),
                cartDeletedMessageTitle,
                "Ensure that the 'Cart Deleted' message is displayed correctly."
        );        return this;
    }

    public CartPage checkThatTheCartIsClosedAfterClickingOnCloseIcon() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        boolean isCartGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(yourCartMessage));

        driver.validations().validateTrue(
                isCartGone,
                "Ensure that the cart is closed after clicking on the close icon. The 'Your Cart' message should not be visible."
        );
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

        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "Ensure that the product cart is displayed."
        );
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

        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "The product cart is not displayed."
        );
        return this;
    }

    public CartPage checkThatTheProductMessageUpdatedSuccesfullyIsDisable() {
        driver.validations().validateEquals(driver.element().getTextOf(cartUpdatedSuccessfullyMessage), cartUpdatedSuccessfullyMessageTitle, "The product update message is incorrect.");

        return this;
    }

    public CartPage checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(5));

        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productcart));
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityInCart));

        String actualQuantity = quantityElement.getText();
        driver.validations().validateEquals(actualQuantity, "1", "The quantity is not 1.");

        boolean isMinusButtonEnabled = driver.get().findElement(productQuantityMinusIcon).isEnabled();
        driver.validations().validateEquals(isMinusButtonEnabled, false, "The minus button is not disabled.");

        System.out.println("Quantity is: " + actualQuantity);
        System.out.println("Minus Icon is disabled.");
        return this;

    }

    public CartPage checkThatTheCheckoutButtonIsClickable() {
        driver.validations().validateEquals(driver.element().isClickable(checkoutButton), true, "The checkout button is not clickable.");

        return this;
    }

    public CartPage checkThatTheCartIsDisplayed() {
        driver.validations().validateEquals(driver.get().findElement(cartOpen).isDisplayed(), true, "The cart is not displayed.");

        return this;
    }

    /************************************** Actions ********************************************/
    public CartPage clickOnAddToCartButton() {
        driver.element().click(addToCartButton);
        return this;
    }

    public CartPage clickOnCartIcon() {
        ((JavascriptExecutor) driver.get()).executeScript("window.scrollTo(0, 0);");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.element().click(cartIcon);
        return this;
    }

    public CartPage clickOnDeleteIcon() {
        driver.element().click(deleteIcon);
        return this;
    }

    public CartPage clickOnCloseIcon() {
        driver.element().click(closeIcon);
        return this;
    }

    public CartPage clickOnQuantityPlusIcon() {
        driver.element().click(productQuantityPlusIcon);
        return this;
    }

    public CartPage clickOnQuantityMinusIcon() {
        driver.element().click(productQuantityMinusIcon);
        return this;
    }

    public CheckoutPageUser clickOnCheckoutButton() {
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


