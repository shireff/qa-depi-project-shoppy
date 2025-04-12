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

    //    invalid values
    private int invalidPrice = -100;
    private int invalidSalePrice = -50;
    private int invalidTotalStock = -20;
    private String longTitle = "Test automation Title! Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!Test automation Title!";
    private String filePath = "src/test/resources/1.txt";


    @BeforeClass
    public void setup() {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
//        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
//        new AdminAddProductPage(driver.get())
//                .clickOnAddProductBtn();
    }

    @Test(priority = 1)
    public void verifyThatAllLabelsOfTheFormAreDisplayed() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
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
                .navigateToProductsPage()
                .clickOnAddProductBtn()
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
                .navigateToProductsPage()
                .clickOnAddProductBtn()
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
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkAddBtnIsDisplayed();
    }

    @Test(priority = 5)
    public void verifyThatCloseBtnXIsDisplayed() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkCloseAddProductFormBtnIsDisplayed();
    }

    @Test(priority = 6)
    public void verifyThatCloseBtnXClosesTheAddProductForm() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkCloseAddProductFormBtnIsDisplayed()
                .clickOnCloseAddProductFormBtn()
                .checkAddProductFormIsNotDisplayed();
    }

    @Test(priority = 7)
    public void validateSubmissionWithCorrectData() {
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
                .checkAddProductFormIsNotDisplayed()
        ;
    }

    @Test(priority = 8)
    public void confirmErrorMsgsAreDisplayedOnSubmittingWithEmptyFields() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .checkSalePriceFieldIsDisplayed()
                .checkTotalStockFieldIsDisplayed()
                .checkUploadImageFieldLabelIsDisplayed()
                .checkTitleFieldIsDisplayed()
                .checkDescriptionFieldIsDisplayed()
                .checkCategoryBtnIsDisplayed()
                .checkBrandBtnIsDisplayed()
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkTitleErrorMsgIsDisplayed()
                .checkTitleErrorMsgText()
                .checkBrandErrorMsgIsDisplayed()
                .checkBrandErrorMsgText()
                .checkCategoryErrorMsgIsDisplayed()
                .checkCategoryErrorMsgText()
                .checkPriceErrorMsgIsDisplayed()
                .checkPriceErrorMsgText()
                .checkTotalStockErrorMsgIsDisplayed()
                .checkTotalStockErrorMsgText()
        ;
    }

    @Test(priority = 9)
    public void ensureOptionalFieldsDoNotTriggerErrors() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
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


    //    ensure the submittion is stopped if any required field is empty
    @Test(priority = 10)
    public void ensureTitleFieldsIsRequiredAndTheSubmittionStopped() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
//                .checkTitleFieldIsDisplayed()
//                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkTitleErrorMsgIsDisplayed()
                .checkTitleErrorMsgText()
        ;
    }

    @Test(priority = 11)
    public void ensureCategoryFieldsIsRequiredAndTheSubmittionStopped() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
//                .checkCategoryBtnIsDisplayed()
//                .clickOnCategoryBtn()
//                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkCategoryErrorMsgIsDisplayed()
                .checkCategoryErrorMsgText()
        ;
    }

    @Test(priority = 12)
    public void ensureBrandFieldsIsRequiredAndTheSubmittionStopped() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
//                .checkBrandBtnIsDisplayed()
//                .clickOnBrandBtn()
//                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkBrandErrorMsgIsDisplayed()
                .checkBrandErrorMsgText()
        ;
    }

    @Test(priority = 13)
    public void ensurePriceFieldsIsRequiredAndTheSubmittionStopped() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
//                .checkPriceFieldIsDisplayed()
//                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkPriceErrorMsgIsDisplayed()
                .checkPriceErrorMsgText()
        ;
    }

    @Test(priority = 14)
    public void ensureTotalStockFieldsIsRequiredAndTheSubmittionStopped() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
//                .checkTotalStockFieldIsDisplayed()
//                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkTotalStockErrorMsgIsDisplayed()
                .checkTotalStockErrorMsgText()
        ;
    }

    // End ensure the submittion is stopped if any required field is empty

    // Invalid numbers
    @Test(priority = 15)
    public void validateSubmissionWithIncorrectValueInPriceField() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(invalidPrice)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
                .checkInvalidPriceErrorMsgText();
        ;
    }

    @Test(priority = 16)
    public void validateSubmissionWithIncorrectValueInTotalStockField() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(invalidTotalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
//                .checkInvalidTotalStockErrorMsgText();
        ;
    }

    @Test(priority = 17)
    public void validateSubmissionWithLongValueInTitleField() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(longTitle)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
//                .checkInvalidTitleErrorMsgText();
        ;
    }



    @Test(priority = 18)
    public void verifyThatTheUploadImageFieldAcceptsOnlyImages() {
        new AdminAddProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnAddProductBtn()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(price)
                .checkSalePriceFieldIsDisplayed()
//                .fillSalePriceField(salePrice)
//                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStock)
                .checkUploadImageFieldLabelIsDisplayed()
                .fillUploadImageField(filePath)
                .checkTitleFieldIsDisplayed()
                .fillTitleField(title)
//                .checkDescriptionFieldIsDisplayed()
//                .fillDescriptionField(description)
                .checkCategoryBtnIsDisplayed()
                .clickOnCategoryBtn()
                .selectOptionFromCategorySelect(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .clickOnBrandBtn()
                .selectOptionFromBrandSelect(brandIndex)
                .checkAddBtnIsDisplayed()
                .clickOnAddBtn()
                .checkAddProductFormIsDisplayed()
        ;
    }


    // End Invalid numbers


    @AfterClass
    public void tearDown() {
//        Thread.sleep(3000);
        driver.get().browser().closeBrowser(driver.get().get());
    }

}
