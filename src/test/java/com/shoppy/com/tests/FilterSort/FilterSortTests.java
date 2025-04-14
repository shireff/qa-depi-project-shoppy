package com.shoppy.com.tests.FilterSort;

import DriverFactory.Driver;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
import com.shoppy.com.pages.SearchPageUser;
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

public class FilterSortTests {
    public Driver driver;

    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
        new ProductsPageUser(driver).driverNavigate();
    }

    @Test
    public void TestCase_Demo() {
        new ProductsPageUser(driver).clickMenCheckBox().clickHMCheckBox().clickAccessoriesCheckBox();
    }
    @Test
    public void usingAllCheckBoxes()
    {
        new ProductsPageUser(driver).clickMenCheckBox().
                clickWomenCheckBox().
                clickKidsCheckBox().
                clickAccessoriesCheckBox().
                clickFootWearCheckBox().
                clickNickCheckBox().
                clickAdidasCheckBox().
                clickPumaCheckBox().
                clickLevisCheckBox().
                clickZaraCheckBox().
                clickHMCheckBox().checkThatTheMenCheckBoxIsChecked().
                checkThatTheWomenCheckBoxIsChecked().
                checkThatTheKidsCheckBoxIsChecked().
                checkThatTheAccessoriesCheckBoxIsChecked().
                checkThatFootWearCheckBoxIsChecked().
                checkThatNikeCheckBoxIsChecked().
                checkThatAdidasCheckBoxIsChecked().
                checkThatPumaCheckBoxIsChecked().
                checkThatLevisCheckBoxIsChecked().
                checkThatZaraCheckBoxIsChecked().
                checkThatHMCheckBoxIsChecked();
    }
    @Test
    public void goingToSearchPageFromProductsPage()
    {
        new ProductsPageUser(driver).clickNavBarSearch().checkThatSearchTabIsVisible();
    }
    @Test
    public void goingToHomePageFromProductsPage()
    {
        new ProductsPageUser(driver).clickNavBarHome();
    }
    @Epic("User Products Page")
    @Feature("Navigation")
    @Story("Verify Products Page URL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Products page URL is correct.")
    @Test(priority = 1)
    public void verifyProductsPageURL() {
        new ProductsPageUser(driver).checkProductsPageUrl();
    }

    @Epic("User Products Page")
    @Feature("Page Titles")
    @Story("Verify Main Titles")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the main titles on the Products page.")
    @Test(priority = 2)
    public void verifyMainTitles() {
        new ProductsPageUser(driver).checkThatTheAllProductsTitleIsDisplayed()
                .checkThatTheFiltersTitleIsDisplayed()
                .checkThatTheCategoryTitleIsDisplayed()
                .checkThatTheBrandTitleIsDisplayed()
                .checkThatProductsCountMutedTextIsVisible();
    }

    @Epic("User Products Page")
    @Feature("Category Filter")
    @Story("Verify Category Checkboxes")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of the category filter checkboxes.")
    @Test(priority = 3)
    public void verifyCategoryCheckboxes() {
        new ProductsPageUser(driver).checkThatTheMenCheckBoxIsNotChecked()
                .clickMenCheckBox()
                .checkThatTheMenCheckBoxIsChecked()
                .clickMenCheckBox() // Uncheck
                .checkThatTheMenCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatTheWomenCheckBoxIsNotChecked()
                .clickWomenCheckBox()
                .checkThatTheWomenCheckBoxIsChecked()
                .clickWomenCheckBox() // Uncheck
                .checkThatTheWomenCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatTheKidsCheckBoxIsNotChecked()
                .clickKidsCheckBox()
                .checkThatTheKidsCheckBoxIsChecked()
                .clickKidsCheckBox() // Uncheck
                .checkThatTheKidsCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatTheAccessoriesCheckBoxIsNotChecked()
                .clickAccessoriesCheckBox()
                .checkThatTheAccessoriesCheckBoxIsChecked()
                .clickAccessoriesCheckBox() // Uncheck
                .checkThatTheAccessoriesCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatFootWearCheckBoxIsNotChecked()
                .clickFootWearCheckBox()
                .checkThatFootWearCheckBoxIsChecked()
                .clickFootWearCheckBox() // Uncheck
                .checkThatFootWearCheckBoxIsNotChecked();
    }

    @Epic("User Products Page")
    @Feature("Brand Filter")
    @Story("Verify Brand Checkboxes")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of the brand filter checkboxes.")
    @Test(priority = 4)
    public void verifyBrandCheckboxes() {
        new ProductsPageUser(driver).checkThatNikeCheckBoxIsNotChecked()
                .clickNickCheckBox()
                .checkThatNikeCheckBoxIsChecked()
                .clickNickCheckBox() // Uncheck
                .checkThatNikeCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatAdidasCheckBoxIsNotChecked()
                .clickAdidasCheckBox()
                .checkThatAdidasCheckBoxIsChecked()
                .clickAdidasCheckBox() // Uncheck
                .checkThatAdidasCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatPumaCheckBoxIsNotChecked()
                .clickPumaCheckBox()
                .checkThatPumaCheckBoxIsChecked()
                .clickPumaCheckBox() // Uncheck
                .checkThatPumaCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatLevisCheckBoxIsNotChecked()
                .clickLevisCheckBox()
                .checkThatLevisCheckBoxIsChecked()
                .clickLevisCheckBox() // Uncheck
                .checkThatLevisCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatZaraCheckBoxIsNotChecked()
                .clickZaraCheckBox()
                .checkThatZaraCheckBoxIsChecked()
                .clickZaraCheckBox() // Uncheck
                .checkThatZaraCheckBoxIsNotChecked();

        new ProductsPageUser(driver).checkThatHMCheckBoxIsNotChecked()
                .clickHMCheckBox()
                .checkThatHMCheckBoxIsChecked()
                .clickHMCheckBox() // Uncheck
                .checkThatHMCheckBoxIsNotChecked();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of the 'Sort By' dropdown options.")
    @Test(priority = 5)
    public void verifySortByFunctionality() {
        new ProductsPageUser(driver).sortByPriceLowToHigh();
        // Add assertions here to check if the products are sorted by price low to high

        new ProductsPageUser(driver).sortByPriceHighToLow();
        // Add assertions here to check if the products are sorted by price high to low

        new ProductsPageUser(driver).sortByTitleA_To_Z();
        // Add assertions here to check if the products are sorted by title A to Z

        new ProductsPageUser(driver).sortByTitleZ_To_A();
        // Add assertions here to check if the products are sorted by title Z to A
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Verify Navigation Bar Tabs")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the visibility and text of the navigation bar tabs.")
    @Test(priority = 6)
    public void verifyNavigationBarTabs() {
        new ProductsPageUser(driver)
                .checkThatProductsTabIsVisible()
                .checkThatMenTabIsVisible()
                .checkThatWomenTabIsVisible()
                .checkThatKidsTabIsVisible()
                .checkThatFootwearTabIsVisible()
                .checkThatAccessoriesTabIsVisible()
                .checkThatSearchTabIsVisible();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Home Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Home page from the Products page.")
    @Test(priority = 7)
    public void navigateToHomePage() {
        HomePage homePage = new ProductsPageUser(driver).clickNavBarHome();
        // Add assertions here to verify that you are on the Home page (e.g., check the URL or a unique element).
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Products Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Products page from within the Products page.")
    @Test(priority = 8)
    public void navigateToProductsPage() {
        new ProductsPageUser(driver).clickNavBarProducts()
                .checkProductsPageUrl();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Men Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Men category page.")
    @Test(priority = 9)
    public void navigateToMenCategory() {
        new ProductsPageUser(driver).clickNavBarMen();
        // Add assertions here to verify that you are on the Men category page (e.g., check the URL or specific filters applied).
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Women Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Women category page.")
    @Test(priority = 10)
    public void navigateToWomenCategory() {
        new ProductsPageUser(driver).clickNavBarWomen();
        // Add assertions here to verify that you are on the Women category page.
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Kids Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Kids category page.")
    @Test(priority = 11)
    public void navigateToKidsCategory() {
        new ProductsPageUser(driver).clickNavBarKids();
        // Add assertions here to verify that you are on the Kids category page.
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Footwear Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Footwear category page.")
    @Test(priority = 12)
    public void navigateToFootwearCategory() {
        new ProductsPageUser(driver).clickNavBarFootWear();
        // Add assertions here to verify that you are on the Footwear category page.
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Accessories Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Accessories category page.")
    @Test(priority = 13)
    public void navigateToAccessoriesCategory() {
        new ProductsPageUser(driver).clickNavBarAccessories();
        // Add assertions here to verify that you are on the Accessories category page.
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Search Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Search page.")
    @Test(priority = 14)
    public void navigateToSearchPage() {
        SearchPageUser searchPageUser = new ProductsPageUser(driver).clickNavBarSearch();
        // Add assertions here to verify that you are on the Search page.
    }

    @Epic("User Products Page")
    @Feature("Footer")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence of footer elements on the Products page.")
    @Test(priority = 15)
    public void verifyFooterElements() {
        // Note: You'll need to add methods to your ProductsPageUser page to interact with and assert on footer elements.
        // Assuming you add methods like checkFooterRightsReservedDisplayed, checkFooterGitHubDisplayed, etc.
        // productsPageUser.checkFooterRightsReservedDisplayed()
        //         .checkFooterGitHubDisplayed()
        //         .checkFooterLinkedInDisplayed()
        //         .checkFooterWhatsAppDisplayed();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
