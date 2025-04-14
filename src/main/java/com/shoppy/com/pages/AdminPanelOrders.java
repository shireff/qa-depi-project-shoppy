package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminPanelOrders
{
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/admin/orders";
    //Responsive nav menu button
    private final By Res_Nav_Button = By.xpath("//header/button");
    //Admin panel responsive
    private final By AdminPanel_Title_Responsive = By.xpath("//h2/h2");
    private final By DashBoard_Button_Responsive = By.xpath("//div/div/nav/div[1]/span");
    private final By Products_Button_Responsive = By.xpath("//div/div/nav/div[2]/span");
    private final By Orders_Button_Responsive = By.xpath("//div/div/nav/div[3]/span");
    //Admin panel nav
    private final By AdminPanel_Title = By.xpath("//aside/div/h2");
    private final By DashBoard_Button = By.xpath("//nav/div[1]");
    private final By Products_Button = By.xpath("//nav/div[2]");
    private final By Orders_Button = By.xpath("//nav/div[3]");
    //logout button
    private final By Logout_Button = By.xpath("//div[1]/div/div/div/header/div/button");
    //basic locators of the page
    private final By AllOrders_Title = By.xpath("//main/div/div/div[1]/div");
    //orders table head
    private final By OrderId_Title = By.xpath("//div[2]/div/table/thead/tr/th[1]");
    private final By OrderDate_Tile = By.xpath("//div[2]/div/table/thead/tr/th[2]");
    private final By OrderStatus_Title = By.xpath("//div[2]/div/table/thead/tr/th[3]");
    private final By OrderPrice_Title = By.xpath("//div[2]/div/table/thead/tr/th[4]");
    //orders table locators
    private final By OrderId_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[1]");//tr[i]/td[i]   tr[i] for the next order
    private final By OrderDate_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[2]");//tr[i]/td[i] tr[i] for the next order
    private final By OrderStatus_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[3]");//tr[i]/td[i]   tr[i] for the next order
    private final By OrderPrice_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[4]");//tr[i]/td[i]    tr[i] for the next order
    private final By ViewOrderDetails_FirstOrder = By.xpath("//tr[1]/td[5]/button");  //tr[i]
    //footer locators
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");

    //constructors
    public AdminPanelOrders(Driver driver)
    {
        this.driver = driver;
    }
    //Actions
    @Step("👆click on the nav bar responsive button")
    public AdminPanelOrders clickOnNavigationResponsiveButton()
    {
        driver.element().click(Res_Nav_Button);
        return this;
    }
    @Step("👆click on products button")
    public AdminProductsPage clickOnProductsBtn()
    {
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on products button responsive")
    public AdminProductsPage clickOnProductsBtnRes()
    {
        driver.element().click(Products_Button_Responsive);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on dashboard button")
    public AdminDashboardPage clickOnDashboardBtn()
    {
        driver.element().click(DashBoard_Button);
        return new AdminDashboardPage(driver);
    }
    @Step("👆click on dashboard button responsive")
    public AdminDashboardPage clickOnDashboardBtnRes()
    {
        driver.element().click(DashBoard_Button_Responsive);
        return new AdminDashboardPage(driver);
    }
    @Step("👆click on view details button")
    public AdminPanelOrdersDetails clickOnViewDetailsBtn()
    {
        driver.element().click(ViewOrderDetails_FirstOrder);
        return new AdminPanelOrdersDetails(driver);
    }
    @Step("👆click on logout button")
    public LoginPage clickOnLogoutBtn()
    {
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }
    //Assertions
    @Step("✅check the the url of the current page")
    public AdminPanelOrders checkAdminPanelOrdersUrl()
    {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), url);
        return this;
    }
    @Step("✅check admin panel header text")
    public AdminPanelOrders checkAdminPanelHeaderText()
    {
        driver.assertion().assertElementTextContains(AdminPanel_Title,"Admin Panel","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check admin panel header text responsive")
    public AdminPanelOrders checkAdminPanelHeaderResText()
    {
        driver.assertion().assertElementTextEquals(AdminPanel_Title_Responsive,"Admin Panel","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check admin panel header is displayed")
    public AdminPanelOrders checkAdminPanelHeaderDisplayed()
    {
        driver.assertion().assertElementDisplayed(AdminPanel_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check admin panel header is displayed responsive")
    public AdminPanelOrders checkAdminPanelHeaderResDisplayed()
    {
        driver.assertion().assertElementDisplayed(AdminPanel_Title_Responsive,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check dashboard btn text")
    public AdminPanelOrders checkDashboardBtnText()
    {
        driver.assertion().assertElementTextEquals(DashBoard_Button,"Dashboard","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check dashboard btn text responsive")
    public AdminPanelOrders checkDashboardBtnResText()
    {
        driver.assertion().assertElementTextEquals(DashBoard_Button_Responsive,"Dashboard","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check dashboard btn is displayed")
    public AdminPanelOrders checkDashboardBtnDisplayed()
    {
        driver.assertion().assertElementDisplayed(DashBoard_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check dashboard btn is displayed responsive")
    public AdminPanelOrders checkDashboardBtnResDisplayed()
    {
        driver.assertion().assertElementDisplayed(DashBoard_Button_Responsive,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check products btn text")
    public AdminPanelOrders checkProductsBtnText()
    {
        driver.assertion().assertElementTextContains(Products_Button,"Products","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check products btn text responsive")
    public AdminPanelOrders checkProductsBtnResText()
    {
        driver.assertion().assertElementTextContains(Products_Button_Responsive,"Products","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check products btn is displayed")
    public AdminPanelOrders checkProductsBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check products btn is displayed responsive")
    public AdminPanelOrders checkProductsBtnResDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button_Responsive,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check orders btn text")
    public AdminPanelOrders checkOrdersBtnText() {
        driver.assertion().assertElementTextContains(Orders_Button,"Orders","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check orders btn text responsive")
    public AdminPanelOrders checkOrdersBtnResText() {
        driver.assertion().assertElementTextContains(Orders_Button_Responsive,"Orders","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check orders btn is displayed")
    public AdminPanelOrders checkOrdersBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check orders btn is displayed responsive")
    public AdminPanelOrders checkOrdersBtnResDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button_Responsive,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check logout button text")
    public AdminPanelOrders checkLogoutBtnText() {
        driver.assertion().assertElementTextEquals(Logout_Button,"Logout","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check logout button is displayed")
    public AdminPanelOrders checkLogoutBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Logout_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check all orders title is displayed")
    public AdminPanelOrders checkAllOrdersTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(AllOrders_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check all orders title text")
    public AdminPanelOrders checkAllOrdersTitleText()
    {
        driver.assertion().assertElementTextContains(AllOrders_Title,"All Orders","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check order id title is displayed")
    public AdminPanelOrders checkOrderIDTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderId_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order id title text")
    public AdminPanelOrders checkOrderIDTitleText()
    {
        driver.assertion().assertElementTextContains(OrderId_Title,"Order ID","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check order date title is displayed")
    public AdminPanelOrders checkOrderDateTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderDate_Tile,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order date title text")
    public AdminPanelOrders checkOrderDateTitleText()
    {
        driver.assertion().assertElementTextEquals(OrderDate_Tile,"Order Date","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check order status title is displayed")
    public AdminPanelOrders checkOrderStatusTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderStatus_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order status title text")
    public AdminPanelOrders checkOrderStatusTitleText()
    {
        driver.assertion().assertElementTextContains(OrderStatus_Title,"Order Status","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check order price title is displayed")
    public AdminPanelOrders checkOrderPriceTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderPrice_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order price title text")
    public AdminPanelOrders checkOrderPriceTitleText()
    {
        driver.assertion().assertElementTextContains(OrderPrice_Title,"Order Price","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check order id is displayed")
    public AdminPanelOrders checkOrderIDIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderId_FirstOrder,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order date is displayed")
    public AdminPanelOrders checkOrderDateIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderDate_FirstOrder,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order status is displayed")
    public AdminPanelOrders checkOrderStatusIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderStatus_FirstOrder,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check order price is displayed")
    public AdminPanelOrders checkOrderPriceIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderPrice_FirstOrder,"The element is not displayed as expected");
        return this;
    }
}
