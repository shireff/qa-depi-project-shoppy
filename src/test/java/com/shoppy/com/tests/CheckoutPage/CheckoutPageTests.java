package com.shoppy.com.tests.CheckoutPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.CartPage;
import com.shoppy.com.pages.CheckoutPageUser;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.*;
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
    }

    @Epic("Checkout")
    @Feature("Click on checkout button")
    @Story("Checkout button direct to checkout page url")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify checkout button direction")
    @Test(priority = 1)
    public void testCheckoutButtonNavigation() {
        new CartPage(driver).clickOnCartIcon()
                            .checkThatTheCartIsDisplayed()
                            .clickOnCheckoutButton();
   }

    @Epic("Checkout")
    @Feature("Page contents' visibility")
    @Story("Visibility of checkout contents")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify if the checkout page contents are visible")
    @Test(priority = 2)
    public void testCheckoutPageContentVisability() {
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

    @Epic("Checkout")
    @Feature("Add_address_button's disability with empty form")
    @Story("Disability of add_address_button with empty form")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify if the add address button is disabled when form is empty")
    @Test(priority = 3)
    public void testAddAddressButtonIsNotClickable() {
        new CheckoutPageUser(driver).clickOnAddAddressButton()
                                    .checkThatTheAddaddressButtonIsNotClickableWhenTheFormFieldsAreEmpty();
    }

    @Epic("Checkout")
    @Feature("Error message show with empty form")
    @Story("Error message show with empty form and click on checkout button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify if the error message show when clicking on the checkout button without form data")
    @Test(priority = 4)
    public void testErrorMessageShowWithEmptyForm() {
        new CheckoutPageUser(driver).clickOnCheckoutButton()
                                    .checkThatTheErrorMessageShowWhenTheFormFieldsAreEmpty();
    }

    @Epic("Checkout")
    @Feature("Fill address form")
    @Story("Fill the address form and success message show")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify filling the address form and success message show")
    @Test(priority = 5)
    public void testFillAddAddressForm() {
        new CheckoutPageUser(driver).fillAddAddressForm("Egypt","6thoctober","125478","01148154132","Testing")
                                    .clickOnAddAddressButton()
                                    .checkThatTheAddAddressMessageShow()
                                    .checkThatTheAddressDataIsDisplayed();
    }

    @Epic("Checkout")
    @Feature("Error message show without payment")
    @Story("Error message show without payment and click checkout button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify if the error message show when clicking on the checkout button without payment data")
    @Test(priority = 6,dependsOnMethods = {"testFillAddAddressForm"})
    public void testErrorMessageshowWithEmptyPaymentFileds() {
        new CheckoutPageUser(driver).clickOnCheckoutButton()
                .checkThatThePaymentMessageShow();
    }

    @Epic("Checkout")
    @Feature("Update address data")
    @Story("Update the address data and success message show")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify updating the address form and success message show")
    @Test(priority = 7 ,dependsOnMethods = {"testFillAddAddressForm"})
    public void testEditAddressButton() {
        new CheckoutPageUser(driver).clickOnEditAddressButton();
        new CheckoutPageUser(driver).fillAddAddressForm("US","Losanglos","87654321","01004815132","NewTesting");
        new CheckoutPageUser(driver).clickOEditAddressButtonInForm();
        new CheckoutPageUser(driver).checkThatTheEditMessageIsDisplayed();
    }

    @Epic("Checkout")
    @Feature("Delete address data")
    @Story("Delete the address data and success message show")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Deleting the address form and success message show")
    @Test(priority = 8 ,dependsOnMethods = {"testFillAddAddressForm"})
    public void testDeleteAddressButton() {
        new CheckoutPageUser(driver).clickOnDeleteAddressButton()
                                    .checkThatTheDeleteMessageIsDisplayed();
        driver.browser().refreshCurrentPage();
    }

    @Epic("Checkout")
    @Feature("Order created successfully by cash on delivery")
    @Story("Create order with cash on delivery")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify creating order by cash on delivery")
    @Test(priority = 9)
    public void testOrderSuccessByCashOndelivery() {
        new CheckoutPageUser(driver).checkThatTheAdressInputIsDisblayed()
                                    .fillAddAddressForm("UK","England","369852","0152896523","Testing")
                                    .clickOnAddAddressButton()
                                    .clickOnAddressSection()
                                    .clickOnCashOnDeliveryButton()
                                    .clickOnCheckoutButton()
                                    .checkThatTheOrderSucessMessageIsDisplayed();
    }

    @Epic("Checkout")
    @Feature("Price and total are updated when clicking + icon")
    @Story("Click on + icon and check the price and total")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the price and total are updated when clicking on + icon")
    @Test(priority = 10)
    public void testProductDataIsUpdatedWhenClickingPlusButton() {
        new CheckoutPageUser(driver).checkThatTheOrderCloseButtonIsDisplayed()
                                    .clickOnCloseButton();

        new CartPage(driver).clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .clickOnCheckoutButton();

        new CheckoutPageUser(driver).clickOnPlusButton()
                .checkThatTheProducDataIsUpdatedWithePlusIcon()
                .checkThatTheUpdateMessageShowWhenUpdatingTheQuantity();
    }

    @Epic("Checkout")
    @Feature("Price and total are updated when clicking - icon")
    @Story("Click on - icon and check the price and total")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the price and total are updated when clicking on - icon")
    @Test(priority = 11)
    public void testProductDataIsUpdatedWhenClickingMinusButton() {
        new CheckoutPageUser(driver).clickOnminusButton()
                .checkThatTheProducDataIsUpdatedWithMinusIcon()
                .checkThatTheUpdateMessageShowWhenUpdatingTheQuantity();
    }

    @Epic("Checkout")
    @Feature("Delete the product")
    @Story("Delete the product and success message show")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify deleting the address form and success message show")
    @Test(priority = 12)
    public void testProductDataIsDeleted(){
        new CheckoutPageUser(driver).clickOndeleteButton()
                .checkThatTheDeleteMessageShow()
                .checkThatTheCheckoutButtonIsClickable();
    }

    @Epic("Checkout")
    @Feature("Order created successfully by paypal")
    @Story("Create order with paypal")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify creating order by paypal")
    @Test(priority = 13)
    public void testOrderSuccessByPaypal() {
        new CheckoutPageUser(driver).clickOnShopyLink();

        new CartPage(driver).checkThatTheProductNameIsDisplayed()
                .clickOnAddToCartButton()
                .checkThatTheProductMessageAddedSuccesfullyIsDisplayed()
                .checkThatTheNumberOnCartIsDisplayed()
                .clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .clickOnCheckoutButton();

        new CheckoutPageUser(driver)
                .clickOnAddressSection()
                .clickOnPaypalButton()
                .clickOnCheckoutButton();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }


}
