package com.shoppy.com.tests.searchPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
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
    public void verifySearchPageLoaded() {
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatSearchBoxIsDisplayed();
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
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();

    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Women' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Women' and verify that product details are displayed.")
    @Test(priority = 6)
    public void searchForWomenAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxWomen();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Kids' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Kids' and verify that product details are displayed.")
    @Test(priority = 7)
    public void searchForKidsAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxKids();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();

    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Footwear' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Footwear' and verify that product details are displayed.")
    @Test(priority = 8)
    public void searchForFootwearAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxFootwear();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for 'Accessories' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for 'Accessories' and verify that product details are displayed.")
    @Test(priority = 9)
    public void searchForAccessoriesAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxAccessories();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();
    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Search for Brand 'Nike' and Verify Results")
    @Severity(SeverityLevel.NORMAL)
    @Description("Perform a search for the brand 'Nike' and verify that product details are displayed.")
    @Test(priority = 10)
    public void searchForNikeAndVerifyResults() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxNike();
        new com.shoppy.com.pages.SearchPageUser(driver).checkThatProductSearchedNameIsDisplayed()
                .checkThatProductSearchedCategoryIsDisplayed()
                .checkThatProductSearchedBrandIsDisplayed()
                .checkThatProductSearchedPriceIsDisplayed()
                .checkThatProductSearchedAddToCardIsDisplayed()
                .checkThatProductSearchedImageIsDisplayed();

    }

    @Epic("User Search Page")
    @Feature("Search Functionality")
    @Story("Click on Searched Image")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that clicking on a searched product's image performs an action (e.g., navigates to the product details page).")
    @Test(priority = 11)
    public void clickOnSearchedImageTest() {
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxMen();
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchedImage();
    }

    @Epic("User Search Page")
    @Feature("Footer")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence of footer elements on the Search page.")
    @Test(priority = 12)
    public void verifyFooterElements() {
        new com.shoppy.com.pages.SearchPageUser(driver)
                .checkFooterRightsReservedDisplayed()
                .checkFooterRightsReservedText("© 2025 Shireff Nady All rights reserved")
                .checkFooterGitHubDisplayed()
                .checkFooterLinkedInDisplayed()
                .checkFooterWhatsAppDisplayed()
                .checkFooterGitHubLink("https://github.com/shireff")
                .checkFooterLinkedInLink("https://www.linkedin.com/in/shireff-nady-5b7791340/")
                .checkFooterWhatsAppLink("https://wa.me/+201274068946");;
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
