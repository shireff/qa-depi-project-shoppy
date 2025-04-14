package com.shoppy.com.tests.CheckoutPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.CheckoutPageUser;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutPageTests {
    public Driver driver;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeClass
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        new LoginPage(driver).loginIntoApp("mylovelynano@gmail.com", "hakem@2010");
        new LoginPage(driver).assertLoginSuccessfulAsUser();

        new CartPage(driver).checkThatTheProductNameIsDisable()
                .clickOnAddToCartButton()
                .checkThatTheProductMessageAddedSuccesfullyIsDisable()
                .checkThatTheNumberOnCartIsDisable()
                .clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .clickOnCheckoutButton();

    }

    @Test(priority = 1)
    public void testClickingCartAndCheckoutButton() {
        new CartPage(driver).clickOnCartIcon()
                            .checkThatTheCartIsDisplayed()
                            .clickOnCheckoutButton();
   }
    @Test(priority = 2)
    public void testCheckoutPageHeaderIsDisplayed() {
        new CheckoutPageUser(driver)
                .checkThatTheHeaderDisblayed()
                .checkThatTheHomeLabelButtonIsDisblayed()
                .checkThatTheProductsLabelButtonIsDisblayed()
                .checkThatTheMensLabelButtonIsDisblayed()
                .checkThatTheWomenLabelButtonIsDisblayed()
                .checkThatTheKidsLabelButtonIsDisblayed()
                .checkThatTheFootwearLabelButtonIsDisblayed()
                .checkThatTheAccessoriesLabelButtonIsDisblayed()
                .checkThatTheSearchLabelButtonIsDisblayed()
                .checkThatTheShoopyIconIsDisblayed()
                .checkThatTheFooterIsDisblayed()
                .checkThatTheRightsReservedIsDisblayed()
                .checkThatTheGithubIsDisblayed()
                .checkThatTheLinkedinIsDisblayed()
                .checkThatTheWatsappIsDisblayed()
                .checkThatTheTitleImageIsDisblayed()
                .checkThatTheProductImageSrcIsDisable()
                .checkThatTheUserSavedAddressIsDisblayed()
                .checkThatTheNewAddressTitleIsDisblayed()
                .checkThatTheAdressLabelIsDisblayed()
                .checkThatTheAdressInputIsDisblayed()
                .checkThatTheCityLabelIsDisblayed()
                .checkThatTheCityInputIsDisblayed()
                .checkThatThePineCodeLabelIsDisblayed()
                .checkThatThePinCodeInputIsDisblayed()
                .checkThatThePhoneLabelIsDisblayed()
                .checkThatThePhoneinputIsDisblayed()
                .checkThatTheNotesLabelIsDisblayed()
                .checkThatTheNotesTextAreaIsDisblayed()
                .checkThatTheAddAddressButtonIsDisblayed()
                .checkThatTheAddAddressButtonIsDisapledWhenFormIsEmpty()
                .checkThatTheProductImagesDisblayed()
                .checkThatTheProductNameDisblayed()
                .checkThatTheMinusButtonDisblayed()
                .checkThatTheAddButtonDisblayed()
                .checkThatTheProductQuantityLabelDisblayed()
                .checkThatTheProductPriceLabelDisblayed()
                .checkThatTheDeleteProductButtonDisblayed()
                .checkThatTheTotalTitleDisblayed()
                .checkThatTheTotalBuyLabelDisblayed()
                .checkThatThePayPalButtonDisblayed()
                .checkThatTheCashButtonDisblayed()
                .checkThatTheCheckoutButtonDisblayed()
                .checkThatTheCheckoutButtonIsClickable();
    }

    @Test(priority = 3)
    public void testAddAddressButtonIsDisabledWhenTheFormFieldsAreEmpty() {
        new CheckoutPageUser(driver).clickOnAddAddressButton()
                                    .checkThatTheAddaddressButtonIsNotClickableWhenTheFormFieldsAreEmpty();
    }

    @Test(priority = 4)
    public void testErrorMessageIsDisplayedWhenTheFormFieldsAreEmpty() {
        new CheckoutPageUser(driver).clickOnCheckoutButton()
                                    .checkThatTheErrorMessageShowWhenTheFormFieldsAreEmpty()
                                    .checkThatTheErrorMessageTitleIsCorrect();
    }

    @Test(priority = 5)
    public void testFillAddAddressForm() {
        new CheckoutPageUser(driver).fillAddAddressForm("Egypt","6thoctober","125478","01148154132","Testing")
                                    .clickOnAddAddressButton()
                                    .checkThatTheAddAddressMessageShow()
                                    //.checkThatTheAddAddressMessageTitleIsCorrect()
                                    .checkThatTheAddressDataIsDisplayed();

    }

    @Test(priority = 6,dependsOnMethods = {"testFillAddAddressForm"})
    public void testErrorMessageIsDisplayedWhenThePaymentFiledsIsEmpty() {
        new CheckoutPageUser(driver).clickOnCheckoutButton()
                .checkThatThePaymentMessageShow();
                //.checkThatThePaymentMessageTitleIsCorrect();
    }

    @Test(priority = 7 ,dependsOnMethods = {"testFillAddAddressForm"})
    public void testEditAddressButton() throws InterruptedException {
        new CheckoutPageUser(driver).clickOnEditAddressButton();
        Thread.sleep(10);
        new CheckoutPageUser(driver).fillAddAddressForm("US","Losanglos","125478","01148154132","NewTesting");
        new CheckoutPageUser(driver).clickOEditAddressButtonInForm();
        new CheckoutPageUser(driver).checkThatTheEditMessageIsDisplayed();
    }

    @Test(priority = 8 ,dependsOnMethods = {"testFillAddAddressForm"})
    public void testDeleteAddressButton() {
        new CheckoutPageUser(driver).clickOnDeleteAddressButton()
                                    .checkThatTheDeleteMessageIsDisplayed();
    }
    @Test(priority = 9)
    public void testOrderSuccessByCashOndelivery() {
        new CheckoutPageUser(driver).checkThatTheAdressInputIsDisblayed()
                                    .fillAddAddressForm("Portsaid cairo","Madina nasr","125478","01148054132","Testing")
                                    .clickOnAddAddressButton()
                                    .clickOnAddressSection()
                                    .clickOnCashOnDeliveryButton()
                                    .clickOnCheckoutButton()
                                    .checkThatTheOrderSucessMessageIsDisplayed();
    }

    @Test(priority = 10)
    public void testProductDataIsUpdatedWhenClickingPlusButton() {
        new CheckoutPageUser(driver).checkThatTheOrderCloseButtonIsDisplayed()
                                    .clickOnCloseButton();

        new CartPage(driver).clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .clickOnCheckoutButton();

        new CheckoutPageUser(driver).clickOnPlusButton()
                .checkThatTheProducDataIsUpdatedWhenIncreasingTheQuantity()
                .checkThatTheToastMessageUpdateIsDisplayed()
                .checkThatTheUpdateMessageShowWhenUpdatingTheQuantity()
                .checkThatTheUpdateMessageTitleIsCorrectWhenUpdatingTheQuantity();
    }

    @Test(priority = 11)
    public void testProductDataIsUpdatedWhenClickingMinusButton() {
        new CheckoutPageUser(driver).clickOnminusButton()
                .checkThatTheProducDataIsUpdatedWhendecreasingTheQuantity()
                .checkThatTheUpdateMessageShowWhenUpdatingTheQuantity()
                .checkThatTheUpdateMessageTitleIsCorrectWhenUpdatingTheQuantity();
    }

//    @Test(priority = 11)
//    public void testProductDataIsDeleted() throws InterruptedException{
//        new CheckoutPageUser(driver).clickOndeleteButton()
//                //.checkThatTheProductMessageDeletedhowWhenDeleting()
//                .checkThatTheProductIsDeleted();
//    }

    @Test(priority = 12)
    public void testOrderSuccessByPaypal() {
        new CheckoutPageUser(driver).clickOnShopyLink();
        new CartPage(driver).checkThatTheProductNameIsDisable()
                .clickOnAddToCartButton()
                .checkThatTheProductMessageAddedSuccesfullyIsDisable()
                .checkThatTheNumberOnCartIsDisable()
                .clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .clickOnCheckoutButton();

        new CheckoutPageUser(driver)
                .fillAddAddressForm("london","london","125478","01148054132","Testing")
                .clickOnAddAddressButton()
                .clickOnAddressSection()
                .clickOnPaypalButton()
                .clickOnCheckoutButton()
                .checkThatTheUrlChangedToThePaypalPage();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
