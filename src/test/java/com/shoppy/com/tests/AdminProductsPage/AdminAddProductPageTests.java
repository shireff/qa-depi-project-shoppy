package com.shoppy.com.tests.AdminProductsPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminAddProductPage;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminProductsPage;
import com.shoppy.com.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class AdminAddProductPageTests {
    public ThreadLocal<Driver> driver;
    protected LoginPage loginPage;
    private String LoginUrl = "https://shoppy-ochre.vercel.app/auth/login";
    //    private String productsUrl = "https://shoppy-ochre.vercel.app/admin/products";
    private String imagePath = "src/test/resources/1.png";
    private String title = "Test automation Title!";
    private String description = "Test automation Description!";
    private int brandIndex = 1;
    private int categoryIndex = 1;
    private int price = 100;
    private int salePrice = 50;
    private int totalStock = 20;

    @BeforeClass
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().browser().openUrl(driver.get().get(), LoginUrl);
        loginPage = new LoginPage(driver.get());
        loginPage.setUserName("Arima@example.com");
        loginPage.setPassword("123456789");
        loginPage.clickLogin();
        new AdminDashboardPage(driver.get())
                .clickOnProductsBtn()
                .checkProductsPageUrl()
                .checkAddProductBtnIsDisplayed()
                .checkProductsAreDisplayed();
        new AdminAddProductPage(driver.get()).clickOnAddProductBtn();
    }

    @Test(priority = 1)
    public void verifyThatAllLabelsOfTheFormAreDisplayed() {
        new AdminAddProductPage(driver.get())
                .checkUploadImageLabelIsDisplayed()
                .checkUploadImageFieldLabelIsDisplayed()
                .checkTitleLabelIsDisplayed()
                .checkDescriptionLabelIsDisplayed()
                .checkCategoryLabelIsDisplayed()
                .checkBrandLabelIsDisplayed()
                .checkPriceLabelIsDisplayed()
                .checkSalePriceLabelIsDisplayed()
                .checkTotalStockLabelIsDisplayed();
    }

    @Test(priority = 2)
    public void verifyThatAllInputFieldsOfTheFormAreDisplayed() {
        new AdminAddProductPage(driver.get())
                .checkTitleFieldIsDisplayed()
                .checkDescriptionFieldIsDisplayed()
                .checkCategoryBtnIsDisplayed()
                .checkCategorySelectIsDisplayed()
                .checkBrandBtnIsDisplayed()
                .checkBrandSelectIsDisplayed()
                .checkPriceFieldIsDisplayed()
                .checkSalePriceFieldIsDisplayed()
                .checkUploadImageFieldIsDisplayed()
                .checkTotalStockFieldIsDisplayed();
    }

    @Test(priority = 3)
    public void verifyThatPlaceholdersTextIsCorrectlyWritten() {
        new AdminAddProductPage(driver.get())
                .checkTitleFieldIsDisplayed()
                .checkTitleFieldPlaceHolderText()
                .checkDescriptionFieldIsDisplayed()
                .checkDescriptionFieldPlaceHolderText()
                .checkPriceFieldIsDisplayed()
                .checkPriceFieldPlaceHolderText()
                .checkSalePriceFieldIsDisplayed()
                .checkSalePriceFieldPlaceHolderText()
                .checkTotalStockFieldIsDisplayed()
                .checkTotalStockFieldPlaceHolderText()
                .checkCategoryBtnIsDisplayed()
                .checkCategoryBtnText()
                .checkBrandBtnIsDisplayed()
                .checkBrandBtnText();
    }

    @Test(priority = 4)
    public void verifyThatAddBtnOfTheFormIsDisplayed() {
        new AdminAddProductPage(driver.get())
                .checkAddBtnIsDisplayed();
    }

    @Test(priority = 5)
    public void verifyThatCloseBtnXIsDisplayed() {
        new AdminAddProductPage(driver.get())
                .checkCloseAddProductFormBtnIsDisplayed();
    }

    @Test(priority = 6)
    public void verifyThatCloseBtnXClosesTheAddProductForm() {
        new AdminAddProductPage(driver.get())
                .checkCloseAddProductFormBtnIsDisplayed()
                .clickOnCloseAddProductFormBtn()
                .checkAddProductFormIsNotDisplayed();
    }

    @Test(priority = 7)
    public void validateSubmissionWithCorrectData() {
        new AdminAddProductPage(driver.get())
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkSalePriceFieldIsDisplayed()
                .fillSalePriceField(salePrice)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkUploadImageFieldLabelIsDisplayed()
                .fillUploadImageField(imagePath)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkDescriptionFieldIsDisplayed()
                .fillDescriptionField(description)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsNotDisplayed()
        ;
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
//        driver.get().browser().closeBrowser(driver.get().get());
    }
}
