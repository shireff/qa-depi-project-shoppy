package com.shoppy.com.tests.login;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.browser().openUrl(driver.get(), url);
        loginPage = new LoginPage(driver);
    }
    @Epic("Login Functionality")
    @Feature("User Login")
    @Story("Login with short password")
    @Test(priority = 1)
    public void testLoginShortPasswordErrorMsg() {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("123");
        loginPage.clickLogin();
        loginPage.assertErrorMessageDisplayed();
    }

    @Epic("Login Functionality")
    @Feature("User Login")
    @Story("Login with wrong password")
    @Test(priority = 2)
    public void testLoginWrongPasswordErrorMsg() {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("WrongPassword");
        loginPage.clickLogin();
        loginPage.assertToastErrorMessageDisplayed();
    }

    @Epic("Login Functionality")
    @Feature("User Login")
    @Story("Login with non-existent user")
    @Test(priority = 3)
    public void testLoginNotExistUserErrorMsg() {
        loginPage.setUserName("notExist@gmail.com");
        loginPage.setPassword("WrongPassword");
        loginPage.clickLogin();
        loginPage.assertUserNotExistToastDisplayed();
    }

    @Epic("Login Functionality")
    @Feature("Admin Login")
    @Story("Login as Admin with correct credentials")
    @Test(priority = 4)
    public void testLoginAsAdmin() {
        loginPage.setUserName("shireffn369@gmail.com");
        loginPage.setPassword("Shireff@123");
        loginPage.clickLogin();
        loginPage.assertLoginSuccessfulAsAdmin();
        String expectedAdminURL = "https://shoppy-ochre.vercel.app/admin/dashboard";
        String actualURL = driver.get().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedAdminURL, "Admin URL mismatch!");
    }

    @Epic("Login Functionality")
    @Feature("User Login")
    @Story("Login as User with correct credentials")
    @Test(priority = 5)
    public void testLoginAsUser() {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("Shireff@123");
        loginPage.clickLogin();
        loginPage.assertLoginSuccessfulAsUser();
        String expectedUserURL = "https://shoppy-ochre.vercel.app/shop/home";
        String actualURL = driver.get().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUserURL, "User URL mismatch!");
    }

//    @Test(priority = 6)
//    public void testGoogleLogin() {
//        loginPage.clickGoogleLogin();
//
//        String mainWindow = driver.get().getWindowHandle();
//
//        driver.get().switchTo().window(mainWindow);
//
//        String currentURL = driver.get().getCurrentUrl();
//        assert currentURL != null;
//        Assert.assertTrue(currentURL.startsWith("https://accounts.google.com/v3/signin"),
//                "Google Sign-in page did not open! Actual URL: " + currentURL);
//    }

    @AfterMethod
    public void tearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
