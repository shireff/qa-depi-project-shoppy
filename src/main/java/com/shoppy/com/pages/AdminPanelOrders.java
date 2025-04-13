package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
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
    public AdminPanelOrders clickOnNavigationResponsiveButton()
    {
        System.out.println("👆click on the nav bar responsive button");
        driver.element().click(Res_Nav_Button);
        return this;
    }
    public AdminProductsPage clickOnProductsBtn()
    {
        System.out.println("👆click on products button");
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
    public AdminProductsPage clickOnProductsBtnRes()
    {
        System.out.println("👆click on products button responsive");
        driver.element().click(Products_Button_Responsive);
        return new AdminProductsPage(driver);
    }
    public AdminDashboardPage clickOnDashboardBtn()
    {
        System.out.println("👆click on dashboard button");
        driver.element().click(DashBoard_Button);
        return new AdminDashboardPage(driver);
    }
    public AdminDashboardPage clickOnDashboardBtnRes()
    {
        System.out.println("👆click on dashboard button responsive");
        driver.element().click(DashBoard_Button_Responsive);
        return new AdminDashboardPage(driver);
    }
    public AdminPanelOrdersDetails clickOnViewDetailsBtn()
    {
        System.out.println("👆click on view details button");
        driver.element().click(ViewOrderDetails_FirstOrder);
        return new AdminPanelOrdersDetails(driver);
    }
    public LoginPage clickOnLogoutBtn()
    {
        System.out.println("👆click on logout button");
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }
    //Assertions
    public AdminPanelOrders checkAdminPanelOrdersUrl()
    {
        System.out.println("✅check the the url of the current page");
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), url);
        return this;
    }
    public AdminPanelOrders checkAdminPanelHeaderText()
    {
        System.out.println("✅check admin panel header text");
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title).contains("Admin Panel"));
        return this;
    }
    public AdminPanelOrders checkAdminPanelHeaderResText()
    {
        System.out.println("✅check admin panel header text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title_Responsive).contains("Admin Panel"));
        return this;
    }

    public AdminPanelOrders checkAdminPanelHeaderDisplayed()
    {
        System.out.println("✅check admin panel header is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title));
        return this;
    }
    public AdminPanelOrders checkAdminPanelHeaderResDisplayed()
    {
        System.out.println("✅check admin panel header is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title_Responsive));
        return this;
    }

    public AdminPanelOrders checkDashboardBtnText()
    {
        System.out.println("✅check dashboard btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button).contains("Dashboard"));
        return this;
    }
    public AdminPanelOrders checkDashboardBtnResText()
    {
        System.out.println("✅check dashboard btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button_Responsive).contains("Dashboard"));
        return this;
    }
    public AdminPanelOrders checkDashboardBtnDisplayed()
    {
        System.out.println("✅check dashboard btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button));
        return this;
    }
    public AdminPanelOrders checkDashboardBtnResDisplayed()
    {
        System.out.println("✅check dashboard btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button_Responsive));
        return this;
    }
    public AdminPanelOrders checkProductsBtnText()
    {
        System.out.println("✅check products btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button).contains("Products"));
        return this;
    }
    public AdminPanelOrders checkProductsBtnResText()
    {
        System.out.println("✅check products btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button_Responsive).contains("Products"));
        return this;
    }

    public AdminPanelOrders checkProductsBtnDisplayed() {
        System.out.println("✅check products btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button));
        return this;
    }
    public AdminPanelOrders checkProductsBtnResDisplayed() {
        System.out.println("✅check products btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button_Responsive));
        return this;
    }

    public AdminPanelOrders checkOrdersBtnText() {
        System.out.println("✅check orders btn text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button).contains("Orders"));
        return this;
    }
    public AdminPanelOrders checkOrdersBtnResText() {
        System.out.println("✅check orders btn text responsive");
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button_Responsive).contains("Orders"));
        return this;
    }

    public AdminPanelOrders checkOrdersBtnDisplayed() {
        System.out.println("✅check orders btn is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button));
        return this;
    }
    public AdminPanelOrders checkOrdersBtnResDisplayed() {
        System.out.println("✅check products btn is displayed responsive");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button_Responsive));
        return this;
    }

    public AdminPanelOrders checkLogoutBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), Logout_Button).contains(" Logout"));
        return this;
    }

    public AdminPanelOrders checkLogoutBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Logout_Button));
        return this;
    }
    public AdminPanelOrders checkAllOrdersTitleIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),AllOrders_Title));
        return this;
    }
    public AdminPanelOrders checkAllOrdersTitleText()
    {
        Assert.assertTrue(ElementActions.getText(driver.get(),AllOrders_Title).contains("All Orders"));
        return this;
    }
    public AdminPanelOrders checkOrderIDTitleIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId_Title));
        return this;
    }
    public AdminPanelOrders checkOrderIDTitleText()
    {
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderId_Title).contains("Order ID"));
        return this;
    }
    public AdminPanelOrders checkOrderDateTitleIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate_Tile));
        return this;
    }
    public AdminPanelOrders checkOrderDateTitleText()
    {
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderDate_Tile).contains("Order Date"));
        return this;
    }
    public AdminPanelOrders checkOrderStatusTitleIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus_Title));
        return this;
    }
    public AdminPanelOrders checkOrderStatusTitleText()
    {
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderStatus_Title).contains("Order Status"));
        return this;
    }
    public AdminPanelOrders checkOrderPriceTitleIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice_Title));
        return this;
    }
    public AdminPanelOrders checkOrderPriceTitleText()
    {
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderPrice_Title).contains("Order Price"));
        return this;
    }
    public AdminPanelOrders checkOrderIDIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId_FirstOrder));
        return this;
    }
    public AdminPanelOrders checkOrderDateIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate_FirstOrder));
        return this;
    }
    public AdminPanelOrders checkOrderStatusIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus_FirstOrder));
        return this;
    }
    public AdminPanelOrders checkOrderPriceIsDisplayed()
    {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice_FirstOrder));
        return this;
    }




}
