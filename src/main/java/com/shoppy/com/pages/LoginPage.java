package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.shoppy.com.utils.ElementActions.find;

public class LoginPage {

    private final Driver driver;

    // **Locators**
    private final By usernameField = By.xpath("(//input[@id=\"email\"])[2]");
    private final By passwordField = By.xpath("(//input[@id=\"password\"])[2]");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMsg = By.cssSelector(".text-destructive");
    private final By toastErrorMsg = By.cssSelector("li[data-state='open'] .text-sm.font-semibold");
    private final By userNotExistToastMsg = By.xpath("//li[@data-state='open']//div[contains(text(),'User does not exists! Please register')]");
    private final By adminDashboardHeader = By.xpath("//h2[text()='Admin Panel']");
 //   private final By userHeader = By.xpath("//span[text()='Shoppy']");
    private final By googleLoginButton = By.xpath("//button[contains(., 'Continue with Google')]");
    private final By emailField = By.xpath("//input[@type='email']");
    private final By nextButton = By.xpath("//span[contains(text(),'Next')]");
    private final By confirmNextButton = By.xpath("//span[contains(text(),'Next')]");

    public LoginPage(Driver driver) {
        this.driver = driver;
    }

    /* -------------------------------------- Actions -------------------------------------- */
    @Step("Set username")
    public LoginPage setUserName(String userName) {
        driver.element().type(usernameField, userName);
        return this;
    }

    @Step("Set password")
    public LoginPage setPassword(String pass) {
        driver.element().type(passwordField, pass);
        return this;
    }

    @Step("Click login button")
    public HomePage clickLogin() {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    @Step("Login with username and password")
    public HomePage loginIntoApp(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        return clickLogin();
    }

    @Step("Click Google login button")
    public void clickGoogleLogin() {
        WebElement googleBtn = find(driver.get(), googleLoginButton);
        googleBtn.click();
    }


    /* -------------------------------------- Assertions -------------------------------------- */
    @Step("Assert login successful as admin")
    public LoginPage assertLoginSuccessfulAsAdmin() {
        driver.assertion().assertElementDisplayed(adminDashboardHeader, "❌ Admin login failed!");
        return this;
    }

//    @Step("Assert login successful as user")
//    public void assertLoginSuccessfulAsUser() {
//        driver.assertion().assertElementDisplayed(userHeader, "❌ User login failed!");
//    }

    @Step("Assert error message is displayed")
    public LoginPage assertErrorMessageDisplayed() {
        driver.assertion().assertElementDisplayed(errorMsg, "❌ Error message is not displayed!");
        return this;
    }

    @Step("Assert toast error message is displayed")
    public LoginPage assertToastErrorMessageDisplayed() {
        driver.assertion().assertElementDisplayed(toastErrorMsg, "❌ Toast error message is not displayed!");
        return this;
    }

    @Step("Assert 'User does not exist' toast message is displayed")
    public LoginPage assertUserNotExistToastDisplayed() {
        driver.assertion().assertElementDisplayed(userNotExistToastMsg, "❌ User not exists toast message is missing!");
        driver.assertion().assertElementTextContains(userNotExistToastMsg, "User does not exists! Please register",
                "❌ User not exists toast message text is incorrect!");
        return this;
    }

}
