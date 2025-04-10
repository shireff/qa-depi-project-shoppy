package com.shoppy.com.tests.Cart;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.utils.BrowserActions;
import org.testng.annotations.*;
import java.time.Duration;

public class CartTests {

    public Driver driver;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new Driver("chrome");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1)
    public void testAddToCartProduct() {
        loginPage.setUserName("mylovelynano@gmail.com");
        loginPage.setPassword("hakem@2010");
        loginPage.clickLogin();
        loginPage.assertLoginSuccessfulAsUser();

        cartPage.checkThatTheProductNameIsDisable()
                .clickOnAddToCartButton()
                .checkThatTheProductMessageAddedSuccesfullyIsDisable()
                .checkThatTheNumberOnCartIsDisable();
    }

    @Test(priority = 2, dependsOnMethods = {"testAddToCartProduct"})
    public void testProductDataIsFoundInCart() {
        cartPage.clickOnCartIcon()
                .checkThatTheProductNameInCartIsDisable()
                .checkThatTheProductPriceIsDisable()
                .checkThatTheProductQuantityIsDisable()
                .checkThatTheProductImageIsDisable()
                .checkThatTheProductTotalIsDisable();

    }

    @Test(priority = 3, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testMinusButtonIdDisapledWhenProductQuantityEqualOne(){
        cartPage.checkThatTheProductMinusButtonIsDisapledWhenQuantityIsOne();
    }

    @Test(priority = 4, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased() {
        cartPage.clickOnQuantityPlusIcon()
                .checkThatTheProductMessageUpdatedSuccesfullyIsDisable()
                .checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity();
    }

    @Test(priority = 5, dependsOnMethods = {"testProductPriceAndTotalIsUpdatedWhenQuantityIsIncreased"})
    public void testProductPriceAndTotalIsUpdatedWhenQuantityIsDecreased(){
        cartPage.clickOnQuantityMinusIcon()
                .checkThatTheProductMessageUpdatedSuccesfullyIsDisable()
                .checkThatTheProducDataIsUpdatedWhenDecreasingTheQuantity();
    }

    @Test(priority = 6, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductDataIsDeletedFromCart()  {
        cartPage.clickOnDeleteIcon()
                .checkThatTheProductIsDeletedFromCart()
                .checkThatTheProductMessageDeletedSuccesfullyIsDisable();

    }

    @Test(priority = 7, dependsOnMethods = {"testProductDataIsDeletedFromCart"})
    public void testCartIconIsClosed()  {
        cartPage.clickOnCloseIcon()
                .checkThatTheCartIsClosedAfterClickingOnCloseIcon();
    }

    @Test(priority = 8)
    public void testCheckoutButtonIsClickable() {
        cartPage.clickOnCartIcon()
                .clickOnCheckoutButton()
                .checkThatTheCheckoutButtonIsClickable();
    }
    @Test(priority = 9, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testTheUrlChagnedToCheckoutPageAfterClickingOnCheckoutButton() {
        cartPage.clickOnCheckoutButton()
                .checkThatTheUrlChangedToTheCheckoutPage();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
