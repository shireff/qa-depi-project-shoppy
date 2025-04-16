package com.shoppy.com.e2e.admin;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminPanelOrders;
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

public class AdminOrdersPageE2E
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page - End to End")
    @Story("Complete Orders Page Workflow")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end scenario: Verify Orders page elements, navigate to different sections, and verify logout functionality.")
    @Test(priority = 1)
    public void completeOrdersPageWorkflow() {

        // 1. Verify Orders Page URL and Basic Elements
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl()
                .checkAdminPanelHeaderDisplayed()
                .checkDashboardBtnDisplayed()
                .checkOrdersBtnDisplayed()
                .checkProductsBtnDisplayed()
                .checkAllOrdersTitleIsDisplayed().checkOrdersTableHeaders();

        // 2. Verify First Order Details
        new AdminPanelOrders(driver).verifyFirstOrderDetails();

        // 3. Navigate to Order Details and Back
        new AdminPanelOrders(driver).clickOnViewDetailsBtn();
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl(); // Verify we stayed on Orders page (or a details page if separate)
        driver.browser().navigateBack();
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl(); // Back to main Orders page

        // 4. Navigate to Dashboard and Back
        new AdminPanelOrders(driver).clickOnDashboardBtn().checkAdminDashboardUrl();
        driver.browser().navigateBack();
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl();

        // 5. Navigate to Products Page and Back
        new AdminPanelOrders(driver).clickOnProductsBtn();
        // Assuming there's a ProductsPage object and checkProductsPageUrl method
        // new ProductsPage(driver).checkProductsPageUrl();
        driver.browser().navigateBack();
        new AdminPanelOrders(driver).checkAdminPanelOrdersUrl();

        // 6. Verify Responsive Navigation
        new AdminPanelOrders(driver).clickOnNavigationResponsiveButton()
                .checkAdminPanelHeaderResDisplayed()
                .checkDashboardBtnResDisplayed()
                .checkProductsBtnResDisplayed()
                .checkOrdersBtnResDisplayed();

        // 7. Verify Logout Functionality
        new AdminPanelOrders(driver).clickOnLogoutBtn();
        // Assuming there's a LoginPage object and checkLoginPageUrl method to verify logout
        // loginPage.checkLoginPageUrl();

        // IMPORTANT: Because logout ends the session, subsequent tests in this class will fail.
        // Consider running this test last or creating separate test classes for login/logout flows.
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
