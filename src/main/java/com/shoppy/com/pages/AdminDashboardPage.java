package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage {
    private final Driver driver;
    private final String URL = "https://shoppy-ochre.vercel.app/admin/dashboard";
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
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), adminPanelHeader).contains("Admin Panel"));
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), adminPanelHeader));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), dashboardBtn).contains("Dashboard"));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), dashboardBtn));
        return this;
    }

    public AdminDashboardPage checkProductsBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), productsBtn).contains("Products"));
        return this;
    }

    public AdminDashboardPage checkProductsBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), productsBtn));
        return this;
    }

    public AdminDashboardPage checkOrdersdBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), ordersdBtn).contains("Orders"));
        return this;
    }

    public AdminDashboardPage checkOrdersdBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), ordersdBtn));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), logoutBtn).contains(" Logout"));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), logoutBtn));
        return this;
    }

    public AdminProductsPage clickOnProductsBtn() {
        driver.element().click(productsBtn);
        return new AdminProductsPage(driver);
    }
}
