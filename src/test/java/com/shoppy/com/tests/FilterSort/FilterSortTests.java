package com.shoppy.com.tests.FilterSort;

import DriverFactory.Driver;
import com.shoppy.com.pages.*;
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

    @Epic("User Products Page")
    @Feature("Page Load")
    @Story("Verify Basic Elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of basic elements on the Products page.")
    @Test(priority = 1)
    public void verifyBasicElements() {
        new ProductsPageUser(driver).checkProductsPageUrl()
                .checkThatTheAllProductsTitleIsDisplayed()
                .checkThatTheFiltersTitleIsDisplayed()
                .checkThatTheCategoryTitleIsDisplayed()
                .checkThatTheBrandTitleIsDisplayed()
                .checkThatProductsCountMutedTextIsVisible();
    }

    @Epic("User Products Page")
    @Feature("Category Filter")
    @Story("Verify Category Checkboxes")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the display and checked state of the category filter checkboxes.")
    @Test(priority = 2)
    public void verifyCategoryCheckboxesDisplayAndToggle() {
        new ProductsPageUser(driver).checkThatTheMenCheckBoxIsNotChecked()
                .checkThatTheWomenCheckBoxIsNotChecked()
                .checkThatTheKidsCheckBoxIsNotChecked()
                .checkThatTheAccessoriesCheckBoxIsNotChecked()
                .checkThatFootWearCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickMenCheckBox().checkThatTheMenCheckBoxIsChecked()
                .clickMenCheckBox().checkThatTheMenCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickWomenCheckBox().checkThatTheWomenCheckBoxIsChecked()
                .clickWomenCheckBox().checkThatTheWomenCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickKidsCheckBox().checkThatTheKidsCheckBoxIsChecked()
                .clickKidsCheckBox().checkThatTheKidsCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickAccessoriesCheckBox().checkThatTheAccessoriesCheckBoxIsChecked()
                .clickAccessoriesCheckBox().checkThatTheAccessoriesCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickFootWearCheckBox().checkThatFootWearCheckBoxIsChecked()
                .clickFootWearCheckBox().checkThatFootWearCheckBoxIsNotChecked();
    }

    @Epic("User Products Page")
    @Feature("Category Filter")
    @Story("Verify Multiple Category Selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the selection of multiple category filter checkboxes.")
    @Test(priority = 3)
    public void verifyMultipleCategorySelection() {
        new ProductsPageUser(driver).clickMenCheckBox().clickWomenCheckBox()
                .checkThatTheMenCheckBoxIsChecked()
                .checkThatTheWomenCheckBoxIsChecked();
        new ProductsPageUser(driver).clickMenCheckBox().clickWomenCheckBox(); // Uncheck for subsequent tests
    }

    @Epic("User Products Page")
    @Feature("Category Filter")
    @Story("Verify Select All Categories")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the selection of all category filter checkboxes.")
    @Test(priority = 4)
    public void verifySelectAllCategories() {
        new ProductsPageUser(driver).clickMenCheckBox().clickWomenCheckBox().clickKidsCheckBox().clickAccessoriesCheckBox().clickFootWearCheckBox()
                .checkThatTheMenCheckBoxIsChecked()
                .checkThatTheWomenCheckBoxIsChecked()
                .checkThatTheKidsCheckBoxIsChecked()
                .checkThatTheAccessoriesCheckBoxIsChecked()
                .checkThatFootWearCheckBoxIsChecked();
        new ProductsPageUser(driver).clickMenCheckBox().clickWomenCheckBox().clickKidsCheckBox().clickAccessoriesCheckBox().clickFootWearCheckBox(); // Uncheck
    }

    @Epic("User Products Page")
    @Feature("Brand Filter")
    @Story("Verify Brand Checkboxes")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the display and checked state of the brand filter checkboxes.")
    @Test(priority = 5)
    public void verifyBrandCheckboxesDisplayAndToggle() {
        new ProductsPageUser(driver).checkThatNikeCheckBoxIsNotChecked()
                .checkThatAdidasCheckBoxIsNotChecked()
                .checkThatPumaCheckBoxIsNotChecked()
                .checkThatLevisCheckBoxIsNotChecked()
                .checkThatZaraCheckBoxIsNotChecked()
                .checkThatHMCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickNickCheckBox().checkThatNikeCheckBoxIsChecked()
                .clickNickCheckBox().checkThatNikeCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickAdidasCheckBox().checkThatAdidasCheckBoxIsChecked()
                .clickAdidasCheckBox().checkThatAdidasCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickPumaCheckBox().checkThatPumaCheckBoxIsChecked()
                .clickPumaCheckBox().checkThatPumaCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickLevisCheckBox().checkThatLevisCheckBoxIsChecked()
                .clickLevisCheckBox().checkThatLevisCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickZaraCheckBox().checkThatZaraCheckBoxIsChecked()
                .clickZaraCheckBox().checkThatZaraCheckBoxIsNotChecked();

        new ProductsPageUser(driver).clickHMCheckBox().checkThatHMCheckBoxIsChecked()
                .clickHMCheckBox().checkThatHMCheckBoxIsNotChecked();
    }

    @Epic("User Products Page")
    @Feature("Brand Filter")
    @Story("Verify Multiple Brand Selection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the selection of multiple brand filter checkboxes.")
    @Test(priority = 6)
    public void verifyMultipleBrandSelection() {
        new ProductsPageUser(driver).clickNickCheckBox().clickAdidasCheckBox()
                .checkThatNikeCheckBoxIsChecked()
                .checkThatAdidasCheckBoxIsChecked();
        new ProductsPageUser(driver).clickNickCheckBox().clickAdidasCheckBox(); // Uncheck
    }

    @Epic("User Products Page")
    @Feature("Brand Filter")
    @Story("Verify Select All Brands")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the selection of all brand filter checkboxes.")
    @Test(priority = 7)
    public void verifySelectAllBrands() {
        new ProductsPageUser(driver).clickNickCheckBox().clickAdidasCheckBox().clickPumaCheckBox().clickLevisCheckBox().clickZaraCheckBox().clickHMCheckBox()
                .checkThatNikeCheckBoxIsChecked()
                .checkThatAdidasCheckBoxIsChecked()
                .checkThatPumaCheckBoxIsChecked()
                .checkThatLevisCheckBoxIsChecked()
                .checkThatZaraCheckBoxIsChecked()
                .checkThatHMCheckBoxIsChecked();
        new ProductsPageUser(driver).clickNickCheckBox().clickAdidasCheckBox().clickPumaCheckBox().clickLevisCheckBox().clickZaraCheckBox().clickHMCheckBox(); // Uncheck
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Options Display")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the display of options in the 'Sort By' dropdown.")
    @Test(priority = 8)
    public void verifySortByOptionsDisplay() {

        new ProductsPageUser(driver).checkThatSortByButtonIsDisplayed();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Price Low to High")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of sorting products by price low to high.")
    @Test(priority = 9)
    public void verifySortByPriceLowToHigh() {
        new ProductsPageUser(driver).sortByPriceLowToHigh().checkThatSortByLowToHigh();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Price High to Low")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of sorting products by price high to low.")
    @Test(priority = 10)
    public void verifySortByPriceHighToLow() {
        new ProductsPageUser(driver).sortByPriceHighToLow().checkThatSortByHighToLow();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Title A to Z")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of sorting products by title A to Z.")
    @Test(priority = 11)
    public void verifySortByTitleAToZ() {
        new ProductsPageUser(driver).sortByTitleA_To_Z().checkThatSortByAToZ();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort By Title Z to A")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of sorting products by title Z to A.")
    @Test(priority = 12)
    public void verifySortByTitleZToA() {
        new ProductsPageUser(driver).sortByTitleZ_To_A().checkThatSortByZToA();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort After Category Filter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify sorting functionality after applying a category filter.")
    @Test(priority = 13)
    public void verifySortAfterCategoryFilter() {
        new ProductsPageUser(driver).clickMenCheckBox().sortByPriceLowToHigh().checkThatTheMenCheckBoxIsChecked().checkThatSortByLowToHigh();
        new ProductsPageUser(driver).clickMenCheckBox().checkThatTheMenCheckBoxIsNotChecked();
    }

    @Epic("User Products Page")
    @Feature("Sort By")
    @Story("Verify Sort After Brand Filter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify sorting functionality after applying a brand filter.")
    @Test(priority = 14)
    public void verifySortAfterBrandFilter() {
        new ProductsPageUser(driver).clickNickCheckBox().sortByTitleZ_To_A().checkThatSortByZToA();
        new ProductsPageUser(driver).clickNickCheckBox();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Verify Navigation Bar Tabs Visibility")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the visibility and text of the navigation bar tabs.")
    @Test(priority = 15)
    public void verifyNavigationBarTabsVisibility() {
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
    @Test(priority = 16)
    public void navigateToHomePage() {
         new ProductsPageUser(driver).clickNavBarHome().assertHomePageHeaderDisplayed();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Products Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Products page from within the Products page.")
    @Test(priority = 17)
    public void navigateToProductsPage() {
        new ProductsPageUser(driver).clickNavBarProducts()
                .checkProductsPageUrl();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Men Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Men category page.")
    @Test(priority = 18)
    public void navigateToMenCategory() {
        new ProductsPageUser(driver).clickNavBarMen().checkThatTheMenCheckBoxIsChecked();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Women Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Women category page.")
    @Test(priority = 19)
    public void navigateToWomenCategory() {
        new ProductsPageUser(driver).clickNavBarWomen().checkThatTheWomenCheckBoxIsChecked();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Kids Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Kids category page.")
    @Test(priority = 20)
    public void navigateToKidsCategory() {
        new ProductsPageUser(driver).clickNavBarKids().checkThatTheKidsCheckBoxIsChecked();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Footwear Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Footwear category page.")
    @Test(priority = 21)
    public void navigateToFootwearCategory() {
        new ProductsPageUser(driver).clickNavBarFootWear().checkThatFootWearCheckBoxIsChecked();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Accessories Category")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Accessories category page.")
    @Test(priority = 22)
    public void navigateToAccessoriesCategory() {
        new ProductsPageUser(driver).clickNavBarAccessories().checkThatTheAccessoriesCheckBoxIsChecked();
    }

    @Epic("User Products Page")
    @Feature("Navigation Bar")
    @Story("Navigate to Search Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the navigation to the Search page.")
    @Test(priority = 23)
    public void navigateToSearchPage() {
        new ProductsPageUser(driver).clickNavBarSearch().checkThatSearchBoxIsDisplayed();
    }

    @Epic("User Products Page")
    @Feature("Footer")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence and correctness of footer elements on the Products page.")
    @Test(priority = 24)
    public void verifyFooterElements() {
            new ProductsPageUser(driver)
                    .checkFooterRightsReservedDisplayed()
                    .checkFooterRightsReservedText("© 2025 Shireff Nady All rights reserved")
                    .checkFooterGitHubDisplayed()
                    .checkFooterLinkedInDisplayed()
                    .checkFooterWhatsAppDisplayed()
                    .checkFooterGitHubLink("https://github.com/shireff")
                    .checkFooterLinkedInLink("https://www.linkedin.com/in/shireff-nady-5b7791340/")
                    .checkFooterWhatsAppLink("https://wa.me/+201274068946");
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
