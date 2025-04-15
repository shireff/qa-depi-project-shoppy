package com.shoppy.com.pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import static com.shoppy.com.utils.Waits.*;

public class CartPage {
    private final Driver driver;

    private final By addToCartButton = By.xpath("//div[7]//button");
    private final By ProductsName = By.xpath("//div[7]//h2");
    private final By productSuccessfullyAddedToCartMessage = By.xpath("//li/div/div[contains(text(),'Product added to cart successfully!')]");
    private final By cartIcon = By.xpath("(//div//div/div/button)[1]");
    private final By productImage = By.xpath("//div[@role=\"dialog\"]//img");
    private final By productPriceInCart = By.xpath("//div[@role=\"dialog\"]//p");
    private final By productQuantityInCart = By.xpath("(//div[@role=\"dialog\"]//span)[1]");
    private final By productTotalInCart = By.xpath("(//div[@role=\"dialog\"]//span)[1]");
    private final By productcart = By.xpath("(//div[@role=\"dialog\"]//h3)[1]");
    private final By deleteIcon = By.xpath("//div[@class='flex flex-col items-center sm:items-end']/*[2]");
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
    String cartUpdatedSuccessfullyMessageTitle = "Card item updated successfully";


    public CartPage(Driver driver) {
        this.driver = driver;
    }

    /************************************ Assertions *******************************************/
    @Step("Assert product name is displayed")
    public CartPage checkThatTheProductNameIsDisplayed() {
        driver.validations().validateEquals(driver.element().getTextOf(ProductsName), ProductsSectionName,
                "❌ Product name in the section should be the same as the expected one!");
        return this;
    }

    @Step("Assert add message is displayed")
    public CartPage checkThatTheProductMessageAddedSuccesfullyIsDisplayed() {
        driver.validations().validateEquals(
                driver.element().getTextOf(productSuccessfullyAddedToCartMessage),
                productSuccessfullyAddedToCartTitle,
                "❌ Ensure that the 'Product Added Successfully' message appears and matches the expected text!"
        );
        return this;
    }

    @Step("Assert cart number is displayed")
    public CartPage checkThatTheNumberOnCartIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(cartNumber).isDisplayed(),
                "❌ Ensure that the number of items in the cart is displayed as expected!"
        );
        return this;
    }

    @Step("Assert product name is displayed")
    public CartPage checkThatTheProductNameInCartIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "❌ Ensure that the product cart is displayed on the page!"
        );
        return this;
    }

    @Step("Assert product image is displayed")
    public CartPage checkThatTheProductImageIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(productImage).isDisplayed(),
                "❌ Ensure that the product image is displayed on the page!"
        );
        return this;
    }

    @Step("Assert product image src is displayed")
    public CartPage checkThatTheProductImageSrcIsDisplayed() {
        driver.validations().validateEquals(
                driver.get().findElement(productImage).getAttribute("src"),
                "http://res.cloudinary.com/dhz0pkov6/image/upload/v1735932881/ecommerce/ubbmqjalem2fi0wmyvbt.png",
                "❌ Ensure that the product image source is correct!"
        );
        return this;
    }

    @Step("Assert product price is displayed")
    public CartPage checkThatTheProductPriceIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(productPriceInCart).isDisplayed(),
                "❌ Ensure that the product price is displayed in the cart!"
        );

        return this;
    }

    @Step("Assert product quantity is displayed")
    public CartPage checkThatTheProductQuantityIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(productQuantityInCart).isDisplayed(),
                "❌ Ensure that the product quantity is displayed in the cart!"
        );
        return this;
    }

    @Step("Assert total is displayed")
    public CartPage checkThatTheProductTotalIsDisplayed() {
        driver.validations().validateTrue(
                driver.get().findElement(productTotalInCart).isDisplayed(),
                "❌ Ensure that the product total is displayed in the cart!"
        );
        return this;
    }

    @Step("Assert product is deleted")
    public CartPage checkThatTheProductIsDeletedFromCart() {
        driver.validations().validateEquals(
                driver.element().getTextOf(cartEmptyMessage),
                CartEmptyMessageTitle,
                "❌ Ensure that the 'Cart Empty' message is displayed correctly!"
        );
        return this;
    }

    @Step("Assert delete message is displayed")
    public CartPage checkThatTheProductMessageDeletedSuccesfullyIsDisplayed() {
        driver.validations().validateEquals(
                driver.element().getTextOf(cartDeletedMessage),
                cartDeletedMessageTitle,
                "❌ Ensure that the 'Cart Deleted' message is displayed correctly!"
        );        return this;
    }

    @Step("Assert cart is closed")
    public CartPage checkThatTheCartIsClosedAfterClickingOnCloseIcon() {
        boolean isCartGone = waitForElementToBeInvisible(driver.get(), yourCartMessage);
        driver.validations().validateTrue(
                isCartGone,
                "❌ Ensure that the cart is closed after clicking on the close icon. The 'Your Cart' message should not be visible!"
        );
        return this;
    }

    @Step("Assert product's data is updated when increasing the quantity")
    public CartPage checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity() {
        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "❌ Ensure that the product cart is displayed!"
        );
        return this;
    }

    @Step("Assert product's data is updated when deacresing the quantity")
    public CartPage checkThatTheProducDataIsUpdatedWhenDecreasingTheQuantity() {
        driver.validations().validateTrue(
                driver.get().findElement(productcart).isDisplayed(),
                "❌ The product cart is not displayed!"
        );
        return this;
    }

    @Step("Assert update message is displayed")
    public CartPage checkThatTheProductMessageUpdatedSuccesfullyIsDisplayed() {
        driver.validations().validateEquals(driver.element().getTextOf(cartUpdatedSuccessfullyMessage), cartUpdatedSuccessfullyMessageTitle, "❌ The product update message is incorrect!");

        return this;
    }

    @Step("Assert product minus button is disapled when quantity is one")
    public CartPage checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne() {
        String actualQuantity = driver.element().getTextOf(productQuantityInCart);
        boolean isMinusButtonEnabled = driver.get().findElement(productQuantityMinusIcon).isEnabled();
        driver.validations().validateEquals(actualQuantity, "1", "❌ The quantity is not 1.");
        driver.validations().validateEquals(isMinusButtonEnabled, false, "❌ The minus button is not disabled!");

        driver.assertion().assertElementDisplayed(productQuantityMinusIcon, "❌ The minus icon is enabled!");
        return this;

    }

    @Step("Assert checkout button is clickable")
    public CartPage checkThatTheCheckoutButtonIsClickable() {
        driver.validations().validateEquals(driver.element().isClickable(checkoutButton), true, "❌ The checkout button is not clickable!");

        return this;
    }

    @Step("Assert cart is displayed")
    public CartPage checkThatTheCartIsDisplayed() {
        driver.validations().validateEquals(driver.get().findElement(cartOpen).isDisplayed(), true, "❌ The cart is not displayed!");
        return this;
    }

    /************************************** Actions ********************************************/
    @Step("Click add to cart button")
    public CartPage clickOnAddToCartButton() {
        driver.element().click(addToCartButton);
        return this;
    }

    @Step("Click cart icon")
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

    @Step("Click delete button")
    public CartPage clickOnDeleteIcon() {
        driver.element().click(deleteIcon);
        return this;
    }

    @Step("Click close button")
    public CartPage clickOnCloseIcon() {
        driver.element().click(closeIcon);
        return this;
    }

    @Step("Click plus quantity icon")
    public CartPage clickOnQuantityPlusIcon() {
        driver.element().click(productQuantityPlusIcon);
        return this;
    }

    @Step("Click minus quantity icon")
    public CartPage clickOnQuantityMinusIcon() {
        driver.element().click(productQuantityMinusIcon);
        return this;
    }

    @Step("Click checkout button")
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


