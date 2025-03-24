package com.shoppy.com.tests.homePage;

import DriverFactory.Driver;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.dataproviders.DataProviderTests;
import com.shoppy.com.utils.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomePageTests {


    public Driver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";


    @BeforeMethod
    public void setUp(Method method) {
        driver = new Driver("chrome");

        //BrowserActions.openUrl(driver, url);
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver.get());
        homePage = new HomePage(driver.get());
    }


    @Test
    public void testHomePageHeaderIsDisplayed() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.assertHomePageHeaderDisplayed();
    }

    @Test(dataProvider = "categoryData", dataProviderClass = DataProviderTests.class)
    public void testCategorySelection(String category, boolean hasProducts) {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory(category);
        homePage.validateProductVisibility(hasProducts, "Category filter failed for: " + category);
    }

    @Test(dataProvider = "brandData", dataProviderClass = DataProviderTests.class)
    public void testBrandSelection(String brand, boolean hasProducts) {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectBrand(brand);
        homePage.validateProductVisibility(hasProducts, "Brand filter failed for: " + brand);
    }

    @Test
    public void testFeatureProductsInteraction() throws InterruptedException {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.assertFeatureProductsDisplayed();
        homePage.clickFirstFeaturedProduct();
        homePage.assertProductModalDisplayed();
    }

    @Test
    public void testCustomerReviewsVisibility() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.isCustomerReviewsDisplayed(), "\n Customer reviews section is missing! \n");
    }

    @Test
    public void testFooterLinks() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.areFooterLinksWorking(), "\n Footer links are not working! \n");
    }

    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
