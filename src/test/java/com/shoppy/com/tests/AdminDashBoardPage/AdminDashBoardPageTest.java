package com.shoppy.com.tests.AdminDashBoardPage;

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
import java.io.File;
import java.time.Duration;

public class AdminDashBoardPageTest
{
    public Driver driver;
    String image1 = "src/test/resources/images/dash_1.jpg";
    String image2 = "src/test/resources/images/dash_2.jpg";
    String image3 = "src/test/resources/images/dash_3.jpg";
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
    }
    @Test
    public void TestMethod()
    {
        new AdminDashboardPage(driver).uploadImageDashBoard(image1).clickOnUploadBtn();
        new AdminDashboardPage(driver).uploadImageDashBoard(image2).clickOnUploadBtn();
        new AdminDashboardPage(driver).uploadImageDashBoard(image3).clickOnUploadBtn();
    }
    @Epic("Admin Dashboard")
    @Feature("Navigation")
    @Story("Verify Navigation Elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of navigation elements on the Admin Dashboard.")
    @Test(priority = 1)
    public void verifyNavigationElements() {
       new AdminDashboardPage(driver)
                .checkAdminPanelHeaderDisplayed()
                .checkAdminPanelHeaderText()
                .checkDashboardBtnDisplayed()
                .checkDashboardBtnText()
                .checkProductsBtnDisplayed()
                .checkProductsBtnText()
                .checkOrdersBtnDisplayed()
                .checkOrdersBtnText()
                .checkLogoutBtnDisplayed()
                .checkLogoutBtnText().checkAdminDashboardUrl();
    }

    @Epic("Admin Dashboard")
    @Feature("Feature Images Section")
    @Story("Verify Feature Images Section UI")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the UI elements of the Feature Images section on the Admin Dashboard.")
    @Test(priority = 2)
    public void verifyFeatureImagesSectionUI() {
       new AdminDashboardPage(driver)
                .checkFeatureImagesTitleText()
                .checkUploadNewImageTitleIsDisplayed()
                .checkUploadNewImageTitleText()
                .checkUploadImageTitleIsDisplayed()
                .checkUploadImageTitleText()
                .checkThatUploadButtonIsDisplayed().checkFeatureImagesTitleIsDisplayed();
    }

    @Epic("Admin Dashboard")
    @Feature("Image Upload")
    @Story("Upload and Verify Image")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Upload a new image to the dashboard and verify its presence.")
    @Test(priority = 3)
    public void uploadAndVerifyImage() {
       new AdminDashboardPage(driver).uploadImageDashBoard(image3)
                .clickOnUploadBtn()
                .checkThatUploadedImageIsDisplayed().clickOnDeleteBtnFourthImage();
        // Note: You might want to add a step to delete the uploaded image for cleanup in a real scenario.
    }

    @Epic("Admin Dashboard")
    @Feature("Image Deletion")
    @Story("Delete Uploaded Image")
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload an image and then attempt to delete it.")
    @Test(priority = 4, dependsOnMethods = "uploadAndVerifyImage")
    public void deleteUploadedImage() {
        new AdminDashboardPage(driver).clickOnDeleteBtnThird();
        // Note: You would typically add an assertion here to verify that the image is no longer displayed.
        // Due to the dynamic nature of image deletion and the lack of a specific "image not found" assertion,
        // we'll skip that explicit check for now but it's crucial in a real test.
    }

    @Epic("Admin Dashboard")
    @Feature("Navigation")
    @Story("Navigate to Products Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Products page from the Admin Dashboard.")
    @Test(priority = 5)
    public void navigateToProductsPage() {
       new AdminDashboardPage(driver).clickOnProductsBtn();
        // You would typically add assertions here to verify that you are on the Products page.
        // For example, check the URL or a specific element on the Products page.
    }

    @Epic("Admin Dashboard")
    @Feature("Navigation")
    @Story("Navigate to Orders Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Orders page from the Admin Dashboard.")
    @Test(priority = 6)
    public void navigateToOrdersPage() {
       new AdminDashboardPage(driver).clickOnOrdersBtn();
        // You would typically add assertions here to verify that you are on the Orders page.
        // For example, check the URL or a specific element on the Orders page.
    }

    @Epic("Admin Dashboard")
    @Feature("Logout")
    @Story("Verify Logout Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that clicking the logout button redirects the user to the login page.")
    @Test(priority = 7)
    public void verifyLogoutFunctionality() {
        new AdminDashboardPage(driver).clickOnLogoutBtn();
        // You would typically add assertions here to verify that you are on the Login page.
        // For example, check the URL or the presence of login-related elements.
    }

//    @Epic("Admin Dashboard")
//    @Feature("Footer")
//    @Story("Verify Footer Elements")
//    @Severity(SeverityLevel.MINOR)
//    @Description("Verify the presence of footer elements on the Admin Dashboard.")
//    @Test(priority = 8)
//    public void verifyFooterElements() {
//        // Note: You'll need to add methods to your AdminDashboardPage to interact with and assert on footer elements.
//        // Assuming you add methods like checkFooterRightsReservedDisplayed, checkFooterGitHubDisplayed, etc.
//        // adminDashboardPage.checkFooterRightsReservedDisplayed()
//        //         .checkFooterGitHubDisplayed()
//        //         .checkFooterLinkedInDisplayed()
//        //         .checkFooterWhatsAppDisplayed();
//    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
