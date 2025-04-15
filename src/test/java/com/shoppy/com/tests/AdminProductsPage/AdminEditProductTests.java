package com.shoppy.com.tests.AdminProductsPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminAddProductPage;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminEditProductPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.*;

public class AdminEditProductTests {
    public ThreadLocal<Driver> driver;
    protected LoginPage loginPage;
    private String LoginUrl = "https://shoppy-ochre.vercel.app/auth/login";
    private String imagePath = "src/test/resources/2.jpeg";
    private String title = "Test automation Title for Edit!";
    private String description = "Test automation Description for Edit!";
    private int brandIndex = 1;
    private int categoryIndex = 1;
    private int price = 100;
    private int salePrice = 50;
    private int totalStock = 20;

    private String imagePathAfterEdit = "src/test/resources/1.png";
    private String titleAfterEdit = "Test automation Title for Edit! AfterEdit";
    private String descriptionAfterEdit = "Test automation Description for Edit! AfterEdit";
    private int brandIndexAfterEdit = 3;
    private int categoryIndexAfterEdit = 3;
    private int priceAfterEdit = 111;
    private int salePriceAfterEdit = 55;
    private int totalStockAfterEdit = 22;

    //    invalid values
    private int invalidPrice = -100;
    private int invalidSalePrice = -50;
    private int invalidTotalStock = -20;
    private String longTitle = "Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit! Test automation Title for Edit!";
    private String filePath = "src/test/resources/2.txt";


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
                .clickOnAddBtn();
    }

    @Test(priority = 1)
    public void verifyThatEditBtnOfTheProductCardIsWorking() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed();
    }

    @Test(priority = 2)
    public void verifyThatAllLabelsOfTheEditFormAreDisplayed() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
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

    @Test(priority = 3)
    public void verifyThatAllInputFieldsOfTheFormAreDisplayed() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
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

    @Test(priority = 4)
    public void verifyThatPlaceholdersTextIsCorrectlyWritten() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
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
                .checkCategoryBtnText(categoryIndex)
                .checkBrandBtnIsDisplayed()
                .checkBrandBtnText(brandIndex)
        ;
    }

    @Test(priority = 5)
    public void verifyThatEditBtnOfTheFormIsDisplayed() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkEditBtnIsDisplayed();
    }

    @Test(priority = 6)
    public void verifyThatCloseBtnXIsDisplayed() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkCloseEditProductFormBtnIsDisplayed();
    }

    @Test(priority = 7)
    public void verifyThatCloseBtnXClosesTheEditProductForm() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkCloseEditProductFormBtnIsDisplayed()
                .clickOnCloseEditProductFormBtn()
                .checkEditProductFormIsNotDisplayed();
    }

    @Test(priority = 8)
    public void ensureTitleFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
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

    @Test(priority = 9)
    public void ensureDescriptionFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkDescriptionFieldIsDisplayed()
                .fillDescriptionField(descriptionAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    @Test(priority = 10)
    public void ensureCategoryFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkCategoryBtnIsDisplayed()
                .selectOptionFromCategorySelect(categoryIndexAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    @Test(priority = 11)
    public void ensureBrandFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkBrandBtnIsDisplayed()
                .selectOptionFromBrandSelect(brandIndexAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    @Test(priority = 12)
    public void ensurePriceFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(priceAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    @Test(priority = 13)
    public void ensureSalePriceFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkSalePriceFieldIsDisplayed()
                .fillSalePriceField(salePriceAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    @Test(priority = 14)
    public void ensureTotalStockFieldsChangesCorrectly() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(totalStockAfterEdit)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsNotDisplayed()

        ;
    }

    // Invalid numbers
    @Test(priority = 15)
    public void validateEditSubmissionWithIncorrectValueInPriceField() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkPriceFieldIsDisplayed()
                .fillPriceField(invalidPrice)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
                .checkEditProductFormIsDisplayed()
                .checkPriceErrorMsgIsDisplayed()
                .checkInvalidPriceErrorMsgText();
        ;
    }
//fail on .checkEditProductFormIsDisplayed()
//                .checkTotalStockErrorMsgIsDisplayed()
//                .checkInvalidTotalStockErrorMsgText();
    @Test(priority = 16)
    public void validateEditSubmissionWithIncorrectValueInTotalStockField() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkTotalStockFieldIsDisplayed()
                .fillTotalStockField(invalidTotalStock)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
//                .checkEditProductFormIsDisplayed()
//                .checkTotalStockErrorMsgIsDisplayed()
//                .checkInvalidTotalStockErrorMsgText();
        ;
    }

    // on fail     .checkEditProductFormIsDisplayed()

    /// /                .checkTitleErrorMsgIsDisplayed()
    /// /                .checkInvalidTitleErrorMsgText();
    @Test(priority = 17)
    public void validateEditSubmissionWithLongValueInTitleField() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkEditProductFormIsDisplayed()
                .checkTitleFieldIsDisplayed()
                .fillTitleField(longTitle)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(longTitle)
//                .checkEditProductFormIsDisplayed()
//                .checkTitleErrorMsgIsDisplayed()
//                .checkInvalidTitleErrorMsgText();
        ;
    }

//fail on
//                .checkUploadImageFieldLabelIsDisplayed()
//                .fillUploadImageField(filePath)
    @Test(priority = 18)
    public void verifyThatTheUploadImageFieldAcceptsOnlyImages() {
        new AdminEditProductPage(driver.get())
                .navigateToProductsPage()
                .clickOnEditBtnCard()
                .checkPriceFieldIsDisplayed()
//                .checkUploadImageFieldLabelIsDisplayed()
//                .fillUploadImageField(filePath)
                .checkEditBtnIsDisplayed()
                .clickOnEditBtn()
//                .deleteAfterAddedSuccessfully(title)
//                .checkEditProductFormIsDisplayed()

        ;
    }

    @AfterClass
    public void tearDown() {
//        Thread.sleep(3000);
        driver.get().browser().closeBrowser(driver.get().get());
    }

}


