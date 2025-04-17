package com.shoppy.com.e2e.admin;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminPanelOrdersDetails;
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

public class AdminOrdersPageDetailsE2E
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn().clickOnViewDetailsBtn();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - End to End")
    @Story("Complete Order Details Workflow")
    @Severity(SeverityLevel.CRITICAL)
    @Description("End-to-end scenario: Verify Order Details page elements, update order status, and navigate back to the Orders list page.")
    @Test(priority = 1)
    public void completeOrderDetailsWorkflow()
    {
        // 1. Verify Order Details Page URL and Basic Elements
        new AdminPanelOrdersDetails(driver).checkAdminPanelOrdersUrl(); // Or a more specific Order Details URL check
        new AdminPanelOrdersDetails(driver).checkOrderDetailsTitleIsDisplayed();
        new AdminPanelOrdersDetails(driver).verifyOrderDetailsElements(); // Combined verification of order details sections


        // 3. Verify Shipping Info Details
        new AdminPanelOrdersDetails(driver).verifyShippingInfoDetails();

        // 4. Update Order Status
        new AdminPanelOrdersDetails(driver).selectInProcessStatus();
        new AdminPanelOrdersDetails(driver).clickOnUpdateOrderStatusBtn();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("In Process");

        // 5. Verify Dropdown Status Selection
        new AdminPanelOrdersDetails(driver).selectDeliveredStatus();
        new AdminPanelOrdersDetails(driver).clickOnUpdateOrderStatusBtn();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("Delivered");

        // 6. Navigate back to Orders Page
        new AdminPanelOrdersDetails(driver).clickOnCloseDetailsBtn();
        new AdminPanelOrdersDetails(driver).checkAdminPanelOrdersUrl();

    }
    @AfterClass
    public void TearDown()
    {
        driver.browser().closeBrowser(driver.get());
    }

}
