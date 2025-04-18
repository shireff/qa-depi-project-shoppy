package com.shoppy.com.tests.signup;


import DriverFactory.Driver;
import com.shoppy.com.pages.SignUp;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Objects;

public class SignUpTests {

    public Driver driver;
    private SignUp signUpPage;
    private final String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeMethod
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        signUpPage = new SignUp(driver);
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Visibility of SignUp link and navigation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify if the sign-up link is visible and navigate to the registration page.")
    @Test(priority = 1)
    public void testSignUpLinkVisibilityAndNavigation() {
        signUpPage
                .assertSignUpLinkIsVisible()
                .clickSignUpLink()
                .assertOnRegisterPageUrl();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Check if sign-up fields are visible")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the sign-up form fields are visible when the user navigates to the sign-up page.")
    @Test(priority = 2)
    public void testFieldsIsVisible() {
        signUpPage.clickSignUpLink().assertSignUpFieldsAreVisible();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with existing email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that an error message is displayed when the user tries to sign up with an existing email.")
    @Test(priority = 3)
    public void testSignWithExistingEmail() {
        signUpPage
                .clickSignUpLink()
                .fillSignUpForm("Shireff", "shireffn369@gmail.com", "Shireff@123")
                .clickSignUpButton()
                .assertToastErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty username")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that an error message is displayed when the username field is left empty.")
    @Test(priority = 4)
    public void testSignWithEmptyUserName() {
        signUpPage
                .clickSignUpLink()
                .fillSignUpForm("", "shireffn369@gmail.com", "Shireff@123")
                .clickSignUpButton()
                .assertErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty email")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that an error message is displayed when the email field is left empty.")
    @Test(priority = 5)
    public void testSignWithEmptyEmail() {
        signUpPage
                .clickSignUpLink()
                .fillSignUpForm("Shireff", "", "Shireff@123")
                .clickSignUpButton()
                .assertErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that an error message is displayed when the password field is left empty.")
    @Test(priority = 6)
    public void testSignWithEmptyPassword() {
        signUpPage.clickSignUpLink()
                .fillSignUpForm("Shireff", "shireffn369@gmail.com", "")
                .clickSignUpButton()
                .assertErrorMessageDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
