package com.shoppy.com.tests.AdminOrdersPage;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminOrderDetailsPageTest {
    public Driver driver;

    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn().clickOnViewDetailsBtn();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Details Page URL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Admin Order Details page URL is correct.")
    @Test(priority = 1)
    public void verifyOrderDetailsPageURL() {
        new AdminPanelOrdersDetails(driver).checkAdminPanelOrdersUrl();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Details Title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Order Details' title.")
    @Test(priority = 2)
    public void verifyOrderDetailsTitle() {
        new AdminPanelOrdersDetails(driver).checkOrderDetailsTitleIsDisplayed()
                .checkOrderDetailsTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order ID Section")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Order ID title and value.")
    @Test(priority = 3)
    public void verifyOrderIDSection() {
        new AdminPanelOrdersDetails(driver).checkOrderIdTitleIsDisplayed()
                .checkOrderIdTitleText()
                .checkOrderIdIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Price Section")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Order Price title and value.")
    @Test(priority = 4)
    public void verifyOrderPriceSection() {
        new AdminPanelOrdersDetails(driver).checkOrderPriceTitleIsDisplayed()
                .checkOrderPriceTitleText()
                .checkOrderPriceIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Date Section")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Order Date title and value.")
    @Test(priority = 5)
    public void verifyOrderDateSection() {
        new AdminPanelOrdersDetails(driver).checkOrderDateTitleIsDisplayed()
                .checkOrderDateTitleText()
                .checkOrderDateIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Status Section")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the Order Status title and value.")
    @Test(priority = 6)
    public void verifyOrderStatusSection() {
        new AdminPanelOrdersDetails(driver).checkOrderStatusTitleIsDisplayed()
                .checkOrderStatusTitleText()
                .checkOrderStatusIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Order Items Title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Order Items' title.")
    @Test(priority = 7)
    public void verifyOrderItemsTitle() {
        new AdminPanelOrdersDetails(driver).checkOrderItemsTitleIsDisplayed()
                .checkOrderItemsTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Items")
    @Story("Verify Product Name Display")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the product name is displayed in the order items.")
    @Test(priority = 8)
    public void verifyProductNameDisplay() {
        new AdminPanelOrdersDetails(driver).checkProductNameIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Items")
    @Story("Verify Price Title and Value")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Price' title and the display of the price value with '$'.")
    @Test(priority = 9)
    public void verifyPriceInOrderItems() {
        new AdminPanelOrdersDetails(driver).checkPriceTitleIsDisplayed()
                .checkPriceTitleText()
                .checkPriceValueIsDisplayed()
                .checkPriceValueText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Items")
    @Story("Verify Quantity Title and Value")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and display of the 'Quantity' title and value.")
    @Test(priority = 10)
    public void verifyQuantityInOrderItems() {
        new AdminPanelOrdersDetails(driver).checkQuantityTitleIsDisplayed()
                .checkQuantityValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Items")
    @Story("Verify Total Price Display")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the display of the total price with '$' in the order items.")
    @Test(priority = 11)
    public void verifyTotalPriceInOrderItems() {
        new AdminPanelOrdersDetails(driver).checkTotalPriceValueIsDisplayed()
                .checkTotalPriceValueText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Shipping Info Title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Shipping Info' title.")
    @Test(priority = 12)
    public void verifyShippingInfoTitle() {
        new AdminPanelOrdersDetails(driver).checkShippingInfoTitleIsDisplayed()
                .checkShippingInfoTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify User Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'User' field title and value.")
    @Test(priority = 13)
    public void verifyUserFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkUserTitleIsDisplayed()
                .checkUserTitleText()
                .checkUserValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify Address Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Address' field title and value.")
    @Test(priority = 14)
    public void verifyAddressFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkAddressTitleIsDisplayed()
                .checkAddressTitleText()
                .checkAddressValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify City Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'City' field title and value.")
    @Test(priority = 15)
    public void verifyCityFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkCityTitleIsDisplayed()
                .checkCityTitleText()
                .checkCityValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify Pincode Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Pincode' field title and value.")
    @Test(priority = 16)
    public void verifyPincodeFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkPincodeTitleIsDisplayed()
                .checkPincodeTitleText()
                .checkPincodeValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify Phone Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Phone' field title and value.")
    @Test(priority = 17)
    public void verifyPhoneFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkPhoneTitleIsDisplayed()
                .checkPhoneTitleText()
                .checkPhoneValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Shipping Info")
    @Story("Verify Notes Field")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Notes' field title and value.")
    @Test(priority = 18)
    public void verifyNotesFieldInShippingInfo() {
        new AdminPanelOrdersDetails(driver).checkNotesTitleIsDisplayed()
                .checkNotesTitleText()
                .checkNotesValueIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify Order Status Dropdown Title")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the presence and text of the 'Order Status' dropdown title.")
    @Test(priority = 19)
    public void verifyOrderStatusDropdownTitle() {
        new AdminPanelOrdersDetails(driver).checkOrderStatusDropDownTitleIsDisplayed()
                .checkOrderStatusDropDownTitleText();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify Pending Status Selection")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'Pending' status can be selected from the dropdown.")
    @Test(priority = 20)
    public void verifySelectPendingStatus() {
        new AdminPanelOrdersDetails(driver).selectPendingStatus();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("Pending"); // Add this assertion
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify In Process Status Selection")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'In Process' status can be selected from the dropdown.")
    @Test(priority = 21)
    public void verifySelectInProcessStatus() {
        new AdminPanelOrdersDetails(driver).selectInProcessStatus();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("In Process");
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify In Shipping Status Selection")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'In Shipping' status can be selected from the dropdown.")
    @Test(priority = 22)
    public void verifySelectInShippingStatus() {
        new AdminPanelOrdersDetails(driver).selectInShippingStatus();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("In Shipping");
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify Delivered Status Selection")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'Delivered' status can be selected from the dropdown.")
    @Test(priority = 23)
    public void verifySelectDeliveredStatus() {
        new AdminPanelOrdersDetails(driver).selectDeliveredStatus();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("Delivered");
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page - Order Status Dropdown")
    @Story("Verify Rejected Status Selection")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'Rejected' status can be selected from the dropdown.")
    @Test(priority = 24)
    public void verifySelectRejectedStatus() {
        new AdminPanelOrdersDetails(driver).selectRejectedStatus();
        new AdminPanelOrdersDetails(driver).checkOrderStatusAfterUpdate("Rejected");
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Update Order Status Button")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'Update Order Status' button is clickable.")
    @Test(priority = 25)
    public void verifyUpdateOrderStatusButton() {
        new AdminPanelOrdersDetails(driver).clickOnUpdateOrderStatusBtn().checkOrderStatusIsDisplayed();
    }

    @Epic("Admin Panel")
    @Feature("Order Details Page")
    @Story("Verify Close Order Details Button")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that the 'Close' button on the Order Details page navigates back to the Orders list page.")
    @Test(priority = 26)
    public void verifyCloseOrderDetailsButton() {
        new AdminPanelOrdersDetails(driver).clickOnCloseDetailsBtn().checkAdminPanelOrdersUrl();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}