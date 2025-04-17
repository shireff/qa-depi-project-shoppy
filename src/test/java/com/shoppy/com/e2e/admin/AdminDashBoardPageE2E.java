package com.shoppy.com.e2e.admin;

import DriverFactory.Driver;
import com.shoppy.com.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class AdminDashBoardPageE2E
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

    @Epic("Admin Dashboard")
    @Feature("End-to-End Dashboard Workflow")
    @Story("Complete Admin Dashboard Interaction")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end scenario: Verify dashboard elements, upload and delete images, navigate to Products and Orders pages, check responsive navigation, verify footer, and logout.")
    @Test(priority = 1)
    public void completeAdminDashboardWorkflow() {
        // 1. Verify Initial Dashboard Elements
        new AdminDashboardPage(driver).verifyNavigationElements();
        new AdminDashboardPage(driver).verifyFeatureImagesSectionUI();
        new AdminDashboardPage(driver).verifyFooterElements();
        new AdminDashboardPage(driver).clickOnResponsiveNavButton()
                .checkAdminPanelHeaderResDisplayed()
                .checkDashboardBtnResDisplayed()
                .checkProductsBtnResDisplayed()
                .checkOrdersBtnResDisplayed();

        // 2. Upload and Verify Images
        new AdminDashboardPage(driver).uploadImageDashBoard(image1).clickOnUploadBtn().checkThatUploadedImageIsDisplayed();
        new AdminDashboardPage(driver).uploadImageDashBoard(image2).clickOnUploadBtn().checkThatUploadedImageIsDisplayed();
        new AdminDashboardPage(driver).uploadImageDashBoard(image3).clickOnUploadBtn().checkThatUploadedImageIsDisplayed();

        // 3. Delete Uploaded Images
        new AdminDashboardPage(driver).deleteMultipleUploadedImages();
        new AdminDashboardPage(driver).checkThatThirdUploadedImageIsNotDisplayed(); // Verify at least one deletion

        // 4. Navigate to Products Page and Verify
        new AdminDashboardPage(driver).clickOnProductsBtn();
        new AdminProductsPage(driver).checkProductsPageUrl(); // Assuming ProductsPageAdmin has this method
        driver.browser().navigateBack();
        new AdminDashboardPage(driver).checkAdminDashboardUrl();

        // 5. Navigate to Orders Page and Verify
        new AdminDashboardPage(driver).clickOnOrdersBtn();
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl(); // Assuming AdminPanelOrders has this method
        driver.browser().navigateBack();
        new AdminDashboardPage(driver).checkAdminDashboardUrl();

        // 6. Logout and Verify
        new AdminDashboardPage(driver).clickOnLogoutBtn();
        new LoginPage(driver).checkLoginPageURL(); // Assuming LoginPage has this method
    }



    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
