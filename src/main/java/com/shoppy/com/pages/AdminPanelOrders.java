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
        System.out.println("👆click on the nav bar responsive button");
        driver.element().click(Res_Nav_Button);
        return this;
    }
    @Step("👆click on products button")
    public AdminProductsPage clickOnProductsBtn()
    {
        System.out.println("👆click on products button");
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on products button responsive")
    public AdminProductsPage clickOnProductsBtnRes()
    {
        System.out.println("👆click on products button responsive");
        driver.element().click(Products_Button_Responsive);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on dashboard button")
    public AdminDashboardPage clickOnDashboardBtn()
    {
        System.out.println("👆click on dashboard button");
        driver.element().click(DashBoard_Button);
        return new AdminDashboardPage(driver);
    }
    @Step("👆click on dashboard button responsive")
    public AdminDashboardPage clickOnDashboardBtnRes()
    {
        System.out.println("👆click on dashboard button responsive");
        driver.element().click(DashBoard_Button_Responsive);
        return new AdminDashboardPage(driver);
    }
    @Step("👆click on view details button")
    public AdminPanelOrdersDetails clickOnViewDetailsBtn()
    {
        System.out.println("👆click on view details button");
        driver.element().click(ViewOrderDetails_FirstOrder);
        return new AdminPanelOrdersDetails(driver);
    }
    @Step("👆click on logout button")
    public LoginPage clickOnLogoutBtn()
    {
        System.out.println("👆click on logout button");
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }
    //Assertions
    @Step("✅check the the url of the current page")
    public AdminPanelOrders checkAdminPanelOrdersUrl()
    {
        System.out.println("✅check the the url of the current page");
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), url);
        return this;
    }
    @Step("✅check admin panel header text")
    public AdminPanelOrders checkAdminPanelHeaderText()
    {
        System.out.println("✅check admin panel header text");
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title).contains("Admin Panel"));
        return this;
    }
    @Step("✅check admin panel header text responsive")
    public AdminPanelOrders checkAdminPanelHeaderResText()
    {
        System.out.println("✅check admin panel header text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title_Responsive).contains("Admin Panel"));
        return this;
    }
    @Step("✅check admin panel header is displayed")
    public AdminPanelOrders checkAdminPanelHeaderDisplayed()
    {
        System.out.println("✅check admin panel header is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title));
        return this;
    }
    @Step("✅check admin panel header is displayed responsive")
    public AdminPanelOrders checkAdminPanelHeaderResDisplayed()
    {
        System.out.println("✅check admin panel header is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title_Responsive));
        return this;
    }
    @Step("✅check dashboard btn text")
    public AdminPanelOrders checkDashboardBtnText()
    {
        System.out.println("✅check dashboard btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button).contains("Dashboard"));
        return this;
    }
    @Step("✅check dashboard btn text responsive")
    public AdminPanelOrders checkDashboardBtnResText()
    {
        System.out.println("✅check dashboard btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button_Responsive).contains("Dashboard"));
        return this;
    }
    @Step("✅check dashboard btn is displayed")
    public AdminPanelOrders checkDashboardBtnDisplayed()
    {
        System.out.println("✅check dashboard btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button));
        return this;
    }
    @Step("✅check dashboard btn is displayed responsive")
    public AdminPanelOrders checkDashboardBtnResDisplayed()
    {
        System.out.println("✅check dashboard btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button_Responsive));
        return this;
    }
    @Step("✅check products btn text")
    public AdminPanelOrders checkProductsBtnText()
    {
        System.out.println("✅check products btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button).contains("Products"));
        return this;
    }
    @Step("✅check products btn text responsive")
    public AdminPanelOrders checkProductsBtnResText()
    {
        System.out.println("✅check products btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button_Responsive).contains("Products"));
        return this;
    }
    @Step("✅check products btn is displayed")
    public AdminPanelOrders checkProductsBtnDisplayed() {
        System.out.println("✅check products btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button));
        return this;
    }
    @Step("✅check products btn is displayed responsive")
    public AdminPanelOrders checkProductsBtnResDisplayed() {
        System.out.println("✅check products btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button_Responsive));
        return this;
    }
    @Step("✅check orders btn text")
    public AdminPanelOrders checkOrdersBtnText() {
        System.out.println("✅check orders btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button).contains("Orders"));
        return this;
    }
    @Step("✅check orders btn text responsive")
    public AdminPanelOrders checkOrdersBtnResText() {
        System.out.println("✅check orders btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button_Responsive).contains("Orders"));
        return this;
    }
    @Step("✅check orders btn is displayed")
    public AdminPanelOrders checkOrdersBtnDisplayed() {
        System.out.println("✅check orders btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button));
        return this;
    }
    @Step("✅check orders btn is displayed responsive")
    public AdminPanelOrders checkOrdersBtnResDisplayed() {
        System.out.println("✅check orders btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button_Responsive));
        return this;
    }
    @Step("✅check logout button text")
    public AdminPanelOrders checkLogoutBtnText() {
        System.out.println("✅check logout button text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Logout_Button).contains(" Logout"));
        return this;
    }
    @Step("✅check logout button is displayed")
    public AdminPanelOrders checkLogoutBtnDisplayed() {
        System.out.println("✅check logout button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Logout_Button));
        return this;
    }
    @Step("✅check all orders title is displayed")
    public AdminPanelOrders checkAllOrdersTitleIsDisplayed()
    {
        System.out.println("✅check all orders title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),AllOrders_Title));
        return this;
    }
    @Step("✅check all orders title text")
    public AdminPanelOrders checkAllOrdersTitleText()
    {
        System.out.println("✅check all orders title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),AllOrders_Title).contains("All Orders"));
        return this;
    }
    @Step("✅check order id title is displayed")
    public AdminPanelOrders checkOrderIDTitleIsDisplayed()
    {
        System.out.println("✅check order id title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId_Title));
        return this;
    }
    @Step("✅check order id title text")
    public AdminPanelOrders checkOrderIDTitleText()
    {
        System.out.println("✅check order id title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderId_Title).contains("Order ID"));
        return this;
    }
    @Step("✅check order date title is displayed")
    public AdminPanelOrders checkOrderDateTitleIsDisplayed()
    {
        System.out.println("✅check order date title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate_Tile));
        return this;
    }
    @Step("✅check order date title text")
    public AdminPanelOrders checkOrderDateTitleText()
    {
        System.out.println("✅check order date title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderDate_Tile).contains("Order Date"));
        return this;
    }
    @Step("✅check order status title is displayed")
    public AdminPanelOrders checkOrderStatusTitleIsDisplayed()
    {
        System.out.println("✅check order status title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus_Title));
        return this;
    }
    @Step("✅check order status title text")
    public AdminPanelOrders checkOrderStatusTitleText()
    {
        System.out.println("✅check order status title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderStatus_Title).contains("Order Status"));
        return this;
    }
    @Step("✅check order price title is displayed")
    public AdminPanelOrders checkOrderPriceTitleIsDisplayed()
    {
        System.out.println("✅check order price title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice_Title));
        return this;
    }
    @Step("✅check order price title text")
    public AdminPanelOrders checkOrderPriceTitleText()
    {
        System.out.println("✅check order price title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderPrice_Title).contains("Order Price"));
        return this;
    }
    @Step("✅check order id is displayed")
    public AdminPanelOrders checkOrderIDIsDisplayed()
    {
        System.out.println("✅check order id is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId_FirstOrder));
        return this;
    }
    @Step("✅check order date is displayed")
    public AdminPanelOrders checkOrderDateIsDisplayed()
    {
        System.out.println("✅check order date is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate_FirstOrder));
        return this;
    }
    @Step("✅check order status is displayed")
    public AdminPanelOrders checkOrderStatusIsDisplayed()
    {
        System.out.println("✅check order status is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus_FirstOrder));
        return this;
    }
    @Step("✅check order price is displayed")
    public AdminPanelOrders checkOrderPriceIsDisplayed()
    {
        System.out.println("✅check order price is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice_FirstOrder));
        return this;
    }
}
