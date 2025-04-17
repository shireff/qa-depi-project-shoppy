package com.shoppy.com.e2e.admin;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminAddProductPage;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminEditProductPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.*;

public class AdminProductE2E {
    public ThreadLocal<Driver> driver;
    protected LoginPage loginPage;
    private String LoginUrl = "https://shoppy-ochre.vercel.app/auth/login";
    private String imagePath = "src/test/resources/1.png";
    private String title = "Test automation Title for Edit!";
    private String description = "Test automation Description!";
    private int brandIndex = 1;
    private int categoryIndex = 1;
    private int price = 100;
    private int salePrice = 50;
    private int totalStock = 20;

    private String titleAfterEdit = "Test automation Title for Edit! AfterEdit";

    @BeforeClass
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
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
    }

    @Test(priority = 1)
    public void addingNewProduct() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
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
                .checkAddProductFormIsNotDisplayed();
    }

    @Test(priority = 2)
    public void editingTheNewProduct() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .checkProductsAreDisplayed()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkTitleFieldIsDisplayed()
                .fillTitleField(titleAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()
        ;

    }

    @Test(priority = 3)
    public void deletingTheNewProduct() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .checkProductsAreDisplayed()
                .deleteAfterUpdatedSuccessfully(titleAfterEdit)
                .checkToastMsgIsDisplayed();
    }

    @AfterClass
    public void tearDown()  {
        driver.get().browser().closeBrowser(driver.get().get());
    }

}



