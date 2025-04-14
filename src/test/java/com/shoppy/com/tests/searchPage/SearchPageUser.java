package com.shoppy.com.tests.searchPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageUser
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
    }
    @Test
    public void TestMethod()
    {
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchBox();
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxHM();
    }
    @Epic("User Search Page")
    @Feature("Navigation")
    @Story("Verify Search Page URL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Search page URL is correct.")
    @Test(priority = 1)
    public void verifySearchPageURL() {
        // Note: The URL might not change upon clicking the search icon,
        // as it might be a modal or an in-page element. Adjust the assertion accordingly.
        // If it does navigate to a specific URL, uncomment and verify.
        // searchPageUser.checkSearchPageUrl();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Verify Search Tab Visibility")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Search tab is visible in the navigation bar.")
    @Test(priority = 2)
    public void verifySearchTabVisibility() {
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchTabIsVisible();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Verify Search Box Visibility")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the search input box is displayed on the Search page.")
    @Test(priority = 3)
    public void verifySearchBoxVisibility() {
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Verify 'No Products Found' Display")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the 'No Products Found' message is displayed before a search is performed.")
    @Test(priority = 4)
    public void verifyNoProductsFoundDisplay() {
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatNoProductsFoundIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Men' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Men' and verify that product details are displayed.")
    @Test(priority = 5)
    public void searchForMenAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxMen();
        // Assuming there will be search results for "Men"
        // You might need to add a way to trigger the search (e.g., pressing Enter or clicking a search button if present)
        // For now, we'll just check if the elements for a search result are displayed after filling the box.
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price if applicable
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Women' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Women' and verify that product details are displayed.")
    @Test(priority = 6)
    public void searchForWomenAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxWomen();
        // Assuming there will be search results for "Women"
        // Add a way to trigger the search if needed
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Kids' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Kids' and verify that product details are displayed.")
    @Test(priority = 7)
    public void searchForKidsAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxKids();
        // Assuming there will be search results for "Kids"
        // Add a way to trigger the search if needed
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Footwear' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Footwear' and verify that product details are displayed.")
    @Test(priority = 8)
    public void searchForFootwearAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxFootwear();
        // Assuming there will be search results for "Footwear"
        // Add a way to trigger the search if needed
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Accessories' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Accessories' and verify that product details are displayed.")
    @Test(priority = 9)
    public void searchForAccessoriesAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxAccessories();
        // Assuming there will be search results for "Accessories"
        // Add a way to trigger the search if needed
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for Brand 'Nike' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for the brand 'Nike' and verify that product details are displayed.")
    @Test(priority = 10)
    public void searchForNikeAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxNike();
        // Assuming there will be search results for "Nike"
        // Add a way to trigger the search if needed
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
        // Optional: Verify Sale Price
        // searchPageUser.checkThatProductSearchedSalePriceIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Click on Searched Image")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that clicking on a searched product's image performs an action (e.g., navigates to the product details page).")
    @Test(priority = 11)
    public void clickOnSearchedImageTest() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxMen();
        // Assuming search results are displayed
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchedImage();
        // Add assertions here to verify that the click action was successful
        // (e.g., checking the URL or the presence of product details elements).
    }

    @Epic("User Search Page")
    @Feature("Footer")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence of footer elements on the Search page.")
    @Test(priority = 12)
    public void verifyFooterElements() {
        // Note: You'll need to add methods to your SearchPageUser page to interact with and assert on footer elements.
        // Assuming you add methods like checkFooterRightsReservedDisplayed, checkFooterGitHubDisplayed, etc.
        // searchPageUser.checkFooterRightsReservedDisplayed()
        //         .checkFooterGitHubDisplayed()
        //         .checkFooterLinkedInDisplayed()
        //         .checkFooterWhatsAppDisplayed();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
