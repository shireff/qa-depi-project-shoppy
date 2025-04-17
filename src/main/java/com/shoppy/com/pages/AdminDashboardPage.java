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
        driver.assertion().assertElementDisplayed(By.cssSelector("svg.lucide-file"), "❌ Icon for uploaded image not visible!");
        return this;
    }

    @Step("👆click on products button")
    public AdminProductsPage clickOnProductsBtn() {
        driver.element().click(Products_Button);
        return new AdminProductsPage(driver);
    }

    @Step("👆click on orders button")
    public AdminPanelOrders clickOnOrdersBtn() {
        driver.element().click(Orders_Button);
        return new AdminPanelOrders(driver);
    }

    @Step("👆click on upload button")
    public AdminDashboardPage clickOnUploadBtn() {
        driver.element().click(Upload_Button);
        return this;
    }

    @Step("👆click on delete button")
    public AdminDashboardPage clickOnDeleteBtn() {
        driver.element().click(First_Image_Delete_Button);
        return this;
    }

    public AdminDashboardPage clickOnDeleteBtnThird() {
        driver.element().click(Third_Image_Delete_Button);
        return this;
    }

    @Step("👆click on delete button")
    public AdminDashboardPage clickOnDeleteBtnFourthImage() {
        driver.element().click(Fourth_Image_Delete_Button);
        return this;
    }

    @Step("👆click on logout button")
    public LoginPage clickOnLogoutBtn() {
        driver.element().click(Logout_Button);
        return new LoginPage(driver);
    }

    @Step("👆click on the second image delete button")
    public AdminDashboardPage clickOnDeleteBtnSecond() {
        driver.element().click(Second_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the fifth image delete button")
    public AdminDashboardPage clickOnDeleteBtnFifth() {
        driver.element().click(Fifth_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the sixth image delete button")
    public AdminDashboardPage clickOnDeleteBtnSixth() {
        driver.element().click(Sixth_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the seventh image delete button")
    public AdminDashboardPage clickOnDeleteBtnSeventh() {
        driver.element().click(Seventh_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the eighth image delete button")
    public AdminDashboardPage clickOnDeleteBtnEighth() {
        driver.element().click(Eighth_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the ninth image delete button")
    public AdminDashboardPage clickOnDeleteBtnNinth() {
        driver.element().click(Ninth_Image_Delete_Button);
        return this;
    }

    @Step("👆click on the tenth image delete button")
    public AdminDashboardPage clickOnDeleteBtnTenth() {
        driver.element().click(Tenth_Image_Delete_Button);
        return this;
    }

    @Step("👆Click on the responsive navigation menu button")
    public AdminDashboardPage clickOnResponsiveNavButton() {
        driver.browser().smallerBrowser();
        Waits.waitForElementVisible(driver.get(), Res_Nav_Button);
        driver.element().click(Res_Nav_Button);
        return this;
    }

    @Step("👆Click on the responsive dashboard button")
    public AdminDashboardPage clickOnResponsiveDashboardButton() {
        driver.element().click(DashBoard_Button_Responsive);
        return this;
    }

    @Step("👆Click on the responsive products button")
    public AdminProductsPage clickOnResponsiveProductsButton() {
        driver.element().click(Products_Button_Responsive);
        return new AdminProductsPage(driver);
    }

    @Step("👆Click on the responsive orders button")
    public AdminPanelOrders clickOnResponsiveOrdersButton() {
        driver.element().click(Orders_Button_Responsive);
        return new AdminPanelOrders(driver);
    }


    //Assertions
    @Step("✅Check Admin Dashboard url")
    public AdminDashboardPage checkAdminDashboardUrl() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), URL);
        return this;
    }

    @Step("✅check admin panel header text")
    public AdminDashboardPage checkAdminPanelHeaderText() {
        driver.assertion().assertElementTextEquals(AdminPanel_Title, "Admin Panel", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check admin panel header isDisplayed")
    public AdminDashboardPage checkAdminPanelHeaderDisplayed() {
        driver.assertion().assertElementDisplayed(AdminPanel_Title, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check dashboard button text")
    public AdminDashboardPage checkDashboardBtnText() {
        driver.assertion().assertElementTextContains(DashBoard_Button, "Dashboard", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check dashboard button is displayed")
    public AdminDashboardPage checkDashboardBtnDisplayed() {
        driver.assertion().assertElementDisplayed(DashBoard_Button, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check dashboard button text")
    public AdminDashboardPage checkProductsBtnText() {
        driver.assertion().assertElementTextContains(Products_Button, "Products", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check products button is displayed")
    public AdminDashboardPage checkProductsBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check orders button text")
    public AdminDashboardPage checkOrdersBtnText() {
        driver.assertion().assertElementTextContains(Orders_Button, "Orders", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check orders button is displayed")
    public AdminDashboardPage checkOrdersBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check logout button text")
    public AdminDashboardPage checkLogoutBtnText() {
        driver.assertion().assertElementTextEquals(Logout_Button, "Logout", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check logout button is displayed")
    public AdminDashboardPage checkLogoutBtnDisplayed() {
        driver.assertion().assertElementDisplayed(Logout_Button, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check feature image title is displayed")
    public AdminDashboardPage checkFeatureImagesTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(Feature_Images_Title, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check feature images text")
    public AdminDashboardPage checkFeatureImagesTitleText() {
        driver.assertion().assertElementTextEquals(Feature_Images_Title, "Feature Images", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check upload new image title is displayed")
    public AdminDashboardPage checkUploadNewImageTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(Upload_New_Image_Title, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check upload new image title text")
    public AdminDashboardPage checkUploadNewImageTitleText() {
        driver.assertion().assertElementTextContains(Upload_New_Image_Title, "Upload New Image", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check upload image title is displayed")
    public AdminDashboardPage checkUploadImageTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(Upload_Image_Title, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check upload image title text")
    public AdminDashboardPage checkUploadImageTitleText() {
        driver.assertion().assertElementTextContains(Upload_Image_Title, "Upload Image", "The text of the element does not match the expected value.");
        return this;
    }

    @Step("✅check that upload button is displayed")
    public AdminDashboardPage checkThatUploadButtonIsDisplayed() {
        driver.assertion().assertElementDisplayed(Upload_Button, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check that uploaded image is displayed")
    public AdminDashboardPage checkThatUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Fourth_Image);
        driver.assertion().assertElementDisplayed(Fourth_Image, "The element is not displayed as expected");
        return this;
    }


    @Step("✅Check if the responsive admin panel title is displayed")
    public AdminDashboardPage checkResponsiveAdminPanelTitleDisplayed() {
        driver.assertion().assertElementDisplayed(AdminPanel_Title_Responsive, "The responsive admin panel title is not displayed.");
        return this;
    }

    @Step("✅Check the text of the responsive admin panel title")
    public AdminDashboardPage checkResponsiveAdminPanelTitleText(String expectedText) {
        driver.assertion().assertElementTextEquals(AdminPanel_Title_Responsive, expectedText, "The responsive admin panel title text does not match.");
        return this;
    }


    @Step("✅Check if the responsive dashboard button is displayed")
    public AdminDashboardPage checkResponsiveDashboardButtonDisplayed() {
        driver.assertion().assertElementDisplayed(DashBoard_Button_Responsive, "The responsive dashboard button is not displayed.");
        return this;
    }

    @Step("✅Check the text of the responsive dashboard button")
    public AdminDashboardPage checkResponsiveDashboardButtonText(String expectedText) {
        driver.assertion().assertElementTextEquals(DashBoard_Button_Responsive, expectedText, "The responsive dashboard button text does not match.");
        return this;
    }


    @Step("✅Check if the responsive products button is displayed")
    public AdminDashboardPage checkResponsiveProductsButtonDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button_Responsive, "The responsive products button is not displayed.");
        return this;
    }

    @Step("✅Check the text of the responsive products button")
    public AdminDashboardPage checkResponsiveProductsButtonText(String expectedText) {
        driver.assertion().assertElementTextEquals(Products_Button_Responsive, expectedText, "The responsive products button text does not match.");
        return this;
    }

    @Step("✅Check if the responsive orders button is displayed")
    public AdminDashboardPage checkResponsiveOrdersButtonDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button_Responsive, "The responsive orders button is not displayed.");
        return this;
    }

    @Step("✅Check the text of the responsive orders button")
    public AdminDashboardPage checkResponsiveOrdersButtonText(String expectedText) {
        driver.assertion().assertElementTextEquals(Orders_Button_Responsive, expectedText, "The responsive orders button text does not match.");
        return this;
    }

    @Step("✅check that second uploaded image is displayed")
    public AdminDashboardPage checkThatSecondUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Second_Image);
        driver.assertion().assertElementDisplayed(Second_Image, "The second uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that third uploaded image is displayed")
    public AdminDashboardPage checkThatThirdUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Third_Image);
        driver.assertion().assertElementDisplayed(Third_Image, "The third uploaded image is not displayed as expected");
        return this;
    }

    @Step("❎check that third uploaded image is displayed")
    public AdminDashboardPage checkThatThirdUploadedImageIsNotDisplayed() {
        waitForElementVisible(driver.get(), Third_Image);
        driver.assertion().assertElementNotDisplayed(Third_Image, "The third uploaded image is not deleted as expected");
        return this;
    }

    @Step("✅check that fifth uploaded image is displayed")
    public AdminDashboardPage checkThatFifthUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Fifth_Image);
        driver.assertion().assertElementDisplayed(Fifth_Image, "The fifth uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that sixth uploaded image is displayed")
    public AdminDashboardPage checkThatSixthUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Sixth_Image);
        driver.assertion().assertElementDisplayed(Sixth_Image, "The sixth uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that seventh uploaded image is displayed")
    public AdminDashboardPage checkThatSeventhUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Seventh_Image);
        driver.assertion().assertElementDisplayed(Seventh_Image, "The seventh uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that eighth uploaded image is displayed")
    public AdminDashboardPage checkThatEighthUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Eighth_Image);
        driver.assertion().assertElementDisplayed(Eighth_Image, "The eighth uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that ninth uploaded image is displayed")
    public AdminDashboardPage checkThatNinthUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Ninth_Image);
        driver.assertion().assertElementDisplayed(Ninth_Image, "The ninth uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅check that tenth uploaded image is displayed")
    public AdminDashboardPage checkThatTenthUploadedImageIsDisplayed() {
        waitForElementVisible(driver.get(), Tenth_Image);
        driver.assertion().assertElementDisplayed(Tenth_Image, "The tenth uploaded image is not displayed as expected");
        return this;
    }

    @Step("✅Check if the footer rights reserved text is displayed")
    public AdminDashboardPage checkFooterRightsReservedDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_Rights_Reserved, "The footer rights reserved text is not displayed.");
        return this;
    }

    @Step("✅Check the text of the footer rights reserved")
    public AdminDashboardPage checkFooterRightsReservedText(String expectedText) {
        driver.assertion().assertElementTextContains(Footer_Rights_Reserved, expectedText, "The footer rights reserved text does not match.");
        return this;
    }

    @Step("✅Check if the GitHub link is displayed")
    public AdminDashboardPage checkFooterGitHubDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_GitHub, "The GitHub link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check if the LinkedIn link is displayed")
    public AdminDashboardPage checkFooterLinkedInDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_LinkedIn, "The LinkedIn link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check if the WhatsApp link is displayed")
    public AdminDashboardPage checkFooterWhatsAppDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_WhatsApp, "The WhatsApp link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check the href attribute of the GitHub link")
    public AdminDashboardPage checkFooterGitHubLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_GitHub, "href", expectedLink, "The GitHub link in the footer is incorrect.");
        return this;
    }

    @Step("✅Check the href attribute of the LinkedIn link")
    public AdminDashboardPage checkFooterLinkedInLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_LinkedIn, "href", expectedLink, "The LinkedIn link in the footer is incorrect.");
        return this;
    }

    @Step("✅Check the href attribute of the WhatsApp link")
    public AdminDashboardPage checkFooterWhatsAppLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_WhatsApp, "href", expectedLink, "The WhatsApp link in the footer is incorrect.");
        return this;
    }

    @Step("✅Check the navigation elements")
    public AdminDashboardPage verifyNavigationElements() {
        new AdminDashboardPage(driver).checkAdminPanelHeaderText().checkAdminPanelHeaderDisplayed()
                .checkDashboardBtnText().checkDashboardBtnDisplayed().checkProductsBtnText()
                .checkProductsBtnDisplayed().checkOrdersBtnText().checkOrdersBtnDisplayed();
        return this;
    }

    @Step("✅check the feature images ui")
    public AdminDashboardPage verifyFeatureImagesSectionUI() {
        new AdminDashboardPage(driver).checkThatUploadButtonIsDisplayed().checkThatUploadedImageIsDisplayed()
                .checkThatSecondUploadedImageIsDisplayed().checkThatThirdUploadedImageIsDisplayed();
        return this;
    }

    @Step("E2E footer test")
    public AdminDashboardPage verifyFooterElements() {
        new ProductsPageUser(driver)
                .checkFooterRightsReservedDisplayed()
                .checkFooterRightsReservedText("© 2025 Shireff Nady All rights reserved")
                .checkFooterGitHubDisplayed()
                .checkFooterLinkedInDisplayed()
                .checkFooterWhatsAppDisplayed()
                .checkFooterGitHubLink("https://github.com/shireff")
                .checkFooterLinkedInLink("https://www.linkedin.com/in/shireff-nady-5b7791340/")
                .checkFooterWhatsAppLink("https://wa.me/+201274068946");
        return this;
    }

    @Step("✅check admin panel header is displayed responsive")
    public AdminDashboardPage checkAdminPanelHeaderResDisplayed() {
        driver.assertion().assertElementDisplayed(AdminPanel_Title_Responsive, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check dashboard btn text responsive")
    public AdminDashboardPage checkDashboardBtnResText() {
        driver.assertion().assertElementTextEquals(DashBoard_Button_Responsive, "Dashboard", "The text of the element does not match the expected value");
        return this;
    }

    @Step("✅check dashboard btn is displayed responsive")
    public AdminDashboardPage checkDashboardBtnResDisplayed() {
        driver.assertion().assertElementDisplayed(DashBoard_Button_Responsive, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check products btn text responsive")
    public AdminDashboardPage checkProductsBtnResText() {
        driver.assertion().assertElementTextContains(Products_Button_Responsive, "Products", "The text of the element does not match the expected value");
        return this;
    }

    @Step("✅check products btn is displayed responsive")
    public AdminDashboardPage checkProductsBtnResDisplayed() {
        driver.assertion().assertElementDisplayed(Products_Button_Responsive, "The element is not displayed as expected");
        return this;
    }

    @Step("✅check orders btn is displayed responsive")
    public AdminDashboardPage checkOrdersBtnResDisplayed() {
        driver.assertion().assertElementDisplayed(Orders_Button_Responsive, "The element is not displayed as expected");
        return this;
    }

    @Step("delete multiple images")
    public AdminDashboardPage deleteMultipleUploadedImages() {
        new AdminDashboardPage(driver).clickOnDeleteBtn().clickOnDeleteBtnThird().clickOnDeleteBtnSecond();
        return this;
    }


}
