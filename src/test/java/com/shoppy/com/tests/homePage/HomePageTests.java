package com.shoppy.com.tests.homePage;

import DriverFactory.Driver;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.dataproviders.DataProviderTests;
import com.shoppy.com.utils.BrowserActions;
import io.qameta.allure.*;
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
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }


    @Epic("Home Page Functionality")
    @Feature("Header Verification")
    @Story("Check if the home page header is displayed")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensure the home page header is visible after login.")
    @Test(priority = 1)
    public void testHomePageHeaderIsDisplayed() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.assertHomePageHeaderDisplayed();
    }

    @Epic("Home Page Functionality")
    @Feature("Category Filter")
    @Story("Verify product visibility after category selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if products are displayed correctly after selecting a category.")
    @Test(priority = 2, dataProvider = "categoryData", dataProviderClass = DataProviderTests.class)
    public void testCategorySelection(String category, boolean hasProducts) throws InterruptedException {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory(category);
        homePage.validateProductVisibility(hasProducts, "Category filter failed for: " + category);
    }

    @Epic("Home Page Functionality")
    @Feature("Brand Filter")
    @Story("Verify product visibility after brand selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if products are displayed correctly after selecting a brand.")
    @Test(priority = 3, dataProvider = "brandData", dataProviderClass = DataProviderTests.class)
    public void testBrandSelection(String brand, boolean hasProducts) {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectBrand(brand);
        homePage.validateProductVisibility(hasProducts, "Brand filter failed for: " + brand);
    }

    @Epic("Home Page Functionality")
    @Feature("Featured Products")
    @Story("Interact with featured products section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test the interaction with featured products and verify modal display.")
    @Test(priority = 4)
    public void testFeatureProductsInteraction() throws InterruptedException {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.assertFeatureProductsDisplayed();
        homePage.clickFirstFeaturedProduct();
        homePage.assertProductModalDisplayed();
    }

    @Epic("Home Page Functionality")
    @Feature("Customer Reviews Section")
    @Story("Check if the customer reviews section is visible")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensure the customer reviews section is visible on the home page.")
    @Test(priority = 5)
    public void testCustomerReviewsVisibility() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.isCustomerReviewsDisplayed(), "\n Customer reviews section is missing! \n");
    }

    @Epic("Home Page Functionality")
    @Feature("Footer Verification")
    @Story("Verify footer links functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if the footer links are functioning as expected.")
    @Test(priority = 6)
    public void testFooterLinks() {
        loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.areFooterLinksWorking(), "\n Footer links are not working! \n");
    }

    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
