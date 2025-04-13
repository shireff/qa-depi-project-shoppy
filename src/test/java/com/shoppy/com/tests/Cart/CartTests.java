package com.shoppy.com.tests.Cart;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.LoginPage;
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
        new LoginPage(driver).loginIntoApp("mylovelynano@gmail.com", "hakem@2010");
    }

    @Test(priority = 1)
    public void testAddToCartProduct() {
        loginPage.assertLoginSuccessfulAsUser();
        new CartPage(driver).checkThatTheProductNameIsDisable()
                            .clickOnAddToCartButton()
                            .checkThatTheProductMessageAddedSuccesfullyIsDisable()
                            .checkThatTheNumberOnCartIsDisable();
    }

    @Test(priority = 2, dependsOnMethods = {"testAddToCartProduct"})
    public void testProductDataIsFoundInCart() {
        new CartPage(driver).clickOnCartIcon()
                            .checkThatTheCartIsDisplayed()
                            .checkThatTheProductNameInCartIsDisable()
                            .checkThatTheProductPriceIsDisable()
                            .checkThatTheProductQuantityIsDisable()
                            .checkThatTheProductImageIsDisable()
                            .checkThatTheProductImageSrcIsDisable()
                            .checkThatTheProductTotalIsDisable();

    }

    @Test(priority = 3, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testMinusButtonIdDisapledWhenProductQuantityEqualOne(){
        new CartPage(driver).checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne();
    }

    @Test(priority = 4, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased() {
        new CartPage(driver).clickOnQuantityPlusIcon()
                            .checkThatTheProductMessageUpdatedSuccesfullyIsDisable()
                            .checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity();
    }

    @Test(priority = 5, dependsOnMethods = {"testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsDecreased(){
        new CartPage(driver).clickOnQuantityMinusIcon()
                            .checkThatTheProductMessageUpdatedSuccesfullyIsDisable()
                            .checkThatTheProducDataIsUpdatedWhenDecreasingTheQuantity();
    }

    @Test(priority = 6, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductDataIsDeletedFromCart()  {
        new CartPage(driver).clickOnDeleteIcon()
                            .checkThatTheProductIsDeletedFromCart()
                            .checkThatTheProductMessageDeletedSuccesfullyIsDisable();

    }

    @Test(priority = 7)
    public void testCheckoutButtonIsClickable() {
        new CartPage(driver).clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .checkThatTheCheckoutButtonIsClickable();
    }

    @Test(priority = 8, dependsOnMethods = {"testProductDataIsDeletedFromCart"})
    public void testCartIconIsClosed()  {
        new CartPage(driver).clickOnCloseIcon()
                            .checkThatTheCartIsClosedAfterClickingOnCloseIcon();
    }


    @Test(priority = 9)
    public void testTheUrlChagnedToCheckoutPageAfterClickingOnCheckoutButton() {
        new CartPage(driver).clickOnAddToCartButton()
                            .checkThatTheProductMessageAddedSuccesfullyIsDisable()
                            .clickOnCartIcon()
                            .clickOnCheckoutButton();
                            //.checkThatTheUrlChangedToTheCheckoutPage();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
