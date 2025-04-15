package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminAddProductPage {

    private final Driver driver;


    private final By addProductForm = By.xpath("//div[@role=\"dialog\"]");
    private final By addProductFormTitle = By.xpath("//div[@role=\"dialog\"]/div/h2");
    private final By addProductBtn = By.xpath("//main/div/button");
    private final By greySection = By.xpath("/html/body/span[1]");

    //    form elements
    // *************** Labels ************* //

    private final By uploadImageLabel = By.xpath("//div[@role=\"dialog\"]/div[2]/label");
    private final By uploadImageFieldLabel = By.xpath("//label[@for=\"image-upload\"]");
    private final By titleLabel = By.xpath("//label[@for=\"title\"]");
    private final By descriptionLabel = By.xpath("//label[@for=\"description\"]");
    private final By categoryLabel = By.xpath("//label[@for=\"category\"]");
    private final By brandLabel = By.xpath("//label[@for=\"brand\"]");
    private final By priceLabel = By.xpath("//label[@for=\"price\"]");
    private final By salePriceLabel = By.xpath("//label[@for=\"salePrice\"]");
    private final By totalStockLabel = By.xpath("//label[@for=\"totalStock\"]");

    // *************** Fields ************* //
    // Upload image is sendkeys thing not click!!!
    private final By uploadImageField = By.xpath("//*[@for=\"image-upload\"]");
    private final By uploadImageInputField = By.id("image-upload");
    private final By titleField = By.id("title");
    private final By descriptionField = By.id("description");

    // category
    private final String categoryOptionsXpath = "//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select/option";
    private final By categoryBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/button");
    private final By categorySelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select");
    private final By categoryOptions = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select/option");   // end category
    private List<By> categoryOptionsXpathList = new ArrayList<By>();
    private final String[] categoryOptionsList = {"Men", "Women", "Kids", "Accessories", "Footwear"};

    // brand
    private final String brandOptionsXpath = "//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option";
    private final By brandBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/button");
    private final By brandSelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select");
    private final By brandOptions = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option");
    private List<By> brandOptionsXpathList = new ArrayList<By>();
    private final String[] brandOptionsList = {"Nike", "Adidas", "Puma", "Levi's", "Zara", "H&M"};

    //end brand

    private final By priceField = By.id("price");
    private final By salePriceField = By.id("salePrice");
    private final By totalStockField = By.id("totalStock");

    private final String priceFieldID = "price";
    private final String salePriceFieldID = "salePrice";
    private final String totalStockFieldID = "totalStock";

    private final By closeAddProductFormBtn = By.xpath("//div[@role=\"dialog\"]/button");
    private final By addBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/button");

    //error msgs
    private final By titleErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[1]/div/span");
    private final By categoryErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[3]/div/span");
    private final By brandErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[4]/div/span");
    private final By priceErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[5]/div/span");
    private final By totalStockErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[7]/div/span");

    //toast msg
    private final By toastMsg = By.xpath("//li[@role=\"status\"]");
    private final By toastCloseBtn = By.xpath("//li[@role=\"status\"]/button");


    public AdminAddProductPage(Driver driver) {
        this.driver = driver;
        categoryOptionsXpathList = setOptions(categoryOptions, categoryOptionsXpath);
        brandOptionsXpathList = setOptions(brandOptions, brandOptionsXpath);
    }

    @Step("Navigate To Products Page")
    public AdminAddProductPage navigateToProductsPage() {
        driver.browser().openUrl(driver.get(), "https://shoppy-ochre.vercel.app/admin/products");
        return this;
    }

    @Step("Click On Add Product Btn")
    public AdminAddProductPage clickOnAddProductBtn() {
        driver.element().click(addProductBtn);
        return this;
    }

    public List<By> setOptions(By options, String Xpath) {
        return ElementActions.getAllElementsLocators(driver.get(), options, Xpath);
    }

    /********* form itself **********/
//    done
    @Step("Check Add Product Form Is Displayed")
    public AdminAddProductPage checkAddProductFormIsDisplayed() {
        driver.assertion().assertElementDisplayed(addProductForm, "❌ addProductForm is not displayed!");
        return this;
    }

    @Step("Check Add Product Form Title Is Displayed")
    public AdminAddProductPage checkAddProductFormTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(addProductFormTitle, "❌ addProductFormTitle is not displayed!");
        return this;
    }

    @Step("Check Add Product Form Title Text IS \"Add New Product\"")
    public AdminAddProductPage checkAddProductFormTitleText() {
        driver.assertion().assertElementTextContains(addProductFormTitle, "Add New Product", "❌ addProductFormTitle is not correct!");
        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
//    done
    @Step("Check Upload Image Label Is Displayed")
    public AdminAddProductPage checkUploadImageLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageLabel, "❌ uploadImageLabel is not displayed!");
        return this;
    }

    @Step("Check Upload Image Field Label Is Displayed")
    public AdminAddProductPage checkUploadImageFieldLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageFieldLabel, "❌ uploadImageFieldLabel is not displayed!");
        return this;
    }

    @Step("Check Title Label Is Displayed")
    public AdminAddProductPage checkTitleLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleLabel, "❌ titleLabel is not displayed!");
        return this;
    }

    @Step("Check Description Label Is Displayed")
    public AdminAddProductPage checkDescriptionLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(descriptionLabel, "❌ descriptionLabel is not displayed!");
        return this;
    }

    @Step("Check Category Label Is Displayed")
    public AdminAddProductPage checkCategoryLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryLabel, "❌ categoryLabel is not displayed!");
        return this;
    }

    @Step("Check Brand Label Is Displayed")
    public AdminAddProductPage checkBrandLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandLabel, "❌ brandLabel is not displayed!");
        return this;
    }

    @Step("Check Price Label Is Displayed")
    public AdminAddProductPage checkPriceLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceLabel, "❌ priceLabel is not displayed!");
        return this;
    }

    @Step("Check Sale Price Label Is Displayed")
    public AdminAddProductPage checkSalePriceLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(salePriceLabel, "❌ salePriceLabel is not displayed!");
        return this;
    }

    @Step("Check Total Stock Label Is Displayed")
    public AdminAddProductPage checkTotalStockLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockLabel, "❌ totalStockLabel is not displayed!");
        return this;
    }

    /*************** End labels Is Displayed *******************/

    /*************** label Text *******************/
    @Step("Check Upload Image Label Text Is \"Upload Image\"")
    public AdminAddProductPage checkUploadImageLabelText() {
        driver.assertion().assertElementTextContains(uploadImageLabel, "Upload Image", "❌ uploadImageLabel is not correct!");
        return this;
    }

    @Step("Check Upload Image Field Label Text Is \"Drag & Drop or Click to Upload\"")
    public AdminAddProductPage checkUploadImageFieldLabelText() {
        driver.assertion().assertElementTextContains(uploadImageFieldLabel, "Drag & Drop or Click to Upload", "❌ uploadImageFieldLabel is not correct!");
        return this;
    }

    @Step("Check Title Label Text Is \"Title\"")
    public AdminAddProductPage checkTitleLabelText() {
        driver.assertion().assertElementTextContains(titleLabel, "Title", "❌ titleLabel is not correct!");
        return this;
    }

    @Step("Check Description Label Text Is \"Description\"")
    public AdminAddProductPage checkDescriptionLabelText() {
        driver.assertion().assertElementTextContains(descriptionLabel, "Description", "❌ descriptionLabel is not correct!");
        return this;
    }

    @Step("Check Category Label Text Is \"Category\"")
    public AdminAddProductPage checkCategoryLabelText() {
        driver.assertion().assertElementTextContains(categoryLabel, "Category", "❌ categoryLabel is not correct!");
        return this;
    }

    @Step("Check Brand Label Text Is \"Brand\"")
    public AdminAddProductPage checkBrandLabelText() {
        driver.assertion().assertElementTextContains(brandLabel, "Brand", "❌ brandLabel is not correct!");
        return this;
    }

    @Step("Check Price Label Text Is \"Price\"")
    public AdminAddProductPage checkPriceLabelText() {
        driver.assertion().assertElementTextContains(priceLabel, "Price", "❌ priceLabel is not correct!");
        return this;
    }

    @Step("Check Sale Price Label Text Is \"Sale Price\"")
    public AdminAddProductPage checkSalePriceLabelText() {
        driver.assertion().assertElementTextContains(salePriceLabel, "Sale Price", "❌ salePriceLabel is not correct!");
        return this;
    }

    @Step("Check Total Stock Label Text Is \"Total Stock\"")
    public AdminAddProductPage checkTotalStockLabelText() {
        driver.assertion().assertElementTextContains(totalStockLabel, "Total Stock", "❌ totalStockLabel is not correct!");
        return this;
    }
    /*************** End label Text *******************/

    /***************Fields Is Displayed *******************/
//done
    @Step("Check Upload Image Field Is Displayed")
    public AdminAddProductPage checkUploadImageFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageField, "❌ uploadImageField is not displayed!");
        return this;
    }

    @Step("Check Title Field Is Displayed")
    public AdminAddProductPage checkTitleFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleField, "❌ titleField is not displayed!");
        return this;
    }

    @Step("check Description Field Is Displayed")
    public AdminAddProductPage checkDescriptionFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(descriptionField, "❌ descriptionField is not displayed!");
        return this;
    }

    @Step("Check Category Btn Is Displayed")
    public AdminAddProductPage checkCategoryBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryBtn, "❌ categoryBtn is not displayed!");
        return this;
    }

    @Step("Check Category Select Is Displayed")
    public AdminAddProductPage checkCategorySelectIsDisplayed() {
        driver.assertion().assertElementDisplayed(categorySelect, "❌ categorySelect is not displayed!");
        return this;
    }

    @Step("Check Brand Btn Is Displayed")
    public AdminAddProductPage checkBrandBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandBtn, "❌ brandBtn is not displayed!");
        return this;
    }

    @Step("Check Brand Select Is Displayed")
    public AdminAddProductPage checkBrandSelectIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandSelect, "❌ brandSelect is not displayed!");
        return this;
    }

    @Step("Check Price Field Is Displayed")
    public AdminAddProductPage checkPriceFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceField, "❌ priceField is not displayed!");
        return this;
    }

    @Step("Check Sale Price Field Is Displayed")
    public AdminAddProductPage checkSalePriceFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(salePriceField, "❌ salePriceField is not displayed!");
        return this;
    }

    @Step("Check Total Stock Field Is Displayed")
    public AdminAddProductPage checkTotalStockFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockField, "❌ totalStockField is not displayed!");
        return this;
    }
    /***************End Fields Is Displayed *******************/

    /***************Placeholder Text *******************/
    @Step("Check Title Field PlaceHolder Text Is \"Enter product title\"")
    public AdminAddProductPage checkTitleFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(titleField, "placeholder", "Enter product title", "❌ titleFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Description Field PlaceHolder Text Is \"Enter product description\"")
    public AdminAddProductPage checkDescriptionFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(descriptionField, "placeholder", "Enter product description", "❌ descriptionFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Price Field PlaceHolder Text Is \"Enter product price\"")
    public AdminAddProductPage checkPriceFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(priceField, "placeholder", "Enter product price", "❌ priceFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Sale Price Field PlaceHolder Text Is \"Enter sale price (optional)\"")
    public AdminAddProductPage checkSalePriceFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(salePriceField, "placeholder", "Enter sale price (optional)", "❌ salePriceFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Total Stock Field PlaceHolder Text Is \"Enter total stock\"")
    public AdminAddProductPage checkTotalStockFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(totalStockField, "placeholder", "Enter total stock", "❌ totalStockFieldPlaceHolder is not correct!");
        return this;
    }


    /***************End Placeholder Text *******************/
    /*************** Category & Brand btn text/default value *******************/

    @Step("Check Category Btn Text Is \"Category\"")
    public AdminAddProductPage checkCategoryBtnText() {
        driver.assertion().assertElementTextContains(categoryBtn, "Category", "❌ categoryBtn is not correct!");
        return this;
    }

    @Step("Check Brand Btn Text Is \"Brand\"")
    public AdminAddProductPage checkBrandBtnText() {
        driver.assertion().assertElementTextContains(brandBtn, "Brand", "❌ brandBtn is not correct!");
        return this;
    }
    /*************** End Category & Brand btn text/default value *******************/

    /*************** Check Category & Brand Options  *******************/

    /*************** End Check Category & Brand Options  *******************/

    /*************** Check Add btn and Close Btn Is Displayed  *******************/
    @Step("Check Add Btn Is Displayed")
    public AdminAddProductPage checkAddBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(addBtn, "❌ addBtn is not displayed!");
        return this;
    }

    @Step("Check Close Add Product Form Btn Is Displayed")
    public AdminAddProductPage checkCloseAddProductFormBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(closeAddProductFormBtn, "❌ closeAddProductFormBtn is not displayed!");
        return this;
    }
    /***************End Check Add btn and Close Btn Is Displayed  *******************/

    /***************Add btn Text  *******************/

    @Step("Check Add Btn Text Is \"Add\"")
    public AdminAddProductPage checkAddBtnText() {
        driver.assertion().assertElementTextContains(addBtn, "Add", "❌ addBtn is not correct!");
        return this;
    }
    /***************End Add btn Text  *******************/

    /***************check Add Product form is not Displayed  *******************/
    @Step("Check Add Product Form Is Not Displayed")
    public AdminAddProductPage checkAddProductFormIsNotDisplayed() {
        assertElementNotDisplayed(addProductForm, "❌ addProductForm is displayed!");
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    @Step("Check Toast Msg Is Displayed")
    public AdminAddProductPage checkToastMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(toastMsg, "❌ toastMsg is not displayed!");
        return this;
    }

    @Step("Check Toast Msg Text Is \"Product Added Successfully\"")
    public AdminAddProductPage checkToastMsgText() {
        driver.assertion().assertElementTextContains(toastMsg, "Product Added Successfully", "❌ toastMsg is not correct!");
        return this;
    }

    @Step("Check Toast Close Btn Is Displayed")
    public AdminAddProductPage checkToastCloseBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(toastCloseBtn, "❌ toastCloseBtn is not displayed!");
        return this;
    }

    @Step("Check Toast Msg Is Not Displayed")
    public AdminAddProductPage checkToastMsgIsNotDisplayed() {
        assertElementNotDisplayed(toastMsg, "❌ toastMsg is displayed!");
        return this;
    }

    /***************End Toast msg staff  *******************/
    /***************  Error Msg Is Displayed *******************/

    @Step("Check Title Error Msg Is Displayed")
    public AdminAddProductPage checkTitleErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleErrorMsg, "❌ titleErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Category Error Msg Is Displayed")
    public AdminAddProductPage checkCategoryErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryErrorMsg, "❌ categoryErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Brand Error Msg Is Displayed")
    public AdminAddProductPage checkBrandErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandErrorMsg, "❌ brandErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Price Error Msg Is Displayed")
    public AdminAddProductPage checkPriceErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceErrorMsg, "❌ priceErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Total Stock Error Msg Is Displayed")
    public AdminAddProductPage checkTotalStockErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockErrorMsg, "❌ totalStockErrorMsg is not displayed!");
        return this;
    }

    /***************  End Error Msg Is Displayed *******************/

    /***************  Error Msg Text *******************/

    @Step("Check Title Error Msg Text Is \"Title is required\"")
    public AdminAddProductPage checkTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is required", "❌ titleErrorMsg is not correct!");
        return this;
    }

    @Step("Check Category Error Msg Text Is \"Category is required\"")
    public AdminAddProductPage checkCategoryErrorMsgText() {
        driver.assertion().assertElementTextContains(categoryErrorMsg, "Category is required", "❌ categoryErrorMsg is not correct!");
        return this;
    }

    @Step("Check Brand Error Msg Text Is \"Brand is required\"")
    public AdminAddProductPage checkBrandErrorMsgText() {
        driver.assertion().assertElementTextContains(brandErrorMsg, "Brand is required", "❌ brandErrorMsg is not correct!");
        return this;
    }

    @Step("Check Price Error Msg Text Is \"Price is required\"")
    public AdminAddProductPage checkPriceErrorMsgText() {
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price is required", "❌ priceErrorMsg is not correct!");
        return this;
    }

    @Step("Check Total Stock Error Msg Text Is \"Total Stock is required\"")
    public AdminAddProductPage checkTotalStockErrorMsgText() {
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock is required", "❌ totalStockErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Price Error Msg Text Is \"Price must be greater than 0.\"")
    public AdminAddProductPage checkInvalidPriceErrorMsgText() {
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price must be greater than 0.", "❌ priceErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Total Stock Error Msg Text Is \"Total Stock must be greater than 0.\"")
    public AdminAddProductPage checkInvalidTotalStockErrorMsgText() {
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock must be greater than 0.", "❌ totalStockErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Title Error Msg Text Is \"Title is too long!\"")
    public AdminAddProductPage checkInvalidTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is too long!", "❌ titleErrorMsg is not correct!");
        return this;
    }
    /***************  End Error Msg Text *******************/

    /***************  ACTIONS  *******************/

    /***************  clicks  *******************/

    @Step("Click On Category Btn")
    public AdminAddProductPage clickOnCategoryBtn() {
        driver.element().click(categoryBtn);
        return this;
    }

    @Step("Click On Brand Btn")
    public AdminAddProductPage clickOnBrandBtn() {
        driver.element().click(brandBtn);
        return this;
    }

    @Step("Click On Close Add Product Form Btn")
    public AdminAddProductPage clickOnCloseAddProductFormBtn() {
        driver.element().click(closeAddProductFormBtn);
        return this;
    }

    @Step("Click On Add Btn")
    public AdminAddProductPage clickOnAddBtn() {
        driver.element().click(addBtn);
        return this;
    }

    @Step("Click On Toast Close Btn")
    public AdminAddProductPage clickOnToastCloseBtn() {
        driver.element().click(toastCloseBtn);
        return this;
    }

    /***************  End clicks  *******************/

    /***************  Send Keys  *******************/
    @Step("Fill Upload Image Field")
    public AdminAddProductPage fillUploadImageField(String path) {
        File uploadFile = new File(path);
        WebElement fileInput = driver.get().findElement(uploadImageInputField);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        return this;
    }

    @Step("Fill Title Field")
    public AdminAddProductPage fillTitleField(String title) {
        driver.element().set(titleField, title);
        return this;
    }

    @Step("Fill Description Field")
    public AdminAddProductPage fillDescriptionField(String description) {
        driver.element().set(descriptionField, description);
        return this;
    }

    @Step("Fill Price Field")
    public AdminAddProductPage fillPriceField(int price) {
        driver.element().setNumberField(driver.get(), priceField, price);
        return this;
    }

    @Step("Fill Sale Price Field")
    public AdminAddProductPage fillSalePriceField(int salePrice) {
        driver.element().setNumberField(driver.get(), salePriceField, salePrice);
        return this;
    }


    @Step("Fill Total Stock Field")
    public AdminAddProductPage fillTotalStockField(int totalStock) {
        driver.element().setNumberField(driver.get(), totalStockField, totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/
    /***************  Select options  *******************/

    @Step("Select Option From Category Select")
    public AdminAddProductPage selectOptionFromCategorySelect(int index) {
        driver.element().selectByIndex(categorySelect, index);
        return this;
    }

    @Step("Select Option From Brand Select")
    public AdminAddProductPage selectOptionFromBrandSelect(int index) {
        driver.element().selectByIndex(brandSelect, index);
        return this;
    }

    /***************  End ACTIONS  *******************/
    @Step("Delete After Added Successfully")
    public AdminAddProductPage deleteAfterAddedSuccessfully(String title) {
        String deleteButtonXpath = "//main//h2[contains(text(),\"" + title + "\")]/../..//button[2]";
        By deleteButton = By.xpath(deleteButtonXpath);
        if (ElementActions.isDisplayed(driver.get(), toastMsg)) {
            driver.element().click(deleteButton);
        }
        return this;
    }

    @Step("Delete After Added Successfully")
    public AdminAddProductPage deleteAfterAddedSuccessfully() {
        String deleteButtonXpath = "//main//h2[contains(text(),\"\")]/../..//button[2]";
        By deleteButton = By.xpath(deleteButtonXpath);
        if (ElementActions.isDisplayed(driver.get(), toastMsg)) {
            driver.element().click(deleteButton);
        }
        return this;
    }

    private void assertElementNotDisplayed(By locator, String errorMessage) {
        boolean isGone = Waits.waitForElementToBeInvisible(driver.get(), locator);
        if (!isGone) {
            throw new AssertionError(errorMessage);
        }
    }

}
