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

    public AdminAddProductPage navigateToProductsPage() {
        driver.browser().openUrl(driver.get(), "https://shoppy-ochre.vercel.app/admin/products");
        return this;
    }

    public AdminAddProductPage clickOnAddProductBtn() {
        driver.element().click(addProductBtn);
        return this;
    }

    public List<By> setOptions(By options, String Xpath) {
        return ElementActions.getAllElementsLocators(driver.get(), options, Xpath);
    }

    /********* form itself **********/
//    done
    public AdminAddProductPage checkAddProductFormIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductForm));
        driver.assertion().assertElementDisplayed(addProductForm, "❌ addProductForm is not displayed!");
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductFormTitle));
        driver.assertion().assertElementDisplayed(addProductFormTitle, "❌ addProductFormTitle is not displayed!");

        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), addProductFormTitle).contains("Add New Product"));
        driver.assertion().assertElementTextContains(addProductFormTitle, "Add New Product", "❌ addProductFormTitle is not correct!");

        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
//    done
    public AdminAddProductPage checkUploadImageLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageLabel));
        driver.assertion().assertElementDisplayed(uploadImageLabel, "❌ uploadImageLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkUploadImageFieldLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageFieldLabel));
        driver.assertion().assertElementDisplayed(uploadImageFieldLabel, "❌ uploadImageFieldLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTitleLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleLabel));
        driver.assertion().assertElementDisplayed(titleLabel, "❌ titleLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkDescriptionLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionLabel));
        driver.assertion().assertElementDisplayed(descriptionLabel, "❌ descriptionLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryLabel));
        driver.assertion().assertElementDisplayed(categoryLabel, "❌ categoryLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandLabel));
        driver.assertion().assertElementDisplayed(brandLabel, "❌ brandLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceLabel));
        driver.assertion().assertElementDisplayed(priceLabel, "❌ priceLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkSalePriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceLabel));
        driver.assertion().assertElementDisplayed(salePriceLabel, "❌ salePriceLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockLabel));
        driver.assertion().assertElementDisplayed(totalStockLabel, "❌ totalStockLabel is not displayed!");

        return this;
    }

    /*************** End labels Is Displayed *******************/

    /*************** label Text *******************/

    public AdminAddProductPage checkUploadImageLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageLabel).contains("Upload Image"));
        driver.assertion().assertElementTextContains(uploadImageLabel, "Upload Image", "❌ uploadImageLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkUploadImageFieldLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageFieldLabel).contains("Drag & Drop or Click to Upload"));
        driver.assertion().assertElementTextContains(uploadImageFieldLabel, "Drag & Drop or Click to Upload", "❌ uploadImageFieldLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkTitleLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), titleLabel).contains("Title"));
        driver.assertion().assertElementTextContains(titleLabel, "Title", "❌ titleLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkDescriptionLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), descriptionLabel).contains("Description"));
        driver.assertion().assertElementTextContains(descriptionLabel, "Description", "❌ descriptionLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkCategoryLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryLabel).contains("Category"));
        driver.assertion().assertElementTextContains(categoryLabel, "Category", "❌ categoryLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkBrandLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandLabel).contains("Brand"));
        driver.assertion().assertElementTextContains(brandLabel, "Brand", "❌ brandLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkPriceLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceLabel).contains("Price"));
        driver.assertion().assertElementTextContains(priceLabel, "Price", "❌ priceLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkSalePriceLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), salePriceLabel).contains("Sale Price"));
        driver.assertion().assertElementTextContains(salePriceLabel, "Sale Price", "❌ salePriceLabel is not correct!");

        return this;
    }

    public AdminAddProductPage checkTotalStockLabelText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockLabel).contains("Total Stock"));
        driver.assertion().assertElementTextContains(totalStockLabel, "Total Stock", "❌ totalStockLabel is not correct!");

        return this;
    }
    /*************** End label Text *******************/

    /***************Fields Is Displayed *******************/
//done
    public AdminAddProductPage checkUploadImageFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageField));
        driver.assertion().assertElementDisplayed(uploadImageField, "❌ uploadImageField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTitleFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleField));
        driver.assertion().assertElementDisplayed(titleField, "❌ titleField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkDescriptionFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionField));
        driver.assertion().assertElementDisplayed(descriptionField, "❌ descriptionField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryBtn));
        driver.assertion().assertElementDisplayed(categoryBtn, "❌ categoryBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategorySelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categorySelect));
        driver.assertion().assertElementDisplayed(categorySelect, "❌ categorySelect is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandBtn));
        driver.assertion().assertElementDisplayed(brandBtn, "❌ brandBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandSelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandSelect));
        driver.assertion().assertElementDisplayed(brandSelect, "❌ brandSelect is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceField));
        driver.assertion().assertElementDisplayed(priceField, "❌ priceField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkSalePriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceField));
        driver.assertion().assertElementDisplayed(salePriceField, "❌ salePriceField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockField));
        driver.assertion().assertElementDisplayed(totalStockField, "❌ totalStockField is not displayed!");

        return this;
    }
    /***************End Fields Is Displayed *******************/

    /***************Placeholder Text *******************/

    public AdminAddProductPage checkTitleFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), titleField).getDomAttribute("placeholder").contains("Enter product title"));
        driver.assertion().assertElementAttributeEquals(titleField, "placeholder", "Enter product title", "❌ titleFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminAddProductPage checkDescriptionFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), descriptionField).getDomAttribute("placeholder").contains("Enter product description"));
        driver.assertion().assertElementAttributeEquals(descriptionField, "placeholder", "Enter product description", "❌ descriptionFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminAddProductPage checkPriceFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), priceField).getDomAttribute("placeholder").contains("Enter product price"));
        driver.assertion().assertElementAttributeEquals(priceField, "placeholder", "Enter product price", "❌ priceFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminAddProductPage checkSalePriceFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), salePriceField).getDomAttribute("placeholder").contains("Enter sale price (optional)"));
        driver.assertion().assertElementAttributeEquals(salePriceField, "placeholder", "Enter sale price (optional)", "❌ salePriceFieldPlaceHolder is not correct!");

        return this;
    }

    public AdminAddProductPage checkTotalStockFieldPlaceHolderText() {
//        Assert.assertTrue(ElementActions.find(driver.get(), totalStockField).getDomAttribute("placeholder").contains("Enter total stock"));
        driver.assertion().assertElementAttributeEquals(totalStockField, "placeholder", "Enter total stock", "❌ totalStockFieldPlaceHolder is not correct!");
        return this;
    }


    /***************End Placeholder Text *******************/
    /*************** Category & Brand btn text/default value *******************/

    public AdminAddProductPage checkCategoryBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryBtn).contains("Category"));
        driver.assertion().assertElementTextContains(categoryBtn, "Category", "❌ categoryBtn is not correct!");

        return this;
    }

    public AdminAddProductPage checkBrandBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandBtn).contains("Brand"));
        driver.assertion().assertElementTextContains(brandBtn, "Brand", "❌ brandBtn is not correct!");

        return this;
    }
    /*************** End Category & Brand btn text/default value *******************/

    /*************** Check Category & Brand Options  *******************/

//    public AdminAddProductPage checkBrandOptions() {
//        Assert.assertEquals(brandOptionsXpathList.size(), brandOptionsList.length);
//
//        for (int i = 0; i < brandOptionsXpathList.size(); i++) {
//            WebElement option = ElementActions.find(driver.get(), brandOptionsXpathList.get(i));
//            Assert.assertTrue(Arrays.stream(brandOptionsList).equals(option.getText()));
//        }
//        return this;
//    }

//    public AdminAddProductPage checkCategoryOptions() {
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
    public AdminAddProductPage checkAddBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addBtn));
        driver.assertion().assertElementDisplayed(addBtn, "❌ addBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCloseAddProductFormBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), closeAddProductFormBtn));
        driver.assertion().assertElementDisplayed(closeAddProductFormBtn, "❌ closeAddProductFormBtn is not displayed!");

        return this;
    }
    /***************End Check Add btn and Close Btn Is Displayed  *******************/

    /***************Add btn Text  *******************/

    public AdminAddProductPage checkAddBtnText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), addBtn).contains("Add"));
        driver.assertion().assertElementTextContains(addBtn, "Add", "❌ addBtn is not correct!");

        return this;
    }
    /***************End Add btn Text  *******************/

    /***************check Add Product form is not Displayed  *******************/

    public AdminAddProductPage checkAddProductFormIsNotDisplayed() {
//        assertElementNotDisplayed(addProductForm, "❌ addProductForm is displayed!");
        assertElementNotDisplayed(addProductForm, "❌ addProductForm is displayed!");
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    public AdminAddProductPage checkToastMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastMsg));
        driver.assertion().assertElementDisplayed(toastMsg, "❌ toastMsg is not displayed!");
        return this;
    }

    public AdminAddProductPage checkToastMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), toastMsg).contains("Product Added Successfully"));
        driver.assertion().assertElementTextContains(toastMsg, "Product Added Successfully", "❌ toastMsg is not correct!");
        return this;
    }

    public AdminAddProductPage checkToastCloseBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastCloseBtn));
        driver.assertion().assertElementDisplayed(toastCloseBtn, "❌ toastCloseBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkToastMsgIsNotDisplayed() {
//        Assert.assertTrue(!ElementActions.isDisplayed(driver.get(), toastMsg));
        assertElementNotDisplayed(toastMsg, "❌ toastMsg is displayed!");

        return this;
    }

    /***************End Toast msg staff  *******************/
    /***************  Error Msg Is Displayed *******************/
    public AdminAddProductPage checkTitleErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleErrorMsg));
        driver.assertion().assertElementDisplayed(titleErrorMsg, "❌ titleErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryErrorMsg));
        driver.assertion().assertElementDisplayed(categoryErrorMsg, "❌ categoryErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandErrorMsg));
        driver.assertion().assertElementDisplayed(brandErrorMsg, "❌ brandErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceErrorMsg));
        driver.assertion().assertElementDisplayed(priceErrorMsg, "❌ priceErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockErrorMsg));
        driver.assertion().assertElementDisplayed(totalStockErrorMsg, "❌ totalStockErrorMsg is not displayed!");

        return this;
    }

    /***************  End Error Msg Is Displayed *******************/

    /***************  Error Msg Text *******************/

    public AdminAddProductPage checkTitleErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), titleErrorMsg).contains("Title is required"));
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is required", "❌ titleErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkCategoryErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), categoryErrorMsg).contains("Category is required"));
        driver.assertion().assertElementTextContains(categoryErrorMsg, "Category is required", "❌ categoryErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkBrandErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), brandErrorMsg).contains("Brand is required"));
        driver.assertion().assertElementTextContains(brandErrorMsg, "Brand is required", "❌ brandErrorMsg is not correct!");
        return this;
    }

    public AdminAddProductPage checkPriceErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceErrorMsg).contains("Price is required"));
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price is required", "❌ priceErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkTotalStockErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockErrorMsg).contains("Total Stock is required"));
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock is required", "❌ totalStockErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkInvalidPriceErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), priceErrorMsg).contains("Price must be greater than 0."));
        driver.assertion().assertElementTextContains(priceErrorMsg, "Price must be greater than 0.", "❌ priceErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkInvalidTotalStockErrorMsgText() {
//        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockErrorMsg).contains("Total Stock must be greater than 0."));
        driver.assertion().assertElementTextContains(totalStockErrorMsg, "Total Stock must be greater than 0.", "❌ totalStockErrorMsg is not correct!");

        return this;
    }

    public AdminAddProductPage checkInvalidTitleErrorMsgText() {
        driver.assertion().assertElementTextContains(titleErrorMsg, "Title is too long!", "❌ titleErrorMsg is not correct!");
        return this;
    }
    /***************  End Error Msg Text *******************/

    /***************  ACTIONS  *******************/

    /***************  clicks  *******************/
//    public AdminAddProductPage clickOnUploadImageFieldLabel() {
//        driver.element().click(uploadImageFieldLabel);
//        return this;
//    }
    public AdminAddProductPage clickOnCategoryBtn() {
        driver.element().click(categoryBtn);
        return this;
    }

    public AdminAddProductPage clickOnBrandBtn() {
        driver.element().click(brandBtn);
        return this;
    }

    public AdminAddProductPage clickOnCloseAddProductFormBtn() {
        driver.element().click(closeAddProductFormBtn);
//        new WebDriverWait(driver.get(), Duration.ofSeconds(5))
//                .until(ExpectedConditions.invisibilityOf(ElementActions.find(driver.get(), addProductForm)));
        return this;
    }

    public AdminAddProductPage clickOnAddBtn() {
        driver.element().click(addBtn);
//        WebElement element = ElementActions.find(driver.get(), addBtn);
//        ((JavascriptExecutor) driver.get()).executeScript("document.querySelector(\"button[type='submit']\").click()");

        return this;
    }

    public AdminAddProductPage clickOnToastCloseBtn() {
        driver.element().click(toastCloseBtn);
        return this;
    }

    /***************  End clicks  *******************/

    /***************  Send Keys  *******************/
    public AdminAddProductPage fillUploadImageField(String path) {
        File uploadFile = new File(path);
//        driver.element().set(uploadImageInputField, uploadFile.getAbsolutePath());
        WebElement fileInput = driver.get().findElement(uploadImageInputField);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        return this;
    }

    public AdminAddProductPage fillTitleField(String title) {
        driver.element().set(titleField, title);
        return this;
    }

    public AdminAddProductPage fillDescriptionField(String description) {
        driver.element().set(descriptionField, description);
        return this;
    }

    public AdminAddProductPage fillPriceField(int price) {
//      driver.element().set(priceField, String.valueOf(price));
        driver.element().setNumberField(driver.get(), priceField, price);
        return this;
    }

    public AdminAddProductPage fillSalePriceField(int salePrice) {
//        driver.element().set(salePriceField, String.valueOf(salePrice));
        driver.element().setNumberField(driver.get(), salePriceField, salePrice);

        return this;
    }

    public AdminAddProductPage fillTotalStockField(int totalStock) {
//        driver.element().set(totalStockField, String.valueOf(totalStock));
        driver.element().setNumberField(driver.get(), totalStockField, totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/
    /***************  Select options  *******************/
    public AdminAddProductPage selectOptionFromCategorySelect(int index) {
//        driver.element().click(categoryOptionsXpathList.get(index));
        driver.element().selectByIndex(categorySelect, index);
        return this;
    }

    public AdminAddProductPage selectOptionFromBrandSelect(int index) {
//        driver.element().click(brandOptionsXpathList.get(index));
        driver.element().selectByIndex(brandSelect, index);
        return this;

    }

    /***************  End ACTIONS  *******************/
    public AdminAddProductPage deleteAfterAddedSuccessfully(String title)
    {
        String deleteButtonXpath = "//main//h2[contains(text(),\""+title+"\")]/../..//button[2]";
        By deleteButton=By.xpath(deleteButtonXpath);
        if (ElementActions.isDisplayed(driver.get(), toastMsg))
        {
        driver.element().click(deleteButton);
        }
        return this;
    }
    public AdminAddProductPage deleteAfterAddedSuccessfully()
    {
        String deleteButtonXpath = "//main//h2[contains(text(),\"\")]/../..//button[2]";
        By deleteButton=By.xpath(deleteButtonXpath);
        if (ElementActions.isDisplayed(driver.get(), toastMsg))
        {
            driver.element().click(deleteButton);
        }
        return this;
    }
//
//    public AdminAddProductPage checkGreyAreaIsNotDisplayed() {
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

//public AdminAddProductPage displayed()
//{
//    new ElementActions(driver.get()).selectByIndex(categorySelect,1);
//    return this;
//}

}
