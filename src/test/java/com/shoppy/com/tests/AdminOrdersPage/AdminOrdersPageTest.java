package com.shoppy.com.tests.AdminOrdersPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminPanelOrders;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminOrdersPageTest
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn();
    }
    @Test
    public void TestMethod()
    {
        new AdminPanelOrders(driver).clickOnViewDetailsBtn();
    }
    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Orders Page URL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Admin Orders page URL is correct.")
    @Test(priority = 1)
    public void verifyOrdersPageURL() {
       new AdminPanelOrders(driver).checkAdminPanelOrdersUrl();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Admin Panel Header")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Admin Panel header on the Orders page.")
    @Test(priority = 2)
    public void verifyAdminPanelHeader() {
        new AdminPanelOrders(driver).checkAdminPanelHeaderDisplayed()
                .checkAdminPanelHeaderText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Admin Panel Header Responsive")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Admin Panel header in responsive view on the Orders page.")
    @Test(priority = 3)
    public void verifyAdminPanelHeaderResponsive() {
        new AdminPanelOrders(driver).clickOnNavigationResponsiveButton()
                .checkAdminPanelHeaderResDisplayed()
                .checkAdminPanelHeaderResText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Dashboard Button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Dashboard button on the Orders page.")
    @Test(priority = 4)
    public void verifyDashboardButton() {
        new AdminPanelOrders(driver).checkDashboardBtnDisplayed()
                .checkDashboardBtnText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Dashboard Button Responsive")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Dashboard button in responsive view on the Orders page.")
    @Test(priority = 5)
    public void verifyDashboardButtonResponsive() {
        new AdminPanelOrders(driver).clickOnNavigationResponsiveButton()
                .checkDashboardBtnResDisplayed()
                .checkDashboardBtnResText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Products Button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Products button on the Orders page.")
    @Test(priority = 6)
    public void verifyProductsButton() {
        new AdminPanelOrders(driver).checkProductsBtnDisplayed()
                .checkProductsBtnText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Products Button Responsive")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Products button in responsive view on the Orders page.")
    @Test(priority = 7)
    public void verifyProductsButtonResponsive() {
        new AdminPanelOrders(driver).clickOnNavigationResponsiveButton()
                .checkProductsBtnResDisplayed()
                .checkProductsBtnResText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Orders Button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Orders button on the Orders page.")
    @Test(priority = 8)
    public void verifyOrdersButton() {
        new AdminPanelOrders(driver).checkOrdersBtnDisplayed()
                .checkOrdersBtnText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Orders Button Responsive")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Orders button in responsive view on the Orders page.")
    @Test(priority = 9)
    public void verifyOrdersButtonResponsive() {
        new AdminPanelOrders(driver).clickOnNavigationResponsiveButton()
                .checkOrdersBtnResDisplayed()
                .checkOrdersBtnResText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Logout Button")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Logout button on the Orders page.")
    @Test(priority = 10)
    public void verifyLogoutButton() {
        new AdminPanelOrders(driver).checkLogoutBtnDisplayed()
                .checkLogoutBtnText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify All Orders Title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'All Orders' title on the Orders page.")
    @Test(priority = 11)
    public void verifyAllOrdersTitle() {
        new AdminPanelOrders(driver).checkAllOrdersTitleIsDisplayed()
                .checkAllOrdersTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Orders Table Headers")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the headers in the Orders table.")
    @Test(priority = 12)
    public void verifyOrdersTableHeaders() {
        new AdminPanelOrders(driver).checkOrderIDTitleIsDisplayed()
                .checkOrderIDTitleText()
                .checkOrderDateTitleIsDisplayed()
                .checkOrderDateTitleText()
                .checkOrderStatusTitleIsDisplayed()
                .checkOrderStatusTitleText()
                .checkOrderPriceTitleIsDisplayed()
                .checkOrderPriceTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify First Order Details")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence of details for the first order in the table.")
    @Test(priority = 13)
    public void verifyFirstOrderDetails() {
        new AdminPanelOrders(driver).checkOrderIDIsDisplayed()
                .checkOrderDateIsDisplayed()
                .checkOrderStatusIsDisplayed()
                .checkOrderPriceIsDisplayed();
        // You might want to add assertions to check the actual values of these fields
        // if you have test data to compare against.
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Navigate to Order Details")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Order Details page by clicking 'View Details' for the first order.")
    @Test(priority = 14)
    public void navigateToOrderDetails() {
        new AdminPanelOrders(driver).clickOnViewDetailsBtn();
        // You would typically add assertions here to verify that you are on the Order Details page.
        // For example, check the URL or the presence of specific elements on the Order Details page.
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Navigate to Dashboard from Orders Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating back to the Dashboard from the Orders page.")
    @Test(priority = 15)
    public void navigateToDashboard() {
        new AdminPanelOrders(driver).clickOnDashboardBtn();
        // You would typically add assertions here to verify that you are on the Admin Dashboard page.
        // For example, check the URL or the presence of specific elements on the Dashboard page.
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Navigate to Products Page from Orders Page")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the functionality of navigating to the Products page from the Orders page.")
    @Test(priority = 16)
    public void navigateToProducts() {
        new AdminPanelOrders(driver).clickOnProductsBtn();
        // You would typically add assertions here to verify that you are on the Admin Products page.
        // For example, check the URL or the presence of specific elements on the Products page.
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Logout from Orders Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that clicking the logout button from the Orders page redirects the user to the login page.")
    @Test(priority = 17)
    public void verifyLogout() {
        new AdminPanelOrders(driver).clickOnLogoutBtn();
        // You would typically add assertions here to verify that you are on the Login page.
        // For example, check the URL or the presence of login-related elements.
    }

    @Epic("Admin Panel")
    @Feature("Orders Page")
    @Story("Verify Footer Elements")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify the presence of footer elements on the Admin Orders page.")
    @Test(priority = 18)
    public void verifyFooterElements() {
        // Note: You'll need to add methods to your AdminPanelOrders page to interact with and assert on footer elements.
        // Assuming you add methods like checkFooterRightsReservedDisplayed, checkFooterGitHubDisplayed, etc.
        // adminPanelOrders.checkFooterRightsReservedDisplayed()
        //         .checkFooterGitHubDisplayed()
        //         .checkFooterLinkedInDisplayed()
        //         .checkFooterWhatsAppDisplayed();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
