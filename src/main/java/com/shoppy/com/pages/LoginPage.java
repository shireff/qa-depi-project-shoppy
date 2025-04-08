package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.shoppy.com.utils.ElementActions.find;

public class LoginPage {

    private final Driver driver;

    // **Locators**
    private final By usernameField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMsg = By.cssSelector(".text-destructive");
    private final By toastErrorMsg = By.cssSelector("li[data-state='open'] .text-sm.font-semibold");
    private final By userNotExistToastMsg = By.xpath("//li[@data-state='open']//div[contains(text(),'User does not exists! Please register')]");
    private final By adminDashboardHeader = By.xpath("//h2[text()='Admin Panel']");
    private final By userHeader = By.xpath("//span[text()='Shoppy']");
    private final By googleLoginButton = By.xpath("//button[contains(., 'Continue with Google')]");
    private final By emailField = By.xpath("//input[@type='email']");
    private final By nextButton = By.xpath("//span[contains(text(),'Next')]");
    private final By confirmNextButton = By.xpath("//span[contains(text(),'Next')]");

    public  LoginPage(Driver driver) {
        this.driver = driver;
    }

    /* -------------------------------------- Actions -------------------------------------- */

    public void setUserName(String userName) {
        ElementActions.set(driver.get(), usernameField, userName);
    }

    public void setPassword(String pass) {
        ElementActions.set(driver.get(), passwordField, pass);
    }

    public HomePage clickLogin() {
        driver.element().click(loginButton);
        return new HomePage(driver.get());
    }

    public HomePage loginIntoApp(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        return clickLogin();
    }

    public void clickGoogleLogin() {
        WebElement googleBtn = find(driver.get(), googleLoginButton);
        googleBtn.click();
    }


    /* -------------------------------------- Assertions -------------------------------------- */

    public void assertLoginSuccessfulAsAdmin() {
        assertElementDisplayed(adminDashboardHeader, "❌ Admin login failed!");
    }

    public void assertLoginSuccessfulAsUser() {
        assertElementDisplayed(userHeader, "❌ User login failed!");
    }

    public void assertErrorMessageDisplayed() {
        assertElementDisplayed(errorMsg, "❌ Error message is not displayed!");
    }

    public void assertToastErrorMessageDisplayed() {
        assertElementDisplayed(toastErrorMsg, "❌ Toast error message is not displayed!");
    }

    public void assertUserNotExistToastDisplayed() {
        assertElementDisplayed(userNotExistToastMsg, "❌ User not exists toast message is missing!");
    }

    private void assertElementDisplayed(By locator, String errorMessage) {
        WebElement element = Waits.waitForElementVisible(driver.get(), locator);
        if (element == null || !element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        }
    }
}
