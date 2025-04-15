package com.shoppy.com.tests.Cart;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.CheckoutPageUser;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartTests {

    public Driver driver;
    protected LoginPage loginPage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver);
        new LoginPage(driver).loginIntoApp("mylovelynano@gmail.com", "hakem@2010").assertLoginSuccessfulAsUser();
    }

    @Epic("1- Cart")
    @Feature("1.1- Add to cart")
    @Story("Add to cart functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify add to cart functionality.")
    @Test(priority = 1)
    public void testAddToCartProduct() {
        new CartPage(driver).checkThatTheProductNameIsDisplayed()
                            .clickOnAddToCartButton()
                            .checkThatTheProductMessageAddedSuccesfullyIsDisplayed()
                            .checkThatTheNumberOnCartIsDisplayed();
    }

    @Epic("2- Cart")
    @Feature("2.1- Product data in Cart")
    @Story("Product data are shown in cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify product data are shown in cart")
    @Test(priority = 2, dependsOnMethods = {"testAddToCartProduct"})
    public void testProductDataIsFoundInCart() {
        new CartPage(driver).clickOnCartIcon()
                            .checkThatTheCartIsDisplayed()
                            .checkThatTheProductNameInCartIsDisplayed()
                            .checkThatTheProductPriceIsDisplayed()
                            .checkThatTheProductQuantityIsDisplayed()
                            .checkThatTheProductImageIsDisplayed()
                            .checkThatTheProductImageSrcIsDisplayed()
                            .checkThatTheProductTotalIsDisplayed();

    }

    @Epic("3- Cart")
    @Feature("3.1- Minus icon disability in Cart")
    @Story("Minus icon disability in cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify minus icon is disable in cart with one quantity.")
    @Test(priority = 3, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testMinusButtonIsDisapledWhenProductQuantityEqualOne(){
        new CartPage(driver).checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne();
    }

    @Epic("4- Cart")
    @Feature("4.1- Price and total updates in Cart with plus icon")
    @Story("Product data are shown in cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify product data are updated in cart with plus icon")
    @Test(priority = 4, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased() {
        new CartPage(driver).clickOnQuantityPlusIcon()
                            .checkThatTheProductMessageUpdatedSuccesfullyIsDisplayed()
                            .checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity();
    }

    @Epic("5- Cart")
    @Feature("5.1- Price and total updates in Cart with minus icon")
    @Story("Price and total updates in Cart with minus icon")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify product price are updated in cart with minus icon")
    @Test(priority = 5, dependsOnMethods = {"testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsDecreased(){
        new CartPage(driver).clickOnQuantityMinusIcon()
                            .checkThatTheProductMessageUpdatedSuccesfullyIsDisplayed()
                            .checkThatTheProducDataIsUpdatedWhenDecreasingTheQuantity();
    }

    @Epic("6- Cart")
    @Feature("6.1- Delete button")
    @Story("Delete button functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify data are deleted from cart")
    @Test(priority = 6, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductDataIsDeletedFromCart()  {
        new CartPage(driver).clickOnDeleteIcon()
                            .checkThatTheProductIsDeletedFromCart()
                            .checkThatTheProductMessageDeletedSuccesfullyIsDisplayed();

    }

    @Epic("7- Cart")
    @Feature("7.1- Checkout button")
    @Story("Checkout button clickability")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify checkout button is clickable")
    @Test(priority = 7)
    public void testCheckoutButtonIsClickable() {
        new CartPage(driver).clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .checkThatTheCheckoutButtonIsClickable();
    }

    @Epic("8- Cart")
    @Feature("8.1- Close cart")
    @Story("Close cart")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify cart is closed")
    @Test(priority = 8, dependsOnMethods = {"testProductDataIsDeletedFromCart"})
    public void testCartIconIsClosed()  {
        new CartPage(driver).clickOnCloseIcon()
                            .checkThatTheCartIsClosedAfterClickingOnCloseIcon();
    }

    @Epic("9- Cart")
    @Feature("9.1- checkout button direction")
    @Story("Checkout button direct to checkout url")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify checkout button direction")
    @Test(priority = 9)
    public void testTheUrlChagnedToCheckoutPageAfterClickingOnCheckoutButton() {
        new CartPage(driver).clickOnAddToCartButton()
                            .checkThatTheProductMessageAddedSuccesfullyIsDisplayed()
                            .clickOnCartIcon()
                            .clickOnCheckoutButton();

        String expectedCheckoutURL = "https://shoppy-ochre.vercel.app/shop/checkout";
        String actualURL = driver.get().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedCheckoutURL, "Checkout URL mismatch!");
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
