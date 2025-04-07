package com.shoppy.com.tests.Cart;

import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class CartTests {

    protected WebDriver driver;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BrowserActions.openUrl(driver, url);
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
                .checkThatTheProductImageIsDisable()
                .checkThatTheTotalIsDisable();

    }

    @Test(priority = 3, dependsOnMethods = {"testAddToCartProduct"})
    public void testCounterNumberIsUpdated() {
        cartPage.clickOnCounterIcon()
                .checkThatTheCartItemMessageUpdatedSuccesfullyIsDisable();

    }


/*
    @Test(priority = 3, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testProductDataIsDeletedFromCart() throws InterruptedException {
        cartPage.clickOnDeleteIcon()
                .checkThatTheProductIsDeletedFromCart();

    }

    @Test(priority = 4, dependsOnMethods = {"testProductDataIsFoundInCart"})
    public void testCartIconIsClosed() throws InterruptedException {
        cartPage.clickOnCloseIcon()
                .checkThatTheCartIsClosedAfterClickingOnCloseIcon();

    }

*/

    @AfterClass
    public void tearDown() {
        BrowserActions.closeBrowser(driver);
   }


}
