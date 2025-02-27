package com.shoppy.com.tests.login;

import com.shoppy.com.base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class LoginTests extends BaseTest {
    @Test(priority = 1)
    public void testLoginShortPasswordErrorMsg() {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("123");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMsg();
        Assert.assertTrue(actualMessage.contains("Password must be at least 8 characters long."));
    }

    @Test(priority = 2)
    public void testLoginWrongPasswordErrorMsg() throws InterruptedException {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("WrongPassword");
        loginPage.clickLogin();
        String actualMessage = loginPage.getToastErrorMsg();
        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains("Email or password is incorrect! Please try again"));
    }

    @Test(priority = 3)
    public void testLoginNotExistUserErrorMsg() {
        loginPage.setUserName("notExist@gmail.com");
        loginPage.setPassword("WrongPassword");
        loginPage.clickLogin();
        String actualMessage = loginPage.getToastErrorMsgUserNotExist();
        Assert.assertTrue(actualMessage.contains("User does not exists! Please register"));
    }


    @Test(priority = 4)
    public void testLoginAsAdmin() {
        loginPage.setUserName("shireffn369@gmail.com");
        loginPage.setPassword("Shireff@123");
        loginPage.clickLogin();
        boolean isAdminLoggedIn = loginPage.isLoggedInAsAdmin(10);
        Assert.assertTrue(isAdminLoggedIn, "Admin login failed! Dashboard header not found.");
        String expectedAdminURL = "https://shoppy-ochre.vercel.app/admin/dashboard";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedAdminURL, "Admin URL mismatch!");
    }

    @Test(priority = 5)
    public void testLoginAsUser() {
        loginPage.setUserName("shireffn369+f@gmail.com");
        loginPage.setPassword("Shireff@123");
        loginPage.clickLogin();
        boolean isAdminLoggedIn = loginPage.isLoggedInAsUser(10);
        Assert.assertTrue(isAdminLoggedIn, "User login failed! User header not found.");
        String expectedUserURL = "https://shoppy-ochre.vercel.app/shop/home";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUserURL, "User URL mismatch!");
    }

    @Test(priority = 6)
    public void testGoogleLogin() {
        loginPage.clickGoogleLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String mainWindow = driver.getWindowHandle();

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        wait.until(ExpectedConditions.urlContains("https://accounts.google.com/v3/signin"));

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.startsWith("https://accounts.google.com/v3/signin"),
                "Google Sign-in page did not open! Actual URL: " + currentURL);

    }
}