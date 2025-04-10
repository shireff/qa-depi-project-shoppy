package com.shoppy.com.tests.AdminProductsPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminProductsPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminProductsPageTests {

    public Driver driver;
    protected LoginPage loginPage;
    private String URL = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeMethod
    public void setup() {
        driver = new Driver("CHROME");
        driver.browser().openUrl(driver.get(), URL);
        loginPage = new LoginPage(driver);
        loginPage.setUserName("Arima@example.com");
        loginPage.setPassword("123456789");
        loginPage.clickLogin();
    }

    @Test(priority = 1)
    public void testNavigationToProductsPage() {
        new AdminDashboardPage(driver)
                .clickOnProductsBtn()
                .checkProductsPageUrl()
                .checkAddProductBtnIsDisplayed()
                .checkProductsAreDisplayed();
    }
    @Test(priority = 2)
    public void testThatProductCardAndItsComponentsExists() {
        testNavigationToProductsPage();
        new AdminProductsPage(driver).
                checkProductCardIsDisplayed()
                .checkProductCardImageIsDisplayed()
                .checkProductCardEditBtnIsDisplayed()
                .checkProductCardDeleteBtnIsDisplayed()
                .checkProductCardPriceIsDisplayed()
                .checkProductCardTitleIsDisplayed();
    }

    @Test(priority = 3)
    public void verifyThatAddProductBtnIsWorkingProperly() {
        testNavigationToProductsPage();
        new AdminProductsPage(driver).clickOnAddProductBtn();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.browser().closeBrowser(driver.get());
    }
}
