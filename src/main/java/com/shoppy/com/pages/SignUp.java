package com.shoppy.com.pages;


import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.shoppy.com.utils.ElementActions.find;


public class SignUp {

    private final WebDriver driver;

    // **Locators**
    private final By signUpLink = By.linkText("Sign Up");
    private final By userNameField = By.id("userName");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
    private final By errorMsg = By.cssSelector(".text-destructive");
    private final By toastErrorMsg = By.cssSelector("li[data-state='open'] .text-sm.font-semibold");

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    /* -------------------------------------- Actions -------------------------------------- */

    public void clickSignUpLink() {
        ElementActions.click(driver, signUpLink);
    }


    public void fillSignUpForm(String userName, String email, String password) {
        ElementActions.set(driver, userNameField, userName);
        ElementActions.set(driver, emailField, email);
        ElementActions.set(driver, passwordField, password);
    }


    public LoginPage clickSignUpButton() {
        ElementActions.click(driver, signUpButton);
        return new LoginPage(driver);
    }

    /* -------------------------------------- Validations -------------------------------------- */


    public boolean isSignUpLinkVisible() {
        return find(driver, signUpLink).isDisplayed();
    }


    public boolean isSignUpFieldsVisible() {
        return find(driver, userNameField).isDisplayed()
                && find(driver, emailField).isDisplayed()
                && find(driver, passwordField).isDisplayed();
    }


    /* -------------------------------------- Assertions -------------------------------------- */

    public void assertErrorMessageDisplayed() {
        assertElementDisplayed(errorMsg, "❌ Error message is not displayed!");
    }

    public void assertToastErrorMessageDisplayed() {
        assertElementDisplayed(toastErrorMsg, "❌ Toast error message is not displayed!");
    }

    private void assertElementDisplayed(By locator, String errorMessage) {
        WebElement element = Waits.waitForElementVisible(driver, locator);
        if (element == null || !element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        }
    }
}
