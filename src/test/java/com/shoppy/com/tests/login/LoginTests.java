package com.shoppy.com.tests.login;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    public Driver driver;
    protected LoginPage loginPage;
    private String url = "https://shoppy-ochre.vercel.app/auth/login";

    @BeforeMethod
    public void setUp() {
        driver = new Driver("chrome");
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver);
    }

    @Epic("Login")
    @Feature("Validation")
    @Story("Login with short password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error message is shown when password is less than allowed length.")
    @Test(priority = 1)
    public void testLoginShortPasswordErrorMsg() {
        loginPage.setUserName("shireffn369+f@gmail.com")
                .setPassword("123")
                .clickLogin();
        loginPage.assertErrorMessageDisplayed();
    }

    @Epic("Login")
    @Feature("Validation")
    @Story("Login with wrong password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify toast message appears when incorrect password is used.")
    @Test(priority = 2)
    public void testLoginWrongPasswordErrorMsg() {
        loginPage.setUserName("shireffn369+f@gmail.com")
                .setPassword("WrongPassword")
                .clickLogin();
        loginPage.assertToastErrorMessageDisplayed();
    }

    @Epic("Login")
    @Feature("Validation")
    @Story("Login with non-existing user")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify toast message appears when user does not exist in the system.")
    @Test(priority = 3)
    public void testLoginNotExistUserErrorMsg() {
        loginPage.setUserName("notExist@gmail.com")
                .setPassword("WrongPassword")
                .clickLogin();
        loginPage.assertUserNotExistToastDisplayed();
    }

    @Epic("Login")
    @Feature("Admin Login")
    @Story("Admin logs in with correct credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure admin can login successfully and redirect to admin dashboard")
    @Test(priority = 4)
    public void testLoginAsAdmin() {
        loginPage.setUserName("shireffn369@gmail.com")
        .setPassword("Shireff@123")
        .clickLogin();
        loginPage.assertLoginSuccessfulAsAdmin();
    }

    @Epic("Login")
    @Feature("User Login")
    @Story("User logs in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify normal user can login and gets redirected to shop homepage")
    @Test(priority = 5)
    public void testLoginAsUser() {
        loginPage.setUserName("shireffn369+f@gmail.com").setPassword("Shireff@123").clickLogin().assertLoginSuccessfulAsUser();
    }


    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
