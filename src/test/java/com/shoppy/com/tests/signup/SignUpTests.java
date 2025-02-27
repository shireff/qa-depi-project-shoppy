package com.shoppy.com.tests.signup;

import com.shoppy.com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    @Test
    public void testSignUpLinkVisibilityAndNavigation() {
        Assert.assertTrue(signUpPage.isSignUpLinkVisible(), "❌ Sign Up link is not visible on the login page.");
        signUpPage.clickSignUpLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"), "❌ Failed to navigate to the Sign Up page.");
    }

    @Test
    public void testFieldsIsVisible() {
        signUpPage.clickSignUpLink();
        Assert.assertTrue(signUpPage.isSignUpFieldsVisible(), "❌ Sign Up form fields are not visible.");
    }

    @Test
    public void testSignWithExistingEmail() throws InterruptedException {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "shireffn369@gmail.com", "Shireff@123");
        signUpPage.clickSignUpButton();
        String actualMessage = loginPage.getToastErrorMsg();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains("Email already exists"));
    }

    @Test
    public void testSignWithEmptyUserName() throws InterruptedException {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("", "shireffn369@gmail.com", "Shireff@123");
        signUpPage.clickSignUpButton();
        String actualMessage = loginPage.getErrorMsg();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains("User Name is required"));
    }

    @Test
    public void testSignWithEmptyEmail() throws InterruptedException {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "", "Shireff@123");
        signUpPage.clickSignUpButton();
        String actualMessage = loginPage.getErrorMsg();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains("Email is required"));
    }

    @Test
    public void testSignWithEmptyPassword() throws InterruptedException {
        signUpPage.clickSignUpLink();
        signUpPage.fillSignUpForm("Shireff", "shireffn369@gmail.com", "");
        signUpPage.clickSignUpButton();
        String actualMessage = loginPage.getErrorMsg();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains("Password is required"));
    }

//    @Test
//    public void testValidSign() throws InterruptedException {
//        signUpPage.clickSignUpLink();
//        signUpPage.fillSignUpForm("new User Automation", "shireffn369+q@gmail.com", "Shireff@123");
//        LoginPage loginPage = signUpPage.clickSignUpButton();
//        Thread.sleep(2000);
//        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "❌ Failed to navigate to the Login page after successful sign up.");
//        System.out.println("✅ Successfully navigated to the Login page.");
//    }

}
