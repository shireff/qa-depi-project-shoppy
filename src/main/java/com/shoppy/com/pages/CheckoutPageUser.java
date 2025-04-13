package com.shoppy.com.pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPageUser
{
    private final Driver driver;

    //Header section
    private final By Header = By.xpath("//span[text()='Shoppy']");

    //Header Responsive Navbar
    private final By Responsive_Nav_Button = By.xpath("//header/div/button[@type=\"button\"]");

    //Header Buttons
    private final By Home_Label_Button = By.xpath("//nav/label[1]");
    private final By Products_Label_Button = By.xpath("//nav/label[2]");
    private final By Men_Label_Button = By.xpath("//nav/label[3]");
    private final By Women_Label_Button = By.xpath("//nav/label[4]");
    private final By Kids_Label_Button = By.xpath("//nav/label[5]");
    private final By Footwear_Label_Button = By.xpath("//nav/label[6]");
    private final By Accessories_Label_Button = By.xpath("//nav/label[7]");
    private final By Search_Label_Button = By.xpath("//nav/label[8]");
    private final By Shoppy_Icon = By.xpath("//header/div/a");

    //Footer section
    private final By footerLinks = By.cssSelector("footer a");

    //Footer links
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");

    //Checkout Title Image
    private final By Title_Image = By.xpath("//img [@alt=\"Account Image\"]");

    //Form fields
    private final By User_Saved_Address = By.xpath("//main/div/div[2]/div[1]/div[1]/p");
    private final By AddNewAddress_Title = By.xpath("//main/div/div[2]/div[1]/div[2]/div");
    private final By Address_Label = By.xpath("//form/div/div[1]/label");
    private final By Address_Input = By.xpath("//input [@id=\"address\"]");
    private final By City_Label = By.xpath("//form/div/div[2]/label");
    private final By City_Input = By.xpath("//input [@id=\"city\"]");
    private final By PineCode_Label = By.xpath("//form/div/div[3]/label");
    private final By PinCode_Input = By.xpath("//input [@id=\"pincode\"]");
    private final By Phone_Label = By.xpath("//form/div/div[4]/label");
    private final By Phone_input = By.xpath("//input [@id=\"phone\"]");
    private final By Notes_Label = By.xpath("//form/div/div[5]/label");
    private final By Notes_TextArea = By.xpath("//textarea [@id=\"notes\"]");
    private final By AddAddress_Button = By.xpath("//button[@type=\"submit\"]");

    //product data
    private final By Product_Image = By.xpath("//main/div/div[2]/div[2]/div[1]/img");
    private final By Product_Name = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/h3");
    private final By Minus_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/button[1]");
    private final By Add_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/button[2]");
    private final By ProductQuantity_Label = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/span");
    private final By ProductPrice_Label = By.xpath("//main/div/div[2]/div[2]/div[1]/div[2]/p");
    private final By DeleteProduct_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[2]/*[local-name() = 'svg']");
    //private final By DeleteProduct_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[2]");

    //Total data
    private final By Total_Title = By.xpath("//main/div/div[2]/div[2]/div[2]/div/span[1]");
    private final By TotalBuy_Label = By.xpath("//main/div/div[2]/div[2]/div[2]/div/span[2]");
    private final By PayPal_Button = By.xpath("//main/div/div[2]/div[2]/div[3]/div[1]");
    private final By Cash_Button = By.xpath("//main/div/div[2]/div[2]/div[3]/div[2]");

    //Checkout button
    private final By Checkout_Button = By.xpath("//main/div/div[2]/div[2]/div[4]/button");

    //Error message
    private final By Error_Message = By.xpath("//div//ol");

    //Update message
    private final By checkoutUpdatedSuccessfullyMessage = By.xpath("//li/div/div[contains(text(),'Card item updated successfully')]");

    //Delete message
    private final By DeletedMessage = By.xpath("//li/div/div");

    //AddAddress message
    private final By AddAddressMessage = By.xpath("//li/div/div");

    //Address data
    private final By AddressData = By.xpath("//form/div/div[1]/label");

    //Order success message
    private final By OrderSuccessMessage = By.xpath("//main/div/div/div/h2");

    //Edit address button(in address section)
    private final By EditAddress_Button = By.xpath("//main/div/div[2]/div/div/div/div[2]/button[1]");

    //Form Edit address button
    private final By FormEditAddress_Button = By.xpath("//main/div/div[2]/div/div[3]/form/button");

    //Edit message
    private final By EditMessage = By.xpath("//li/div/div");

    //Delete message
    private final By DeleteMessage = By.xpath("//li/div/div");

    //Delete address button(in address section)
    private final By FormDeleteAddress_Button = By.xpath("//main/div/div[2]/div/div/div/div[2]/button[2]");

    //Close Button
    private final By Close_Button = By.xpath("//main/div/div/div/button");


    String ErrorMessageTitle = "Please select an address to proceed with the payment.";
    String UpdatedMessageTitle = "Card item updated successfully";
    String DeletedMessageTitle = "Card item deleted successfully";
    String AddAddressMessageTitle = "Address added successfully";


    //constructor
    public CheckoutPageUser(Driver driver)
    {
        this.driver = driver;
    }


/************************************ Assertions *******************************************/
   //Header Displayedibility

    @Step("Assert header is displayed")
    public CheckoutPageUser checkThatTheHeaderDisblayed() {
    Assert.assertTrue(driver.get().findElement(Header).isDisplayed());
    return this;
}

    //Header Buttons Displayedibility

    @Step("Assert home label button is displayed")
    public CheckoutPageUser checkThatTheHomeLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Home_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert products label button is displayed")
    public CheckoutPageUser checkThatTheProductsLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Products_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert mens label button is displayed")
    public CheckoutPageUser checkThatTheMensLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Men_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert women label button is displayed")
    public CheckoutPageUser checkThatTheWomenLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Women_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert kids label button  is displayed")
    public CheckoutPageUser checkThatTheKidsLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Kids_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert footwear label button is displayed")
    public CheckoutPageUser checkThatTheFootwearLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Footwear_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert accessories label button is displayed")
    public CheckoutPageUser checkThatTheAccessoriesLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Accessories_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert search label button is displayed")
    public CheckoutPageUser checkThatTheSearchLabelButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Search_Label_Button).isDisplayed());
        return this;
    }

    @Step("Assert shoppy icon is displayed")
    public CheckoutPageUser checkThatTheShoopyIconIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Shoppy_Icon).isDisplayed());
        return this;
    }

    //footer Displayedibility

    @Step("Assert footer is displayed")
    public CheckoutPageUser checkThatTheFooterIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(footerLinks).isDisplayed());
        return this;
    }
    //footer_links Displayedibility

    @Step("Assert Right reserved is displayed")
     public CheckoutPageUser checkThatTheRightsReservedIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Footer_Rights_Reserved).isDisplayed());
        return this;
    }

    @Step("Assert GitHub is displayed")
    public CheckoutPageUser checkThatTheGithubIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Footer_GitHub).isDisplayed());
        return this;
    }

    @Step("Assert Linkedin is displayed")
    public CheckoutPageUser checkThatTheLinkedinIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Footer_LinkedIn).isDisplayed());
        return this;
    }

    @Step("Assert Whatsapp is displayed")
    public CheckoutPageUser checkThatTheWatsappIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Footer_WhatsApp).isDisplayed());
        return this;
    }

   //Title_Image Disapility

    @Step("Assert title image is displayed")
    public CheckoutPageUser checkThatTheTitleImageIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Title_Image).isDisplayed());
        return this;
    }

    @Step("Assert product image src is displayed")
    public CheckoutPageUser checkThatTheProductImageSrcIsDisable() {
        Assert.assertEquals(driver.get().findElement(Title_Image).getAttribute("src"), "https://shoppy-ochre.vercel.app/assets/account-BgQkthTh.jpg");
        return this;
    }

    //Form_adding_address Displayedibility

    @Step("Assert user saved address is displayed")
    public CheckoutPageUser checkThatTheUserSavedAddressIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(User_Saved_Address).isDisplayed());
        return this;
    }

    @Step("Assert new address title is displayed")
    public CheckoutPageUser checkThatTheNewAddressTitleIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(AddNewAddress_Title).isDisplayed());
        return this;
    }

    @Step("Assert address label is displayed")
    public CheckoutPageUser checkThatTheAdressLabelIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Address_Label).isDisplayed());
        return this;
    }

    @Step("Assert address input is displayed")
    public CheckoutPageUser checkThatTheAdressInputIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Address_Input).isDisplayed());
        return this;
    }

    @Step("Assert city label is displayed")
    public CheckoutPageUser checkThatTheCityLabelIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(City_Label).isDisplayed());
        return this;
    }

    @Step("Assert city input is displayed")
    public CheckoutPageUser checkThatTheCityInputIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(City_Input).isDisplayed());
        return this;
    }

    @Step("Assert pin code label is displayed")
    public CheckoutPageUser checkThatThePineCodeLabelIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(PineCode_Label).isDisplayed());
        return this;
    }

    @Step("Assert pin code input is displayed")
    public CheckoutPageUser checkThatThePinCodeInputIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(PinCode_Input).isDisplayed());
        return this;
    }

    @Step("Assert phone input lable is displayed")
    public CheckoutPageUser checkThatThePhoneLabelIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Phone_Label).isDisplayed());
        return this;
    }

    @Step("Assert phone input is displayed")
    public CheckoutPageUser checkThatThePhoneinputIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Phone_input).isDisplayed());
        return this;
    }

    @Step("Assert notes label is displayed")
    public CheckoutPageUser checkThatTheNotesLabelIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Notes_Label).isDisplayed());
        return this;
    }

    @Step("Assert notes text area is displayed")
    public CheckoutPageUser checkThatTheNotesTextAreaIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(Notes_TextArea).isDisplayed());
        return this;
    }

    @Step("Assert addaddress button is displayed")
    public CheckoutPageUser checkThatTheAddAddressButtonIsDisblayed() {
        Assert.assertTrue(driver.get().findElement(AddAddress_Button).isDisplayed());
        return this;
    }

    @Step("Assert addaddress button is disapled")
    public CheckoutPageUser checkThatTheAddAddressButtonIsDisapledWhenFormIsEmpty() {
        Assert.assertFalse(driver.get().findElement(AddAddress_Button).isEnabled());
        System.out.println("AddAddress Button is disapled when Form Is Empty");
        return this;
    }

    //Product_data Displayedibility
    @Step("Assert product image is displayed")
    public CheckoutPageUser checkThatTheProductImagesDisblayed() {
        Assert.assertTrue(driver.get().findElement(Product_Image).isDisplayed());
        return this;
    }

    @Step("Assert product name is displayed")
    public CheckoutPageUser checkThatTheProductNameDisblayed() {
        Assert.assertTrue(driver.get().findElement(Product_Name).isDisplayed());
        return this;
    }

    @Step("Assert minus button is displayed")
    public CheckoutPageUser checkThatTheMinusButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(Minus_Button).isDisplayed());
        return this;
    }

    @Step("Assert add button is displayed")
    public CheckoutPageUser checkThatTheAddButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(Add_Button).isDisplayed());
        return this;
    }

    @Step("Assert product quantity is displayed")
    public CheckoutPageUser checkThatTheProductQuantityLabelDisblayed() {
        Assert.assertTrue(driver.get().findElement(ProductQuantity_Label).isDisplayed());
        return this;
    }

    @Step("Assert product price label is displayed")
    public CheckoutPageUser checkThatTheProductPriceLabelDisblayed() {
        Assert.assertTrue(driver.get().findElement(ProductPrice_Label).isDisplayed());
        return this;
    }

    @Step("Assert delete product button is displayed")
    public CheckoutPageUser checkThatTheDeleteProductButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(DeleteProduct_Button).isDisplayed());
        return this;
    }

    //Total_data Displayedibility

    @Step("Assert total title is displayed")
    public CheckoutPageUser checkThatTheTotalTitleDisblayed() {
        Assert.assertTrue(driver.get().findElement(Total_Title).isDisplayed());
        return this;
    }

    @Step("Assert total buy label is displayed")
    public CheckoutPageUser checkThatTheTotalBuyLabelDisblayed() {
        Assert.assertTrue(driver.get().findElement(TotalBuy_Label).isDisplayed());
        return this;
    }

    @Step("Assert paypal button is displayed")
    public CheckoutPageUser checkThatThePayPalButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(PayPal_Button).isDisplayed());
        return this;
    }

    @Step("Assert cash button is displayed")
    public CheckoutPageUser checkThatTheCashButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(Cash_Button).isDisplayed());
        return this;
    }

    //Checkout_button Displayedibility
    @Step("Assert checkout button is displayed")
    public CheckoutPageUser checkThatTheCheckoutButtonDisblayed() {
        Assert.assertTrue(driver.get().findElement(Checkout_Button).isDisplayed());
        return this;
    }
    @Step("Assert checkout button is clickable")
    public CheckoutPageUser checkThatTheCheckoutButtonIsClickable() {
        Assert.assertTrue(driver.element().isClickable(Checkout_Button));
        return this;
    }

    // AddAddress button is disabled when the form fields are empty
    @Step("Assert addaddress button is not clickable")
    public CheckoutPageUser checkThatTheAddaddressButtonIsNotClickableWhenTheFormFieldsAreEmpty() {
        Assert.assertFalse(driver.element().isClickable(AddAddress_Button));
        return this;
    }
    @Step("Assert error message is displayed")
    public CheckoutPageUser checkThatTheErrorMessageShowWhenTheFormFieldsAreEmpty() {
        Assert.assertTrue(driver.get().findElement(Error_Message).isDisplayed());
        return this;

    }

    @Step("Assert error message text is correct")
    public CheckoutPageUser checkThatTheErrorMessageTitleIsCorrect() {
        Assert.assertEquals(driver.element().getTextOf(Error_Message), ErrorMessageTitle);
        return this;
    }

    @Step("Assert product data aftern increasing quantity are displayed")
    public CheckoutPageUser checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(ProductQuantity_Label, "2"));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Product_Name));

        WebElement productElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPrice_Label));
        System.out.println("Price After Update is: " + productElement2.getText());

        WebElement productElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductQuantity_Label));
        System.out.println("Quantity After Update is: " + productElement3.getText());

        WebElement productElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(TotalBuy_Label));
        System.out.println("Total After Update is: " + productElement4.getText());

        Assert.assertTrue(driver.get().findElement(Product_Name).isDisplayed());
        return this;
    }

    @Step("Assert update element on checkout page")
    public CheckoutPageUser checkThatTheToastMessageUpdateIsDisplayed() {
        String MSG = "Card item updated successfully";
        By AC = By.xpath("//li[@role=\"status\"]");
        driver.assertion().assertElementTextEquals(AC, MSG, "Element not updated on checkout");
        return this;
    }



    @Step("Assert product data after decreasing quantity are displayed")
    public CheckoutPageUser checkThatTheProducDataIsUpdatedWhendecreasingTheQuantity() {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(20));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(ProductQuantity_Label, "1"));
        WebElement productElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Product_Name));

        WebElement productElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPrice_Label));
        System.out.println("Price After Update is: " + productElement5.getText());

        WebElement productElement6 = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductQuantity_Label));
        System.out.println("Quantity After Update is: " + productElement6.getText());

        WebElement productElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(TotalBuy_Label));
        System.out.println("Total After Update is: " + productElement7.getText());

        Assert.assertTrue(driver.get().findElement(Product_Name).isDisplayed());
        return this;
    }

    @Step("Assert update message is displayed")
    public CheckoutPageUser checkThatTheUpdateMessageShowWhenUpdatingTheQuantity() {
        Assert.assertTrue(driver.get().findElement(checkoutUpdatedSuccessfullyMessage).isDisplayed());
        return this;

    }

    @Step("Assert update message text is correct")
    public CheckoutPageUser checkThatTheUpdateMessageTitleIsCorrectWhenUpdatingTheQuantity() {
        Assert.assertEquals(driver.element().getTextOf(checkoutUpdatedSuccessfullyMessage), UpdatedMessageTitle);
        return this;
    }

    @Step("Assert product is deleted and checkout is disapled")
    public CheckoutPageUser checkThatTheProductIsDeleted() {
        Assert.assertFalse(driver.element().isClickable(Checkout_Button));
        System.out.println("checkout Button is disapled");
        return this;
    }

//    @Step("Assert delete message text is correct")
//    public CheckoutPageUser checkThatTheProductMessageDeletedhowWhenDeleting() throws InterruptedException {
//       // WebDriverWait wait12 = new WebDriverWait(driver.get(), Duration.ofSeconds(5));
//        //WebElement productElement = wait12.until(ExpectedConditions.visibilityOfElementLocated(DeletedMessage));
//        //Assert.assertEquals(driver.element().getTextOf(DeletedMessage), DeletedMessageTitle);
//        By AC = By.xpath("//li[@role=\"status\"]");
//
//      //  Thread.sleep(1000000);
//        driver.assertion().assertElementTextEquals(AC,DeletedMessageTitle,"The product is not deleted");
//        return this;
//    }

    //Enter address form data
    @Step("Fill address form with Address, City, Pincode , Phone , Notes")
    public CheckoutPageUser fillAddAddressForm(String address, String city, String pincode, String phone, String notes) {
        driver.element().set( Address_Input, address);
        driver.element().set(City_Input, city);
        driver.element().set( PinCode_Input, pincode);
        driver.element().set( Phone_input, phone);
        driver.element().set( Notes_TextArea, notes);
        return this;
    }

    @Step("Assert AddAddress message is displayed")
    public CheckoutPageUser checkThatTheAddAddressMessageShow() {
        Assert.assertTrue(driver.get().findElement(AddAddressMessage).isDisplayed());
        return this;
    }

    @Step("Assert error message text is correct")
    public CheckoutPageUser checkThatTheAddAddressMessageTitleIsCorrect() {
        WebDriverWait wait4 = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        WebElement productElement = wait4.until(ExpectedConditions.visibilityOfElementLocated(AddAddressMessage));
        Assert.assertEquals(driver.element().getTextOf(AddAddressMessage), AddAddressMessageTitle);
        return this;
    }

    //Address_data Displayedibility
    @Step("Assert Address data is displayed")
    public CheckoutPageUser checkThatTheAddressDataIsDisplayed() {
       // Assert.assertTrue(driver.get().findElement(AddressData).isDisplayed());
        driver.assertion().assertElementDisplayed(AddressData,"The label is not found");
        return this;
    }

    //Edit message Displayedibility
    @Step("Assert Address data is displayed")
    public CheckoutPageUser checkThatTheEditMessageIsDisplayed() {
        Assert.assertTrue(driver.get().findElement(EditMessage).isDisplayed());
        return this;
    }

    //Delete message Displayedibility
    @Step("Assert Address data is displayed")
    public CheckoutPageUser checkThatTheDeleteMessageIsDisplayed() {
        Assert.assertTrue(driver.get().findElement(DeleteMessage).isDisplayed());
        return this;
    }

    //Order success message Displayedibility
    @Step("Assert Address data is displayed")
    public CheckoutPageUser checkThatTheOrderSucessMessageIsDisplayed() {
        Assert.assertTrue(driver.get().findElement(OrderSuccessMessage).isDisplayed());
        return this;
    }

    //Order close button Displayedibility
    @Step("Assert Order close button is displayed")
    public CheckoutPageUser checkThatTheOrderCloseButtonIsDisplayed() {
        Assert.assertTrue(driver.get().findElement(Close_Button).isDisplayed());
        return this;
    }

    //The Url chenged to paypal
    @Step("Assert Order close button is displayed")
        public CheckoutPageUser checkThatTheUrlChangedToThePaypalPage() {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), "https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-9PW8158869794003M");
        return this;
    }

    /************************************** Actions ********************************************/
    @Step("Click addaddress button")
    public CheckoutPageUser clickOnAddAddressButton()  {
        driver.element().click(AddAddress_Button);
        return this;
    }

    @Step("Click checkout button")
    public CheckoutPageUser clickOnCheckoutButton()  {
        driver.element().click(Checkout_Button);
        return this;
    }

    @Step("Click add(+) button")
    public CheckoutPageUser clickOnPlusButton()  {
        driver.element().click(Add_Button);
        return this;
    }

    @Step("Click minus(-) button")
    public CheckoutPageUser clickOnminusButton()  {
        driver.element().click(Minus_Button);
        return this;
    }

    @Step("Click delete button")
    public CheckoutPageUser clickOndeleteButton()  {
        driver.element().click(DeleteProduct_Button);
        return this;
    }

    @Step("Click address section")
    public CheckoutPageUser clickOnAddressSection()  {
        driver.element().click(AddressData);
        return this;
    }

    @Step("Click cashondelivery section")
    public CheckoutPageUser clickOnCashOnDeliveryButton()  {
        driver.element().click(Cash_Button);
        return this;
    }

    @Step("Click paypal section")
    public CheckoutPageUser clickOnPaypalButton()  {
        driver.element().click(PayPal_Button);
        return this;
    }

    @Step("Click edit button in address section")
    public CheckoutPageUser clickOnEditAddressButton()  {
        driver.element().click(EditAddress_Button);
        return this;
    }

    @Step("Click edit address button in form")
    public CheckoutPageUser clickOEditAddressButtonInForm()  {
        driver.element().click(FormEditAddress_Button);
        return this;
    }

    @Step("Click edit address button in address section")
    public CheckoutPageUser clickOnDeleteAddressButton()  {
        driver.element().click(FormDeleteAddress_Button);
        //driver.get().findElement(FormDeleteAddress_Button).submit();
        return this;
    }

    @Step("Click close button")
    public CheckoutPageUser clickOnCloseButton()  {
        driver.element().click(Close_Button);
        return this;
    }

    @Step("Click shopy link")
    public HomePage clickOnShopyLink()  {
        driver.element().click(Shoppy_Icon);
        return new HomePage(driver);
    }


}

