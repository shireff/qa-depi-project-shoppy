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
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDashBoardPageTest {

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
    public void TestMethod() {
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
                .checkLogoutBtnText()
                .checkAdminDashboardUrl();
    }

    @Epic("Admin Dashboard")
    @Feature("Feature Images Section")
    @Story("Verify Feature Images Section UI")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the UI elements of the Feature Images section on the Admin Dashboard.")
    @Test(priority = 2)
    public void verifyFeatureImagesSectionUI() {
        new AdminDashboardPage(driver)
                .checkFeatureImagesTitleIsDisplayed()
                .checkFeatureImagesTitleText()
                .checkUploadNewImageTitleIsDisplayed()
                .checkUploadNewImageTitleText()
                .checkUploadImageTitleIsDisplayed()
                .checkUploadImageTitleText()
                .checkThatUploadButtonIsDisplayed();
    }

    @Epic("Admin Dashboard")
    @Feature("Image Upload")
    @Story("Upload and Verify Image")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Upload a new image to the dashboard and verify its presence.")
    @Test(priority = 3)
    public void uploadAndVerifyImage() {
        new AdminDashboardPage(driver)
                .uploadImageDashBoard(image3)
                .clickOnUploadBtn()
                .checkThatUploadedImageIsDisplayed()
                .clickOnDeleteBtnFourthImage();
    }

    @Epic("Admin Dashboard")
    @Feature("Image Deletion")
    @Story("Delete Uploaded Image")
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload an image and then attempt to delete it.")
    @Test(priority = 4, dependsOnMethods = "uploadAndVerifyImage")
    public void deleteUploadedImage() {
        new AdminDashboardPage(driver).clickOnDeleteBtnThird().checkThatThirdUploadedImageIsNotDisplayed();
    }

    @Epic("Admin Dashboard")
    @Feature("Navigation")
    @Story("Navigate to Products Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Products page from the Admin Dashboard.")
    @Test(priority = 5)
    public void navigateToProductsPage() {
        new AdminDashboardPage(driver).clickOnProductsBtn().checkProductsPageUrl();
    }

    @Epic("Admin Dashboard")
    @Feature("Navigation")
    @Story("Navigate to Orders Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Orders page from the Admin Dashboard.")
    @Test(priority = 6)
    public void navigateToOrdersPage() {
        new AdminDashboardPage(driver).clickOnOrdersBtn().checkAdminPanelOrdersUrl();
    }
    @Epic("Admin Dashboard")
    @Feature("Footer")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence and correctness of footer elements on the Admin Dashboard.")
    @Test(priority = 7)
    public void verifyFooterElements() {
        new AdminDashboardPage(driver)
                .checkFooterRightsReservedDisplayed()
                .checkFooterRightsReservedText("© 2025 Shireff Nady All rights reserved")
                .checkFooterGitHubDisplayed()
                .checkFooterLinkedInDisplayed()
                .checkFooterWhatsAppDisplayed()
                .checkFooterGitHubLink("https://github.com/shireff")
                .checkFooterLinkedInLink("https://www.linkedin.com/in/shireff-nady-5b7791340/")
                .checkFooterWhatsAppLink("https://wa.me/+201274068946");
    }
    @Epic("Admin Dashboard")
    @Feature("Responsive Navigation")
    @Story("Verify Responsive Navigation Menu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the functionality of the responsive navigation menu.")
    @Test(priority = 8)
    public void verifyResponsiveNavigationMenu() {
        new AdminDashboardPage(driver)
                .clickOnResponsiveNavButton()
                .checkResponsiveAdminPanelTitleDisplayed()
                .checkResponsiveAdminPanelTitleText("Admin Panel")
                .checkResponsiveDashboardButtonDisplayed()
                .checkResponsiveDashboardButtonText("Dashboard")
                .checkResponsiveProductsButtonDisplayed()
                .checkResponsiveProductsButtonText("Products")
                .checkResponsiveOrdersButtonDisplayed()
                .checkResponsiveOrdersButtonText("Orders");
    }
    @Epic("Admin Dashboard")
    @Feature("Image Deletion")
    @Story("Delete Multiple Uploaded Images")
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload multiple images and then attempt to delete them.")
    @Test(priority = 9, dependsOnMethods = "uploadAndVerifyImage")
    public void deleteMultipleUploadedImages() {
        AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.clickOnDeleteBtnSecond();
        adminDashboardPage.clickOnDeleteBtnFifth();
        adminDashboardPage.clickOnDeleteBtnSixth();
        adminDashboardPage.clickOnDeleteBtnSeventh();
        adminDashboardPage.clickOnDeleteBtnEighth();
        adminDashboardPage.clickOnDeleteBtnNinth();
        adminDashboardPage.clickOnDeleteBtnTenth();
    }

    @Epic("Admin Dashboard")
    @Feature("Logout")
    @Story("Verify Logout Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that clicking the logout button redirects the user to the login page.")
    @Test(priority = 10)
    public void verifyLogoutFunctionality() {
        new AdminDashboardPage(driver).clickOnLogoutBtn();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}