package com.shoppy.com.tests.Cart;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.utils.BrowserActions;
import org.testng.annotations.*;
import java.time.Duration;

public class CartTests {

    protected Driver driver;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
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
    public void testAddToCartProduct() throws InterruptedException {
        loginPage.setUserName("mylovelynano@gmail.com");
        loginPage.setPassword("hakem@2010");
        loginPage.clickLogin();
        loginPage.assertLoginSuccessfulAsUser();

        cartPage.checkThatTheProductNameIsDisable()
                .clickOnAddToCartButton()
                .checkThatTheProductMessageAddedSuccesfullyIsDisable();
    }

    @Test(priority = 2, dependsOnMethods = {"testAddToCartProduct"})
    public void testProductDataIsFoundInCart() {
        cartPage.clickOnCartIcon()
                .checkThatTheProductNameInCartIsDisable()
                .checkThatTheProductPriceIsDisable()
                .checkThatTheProductQuantityIsDisable()
                .checkThatTheProductImageIsDisable();
              //  .checkThatTheTotalIsDisable();

    }
/*
    @Test(priority = 3, dependsOnMethods = {"testAddToCartProduct"})
    public void testCounterNumberIsUpdated() {
        cartPage.clickOnCounterIcon()
                .checkThatTheCartItemMessageUpdatedSuccesfullyIsDisable();

    }
*/


    @Test(priority = 3, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductDataIsDeletedFromCart() throws InterruptedException {
        cartPage.clickOnDeleteIcon()
                .checkThatTheProductIsDeletedFromCart();

    }

//    @Test(priority = 4, dependsOnMethods = {"testProductDataIsFoundInCart"})
//    public void testCartIconIsClosed() throws InterruptedException {
//        cartPage.clickOnCloseIcon()
//                .checkThatTheCartIsClosedAfterClickingOnCloseIcon();
//
//    }



    @AfterClass
    public void tearDown() throws InterruptedException {
     //   Thread.sleep(2000);
        driver.browser().closeBrowser(driver.get());
    }


}
