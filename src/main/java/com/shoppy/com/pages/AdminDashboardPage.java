package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

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
    //private final By Drag_Drop_Click_Upload = By.xpath("//main/div/div[1]/div/div/label");
    private final By Drag_Drop_Click_Upload = By.xpath("//input [@id=\"image-upload\"]");

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
    private final By First_Image_Delete_Button = By.xpath("//main/div/div[2]/div[1]/div/button");
    private final By Second_Image_Delete_Button = By.xpath("//main/div/div[2]/div[2]/div/button");
    private final By Third_Image_Delete_Button = By.xpath("//main/div/div[2]/div[3]/div/button");
    private final By Fourth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[4]/div/button");
    private final By Fifth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[5]/div/button");
    private final By Sixth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[6]/div/button");
    private final By Seventh_Image_Delete_Button = By.xpath("//main/div/div[2]/div[7]/div/button");
    private final By Eighth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[8]/div/button");
    private final By Ninth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[9]/div/button");
    private final By Tenth_Image_Delete_Button = By.xpath("//main/div/div[2]/div[10]/div/button");

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
    //Actions
    @Step("🔃upload image selected image")
    public AdminDashboardPage uploadImageDashBoard(String path) {
        System.out.println("🔃upload image with path "+ path);
        File uploadFile = new File(path);
//        driver.element().set(Drag_Drop_Click_Upload, uploadFile.getAbsolutePath());
        driver.get().findElement(Drag_Drop_Click_Upload).sendKeys(uploadFile.getAbsolutePath());
        return this;
    }
    @Step("👆click on products button")
    public AdminProductsPage clickOnProductsBtn() {
        System.out.println("👆Clicking on products button");
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on orders button")
    public AdminPanelOrders clickOnOrdersBtn()
    {
        System.out.println("👆Clicking on orders button");
        driver.element().click(Orders_Button);
        return new AdminPanelOrders(driver);
    }
    @Step("👆click on upload image box")
    public AdminDashboardPage clickOnUploadImageBox()
    {
        System.out.println("👆Clicking on upload image box");
        driver.element().click(Drag_Drop_Click_Upload);
        return this;
    }
    @Step("👆click on upload button")
    public AdminDashboardPage clickOnUploadBtn()
    {
        System.out.println("👆Clicking on upload button");
        driver.element().click(Upload_Button);
        return this;
    }
    @Step("👆click on delete button")
    public AdminDashboardPage clickOnDeleteBtn()
    {
        System.out.println("👆Clicking on delete button");
        driver.element().click(First_Image_Delete_Button);
        return this;
    }
    @Step("👆click on logout button")
    public LoginPage clickOnLogoutBtn()
    {
        System.out.println("👆Clicking on logout button");
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }


    //Assertions
    @Step("✅Check Admin Dashboard url")
    public AdminDashboardPage checkAdminDashboardUrl()
    {
        System.out.println("✅Checking Admin dashboard url");
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }
    @Step("✅check admin panel header text")
    public AdminDashboardPage checkAdminPanelHeaderText()
    {
        System.out.println("✅check admin panel header text");
        Assert.assertTrue(ElementActions.getText(driver.get(), AdminPanel_Title).contains("Admin Panel"));
        return this;
    }
    @Step("✅check admin panel header isDisplayed")
    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        System.out.println("✅check admin panel header isDisplayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), AdminPanel_Title));
        return this;
    }
    @Step("✅check dashboard button text")
    public AdminDashboardPage checkDashboardBtnText() {
        System.out.println("✅check dashboard button text");
        Assert.assertTrue(ElementActions.getText(driver.get(), DashBoard_Button).contains("Dashboard"));
        return this;
    }
    @Step("✅check dashboard button is displayed")
    public AdminDashboardPage checkDashboardBtnDisplayed() {
        System.out.println("✅check dashboard button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), DashBoard_Button));
        return this;
    }
    @Step("✅check dashboard button text")
    public AdminDashboardPage checkProductsBtnText() {
        System.out.println("✅check dashboard button text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Products_Button).contains("Products"));
        return this;
    }
    @Step("✅check products button is displayed")
    public AdminDashboardPage checkProductsBtnDisplayed() {
        System.out.println("✅check products button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Products_Button));
        return this;
    }
    @Step("✅check orders button text")
    public AdminDashboardPage checkOrdersBtnText() {
        System.out.println("✅check orders button text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Orders_Button).contains("Orders"));
        return this;
    }
    @Step("✅check orders button is displayed")
    public AdminDashboardPage checkOrdersBtnDisplayed() {
        System.out.println("✅check orders button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Orders_Button));
        return this;
    }

    @Step("✅check logout button text")
    public AdminDashboardPage checkLogoutBtnText() {
        System.out.println("✅check logout button text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Logout_Button).contains(" Logout"));
        return this;
    }
    @Step("✅check logout button is displayed")
    public AdminDashboardPage checkLogoutBtnDisplayed() {
        System.out.println("✅check logout button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Logout_Button));
        return this;
    }
    @Step("✅check feature image title is displayed")
    public AdminDashboardPage checkFeatureImagesTitleIsDisplayed()
    {
        System.out.println("✅check feature image title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), Feature_Images_Title));
        return this;
    }
    @Step("✅check feature images text")
    public AdminDashboardPage checkFeatureImagesTitleText()
    {
        System.out.println("✅check feature images text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Feature_Images_Title).contains("Feature Images"));
        return this;
    }
    @Step("✅check upload new image title is displayed")
    public AdminDashboardPage checkUploadNewImageTitleIsDisplayed()
    {
        System.out.println("✅check upload new image title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Upload_New_Image_Title));
        return this;
    }
    @Step("✅check upload new image title text")
    public AdminDashboardPage checkUploadNewImageTitleText()
    {
        System.out.println("✅check upload new image title text");
        Assert.assertTrue(ElementActions.getText(driver.get(), Upload_New_Image_Title).contains("Upload New Image"));
        return this;
    }
    @Step("✅check upload image title is displayed")
    public AdminDashboardPage checkUploadImageTitleIsDisplayed()
    {
        System.out.println("✅check upload image title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Upload_Image_Title));
        return this;
    }
    @Step("✅check upload image title text")
    public AdminDashboardPage checkUploadImageTitleText()
    {
        System.out.println("✅check upload image title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Upload_Image_Title).contains("Upload Image"));
        return this;
    }
    @Step("✅check that upload button is displayed")
    public AdminDashboardPage checkThatUploadButtonIsDisplayed()
    {
        System.out.println("✅check that upload button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Upload_Button));
        return this;
    }
    @Step("✅check that uploaded image is displayed")
    public AdminDashboardPage checkThatUploadedImageIsDisplayed()
    {
        System.out.println("✅check that uploaded image is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Image));
        return this;
    }

}
