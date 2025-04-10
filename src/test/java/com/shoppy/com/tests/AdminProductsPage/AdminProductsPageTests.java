package com.shoppy.com.tests.AdminProductsPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminAddProductPage;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminProductsPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.*;

import java.time.Duration;

public class AdminProductsPageTests {

    public ThreadLocal<Driver> driver;
    protected LoginPage loginPage;
    private String URL = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeClass
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().browser().openUrl(driver.get().get(), URL);
        loginPage = new LoginPage(driver.get());
        loginPage.setUserName("Arima@example.com");
        loginPage.setPassword("123456789");
        loginPage.clickLogin();
    }

    @Test(priority = 1)
    public void testNavigationToProductsPage() {
        new AdminDashboardPage(driver.get())
                .clickOnProductsBtn()
                .checkProductsPageUrl()
                .checkAddProductBtnIsDisplayed()
                .checkProductsAreDisplayed();
    }

    @Test(priority = 2)
    public void testThatProductCardAndItsComponentsExists() {
        new AdminProductsPage(driver.get()).
                checkProductCardIsDisplayed()
                .checkProductCardImageIsDisplayed()
                .checkProductCardEditBtnIsDisplayed()
                .checkProductCardDeleteBtnIsDisplayed()
                .checkProductCardPriceIsDisplayed()
                .checkProductCardTitleIsDisplayed();
    }

    @Test(priority = 3)
    public void verifyThatAddProductButtonIsWorkingProperly() {
        new AdminProductsPage(driver.get())
                .checkAddProductBtnIsDisplayed()
                .clickOnAddProductBtn()
                .checkAddProductFormIsDisplayed();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.get().browser().closeBrowser(driver.get().get());
    }
}
