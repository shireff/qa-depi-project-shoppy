package com.shoppy.com.tests.homePage;

import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.dataproviders.DataProviderTests;
import com.shoppy.com.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;

public class HomePageTests {


    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";


    @BeforeMethod
    public void setUp(Method method) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BrowserActions.openUrl(driver, url);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
        BrowserActions.closeBrowser(driver);
    }
}
