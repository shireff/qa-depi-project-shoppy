package com.shoppy.com.tests.signup;


import DriverFactory.Driver;
import com.shoppy.com.pages.SignUp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.browser().openUrl(driver.get(), url);
        signUpPage = new SignUp(driver);
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Visibility of SignUp link and navigation")
    @Test(priority = 1)
    public void testSignUpLinkVisibilityAndNavigation() {
        Assert.assertTrue(signUpPage.isSignUpLinkVisible(), "❌ Sign Up link is not visible.");
        signUpPage.clickSignUpLink();
        Assert.assertTrue(Objects.requireNonNull(driver.get().getCurrentUrl()).contains("/auth/register"), "❌ Navigation to Sign Up page failed.");
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Check if sign-up fields are visible")
    @Test(priority = 2)
    public void testFieldsIsVisible() {
        signUpPage.clickSignUpLink();
        Assert.assertTrue(signUpPage.isSignUpFieldsVisible(), "❌ Sign Up form fields are not visible.");
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with existing email")
    @Test(priority = 3)
    public void testSignWithExistingEmail() {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "shireffn369@gmail.com", "Shireff@123");
        signUpPage.clickSignUpButton();
        signUpPage.assertToastErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty username")
    @Test(priority = 4)
    public void testSignWithEmptyUserName() {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("", "shireffn369@gmail.com", "Shireff@123");
        signUpPage.clickSignUpButton();
        signUpPage.assertErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty email")
    @Test(priority = 5)
    public void testSignWithEmptyEmail() {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "", "Shireff@123");
        signUpPage.clickSignUpButton();
        signUpPage.assertErrorMessageDisplayed();
    }

    @Epic("SignUp Functionality")
    @Feature("User Registration")
    @Story("Sign up with empty password")
    @Test(priority = 6)
    public void testSignWithEmptyPassword() {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "shireffn369@gmail.com", "");
        signUpPage.clickSignUpButton();
        signUpPage.assertErrorMessageDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
