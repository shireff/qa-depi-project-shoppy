package com.shoppy.com.e2e.user;
import com.shoppy.com.pages.HomePage;
import io.qameta.allure.*;
import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
import com.shoppy.com.pages.SearchPageUser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserE2EFilterSort {
    public Driver driver;

    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
        new ProductsPageUser(driver).driverNavigate();
    }
    @Epic("User Products Page")
    @Feature("End-to-End Filtering and Sorting")
    @Story("Browse, Filter, Sort, Navigate, and Verify Footer")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end scenario: Browse products page, apply category and brand filters, sort the results, navigate to other pages, and verify footer elements.")
    @Test(priority = 1)
    public void endToEndFilterSortNavigationVerification() {
        // 1. Verify initial state of the Products Page
        new ProductsPageUser(driver).checkProductsPageUrl()
                .checkThatTheAllProductsTitleIsDisplayed()
                .checkThatTheFiltersTitleIsDisplayed()
                .checkThatTheCategoryTitleIsDisplayed()
                .checkThatTheBrandTitleIsDisplayed()
                .checkThatProductsCountMutedTextIsVisible();

        // 2. Apply Category Filters
        new ProductsPageUser(driver).clickMenCheckBox().checkThatTheMenCheckBoxIsChecked()
                .clickFootWearCheckBox().checkThatFootWearCheckBoxIsChecked();

        // 3. Apply Brand Filters
        new ProductsPageUser(driver).clickNickCheckBox().checkThatNikeCheckBoxIsChecked();

        // 4. Sort the Results
        new ProductsPageUser(driver).sortByPriceHighToLow().checkThatSortByHighToLow();

        // 5. Navigate to Home Page and Verify
        new ProductsPageUser(driver).clickNavBarHome().assertHomePageHeaderDisplayed();
        new HomePage(driver).assertLoginSuccessfulAsUser();
        driver.browser().navigateBack();
        new ProductsPageUser(driver).checkProductsPageUrl(); // Ensure we are back on the Products page

        // 6. Navigate to Search Page and Perform a Search
        new ProductsPageUser(driver).clickNavBarSearch().checkThatSearchBoxIsDisplayed();
        new SearchPageUser(driver).fillSearchBox("Shirt");
        // Assuming there's a way to trigger the search and results are displayed
        // We'll just check if search related elements become visible
        new SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed();
        driver.browser().navigateBack();
        new ProductsPageUser(driver).checkProductsPageUrl(); // Back to Products page

        // 7. Navigate to a specific category (e.g., Women)
        new ProductsPageUser(driver).clickNavBarWomen().checkThatTheWomenCheckBoxIsChecked();
        driver.browser().navigateBack();
        new ProductsPageUser(driver).checkProductsPageUrl();

        // 8. Verify Footer Elements on the Products Page
        new ProductsPageUser(driver).verifyFooterElements();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
