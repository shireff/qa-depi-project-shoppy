package com.shoppy.com.e2e.user;

import DriverFactory.Driver;
import com.shoppy.com.pages.CheckoutPageUser;
import com.shoppy.com.pages.HomePage;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.SignUp;
import io.qameta.allure.*;
import org.testng.annotations.*;


public class UserE2E {

    public Driver driver;
    private SignUp signUpPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private CheckoutPageUser checkout;


    private final String url = "https://shoppy-ochre.vercel.app/auth/login";
    private String email;
    private String userName;
    String password = "password@123";

    @BeforeClass
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        signUpPage = new SignUp(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        checkout = new CheckoutPageUser(driver);
        email = "test" + Math.random() + "@gmail.com";
        userName = "test" + Math.random();
    }

    @Epic("1 - User Management")
    @Feature("1.1 - Account Creation")
    @Story("User can access and use the SignUp functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate that a user can open the sign-up form, fill in their information, and receive appropriate feedback after submission.")
    @Test(priority = 1)
    public void SignUpNewUser() {
        signUpPage.clickSignUpLink().assertSignUpFieldsAreVisible()
                .fillSignUpForm(userName, email, password)
                .clickSignUpButton().assertToastErrorMessageDisplayed();

    }

    @Epic("1 - User Management")
    @Feature("1.2 - Authentication")
    @Story("User can log in after successful registration")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a newly registered user can log in using their credentials and access the application successfully.")
    @Test(priority = 2, dependsOnMethods = "SignUpNewUser")
    public void loginNewUser() {
        loginPage.loginIntoApp(email, password).assertLoginSuccessfulAsUser();
    }


    @Epic("2 - Shopping Flow")
    @Feature("2.1 - Add to Cart")
    @Story("User can add a product to the cart from the home page after logging in")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a logged-in user can add a featured product to the cart from the home page and see it correctly listed in the cart with name and price.")
    @Test(priority = 3, dependsOnMethods = "loginNewUser")
    public void fromHomePageAddProduct() {
        homePage.clickAddToCardFirstFeaturedProduct()
                .checkThatTheProductMessageAddedSuccesfullyIsDisplayed()
                .clickOnCartIcon()
                .checkThatTheCartIsDisplayed()
                .checkThatTheProductNameInCartIsDisplayed()
                .checkThatTheProductPriceIsDisplayed()
                .clickOnCheckoutButton();
    }

    @Epic("2 - Shopping Flow")
    @Feature("2.2 - Checkout and Payment")
    @Story("User can proceed to payment from the checkout page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that the checkout page header is displayed correctly as the user begins the payment process.")
    @Test(priority = 4, dependsOnMethods = "fromHomePageAddProduct")
    public void fromCheckoutPageMakeThePaymentProcess() {
        checkout.checkThatTheHeaderDisblayed();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }

}
