package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminDashboardPage {
    private final Driver driver;
    private final String URL = "https://shoppy-ochre.vercel.app/admin/dashboard";
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
    //Admin Dash Board the rest of the locators
    private final By Feature_Images_Title = By.xpath("//main/div/h1");
    private final By Upload_New_Image_Title = By.xpath("//main/div/div[1]/h2");
    private final By Upload_Image_Title = By.xpath("//main/div/div[1]/div/label");
    private final By Drag_Drop_Click_Upload = By.xpath("//main/div/div[1]/div/div/label");
    private final By Upload_Button = By.xpath("//main/div/div[1]/button");
    //images uploaded  locators
    private final By First_Image = By.xpath("//main/div/div[2]/div[1]/div");  //div[i]/div to go to the next image
    private final By Second_Image = By.xpath("//main/div/div[2]/div[2]/div"); //div[i]/div to go to the next image
    private final By Third_Image = By.xpath("//main/div/div[2]/div[3]/div");  //div[i]/div to go to the next image
    private final By Fourth_Image = By.xpath("//main/div/div[2]/div[4]/div"); //div[i]/div to go to the next image
    private final By Fifth_Image = By.xpath("//main/div/div[2]/div[5]/div"); //div[i]/div to go to the next image
    private final By Sixth_Image = By.xpath("//main/div/div[2]/div[6]/div"); //div[i]/div to go to the next image
    private final By Seventh_Image = By.xpath("//main/div/div[2]/div[7]/div"); //div[i]/div to go to the next image
    private final By Eighth_Image = By.xpath("//main/div/div[2]/div[8]/div"); //div[i]/div to go to the next image
    private final By Ninth_Image = By.xpath("//main/div/div[2]/div[9]/div"); //div[i]/div to go to the next image
    private final By Tenth_Image = By.xpath("//main/div/div[2]/div[10]/div"); //div[i]/div to go to the next image
    //footer locators
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");



    //    /****************the rest is the footer and its buttons ************************/
    //constructor
    public AdminDashboardPage(Driver driver) {
        this.driver = driver;
    }

    public AdminDashboardPage checkAdminDashboardUrl() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title).contains("Admin Panel"));
        return this;
    }

    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button).contains("Dashboard"));
        return this;
    }

    public AdminDashboardPage checkDashboardBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button));
        return this;
    }

    public AdminDashboardPage checkProductsBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button).contains("Products"));
        return this;
    }

    public AdminDashboardPage checkProductsBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button));
        return this;
    }

    public AdminDashboardPage checkOrdersBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button).contains("Orders"));
        return this;
    }

    public AdminDashboardPage checkOrdersBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), Logout_Button).contains(" Logout"));
        return this;
    }

    public AdminDashboardPage checkLogoutBtnDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Logout_Button));
        return this;
    }

    public AdminProductsPage clickOnProductsBtn() {
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
}
