package com.shoppy.com.pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.shoppy.com.utils.Waits.*;

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
    private final By checkoutUpdatedSuccessfullyMessage = By.xpath("//li/div/div");

    //Delete message
    private final By DeletedMessage = By.xpath("//li/div/div");

    //AddAddress message
    private final By AddAddressMessage = By.xpath("//li/div/div");

    //Address data
    private final By AddressData = By.xpath("//div[1]/div/main/div/div[2]/div[1]/div[1]/div[1]");

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

    //Payment message
    private final By PaymentMessage = By.xpath("//div[2]/ol/li");


    //constructor
    public CheckoutPageUser(Driver driver)
    {
        this.driver = driver;
    }


/************************************ Assertions *******************************************/
   //Header Displayedibility
    @Step("Assert header is displayed")
    public CheckoutPageUser checkThatTheHeaderDisblayed() {
       driver.assertion().assertElementDisplayed(Header, "❌ The header is not displayed!");
       return this;
}

    //Header Buttons Displayedibility
    @Step("Assert home label button is displayed")
    public CheckoutPageUser checkThatTheHomeLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Home_Label_Button, "❌ The home label button is not displayed!");
        return this;
    }

    @Step("Assert products label button is displayed")
    public CheckoutPageUser checkThatTheProductsLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Products_Label_Button, "❌ The products label button is not displayed!");
        return this;
    }

    @Step("Assert mens label button is displayed")
    public CheckoutPageUser checkThatTheMensLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Men_Label_Button, "❌ The mens label button is not displayed!");
        return this;
    }

    @Step("Assert women label button is displayed")
    public CheckoutPageUser checkThatTheWomenLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Women_Label_Button, "❌ The women label button is not displayed!");
        return this;
    }

    @Step("Assert kids label button  is displayed")
    public CheckoutPageUser checkThatTheKidsLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Kids_Label_Button, "❌ The kids label button is not displayed!");
        return this;
    }

    @Step("Assert footwear label button is displayed")
    public CheckoutPageUser checkThatTheFootwearLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Footwear_Label_Button, "❌ The footwear label button is not displayed!");
        return this;
    }

    @Step("Assert accessories label button is displayed")
    public CheckoutPageUser checkThatTheAccessoriesLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Accessories_Label_Button, "❌ The accessories label button is not displayed!");
        return this;
    }

    @Step("Assert search label button is displayed")
    public CheckoutPageUser checkThatTheSearchLabelButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(Search_Label_Button, "❌ The search label button is not displayed!");
        return this;
    }

    @Step("Assert shoppy icon is displayed")
    public CheckoutPageUser checkThatTheShoopyIconIsDisblayed() {
        driver.assertion().assertElementDisplayed(Shoppy_Icon, "❌ The shoppy icon is not displayed!");
        return this;
    }

    //footer Displayedibility
    @Step("Assert footer is displayed")
    public CheckoutPageUser checkThatTheFooterIsDisblayed() {
        driver.assertion().assertElementDisplayed(footerLinks, "❌ The footer is not displayed!");
        return this;
    }
    //footer_links Displayedibility
    @Step("Assert Right reserved is displayed")
     public CheckoutPageUser checkThatTheRightsReservedIsDisblayed() {
        driver.assertion().assertElementDisplayed(Footer_Rights_Reserved, "❌ The footer rights reserved is not displayed!");
        return this;
    }

    @Step("Assert GitHub is displayed")
    public CheckoutPageUser checkThatTheGithubIsDisblayed() {
        driver.assertion().assertElementDisplayed(Footer_GitHub, "❌ The github is not displayed!");
        return this;
    }

    @Step("Assert Linkedin is displayed")
    public CheckoutPageUser checkThatTheLinkedinIsDisblayed() {
        driver.assertion().assertElementDisplayed(Footer_LinkedIn, "❌ The linkedin is not displayed!");
        return this;
    }

    @Step("Assert Whatsapp is displayed")
    public CheckoutPageUser checkThatTheWatsappIsDisblayed() {
        driver.assertion().assertElementDisplayed(Footer_WhatsApp, "❌ The whatsapp is not displayed!");
        return this;
    }

   //Title_Image Disapility
    @Step("Assert title image is displayed")
    public CheckoutPageUser checkThatTheTitleImageIsDisblayed() {
        driver.assertion().assertElementDisplayed(Title_Image, "❌ The title image is not displayed!");
        return this;
    }

    @Step("Assert product image src is displayed")
    public CheckoutPageUser checkThatTheProductImageSrcIsDisable() {
        String title_image_src = driver.get().findElement(Title_Image).getAttribute("src");
        driver.validations().validateEquals(title_image_src, "https://shoppy-ochre.vercel.app/assets/account-BgQkthTh.jpg", "❌ The title image src is not displayed!");
        return this;
    }

    //Form_adding_address Displayedibility
    @Step("Assert user saved address is displayed")
    public CheckoutPageUser checkThatTheUserSavedAddressIsDisblayed() {
        driver.assertion().assertElementDisplayed(User_Saved_Address, "❌ The user saved address is not displayed!");
        return this;
    }

    @Step("Assert new address title is displayed")
    public CheckoutPageUser checkThatTheNewAddressTitleIsDisblayed() {
        driver.assertion().assertElementDisplayed(AddNewAddress_Title, "❌ The add new address title is not displayed!");
        return this;
    }

    @Step("Assert address label is displayed")
    public CheckoutPageUser checkThatTheAdressLabelIsDisblayed() {
        driver.assertion().assertElementDisplayed(Address_Label, "❌ The address label is not displayed!");

        return this;
    }

    @Step("Assert address input is displayed")
    public CheckoutPageUser checkThatTheAdressInputIsDisblayed() {
        driver.assertion().assertElementDisplayed(Address_Input, "❌ The address input is not displayed!");
        return this;
    }

    @Step("Assert city label is displayed")
    public CheckoutPageUser checkThatTheCityLabelIsDisblayed() {
        driver.assertion().assertElementDisplayed(City_Label, "❌ The city label is not displayed!");
        return this;
    }

    @Step("Assert city input is displayed")
    public CheckoutPageUser checkThatTheCityInputIsDisblayed() {
        driver.assertion().assertElementDisplayed(City_Input, "❌ The city input is not displayed!");
        return this;
    }

    @Step("Assert pin code label is displayed")
    public CheckoutPageUser checkThatThePineCodeLabelIsDisblayed() {
        driver.assertion().assertElementDisplayed(PineCode_Label, "❌ The pincode label is not displayed!");
        return this;
    }

    @Step("Assert pin code input is displayed")
    public CheckoutPageUser checkThatThePinCodeInputIsDisblayed() {
        driver.assertion().assertElementDisplayed(PinCode_Input, "❌ The pincode input is not displayed!");
        return this;
    }

    @Step("Assert phone label lable is displayed")
    public CheckoutPageUser checkThatThePhoneLabelIsDisblayed() {
        driver.assertion().assertElementDisplayed(Phone_Label, "❌ The phone label is not displayed!");
        return this;
    }

    @Step("Assert phone input is displayed")
    public CheckoutPageUser checkThatThePhoneinputIsDisblayed() {
        driver.assertion().assertElementDisplayed(Phone_input, "❌ The phone input is not displayed!");
        return this;
    }

    @Step("Assert notes label is displayed")
    public CheckoutPageUser checkThatTheNotesLabelIsDisblayed() {
        driver.assertion().assertElementDisplayed(Notes_Label, "❌ The notes label is not displayed!");
        return this;
    }

    @Step("Assert notes textarea is displayed")
    public CheckoutPageUser checkThatTheNotesTextAreaIsDisblayed() {
        driver.assertion().assertElementDisplayed(Notes_TextArea, "❌ The notes textarea is not displayed!");
        return this;
    }

    @Step("Assert addaddress button is displayed")
    public CheckoutPageUser checkThatTheAddAddressButtonIsDisblayed() {
        driver.assertion().assertElementDisplayed(AddAddress_Button, "❌ The addaddress button is not displayed!");
        return this;
    }

    @Step("Assert addaddress button is disapled")
    public CheckoutPageUser checkThatTheAddAddressButtonIsDisapledWhenFormIsEmpty() {

        boolean isAddAddressButtonEnabled = driver.get().findElement(AddAddress_Button).isEnabled();
        driver.validations().validateEquals(isAddAddressButtonEnabled, false, "❌ The minus button is not disabled!");
        return this;
    }

    //Product_data Displayedibility
    @Step("Assert product image is displayed")
    public CheckoutPageUser checkThatTheProductImagesDisblayed() {
        driver.assertion().assertElementDisplayed(Product_Image, "❌ The product image is not displayed!");
        return this;
    }

    @Step("Assert product name is displayed")
    public CheckoutPageUser checkThatTheProductNameDisblayed() {
        driver.assertion().assertElementDisplayed(Product_Name, "❌ The product name is not displayed!");
        return this;
    }

    @Step("Assert minus button is displayed")
    public CheckoutPageUser checkThatTheMinusButtonDisblayed() {
        driver.assertion().assertElementDisplayed(Minus_Button, "❌ The minus button is not displayed!");
        return this;
    }

    @Step("Assert add button is displayed")
    public CheckoutPageUser checkThatTheAddButtonDisblayed() {
        driver.assertion().assertElementDisplayed(Add_Button, "❌ The add button is not displayed!");
        return this;
    }

    @Step("Assert product quantity is displayed")
    public CheckoutPageUser checkThatTheProductQuantityLabelDisblayed() {
        driver.assertion().assertElementDisplayed(ProductQuantity_Label, "❌ The product quantity is not displayed!");
        return this;
    }

    @Step("Assert product price label is displayed")
    public CheckoutPageUser checkThatTheProductPriceLabelDisblayed() {
        driver.assertion().assertElementDisplayed(ProductPrice_Label, "❌ The product price label is not displayed!");
        return this;
    }

    @Step("Assert delete product button is displayed")
    public CheckoutPageUser checkThatTheDeleteProductButtonDisblayed() {
        driver.assertion().assertElementDisplayed(DeleteProduct_Button, "❌ The product button is not displayed!");
        return this;
    }

    //Total_data Displayedibility
    @Step("Assert total title is displayed")
    public CheckoutPageUser checkThatTheTotalTitleDisblayed() {
        driver.assertion().assertElementDisplayed(Total_Title, "❌ The total title is not displayed!");
        return this;
    }

    @Step("Assert total buy label is displayed")
    public CheckoutPageUser checkThatTheTotalBuyLabelDisblayed() {
        driver.assertion().assertElementDisplayed(TotalBuy_Label, "❌ The total label is not displayed!");
        return this;
    }

    @Step("Assert paypal button is displayed")
    public CheckoutPageUser checkThatThePayPalButtonDisblayed() {
        driver.assertion().assertElementDisplayed(PayPal_Button, "❌ The paypal button is not displayed!");
        return this;
    }

    @Step("Assert cash button is displayed")
    public CheckoutPageUser checkThatTheCashButtonDisblayed() {
        driver.assertion().assertElementDisplayed(Cash_Button, "❌ The cash button is not displayed!");
        return this;
    }

    //Checkout_button Displayedibility
    @Step("Assert checkout button is displayed")
    public CheckoutPageUser checkThatTheCheckoutButtonDisblayed() {
        driver.assertion().assertElementDisplayed(Checkout_Button, "❌ The checkout button is not displayed!");
        return this;
    }
    @Step("Assert checkout button is clickable")
    public CheckoutPageUser checkThatTheCheckoutButtonIsClickable() {
        driver.validations().validateEquals(driver.element().isClickable(Checkout_Button), true, "❌ The checkout button is not clickable!");
        return this;
    }

    // AddAddress button is disabled when the form fields are empty
    @Step("Assert addaddress button is not clickable")
    public CheckoutPageUser checkThatTheAddaddressButtonIsNotClickableWhenTheFormFieldsAreEmpty() {
        driver.validations().validateEquals(driver.element().isClickable(AddAddress_Button), false, "❌ The addaddress button is clickabl!");

        return this;
    }

    @Step("Assert error message is displayed")
    public CheckoutPageUser checkThatTheErrorMessageShowWhenTheFormFieldsAreEmpty() {
        driver.assertion().assertElementDisplayed(Error_Message, "❌ The error is not displayed!");
        return this;

    }

    @Step("Assert product data aftern increasing quantity are displayed")
    public CheckoutPageUser checkThatTheProducDataIsUpdatedWithePlusIcon() {
        waitForElementTextToBe(driver.get(), ProductQuantity_Label, "2");

        String productQuantity =driver.get().findElement(ProductQuantity_Label).getText();
        driver.validations().validateEquals(productQuantity,"2", "❌ The product quantity is not 2");
        return this;
    }

    @Step("Assert product data after decreasing quantity are displayed")
    public CheckoutPageUser checkThatTheProducDataIsUpdatedWithMinusIcon() {
        waitForElementTextToBe(driver.get(), ProductQuantity_Label, "1");

        String productQuantity =driver.get().findElement(ProductQuantity_Label).getText();
        driver.validations().validateEquals(productQuantity,"1", "❌ The product quantity is not 1");
        return this;
    }

    @Step("Assert update message is displayed")
    public CheckoutPageUser checkThatTheUpdateMessageShowWhenUpdatingTheQuantity() {
        driver.assertion().assertElementDisplayed(checkoutUpdatedSuccessfullyMessage, "❌ The update message is not displayed!");
        return this;
    }

    @Step("Assert delete message is displayed")
    public CheckoutPageUser checkThatTheDeleteMessageShow() {
        driver.assertion().assertElementDisplayed(DeletedMessage, "❌ The product is not deleted!");
        return this;
    }

    //Enter address form data
    @Step("Fill address form with Address, City, Pincode , Phone , Notes")
    public CheckoutPageUser fillAddAddressForm(String address, String city, String pincode, String phone, String notes) {
        driver.element().type(Address_Input, address);
        driver.element().type(City_Input, city);
        driver.element().type(PinCode_Input, pincode);
        driver.element().type(Phone_input, phone);
        driver.element().type(Notes_TextArea, notes);
        return this;
    }

    @Step("Assert AddAddress message is displayed")
    public CheckoutPageUser checkThatTheAddAddressMessageShow() {
        driver.assertion().assertElementDisplayed(AddAddressMessage, "❌ The addaddress message is not displayed!");
        return this;
    }

    //Address_data Displayedibility
    @Step("Assert Address data is displayed")
    public CheckoutPageUser checkThatTheAddressDataIsDisplayed() {
        driver.assertion().assertElementDisplayed(AddressData,"❌ The Address data is not displayed");
        return this;
    }

    //Edit message Displayedibility
    @Step("Assert edit message is displayed")
    public CheckoutPageUser checkThatTheEditMessageIsDisplayed() {
        driver.assertion().assertElementDisplayed(EditMessage, "❌ The edit message is not displayed!");
        return this;
    }

    //Delete message Displayedibility
    @Step("Assert delete message is displayed")
    public CheckoutPageUser checkThatTheDeleteMessageIsDisplayed() {
        driver.assertion().assertElementDisplayed(DeleteMessage, "❌ The delete message is not displayed!");
        return this;
    }

    //Order success message Displayedibility
    @Step("Assert order success message is displayed")
    public CheckoutPageUser checkThatTheOrderSucessMessageIsDisplayed() {
        driver.assertion().assertElementDisplayed(OrderSuccessMessage, "❌ The order success message is not displayed!");
        return this;
    }

    //Order close button Displayedibility
    @Step("Assert Order close button is displayed")
    public CheckoutPageUser checkThatTheOrderCloseButtonIsDisplayed() {
        driver.assertion().assertElementDisplayed(Close_Button, "❌ The order close button is not displayed!");
        return this;
    }

    //Payment message disability
    @Step("Assert payment error message is displayed")
    public CheckoutPageUser checkThatThePaymentMessageShow() {
        driver.assertion().assertElementDisplayed(PaymentMessage, "❌ The payment error message is not displayed!");
        return this;
    }

    //URL changed to paypal
    @Step("Assert payment error message is displayed")
    public CheckoutPageUser checkThatTheUrlChangedToPaypal() {
        boolean currentUrl = waitForUrlToContain(driver.get(), "paypal.com");
        driver.validations().validateTrue(
                currentUrl,
                "❌ The url doesn't changed to paypal!"
        );
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

    @Step("Select address")
    public CheckoutPageUser clickOnAddressSection()  {
        driver.element().click(AddressData);
        return this;
    }

    @Step("Click cash_on_delivery button")
    public CheckoutPageUser clickOnCashOnDeliveryButton()  {
        driver.element().click(Cash_Button);
        return this;
    }

    @Step("Click paypal button")
    public CheckoutPageUser clickOnPaypalButton()  {
        driver.element().click(PayPal_Button);
        return this;
    }

    @Step("Click edit address button in address section")
    public CheckoutPageUser clickOnEditAddressButton()  {
        driver.element().click(EditAddress_Button);
        return this;
    }

    @Step("Click edit address button in form")
    public CheckoutPageUser clickOEditAddressButtonInForm()  {
        driver.element().click(FormEditAddress_Button);
        return this;
    }

    @Step("Click delete address button in address section")
    public CheckoutPageUser clickOnDeleteAddressButton()  {
        driver.element().click(FormDeleteAddress_Button);
        return this;
    }

    @Step("Click close button")
    public CheckoutPageUser clickOnCloseButton()  {
        driver.element().click(Close_Button);
        return this;
    }

    @Step("Click shoppy link")
    public HomePage clickOnShopyLink()  {
        driver.element().click(Shoppy_Icon);
        return new HomePage(driver);
    }


}

