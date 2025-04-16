package com.shoppy.com.e2e.user;

import DriverFactory.Driver;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
import com.shoppy.com.pages.SearchPageUser;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchE2E
{

    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
    }

    @Epic("User Search Page")
    @Feature("End-to-End Search Functionality")
    @Story("Complete Search Workflow and Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end scenario: Navigate to the Search page, perform various searches, verify results, interact with a search result, navigate back, and check footer elements.")
    @Test(priority = 1)
    public void completeSearchWorkflowAndNavigation() {
        // 1. Verify initial state of the Search Page
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed()
                .checkThatNoProductsFoundIsDisplayed();

        // 2. Search for "Men" and Verify Results
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxMen();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();

        // 3. Click on the Searched Image
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchedImage();
        // Assuming clicking the image navigates to a product details page
        // You would ideally have a ProductDetailsPage object and perform assertions there
        // For this E2E in SearchPage context, we'll navigate back
        driver.browser().navigateBack();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed(); // Ensure we are back on the search page

        // 4. Search for "Nike" and Verify Results
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxNike();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed(); // Specific check for brand

        // 5. Navigate to Home Page via Shoppy Icon
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
        new com.shoppy.com.pages.SearchPageUser(driver).checkSearchPageUrl();
        driver.browser().navigateBack();
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap(); // Navigate back to Search page

        // 6. Verify Footer Elements on the Search Page
        new com.shoppy.com.pages.SearchPageUser(driver).verifyFooterElements();
    }

    @Epic("User Search Page")
    @Feature("Navigation")
    @Story("Verify Navigation from Search Page to Home")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify navigation from the Search page to the Home page using the navigation bar.")
    @Test(priority = 2)
    public void navigateToHomeFromSearchPage() {
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnHomeTap().checkHomePageUrl();
        driver.browser().navigateBack();
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Navigation")
    @Story("Verify Navigation from Search Page to Products")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify navigation from the Search page to the Products page using the navigation bar.")
    @Test(priority = 3)
    public void navigateToProductsFromSearchPage() {
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnProductsTap();
        new ProductsPageUser(driver).checkProductsPageUrl();
        driver.browser().navigateBack();
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
