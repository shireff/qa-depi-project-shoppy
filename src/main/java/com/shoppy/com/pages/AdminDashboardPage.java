package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

import static com.shoppy.com.utils.Waits.waitForElementVisible;

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
    private final By click_For_Upload_Win = By.xpath("//label [@for=\"image-upload\"]");
    private final By select_Image_Upload = By.xpath("//div/input[@id=\"image-upload\"]");


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
        File uploadFile = new File(path);
        driver.get().findElement(select_Image_Upload).sendKeys(uploadFile.getAbsolutePath());
        return this;
    }
    @Step("👆click on products button")
    public AdminProductsPage clickOnProductsBtn() {
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }
    @Step("👆click on orders button")
    public AdminPanelOrders clickOnOrdersBtn()
    {
        driver.element().click(Orders_Button);
        return new AdminPanelOrders(driver);
    }
    @Step("👆click on upload button")
    public AdminDashboardPage clickOnUploadBtn()
    {
        driver.element().click(Upload_Button);
        return this;
    }
    @Step("👆click on delete button")
    public AdminDashboardPage clickOnDeleteBtn()
    {
        driver.element().click(First_Image_Delete_Button);
        return this;
    }
    public AdminDashboardPage clickOnDeleteBtnThird()
    {
        driver.element().click(Third_Image_Delete_Button);
        return this;
    }
    @Step("👆click on delete button")
    public AdminDashboardPage clickOnDeleteBtnFourthImage()
    {
        driver.element().click(Fourth_Image_Delete_Button);
        return this;
    }
    @Step("👆click on logout button")
    public LoginPage clickOnLogoutBtn()
    {
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }


    //Assertions
    @Step("✅Check Admin Dashboard url")
    public AdminDashboardPage checkAdminDashboardUrl()
    {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }
    @Step("✅check admin panel header text")
    public AdminDashboardPage checkAdminPanelHeaderText()
    {
        driver.assertion().assertElementTextEquals(AdminPanel_Title,"Admin Panel","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check admin panel header isDisplayed")
    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        driver.assertion().assertElementDisplayed(AdminPanel_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check dashboard button text")
    public AdminDashboardPage checkDashboardBtnText() {
        driver.assertion().assertElementTextContains(DashBoard_Button,"Dashboard","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check dashboard button is displayed")
    public AdminDashboardPage checkDashboardBtnDisplayed() {
        driver.assertion().assertElementDisplayed(DashBoard_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check dashboard button text")
    public AdminDashboardPage checkProductsBtnText() {
        driver.assertion().assertElementTextContains(Products_Button,"Products","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check products button is displayed")
    public AdminDashboardPage checkProductsBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check orders button text")
    public AdminDashboardPage checkOrdersBtnText() {
        driver.assertion().assertElementTextContains(Orders_Button,"Orders","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check orders button is displayed")
    public AdminDashboardPage checkOrdersBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button,"The element is not displayed as expected");
        return this;
    }

    @Step("✅check logout button text")
    public AdminDashboardPage checkLogoutBtnText() {
        driver.assertion().assertElementTextEquals(Logout_Button,"Logout","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check logout button is displayed")
    public AdminDashboardPage checkLogoutBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Logout_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check feature image title is displayed")
    public AdminDashboardPage checkFeatureImagesTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Feature_Images_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check feature images text")
    public AdminDashboardPage checkFeatureImagesTitleText()
    {
        driver.assertion().assertElementTextEquals(Feature_Images_Title,"Feature Images","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check upload new image title is displayed")
    public AdminDashboardPage checkUploadNewImageTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Upload_New_Image_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check upload new image title text")
    public AdminDashboardPage checkUploadNewImageTitleText()
    {
        driver.assertion().assertElementTextContains(Upload_New_Image_Title,"Upload New Image","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check upload image title is displayed")
    public AdminDashboardPage checkUploadImageTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Upload_Image_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check upload image title text")
    public AdminDashboardPage checkUploadImageTitleText()
    {
        driver.assertion().assertElementTextContains(Upload_Image_Title,"Upload Image","The text of the element does not match the expected value.");
        return this;
    }
    @Step("✅check that upload button is displayed")
    public AdminDashboardPage checkThatUploadButtonIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Upload_Button,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that uploaded image is displayed")
    public AdminDashboardPage checkThatUploadedImageIsDisplayed()
    {
        waitForElementVisible(driver.get(),Fourth_Image);
        driver.assertion().assertElementDisplayed(Fourth_Image,"The element is not displayed as expected");
        return this;
    }
}
