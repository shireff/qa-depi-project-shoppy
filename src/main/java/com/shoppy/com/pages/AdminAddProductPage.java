package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminAddProductPage {

    private final Driver driver;

    private final By addProductForm = By.xpath("//div[@role=\"dialog\"]");
    private final By addProductFormTitle = By.xpath("//div[@role=\"dialog\"]/div/h2");

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
    private final By uploadImageField = By.id("image-upload");
    private final By titleField = By.id("title");
    private final By descriptionField = By.id("description");

    // category
    private final String categoryOptionsXpath = "//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select/option";
    private final By categoryBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/button");
    private final By categorySelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select");
    private final By categoryOptions = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[3]/div/select/option");   // end category
    private final List<By> categoryOptionsXpathList = setOptions(categoryOptions, categoryOptionsXpath);
    private final String[] categoryOptionsList = {"Men", "Women", "Kids", "Accessories", "Footwear"};

    // brand
    private final String brandOptionsXpath = "//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option";
    private final By brandBtn = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/button");
    private final By brandSelect = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select");
    private final By brandOptions = By.xpath("//div[@role=\"dialog\"]/div[3]/form/div/div[4]/div/select/option");
    private final List<By> brandOptionsXpathList = setOptions(brandOptions, brandOptionsXpath);
    private final String[] brandOptionsList = {"Nike", "Adidas", "Puma", "Levi's", "Zara", "H&M"};

    //end brand

    private final By priceField = By.id("price");
    private final By salePriceField = By.id("salePrice");
    private final By totalStockField = By.id("totalStock");

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
    }

    public List<By> setOptions(By options, String Xpath) {
        return ElementActions.getAllElementsLocators(driver.get(), options, Xpath);
    }

    /********* form itself **********/
    public AdminAddProductPage checkAddProductFormIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductForm));
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductFormTitle));
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addProductFormTitle).contains("Add New Product"));
        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
    public AdminAddProductPage checkUploadImageLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageLabel));
        return this;
    }

    public AdminAddProductPage checkUploadImageFieldLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageFieldLabel));
        return this;
    }

    public AdminAddProductPage checkTitleLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleLabel));
        return this;
    }

    public AdminAddProductPage checkDescriptionLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionLabel));
        return this;
    }

    public AdminAddProductPage checkCategoryLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryLabel));
        return this;
    }

    public AdminAddProductPage checkBrandLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandLabel));
        return this;
    }

    public AdminAddProductPage checkPriceLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceLabel));
        return this;
    }

    public AdminAddProductPage checkSalePriceLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceLabel));
        return this;
    }

    public AdminAddProductPage checkTotalStockLabelIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockLabel));
        return this;
    }

    /*************** End labels Is Displayed *******************/

    /*************** label Text *******************/

    public AdminAddProductPage checkUploadImageLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageLabel).contains("Upload Image"));
        return this;
    }

    public AdminAddProductPage checkUploadImageFieldLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), uploadImageFieldLabel).contains("Drag & Drop or Click to Upload"));
        return this;
    }

    public AdminAddProductPage checkTitleLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), titleLabel).contains("Title"));
        return this;
    }

    public AdminAddProductPage checkDescriptionLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), descriptionLabel).contains("Description"));
        return this;
    }

    public AdminAddProductPage checkCategoryLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), categoryLabel).contains("Category"));
        return this;
    }

    public AdminAddProductPage checkBrandLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), brandLabel).contains("Brand"));
        return this;
    }

    public AdminAddProductPage checkPriceLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), priceLabel).contains("Price"));
        return this;
    }

    public AdminAddProductPage checkSalePriceLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), salePriceLabel).contains("Sale Price"));
        return this;
    }

    public AdminAddProductPage checkTotalStockLabelText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockLabel).contains("Total Stock"));
        return this;
    }
    /*************** End label Text *******************/

    /***************Fields Is Displayed *******************/
    public AdminAddProductPage checkUploadImageFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageField));
        return this;
    }

    public AdminAddProductPage checkTitleFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleField));
        return this;
    }

    public AdminAddProductPage checkDescriptionFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionField));
        return this;
    }

    public AdminAddProductPage checkCategoryBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryBtn));
        return this;
    }

    public AdminAddProductPage checkCategorySelectIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categorySelect));
        return this;
    }

    public AdminAddProductPage checkBrandBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandBtn));
        return this;
    }

    public AdminAddProductPage checkBrandSelectIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandSelect));
        return this;
    }

    public AdminAddProductPage checkPriceFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceField));
        return this;
    }

    public AdminAddProductPage checkSalePriceFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceField));
        return this;
    }

    public AdminAddProductPage checkTotalStockFieldIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockField));
        return this;
    }
    /***************Fields Is Displayed *******************/

    /***************Placeholder Text *******************/

    public AdminAddProductPage checkTitleFieldPlaceHolderText() {
        Assert.assertTrue(ElementActions.find(driver.get(), titleField).getDomAttribute("placeholder").contains("Enter product title"));
        return this;
    }

    public AdminAddProductPage checkDescriptionFieldPlaceHolderText() {
        Assert.assertTrue(ElementActions.find(driver.get(), descriptionField).getDomAttribute("placeholder").contains("Enter product description"));
        return this;
    }

    public AdminAddProductPage checkPriceFieldPlaceHolderText() {
        Assert.assertTrue(ElementActions.find(driver.get(), priceField).getDomAttribute("placeholder").contains("Enter product price"));
        return this;
    }

    public AdminAddProductPage checkSalePriceFieldPlaceHolderText() {
        Assert.assertTrue(ElementActions.find(driver.get(), salePriceField).getDomAttribute("placeholder").contains("Enter sale price (optional)"));
        return this;
    }

    public AdminAddProductPage checkTotalStockFieldPlaceHolderText() {
        Assert.assertTrue(ElementActions.find(driver.get(), totalStockField).getDomAttribute("placeholder").contains("Enter total stock"));
        return this;
    }

    /***************End Placeholder Text *******************/

    /*************** Category & Brand btn text/default value *******************/

    public AdminAddProductPage checkCategoryBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), categoryBtn).contains("Category"));
        return this;
    }

    public AdminAddProductPage checkBrandBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), brandBtn).contains("Brand"));
        return this;
    }
    /*************** End Category & Brand btn text/default value *******************/

    /*************** Check Category & Brand Options  *******************/

    public AdminAddProductPage checkBrandOptions() {
        Assert.assertEquals(brandOptionsXpathList.size(), brandOptionsList.length);

        for (int i = 0; i < brandOptionsXpathList.size(); i++) {
            WebElement option = ElementActions.find(driver.get(), brandOptionsXpathList.get(i));
            Assert.assertTrue(Arrays.stream(brandOptionsList).equals(option.getText()));
        }
        return this;
    }

    public AdminAddProductPage checkCategoryOptions() {
        Assert.assertEquals(categoryOptionsXpathList.size(), categoryOptionsList.length);
        for (int i = 0; i < categoryOptionsXpathList.size(); i++) {
            WebElement option = ElementActions.find(driver.get(), categoryOptionsXpathList.get(i));
            Assert.assertTrue(Arrays.stream(categoryOptionsList).equals(option.getText()));
        }

        return this;
    }
    /*************** End Check Category & Brand Options  *******************/

    /*************** Check Add btn and Close Btn Is Displayed  *******************/
    public AdminAddProductPage checkAddBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addBtn));
        return this;
    }

    public AdminAddProductPage checkCloseAddProductFormBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), closeAddProductFormBtn));
        return this;
    }
    /***************End Check Add btn and Close Btn Is Displayed  *******************/

    /***************Add btn Text  *******************/

    public AdminAddProductPage checkAddBtnText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addBtn).contains("Add"));
        return this;
    }
    /***************End Add btn Text  *******************/

    /***************check Add Product form is not Displayed  *******************/
    public AdminAddProductPage checkAddProductFormIsNotDisplayed() {
        Assert.assertTrue(!ElementActions.isDisplayed(driver.get(), addProductForm));
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    public AdminAddProductPage checkToastMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastMsg));
        return this;
    }

    public AdminAddProductPage checkToastMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), toastMsg).contains("Product Added Successfully"));
        return this;
    }

    public AdminAddProductPage checkToastCloseBtnIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastCloseBtn));
        return this;
    }

    public AdminAddProductPage checkToastMsgIsNotDisplayed() {
        Assert.assertTrue(!ElementActions.isDisplayed(driver.get(), toastMsg));
        return this;
    }

    /***************End Toast msg staff  *******************/
    /***************  Error Msg Is Displayed *******************/
    public AdminAddProductPage checkTitleErrorMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleErrorMsg));
        return this;
    }

    public AdminAddProductPage checkCategoryErrorMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryErrorMsg));
        return this;
    }

    public AdminAddProductPage checkBrandErrorMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandErrorMsg));
        return this;
    }

    public AdminAddProductPage checkPriceErrorMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceErrorMsg));
        return this;
    }

    public AdminAddProductPage checkTotalStockErrorMsgIsDisplayed() {
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockErrorMsg));
        return this;
    }

    /***************  End Error Msg Is Displayed *******************/

    /***************  Error Msg Text *******************/

    public AdminAddProductPage checkTitleErrorMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), titleErrorMsg).contains("Title is required"));
        return this;
    }

    public AdminAddProductPage checkCategoryErrorMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), categoryErrorMsg).contains("Category is required"));
        return this;
    }

    public AdminAddProductPage checkBrandErrorMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), brandErrorMsg).contains("Brand is required"));
        return this;
    }

    public AdminAddProductPage checkPriceErrorMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), priceErrorMsg).contains("Price is required"));
        return this;
    }

    public AdminAddProductPage checkTotalStockErrorMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), totalStockErrorMsg).contains("Total Stock is required"));
        return this;
    }
    /***************  End Error Msg Text *******************/

    /***************  ACTIONS  *******************/

    /***************  clicks  *******************/
    public AdminAddProductPage clickOnCategoryBtn() {
        driver.element().click( categoryBtn);
        return this;
    }

    public AdminAddProductPage clickOnBrandBtn() {
        driver.element().click( brandBtn);
        return this;
    }

    public AdminAddProductPage clickOnCloseAddProductFormBtn() {
        driver.element().click(closeAddProductFormBtn);
        return this;
    }

    public AdminAddProductPage clickOnAddBtn() {
        driver.element().click(addBtn);
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
        ElementActions.set(driver.get(), uploadImageField, uploadFile.getAbsolutePath());
        return this;
    }

    public AdminAddProductPage fillTitleField(String title) {
        ElementActions.set(driver.get(), titleField, title);
        return this;
    }

    public AdminAddProductPage fillDescriptionField(String description) {
        ElementActions.set(driver.get(), descriptionField, description);
        return this;
    }

    public AdminAddProductPage fillPriceField(String price) {
        ElementActions.set(driver.get(), priceField, price);
        return this;
    }

    public AdminAddProductPage fillSalePriceField(String salePrice) {
        ElementActions.set(driver.get(), salePriceField, salePrice);
        return this;
    }

    public AdminAddProductPage fillTotalStockField(String totalStock) {
        ElementActions.set(driver.get(), totalStockField, totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/

    /***************  End ACTIONS  *******************/

}
