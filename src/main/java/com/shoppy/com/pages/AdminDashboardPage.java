package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage {
    private final Driver driver;
    private  final String URL="https://shoppy-ochre.vercel.app/admin/dashboard";
    private final By adminPanelHeader = By.xpath("//h2[@class=\"text-2xl font-extrabold\"]");
    private final By dashboardBtn = By.xpath("//div[@class=\"flex text-xl items-center gap-2 rounded-md px-3 py-2 text-muted-foreground hover:bg-muted hover:text-foreground cursor-pointer\"][1]");
    private final By productsBtn = By.xpath("//div[@class=\"flex text-xl items-center gap-2 rounded-md px-3 py-2 text-muted-foreground hover:bg-muted hover:text-foreground cursor-pointer\"][2]");
    private final By ordersdBtn = By.xpath("//div[@class=\"flex text-xl items-center gap-2 rounded-md px-3 py-2 text-muted-foreground hover:bg-muted hover:text-foreground cursor-pointer\"][3]");
    private final By logoutBtn = By.xpath("//div[@class=\"flex flex-1 justify-end\"]/button");

    //    /****************the rest is the footer and its buttons ************************/
    public AdminDashboardPage(Driver driver) {
        this.driver = driver;
    }

    public AdminDashboardPage checkAdminDashboardUrl() {
        Assert.assertEquals(driver.browser().getCurrentURL(), URL);
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderText() {
        Assert.assertTrue(driver.element().getTextOf(adminPanelHeader).contains("Admin Panel"));
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(adminPanelHeader));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnText() {
        Assert.assertTrue(driver.element().getTextOf(dashboardBtn).contains("Dashboard"));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(dashboardBtn));
        return this;
    }

    public AdminDashboardPage checkProductsBtnText() {
        Assert.assertTrue(driver.element().getTextOf(productsBtn).contains("Products"));
        return this;
    }

    public AdminDashboardPage checkProductsBtnDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(productsBtn));
        return this;
    }

    public AdminDashboardPage checkOrdersdBtnText() {
        Assert.assertTrue(driver.element().getTextOf(ordersdBtn).contains("Orders"));
        return this;
    }

    public AdminDashboardPage checkOrdersdBtnDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(ordersdBtn));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnText() {
        Assert.assertTrue(driver.element().getTextOf(logoutBtn).contains(" Logout"));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutBtn));
        return this;
    }

    public AdminProductsPage clickOnProductsBtn() {
        driver.element().click(productsBtn);
        return new AdminProductsPage(driver);
    }
}
