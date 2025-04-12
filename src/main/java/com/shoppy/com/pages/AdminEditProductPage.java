package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class AdminEditProductPage {
    //  a card with specific title
    //main//h2[contains(text(),"Carbon Blue Men's Crew Neck")]
    private final Driver driver;
    // options problem
    private final By div = By.xpath("//div[@data-radix-popper-content-wrapper]");

// private final String path = "./../../../../../../test/resources/1.png"

    //
    private final By editProductForm = By.xpath("//div[@role=\"dialog\"]");
    private final By editProductFormTitle = By.xpath("//div[@role=\"dialog\"]/div/h2");
//    private final By addProductBtn = By.xpath("//main/div/button");
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


    public AdminEditProductPage(Driver driver) {
        this.driver = driver;
        categoryOptionsXpathList = setOptions(categoryOptions, categoryOptionsXpath);
        brandOptionsXpathList = setOptions(brandOptions, brandOptionsXpath);
    }

    public AdminEditProductPage navigateToProductsPage() {
        driver.browser().openUrl(driver.get(), "https://shoppy-ochre.vercel.app/admin/products");
        return this;
    }

//    public AdminEditProductPage clickOnAddProductBtn() {
//        driver.element().click(addProductBtn);
//        return this;
//    }

    public List<By> setOptions(By options, String Xpath) {
        return ElementActions.getAllElementsLocators(driver.get(), options, Xpath);
    }

    /********* form itself **********/
//    done
    public AdminEditProductPage checkEditProductFormIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductForm));
        driver.assertion().assertElementDisplayed(editProductForm, "❌ editProductForm is not displayed!");
        return this;
    }

    public AdminEditProductPage checkEditProductFormTitleIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductFormTitle));
        driver.assertion().assertElementDisplayed(editProductFormTitle, "❌ editProductFormTitle is not displayed!");

        return this;
    }

    public AdminEditProductPage checkEditProductFormTitleText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), addProductFormTitle).contains("Add New Product"));
        driver.assertion().assertElementTextContains(editProductFormTitle, "Edit Product", "❌ editProductFormTitle is not correct!");

        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
//    done
    public AdminEditProductPage checkUploadImageLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageLabel));
        driver.assertion().assertElementDisplayed(uploadImageLabel, "❌ uploadImageLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkUploadImageFieldLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageFieldLabel));
        driver.assertion().assertElementDisplayed(uploadImageFieldLabel, "❌ uploadImageFieldLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkTitleLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleLabel));
        driver.assertion().assertElementDisplayed(titleLabel, "❌ titleLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkDescriptionLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionLabel));
        driver.assertion().assertElementDisplayed(descriptionLabel, "❌ descriptionLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkCategoryLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryLabel));
        driver.assertion().assertElementDisplayed(categoryLabel, "❌ categoryLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkBrandLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandLabel));
        driver.assertion().assertElementDisplayed(brandLabel, "❌ brandLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkPriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceLabel));
        driver.assertion().assertElementDisplayed(priceLabel, "❌ priceLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkSalePriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceLabel));
        driver.assertion().assertElementDisplayed(salePriceLabel, "❌ salePriceLabel is not displayed!");

        return this;
    }

    public AdminEditProductPage checkTotalStockLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockLabel));
        driver.assertion().assertElementDisplayed(totalStockLabel, "❌ totalStockLabel is not displayed!");

        return this;
    }

    /*************** End labels Is Displayed *******************/

    /*************** label Text *******************/

    public AdminEditProductPage checkUploadImageLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageLabel).contains("Upload Image"));
        driver.assertion().assertElementTextContains(uploadImageLabel, "Upload Image", "❌ uploadImageLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkUploadImageFieldLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageFieldLabel).contains("Drag & Drop or Click to Upload"));
        driver.assertion().assertElementTextContains(uploadImageFieldLabel, "Drag & Drop or Click to Upload", "❌ uploadImageFieldLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkTitleLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), titleLabel).contains("Title"));
        driver.assertion().assertElementTextContains(titleLabel, "Title", "❌ titleLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkDescriptionLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), descriptionLabel).contains("Description"));
        driver.assertion().assertElementTextContains(descriptionLabel, "Description", "❌ descriptionLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkCategoryLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryLabel).contains("Category"));
        driver.assertion().assertElementTextContains(categoryLabel, "Category", "❌ categoryLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkBrandLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandLabel).contains("Brand"));
        driver.assertion().assertElementTextContains(brandLabel, "Brand", "❌ brandLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkPriceLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceLabel).contains("Price"));
        driver.assertion().assertElementTextContains(priceLabel, "Price", "❌ priceLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkSalePriceLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), salePriceLabel).contains("Sale Price"));
        driver.assertion().assertElementTextContains(salePriceLabel, "Sale Price", "❌ salePriceLabel is not correct!");

        return this;
    }

    public AdminEditProductPage checkTotalStockLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockLabel).contains("Total Stock"));
        driver.assertion().assertElementTextContains(totalStockLabel, "Total Stock", "❌ totalStockLabel is not correct!");

        return this;
    }
    /*************** End label Text *******************/

    /***************Fields Is Displayed *******************/
//done
    public AdminEditProductPage checkUploadImageFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageField));
        driver.assertion().assertElementDisplayed(uploadImageField, "❌ uploadImageField is not displayed!");

        return this;
    }

    public AdminEditProductPage checkTitleFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleField));
        driver.assertion().assertElementDisplayed(titleField, "❌ titleField is not displayed!");

        return this;
    }

    public AdminEditProductPage checkDescriptionFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionField));
        driver.assertion().assertElementDisplayed(descriptionField, "❌ descriptionField is not displayed!");

        return this;
    }

    public AdminEditProductPage checkCategoryBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryBtn));
        driver.assertion().assertElementDisplayed(categoryBtn, "❌ categoryBtn is not displayed!");

        return this;
    }

    public AdminEditProductPage checkCategorySelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categorySelect));
        driver.assertion().assertElementDisplayed(categorySelect, "❌ categorySelect is not displayed!");

        return this;
    }

    public AdminEditProductPage checkBrandBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandBtn));
        driver.assertion().assertElementDisplayed(brandBtn, "❌ brandBtn is not displayed!");

        return this;
    }

    public AdminEditProductPage checkBrandSelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandSelect));
        driver.assertion().assertElementDisplayed(brandSelect, "❌ brandSelect is not displayed!");

        return this;
    }

    public AdminEditProductPage checkPriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceField));
        driver.assertion().assertElementDisplayed(priceField, "❌ priceField is not displayed!");

        return this;
    }

    public AdminEditProductPage checkSalePriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceField));
        driver.assertion().assertElementDisplayed(salePriceField, "❌ salePriceField is not displayed!");

        return this;
    }

    public AdminEditProductPage checkTotalStockFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockField));
        driver.assertion().assertElementDisplayed(totalStockField, "❌ totalStockField is not displayed!");

        return this;
    }
    /***************End Fields Is Displayed *******************/

    /***************Placeholder Text *******************/

    public AdminEditProductPage checkTitleFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), titleField).getDomAttribute("placeholder").contains("Enter product title"));
        driver.assertion().assertElementAttributeEquals(titleField, "placeholder", "Enter product title", "❌ titleFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminEditProductPage checkDescriptionFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), descriptionField).getDomAttribute("placeholder").contains("Enter product description"));
        driver.assertion().assertElementAttributeEquals(descriptionField, "placeholder", "Enter product description", "❌ descriptionFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminEditProductPage checkPriceFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), priceField).getDomAttribute("placeholder").contains("Enter product price"));
        driver.assertion().assertElementAttributeEquals(priceField, "placeholder", "Enter product price", "❌ priceFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminEditProductPage checkSalePriceFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), salePriceField).getDomAttribute("placeholder").contains("Enter sale price (optional)"));
        driver.assertion().assertElementAttributeEquals(salePriceField, "placeholder", "Enter sale price (optional)", "❌ salePriceFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminEditProductPage checkTotalStockFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), totalStockField).getDomAttribute("placeholder").contains("Enter total stock"));
        driver.assertion().assertElementAttributeEquals(totalStockField, "placeholder", "Enter total stock", "❌ totalStockFieldPlaceHolder is not correct!");
        return this;
    }


    /***************End Placeholder Text *******************/
    /*************** Category & Brand btn text/default value *******************/

    public AdminEditProductPage checkCategoryBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryBtn).contains("Category"));
        driver.assertion().assertElementTextContains(categoryBtn, "Category", "❌ categoryBtn is not correct!");

        return this;
    }

    public AdminEditProductPage checkBrandBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandBtn).contains("Brand"));
        driver.assertion().assertElementTextContains(brandBtn, "Brand", "❌ brandBtn is not correct!");

        return this;
    }
    /*************** End Category & Brand btn text/default value *******************/

    /*************** Check Category & Brand Options  *******************/

//    public AdminEditProductPage checkBrandOptions() {
//        Assert.assertEquals(brandOptionsXpathList.size(), brandOptionsList.length);
//
//        for (int i = 0; i < brandOptionsXpathList.size(); i++) {
//            WebElement option = ElementActions.find(driver.get(), brandOptionsXpathList.get(i));
//            Assert.assertTrue(Arrays.stream(brandOptionsList).equals(option.getText()));
//        }
//        return this;
//    }

//    public AdminEditProductPage checkCategoryOptions() {
//        Assert.assertEquals(categoryOptionsXpathList.size(), categoryOptionsList.length);
//        for (int i = 0; i < categoryOptionsXpathList.size(); i++) {
//            WebElement option = ElementActions.find(driver.get(), categoryOptionsXpathList.get(i));
//            Assert.assertTrue(Arrays.stream(categoryOptionsList).equals(option.getText()));
//        }
//
//        return this;
//    }
    /*************** End Check Category & Brand Options  *******************/

    /*************** Check Add btn and Close Btn Is Displayed  *******************/
    public AdminEditProductPage checkEditBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addBtn));
        driver.assertion().assertElementDisplayed(editBtn, "❌ editBtn is not displayed!");

        return this;
    }

    public AdminEditProductPage checkCloseEditProductFormBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), closeAddProductFormBtn));
        driver.assertion().assertElementDisplayed(closeEditProductFormBtn, "❌ closeEditProductFormBtn is not displayed!");

        return this;
    }
    /***************End Check Add btn and Close Btn Is Displayed  *******************/

    /***************Add btn Text  *******************/

    public AdminEditProductPage checkEditBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), addBtn).contains("Add"));
        driver.assertion().assertElementTextContains(editBtn, "Edit", "❌ editBtn is not correct!");

        return this;
    }
    /***************End Add btn Text  *******************/

    /***************check Add Product form is not Displayed  *******************/

    public AdminEditProductPage checkEditProductFormIsNotDisplayed() {
//        assertElementNotDisplayed(addProductForm, "❌ addProductForm is displayed!");
        assertElementNotDisplayed(editProductForm, "❌ editProductForm is displayed!");
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    public AdminEditProductPage checkToastMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastMsg));
        driver.assertion().assertElementDisplayed(toastMsg, "❌ toastMsg is not displayed!");

        return this;
    }

    public AdminEditProductPage checkToastMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), toastMsg).contains("Product Added Successfully"));
        driver.assertion().assertElementTextContains(toastMsg, "Product Updated Successfully", "❌ toastMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkToastCloseBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastCloseBtn));
        driver.assertion().assertElementDisplayed(toastCloseBtn, "❌ toastCloseBtn is not displayed!");

        return this;
    }

    public AdminEditProductPage checkToastMsgIsNotDisplayed() {
//        Assert.assertTrue(!ElementActions.isDisplayed(driver.get(), toastMsg));
        assertElementNotDisplayed(toastMsg, "❌ toastMsg is displayed!");

        return this;
    }

    /***************End Toast msg staff  *******************/
    /***************  Error Msg Is Displayed *******************/
    public AdminEditProductPage checkTitleErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleErrorMsg));
        driver.assertion().assertElementDisplayed(titleErrorMsg, "❌ titleErrorMsg is not displayed!");

        return this;
    }

    public AdminEditProductPage checkCategoryErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryErrorMsg));
        driver.assertion().assertElementDisplayed(categoryErrorMsg, "❌ categoryErrorMsg is not displayed!");

        return this;
    }

    public AdminEditProductPage checkBrandErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandErrorMsg));
        driver.assertion().assertElementDisplayed(brandErrorMsg, "❌ brandErrorMsg is not displayed!");

        return this;
    }

    public AdminEditProductPage checkPriceErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceErrorMsg));
        driver.assertion().assertElementDisplayed(priceErrorMsg, "❌ priceErrorMsg is not displayed!");

        return this;
    }

    public AdminEditProductPage checkTotalStockErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockErrorMsg));
        driver.assertion().assertElementDisplayed(totalStockErrorMsg, "❌ totalStockErrorMsg is not displayed!");

        return this;
    }

    /***************  End Error Msg Is Displayed *******************/

    /***************  Error Msg Text *******************/

    public AdminEditProductPage checkTitleErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), titleErrorMsg).contains("Title is required"));
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is required", "❌ titleErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkCategoryErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryErrorMsg).contains("Category is required"));
        driver.assertion().assertElementTextContains(categoryErrorMsg, "Category is required", "❌ categoryErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkBrandErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandErrorMsg).contains("Brand is required"));
        driver.assertion().assertElementTextContains(brandErrorMsg, "Brand is required", "❌ brandErrorMsg is not correct!");
        return this;
    }

    public AdminEditProductPage checkPriceErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceErrorMsg).contains("Price is required"));
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price is required", "❌ priceErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkTotalStockErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockErrorMsg).contains("Total Stock is required"));
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock is required", "❌ totalStockErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkInvalidPriceErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceErrorMsg).contains("Price must be greater than 0."));
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price must be greater than 0.", "❌ priceErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkInvalidTotalStockErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockErrorMsg).contains("Total Stock must be greater than 0."));
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock must be greater than 0.", "❌ totalStockErrorMsg is not correct!");

        return this;
    }

    public AdminEditProductPage checkInvalidTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is too long!", "❌ titleErrorMsg is not correct!");
        return this;
    }
    /***************  End Error Msg Text *******************/

    /***************  ACTIONS  *******************/

    /***************  clicks  *******************/
//    public AdminEditProductPage clickOnUploadImageFieldLabel() {
//        driver.element().click(uploadImageFieldLabel);
//        return this;
//    }
    public AdminEditProductPage clickOnCategoryBtn() {
        driver.element().click(categoryBtn);
        return this;
    }

    public AdminEditProductPage clickOnBrandBtn() {
        driver.element().click(brandBtn);
        return this;
    }

    public AdminEditProductPage clickOnCloseEditProductFormBtn() {
        driver.element().click(closeEditProductFormBtn);
//        new WebDriverWait(driver.get(), Duration.ofSeconds(5))
//                .until(ExpectedConditions.invisibilityOf(ElementActions.find(driver.get(), addProductForm)));
        return this;
    }

    public AdminEditProductPage clickOnEditBtn() {
        driver.element().click(editBtn);
//        WebElement element = ElementActions.find(driver.get(), addBtn);
//        ((JavascriptExecutor) driver.get()).executeScript("document.querySelector(\"button[type='submit']\").click()");

        return this;
    }

    public AdminEditProductPage clickOnToastCloseBtn() {
        driver.element().click(toastCloseBtn);
        return this;
    }

    /***************  End clicks  *******************/

    /***************  Send Keys  *******************/
    public AdminEditProductPage fillUploadImageField(String path) {
        File uploadFile = new File(path);
//        driver.element().set(uploadImageInputField, uploadFile.getAbsolutePath());
        WebElement fileInput = driver.get().findElement(uploadImageInputField);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        return this;
    }

    public AdminEditProductPage fillTitleField(String title) {
        driver.element().set(titleField, title);
        return this;
    }

    public AdminEditProductPage fillDescriptionField(String description) {
        driver.element().set(descriptionField, description);
        return this;
    }

    public AdminEditProductPage fillPriceField(int price) {
//      driver.element().set(priceField, String.valueOf(price));
        driver.element().setNumberField(driver.get(), priceField, price);
        return this;
    }

    public AdminEditProductPage fillSalePriceField(int salePrice) {
//        driver.element().set(salePriceField, String.valueOf(salePrice));
        driver.element().setNumberField(driver.get(), salePriceField, salePrice);

        return this;
    }

    public AdminEditProductPage fillTotalStockField(int totalStock) {
//        driver.element().set(totalStockField, String.valueOf(totalStock));
        driver.element().setNumberField(driver.get(), totalStockField, totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/
    /***************  Select options  *******************/
    public AdminEditProductPage selectOptionFromCategorySelect(int index) {
//        driver.element().click(categoryOptionsXpathList.get(index));
        driver.element().selectByIndex(categorySelect, index);
        return this;
    }

    public AdminEditProductPage selectOptionFromBrandSelect(int index) {
//        driver.element().click(brandOptionsXpathList.get(index));
        driver.element().selectByIndex(brandSelect, index);
        return this;

    }

    /***************  End ACTIONS  *******************/
//
//    public AdminEditProductPage checkGreyAreaIsNotDisplayed() {
//        Assert.assertFalse(ElementActions.isDisplayed(driver.get(), greySection));
//        return this;
//    }
//    private void assertElementDisplayed(By locator, String errorMessage) {
//        WebElement element = Waits.waitForElementVisible(driver.get(), locator);
//        if (element == null || !element.isDisplayed()) {
//            throw new AssertionError(errorMessage);
//        }
//    }
    private void assertElementNotDisplayed(By locator, String errorMessage) {
        boolean isGone = Waits.waitForElementToBeInvisible(driver.get(), locator);
        if (!isGone) {
            throw new AssertionError(errorMessage);
        }
    }
// options problem

//public AdminEditProductPage displayed()
//{
//    new ElementActions(driver.get()).selectByIndex(categorySelect,1);
//    return this;
//}

}
