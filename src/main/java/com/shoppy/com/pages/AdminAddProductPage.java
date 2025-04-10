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
    // options problem
    private final By div = By.xpath("//div[@data-radix-popper-content-wrapper]");
// private final String path = "./../../../../../../test/resources/1.png"

    //
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
        assertElementDisplayed(addProductForm, "❌ addProductForm is not displayed!");
        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addProductFormTitle));
        assertElementDisplayed(addProductFormTitle, "❌ addProductFormTitle is not displayed!");

        return this;
    }

    public AdminAddProductPage checkAddProductFormTitleText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), addProductFormTitle).contains("Add New Product"));
        return this;
    }
    /************** end form itself***************/

    /***************labels Is Displayed *******************/
//    done
    public AdminAddProductPage checkUploadImageLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageLabel));
        assertElementDisplayed(uploadImageLabel, "❌ uploadImageLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkUploadImageFieldLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageFieldLabel));
        assertElementDisplayed(uploadImageFieldLabel, "❌ uploadImageFieldLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTitleLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleLabel));
        assertElementDisplayed(titleLabel, "❌ titleLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkDescriptionLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionLabel));
        assertElementDisplayed(descriptionLabel, "❌ descriptionLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryLabel));
        assertElementDisplayed(categoryLabel, "❌ categoryLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandLabel));
        assertElementDisplayed(brandLabel, "❌ brandLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceLabel));
        assertElementDisplayed(priceLabel, "❌ priceLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkSalePriceLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceLabel));
        assertElementDisplayed(salePriceLabel, "❌ salePriceLabel is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockLabelIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockLabel));
        assertElementDisplayed(totalStockLabel, "❌ totalStockLabel is not displayed!");

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
//done
    public AdminAddProductPage checkUploadImageFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), uploadImageField));
        assertElementDisplayed(uploadImageField, "❌ uploadImageField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTitleFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), titleField));
        assertElementDisplayed(titleField, "❌ titleField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkDescriptionFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), descriptionField));
        assertElementDisplayed(descriptionField, "❌ descriptionField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryBtn));
        assertElementDisplayed(categoryBtn, "❌ categoryBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategorySelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categorySelect));
        assertElementDisplayed(categorySelect, "❌ categorySelect is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandBtn));
        assertElementDisplayed(brandBtn, "❌ brandBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandSelectIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandSelect));
        assertElementDisplayed(brandSelect, "❌ brandSelect is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceField));
        assertElementDisplayed(priceField, "❌ priceField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkSalePriceFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), salePriceField));
        assertElementDisplayed(salePriceField, "❌ salePriceField is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockFieldIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockField));
        assertElementDisplayed(totalStockField, "❌ totalStockField is not displayed!");

        return this;
    }
    /***************End Fields Is Displayed *******************/

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
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), addBtn));
        assertElementDisplayed(addBtn, "❌ addBtn is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCloseAddProductFormBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), closeAddProductFormBtn));
        assertElementDisplayed(closeAddProductFormBtn, "❌ closeAddProductFormBtn is not displayed!");

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
        assertElementNotDisplayed(addProductForm, "❌ addProductForm is displayed!");
        return this;
    }
    /***************End check Add Product form is not Displayed  *******************/

    /***************Toast msg staff  *******************/
    public AdminAddProductPage checkToastMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastMsg));
        assertElementDisplayed(toastMsg, "❌ toastMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkToastMsgText() {
        Assert.assertTrue(ElementActions.getText(driver.get(), toastMsg).contains("Product Added Successfully"));
        return this;
    }

    public AdminAddProductPage checkToastCloseBtnIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), toastCloseBtn));
        assertElementDisplayed(toastCloseBtn, "❌ toastCloseBtn is not displayed!");

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
        assertElementDisplayed(titleErrorMsg, "❌ titleErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkCategoryErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), categoryErrorMsg));
        assertElementDisplayed(categoryErrorMsg, "❌ categoryErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkBrandErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), brandErrorMsg));
        assertElementDisplayed(brandErrorMsg, "❌ brandErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkPriceErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), priceErrorMsg));
        assertElementDisplayed(priceErrorMsg, "❌ priceErrorMsg is not displayed!");

        return this;
    }

    public AdminAddProductPage checkTotalStockErrorMsgIsDisplayed() {
//        Assert.assertTrue(ElementActions.isDisplayed(driver.get(), totalStockErrorMsg));
        assertElementDisplayed(totalStockErrorMsg, "❌ totalStockErrorMsg is not displayed!");

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
        ElementActions.setNumberField(driver.get(),priceField,price);
        return this;
    }

    public AdminAddProductPage fillSalePriceField(int salePrice) {
//        driver.element().set(salePriceField, String.valueOf(salePrice));
        ElementActions.setNumberField(driver.get(),salePriceField,salePrice);

        return this;
    }

    public AdminAddProductPage fillTotalStockField(int totalStock) {
//        driver.element().set(totalStockField, String.valueOf(totalStock));
        ElementActions.setNumberField(driver.get(),totalStockField,totalStock);
        return this;
    }

    /***************  End Send Keys  *******************/
    /***************  Select options  *******************/
    public AdminAddProductPage selectOptionFromCategorySelect(int index) {
//        driver.element().click(categoryOptionsXpathList.get(index));
        new ElementActions(driver.get()).selectByIndex(categorySelect, index);
        return this;
    }

    public AdminAddProductPage selectOptionFromBrandSelect(int index) {
//        driver.element().click(brandOptionsXpathList.get(index));
        new ElementActions(driver.get()).selectByIndex(brandSelect, index);
        return this;

    }

    /***************  End ACTIONS  *******************/
//
//    public AdminAddProductPage checkGreyAreaIsNotDisplayed() {
//        Assert.assertFalse(ElementActions.isDisplayed(driver.get(), greySection));
//        return this;
//    }
    private void assertElementDisplayed(By locator, String errorMessage) {
        WebElement element = Waits.waitForElementVisible(driver.get(), locator);
        if (element == null || !element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        }
    }

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
