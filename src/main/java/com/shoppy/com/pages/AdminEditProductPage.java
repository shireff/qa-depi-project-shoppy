package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;


public class AdminEditProductPage {

    private final Driver driver;
    // options problem
    private final By div = By.xpath("//div[@data-radix-popper-content-wrapper]");
    //
    private final By editProductForm = By.xpath("//div[@role=\"dialog\"]");
    private final By editProductFormTitle = By.xpath("//div[@role=\"dialog\"]/div/h2");
    private final By greySection = By.xpath("/html/body/span[1]");
    private final By editBtnCard = By.xpath("//main//h2[contains(text(),\"automation Title for Edit!\")]/../..//button[1]");

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
    private final String[] categoryOptionsList = {"Men", "Women", "Kids", "Accessories", "Footwear"};

    // brand
    private final String brandOptionsXpath = "//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option";
    private final By brandBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/button");
    private final By brandSelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select");
    private final By brandOptions = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option");
    private final String[] brandOptionsList = {"Nike", "Adidas", "Puma", "Levi's", "Zara", "H&M"};

    //end brand

    private final By priceField = By.id("price");
    private final By salePriceField = By.id("salePrice");
    private final By totalStockField = By.id("totalStock");

    private final String priceFieldID = "price";
    private final String salePriceFieldID = "salePrice";
    private final String totalStockFieldID = "totalStock";

    private final By closeEditProductFormBtn = By.xpath("//div[@role=\"dialog\"]/button");
    private final By editBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/button");

    //error msgs
    private final By titleErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[1]/div/span");
    private final By categoryErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[3]/div/span");
    private final By brandErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[4]/div/span");
    private final By priceErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[5]/div/span");
    private final By totalStockErrorMsg = By.xpath("//div[@role=\"dialog\"]/div/form/div/div[7]/div/span");

    //toast msg
    private final By toastMsg = By.xpath("//li[@role=\"status\"]");
    private final By toastCloseBtn = By.xpath("//li[@role=\"status\"]/button");

    //    private final String cardXpath = "//main//h2";
    private final By firstProduct = By.xpath("(//main//h2)[1]");

    public AdminEditProductPage(Driver driver) {
        this.driver = driver;
    }

    @Step("Navigate To Products Page")
    public AdminEditProductPage navigateToProductsPage() {
        driver.browser().openUrl(driver.get(), "https://shoppy-ochre.vercel.app/admin/products");
        return this;
    }

    /********* form itself **********/
//    done
    @Step("Check Edit Product Form Is Displayed")
    public AdminEditProductPage checkEditProductFormIsDisplayed() {
        driver.assertion().assertElementDisplayed(editProductForm, "❌ editProductForm is not displayed!");
        return this;
    }

    @Step("Check Edit Product Form Title Is Displayed")
    public AdminEditProductPage checkEditProductFormTitleIsDisplayed() {
        driver.assertion().assertElementDisplayed(editProductFormTitle, "❌ editProductFormTitle is not displayed!");
        return this;
    }

    @Step("Check Edit Product Form Title Text Is \"Edit Product\"")
    public AdminEditProductPage checkEditProductFormTitleText() {
        driver.assertion().assertElementTextContains(editProductFormTitle, "Edit Product", "❌ editProductFormTitle is not correct!");
        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
//    done
    @Step("Check Upload Image Label Is Displayed")
    public AdminEditProductPage checkUploadImageLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageLabel, "❌ uploadImageLabel is not displayed!");
        return this;
    }

    @Step("Check Upload Image Field Label Is Displayed")
    public AdminEditProductPage checkUploadImageFieldLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageFieldLabel, "❌ uploadImageFieldLabel is not displayed!");
        return this;
    }

    @Step("Check Title Label Is Displayed")
    public AdminEditProductPage checkTitleLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleLabel, "❌ titleLabel is not displayed!");
        return this;
    }

    @Step("Check Description Label Is Displayed")
    public AdminEditProductPage checkDescriptionLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(descriptionLabel, "❌ descriptionLabel is not displayed!");
        return this;
    }

    @Step("Check Category Label Is Displayed")
    public AdminEditProductPage checkCategoryLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryLabel, "❌ categoryLabel is not displayed!");
        return this;
    }

    @Step("Check Brand Label Is Displayed")
    public AdminEditProductPage checkBrandLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandLabel, "❌ brandLabel is not displayed!");
        return this;
    }

    @Step("Check Price Label Is Displayed")
    public AdminEditProductPage checkPriceLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceLabel, "❌ priceLabel is not displayed!");
        return this;
    }

    @Step("Check Sale Price Label Is Displayed")
    public AdminEditProductPage checkSalePriceLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(salePriceLabel, "❌ salePriceLabel is not displayed!");
        return this;
    }

    @Step("Check Total Stock Label Is Displayed")
    public AdminEditProductPage checkTotalStockLabelIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockLabel, "❌ totalStockLabel is not displayed!");
        return this;
    }

    /*************** End labels Is Displayed *******************/

    /*************** label Text *******************/

    @Step("Check Upload Image Label Text Is \"Upload Image\"")
    public AdminEditProductPage checkUploadImageLabelText() {
        driver.assertion().assertElementTextContains(uploadImageLabel, "Upload Image", "❌ uploadImageLabel is not correct!");
        return this;
    }

    @Step("Check Upload Image Field Label Text Is \"Drag & Drop or Click to Upload\"")
    public AdminEditProductPage checkUploadImageFieldLabelText() {
        driver.assertion().assertElementTextContains(uploadImageFieldLabel, "Drag & Drop or Click to Upload", "❌ uploadImageFieldLabel is not correct!");
        return this;
    }

    @Step("Check Title Label Text Is \"Title\"")
    public AdminEditProductPage checkTitleLabelText() {
        driver.assertion().assertElementTextContains(titleLabel, "Title", "❌ titleLabel is not correct!");
        return this;
    }

    @Step("Check Description Label Text Is \"Description\"")
    public AdminEditProductPage checkDescriptionLabelText() {
        driver.assertion().assertElementTextContains(descriptionLabel, "Description", "❌ descriptionLabel is not correct!");
        return this;
    }

    @Step("Check Category Label Text Is \"Category\"")
    public AdminEditProductPage checkCategoryLabelText() {
        driver.assertion().assertElementTextContains(categoryLabel, "Category", "❌ categoryLabel is not correct!");
        return this;
    }

    @Step("Check Brand Label Text Is \"Brand\"")
    public AdminEditProductPage checkBrandLabelText() {
        driver.assertion().assertElementTextContains(brandLabel, "Brand", "❌ brandLabel is not correct!");
        return this;
    }

    @Step("Check Price Label Text Is \"Price\"")
    public AdminEditProductPage checkPriceLabelText() {
        driver.assertion().assertElementTextContains(priceLabel, "Price", "❌ priceLabel is not correct!");
        return this;
    }

    @Step("Check Sale Price Label Text Is \"Sale Price\"")
    public AdminEditProductPage checkSalePriceLabelText() {
        driver.assertion().assertElementTextContains(salePriceLabel, "Sale Price", "❌ salePriceLabel is not correct!");
        return this;
    }

    @Step("Check Total Stock Label Text Is \"Total Stock\"")
    public AdminEditProductPage checkTotalStockLabelText() {
        driver.assertion().assertElementTextContains(totalStockLabel, "Total Stock", "❌ totalStockLabel is not correct!");
        return this;
    }
    /*************** End label Text *******************/

    /***************Fields Is Displayed *******************/
//done
    @Step("Check Upload Image Field Is Displayed")
    public AdminEditProductPage checkUploadImageFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(uploadImageField, "❌ uploadImageField is not displayed!");
        return this;
    }

    @Step("Check Title Field Is Displayed")
    public AdminEditProductPage checkTitleFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleField, "❌ titleField is not displayed!");
        return this;
    }

    @Step("Check Description Field Is Displayed")
    public AdminEditProductPage checkDescriptionFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(descriptionField, "❌ descriptionField is not displayed!");
        return this;
    }

    @Step("Check Category Btn Is Displayed")
    public AdminEditProductPage checkCategoryBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryBtn, "❌ categoryBtn is not displayed!");
        return this;
    }

    @Step("Check Category Select Is Displayed")
    public AdminEditProductPage checkCategorySelectIsDisplayed() {
        driver.assertion().assertElementDisplayed(categorySelect, "❌ categorySelect is not displayed!");
        return this;
    }

    @Step("Check Brand Btn Is Displayed")
    public AdminEditProductPage checkBrandBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandBtn, "❌ brandBtn is not displayed!");
        return this;
    }

    @Step("Check Brand Select Is Displayed")
    public AdminEditProductPage checkBrandSelectIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandSelect, "❌ brandSelect is not displayed!");
        return this;
    }

    @Step("Check Price Field Is Displayed")
    public AdminEditProductPage checkPriceFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceField, "❌ priceField is not displayed!");
        return this;
    }

    @Step("Check Sale Price Field Is Displayed")
    public AdminEditProductPage checkSalePriceFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(salePriceField, "❌ salePriceField is not displayed!");
        return this;
    }

    @Step("Check Total Stock Field Is Displayed")
    public AdminEditProductPage checkTotalStockFieldIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockField, "❌ totalStockField is not displayed!");
        return this;
    }
    /***************End Fields Is Displayed *******************/

    /***************Placeholder Text *******************/

    @Step("Check Title Field PlaceHolder Text \"Enter product title\"")
    public AdminEditProductPage checkTitleFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(titleField, "placeholder", "Enter product title", "❌ titleFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Description Field PlaceHolder Text \"Enter product description\"")
    public AdminEditProductPage checkDescriptionFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(descriptionField, "placeholder", "Enter product description", "❌ descriptionFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Price Field PlaceHolder Text \"Enter product price\"")
    public AdminEditProductPage checkPriceFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(priceField, "placeholder", "Enter product price", "❌ priceFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Sale Price Field PlaceHolder Text \"Enter sale price (optional)\"")
    public AdminEditProductPage checkSalePriceFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(salePriceField, "placeholder", "Enter sale price (optional)", "❌ salePriceFieldPlaceHolder is not correct!");
        return this;
    }

    @Step("Check Total Stock Field PlaceHolder Text \"Enter total stock\"")
    public AdminEditProductPage checkTotalStockFieldPlaceHolderText() {
        driver.assertion().assertElementAttributeEquals(totalStockField, "placeholder", "Enter total stock", "❌ totalStockFieldPlaceHolder is not correct!");
        return this;
    }


    /***************End Placeholder Text *******************/
    /*************** Category & Brand btn text/default value *******************/

    @Step("Check Category Btn Text Is The Same As The Chosen One")
    public AdminEditProductPage checkCategoryBtnText(int index) {
        driver.assertion().assertElementTextContains(categoryBtn, categoryOptionsList[index], "❌ categoryBtn is not correct!");
        return this;
    }

    @Step("Check Brand Btn Text Is The Same As The Chosen One")
    public AdminEditProductPage checkBrandBtnText(int index) {
        driver.assertion().assertElementTextContains(brandBtn, brandOptionsList[index], "❌ brandBtn is not correct!");
        return this;
    }
    /*************** End Category & Brand btn text/default value *******************/

    /*************** Check Add btn and Close Btn Is Displayed  *******************/
    @Step("Check Edit Btn Is Displayed")
    public AdminEditProductPage checkEditBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(editBtn, "❌ editBtn is not displayed!");
        return this;
    }

    @Step("Check Close Edit Product Form Btn Is Displayed")
    public AdminEditProductPage checkCloseEditProductFormBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(closeEditProductFormBtn, "❌ closeEditProductFormBtn is not displayed!");
        return this;
    }
    /***************End Check Add btn and Close Btn Is Displayed  *******************/

    /***************Add btn Text  *******************/

    @Step("Check Edit Btn Text Is \"Edit\"")
    public AdminEditProductPage checkEditBtnText() {
        driver.assertion().assertElementTextContains(editBtn, "Edit", "❌ editBtn is not correct!");
        return this;
    }
    /***************End Add btn Text  *******************/

    /***************check Add Product form is not Displayed  *******************/

    @Step("Check Edit Product Form Is Not Displayed")
    public AdminEditProductPage checkEditProductFormIsNotDisplayed() {
        assertElementNotDisplayed(editProductForm, "❌ editProductForm is displayed!");
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    @Step("Check Toast Msg Is Displayed")
    public AdminEditProductPage checkToastMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(toastMsg, "❌ toastMsg is not displayed!");
        return this;
    }

    @Step("Check Toast Msg Text Is \"Product Updated Successfully\"")
    public AdminEditProductPage checkToastMsgText() {
        driver.assertion().assertElementTextContains(toastMsg, "Product Updated Successfully", "❌ toastMsg is not correct!");
        return this;
    }

    @Step("Check Toast Close Btn Is Displayed")
    public AdminEditProductPage checkToastCloseBtnIsDisplayed() {
        driver.assertion().assertElementDisplayed(toastCloseBtn, "❌ toastCloseBtn is not displayed!");
        return this;
    }

    @Step("Check Toast Msg Is Not Displayed")
    public AdminEditProductPage checkToastMsgIsNotDisplayed() {
        assertElementNotDisplayed(toastMsg, "❌ toastMsg is displayed!");
        return this;
    }

    /***************End Toast msg staff  *******************/
    /***************  Error Msg Is Displayed *******************/
    @Step("Check Title Error Msg Is Displayed")
    public AdminEditProductPage checkTitleErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(titleErrorMsg, "❌ titleErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Category Error Msg Is Displayed")
    public AdminEditProductPage checkCategoryErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(categoryErrorMsg, "❌ categoryErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Brand Error Msg Is Displayed")
    public AdminEditProductPage checkBrandErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(brandErrorMsg, "❌ brandErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Price Error Msg Is Displayed")
    public AdminEditProductPage checkPriceErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(priceErrorMsg, "❌ priceErrorMsg is not displayed!");
        return this;
    }

    @Step("Check Total Stock Error Msg Is Displayed")
    public AdminEditProductPage checkTotalStockErrorMsgIsDisplayed() {
        driver.assertion().assertElementDisplayed(totalStockErrorMsg, "❌ totalStockErrorMsg is not displayed!");
        return this;
    }

    /***************  End Error Msg Is Displayed *******************/

    /***************  Error Msg Text *******************/

    @Step("Check Title Error Msg Text Is \"Title is required\"")
    public AdminEditProductPage checkTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is required", "❌ titleErrorMsg is not correct!");
        return this;
    }

    @Step("Check Category Error Msg Text Is \"Category is required\"")
    public AdminEditProductPage checkCategoryErrorMsgText() {
        driver.assertion().assertElementTextContains(categoryErrorMsg, "Category is required", "❌ categoryErrorMsg is not correct!");
        return this;
    }

    @Step("Check Brand Error Msg Text Is \"Brand is required\"")
    public AdminEditProductPage checkBrandErrorMsgText() {
        driver.assertion().assertElementTextContains(brandErrorMsg, "Brand is required", "❌ brandErrorMsg is not correct!");
        return this;
    }

    @Step("Check Price Error Msg Text Is \"Price is required\"")
    public AdminEditProductPage checkPriceErrorMsgText() {
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price is required", "❌ priceErrorMsg is not correct!");
        return this;
    }

    @Step("Check Total Stock Error Msg Text Is \"Total Stock is required\"")
    public AdminEditProductPage checkTotalStockErrorMsgText() {
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock is required", "❌ totalStockErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Price Error Msg Text Is \"Price must be greater than 0.\"")
    public AdminEditProductPage checkInvalidPriceErrorMsgText() {
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price must be greater than 0.", "❌ priceErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Total Stock Error Msg Text Is \"Total Stock must be greater than 0.\"")
    public AdminEditProductPage checkInvalidTotalStockErrorMsgText() {
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock must be greater than 0.", "❌ totalStockErrorMsg is not correct!");
        return this;
    }

    @Step("Check Invalid Title Error Msg Text Is \"Title is too long!\"")
    public AdminEditProductPage checkInvalidTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is too long!", "❌ titleErrorMsg is not correct!");
        return this;
    }
    /***************  End Error Msg Text *******************/

    /***************  ACTIONS  *******************/

    /***************  clicks  *******************/
    @Step("Click On Category Btn")
    public AdminEditProductPage clickOnCategoryBtn() {
        driver.element().click(categoryBtn);
        return this;
    }

    @Step("Click On Brand Btn")
    public AdminEditProductPage clickOnBrandBtn() {
        driver.element().click(brandBtn);
        return this;
    }

    @Step("Click On Close Edit Product Form Btn")
    public AdminEditProductPage clickOnCloseEditProductFormBtn() {
        driver.element().click(closeEditProductFormBtn);
        return this;
    }

    @Step("Click On Edit Btn")
    public AdminEditProductPage clickOnEditBtn() {
        driver.element().click(editBtn);
        return this;
    }

    @Step("Click On Edit Btn Card")
    public AdminEditProductPage clickOnEditBtnCard() {
        driver.element().click(editBtnCard);
        return this;
    }

    @Step("Click On Toast Close Btn")
    public AdminEditProductPage clickOnToastCloseBtn() {
        driver.element().click(toastCloseBtn);
        return this;
    }

    /***************  End clicks  *******************/
    /***************  clear Fields  *******************/
    @Step("Clear Title Field")
    public AdminEditProductPage clearTitleField() {
        clearField(titleField);
        return this;
    }

    @Step("Clear Description Field")
    public AdminEditProductPage clearDescriptionField() {
        clearField(descriptionField);
        return this;
    }

    @Step("Clear Price Field")
    public AdminEditProductPage clearPriceField() {
        clearField(priceField);
        return this;
    }

    @Step("Clear Total Stock Field")
    public AdminEditProductPage clearTotalStockField() {
        clearField(totalStockField);
        return this;
    }

    @Step("Clear Sale Price Field")
    public AdminEditProductPage clearSalePriceField() {
        clearField(salePriceField);
        return this;
    }
    /***************  End clear Fields  *******************/

    /***************  Send Keys  *******************/
    @Step("Fill Upload Image Field")
    public AdminEditProductPage fillUploadImageField(String path) {
        File uploadFile = new File(path);
        WebElement fileInput = driver.get().findElement(uploadImageInputField);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        return this;
    }

    @Step("Fill Title Field")
    public AdminEditProductPage fillTitleField(String title) {
        driver.element().set(titleField, title);
        return this;
    }

    @Step("Fill Description Field")
    public AdminEditProductPage fillDescriptionField(String description) {
        driver.element().set(descriptionField, description);
        return this;
    }

    @Step("Fill Price Field")
    public AdminEditProductPage fillPriceField(int price) {
        driver.element().setNumberField(driver.get(), priceField, price);
        return this;
    }

    @Step("Fill Sale Price Field")
    public AdminEditProductPage fillSalePriceField(int salePrice) {
        driver.element().setNumberField(driver.get(), salePriceField, salePrice);
        return this;
    }

    @Step("Fill Total Stock Field")
    public AdminEditProductPage fillTotalStockField(int totalStock) {
        driver.element().setNumberField(driver.get(), totalStockField, totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/
    /***************  Select options  *******************/

    @Step("Select Option From Category Select")
    public AdminEditProductPage selectOptionFromCategorySelect(int index) {
        driver.element().selectByIndex(categorySelect, index);
        return this;
    }

    @Step("Select Option From Brand Select")
    public AdminEditProductPage selectOptionFromBrandSelect(int index) {
        driver.element().selectByIndex(brandSelect, index);
        return this;

    }

    /***************  End ACTIONS  *******************/

    @Step("Assert Element Not Displayed")
    private void assertElementNotDisplayed(By locator, String errorMessage) {
        boolean isGone = Waits.waitForElementToBeInvisible(driver.get(), locator);
        if (!isGone) {
            throw new AssertionError(errorMessage);
        }
    }

    public void clearField(By locator) {
        WebElement input = ElementActions.find(driver.get(), locator);
        input.sendKeys("");
        input.submit();
    }

    @Step("Delete After Updated Successfully")
    public AdminEditProductPage deleteAfterUpdatedSuccessfully(String title) {
        String deleteButtonXpath = "//main//h2[contains(text(),\"" + title + "\")]/../..//button[2]";
        By deleteButton = By.xpath(deleteButtonXpath);
//        if (ElementActions.isDisplayed(driver.get(), toastMsg)) {
        driver.element().click(deleteButton);
//        }
        return this;
    }

    @Step("Check Products Are Displayed")
    public AdminEditProductPage checkProductsAreDisplayed() {
        driver.assertion().assertElementDisplayed(firstProduct, "❌ firstProduct is not displayed!");
        return this;
    }
}
