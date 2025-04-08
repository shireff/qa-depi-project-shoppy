package com.shoppy.com.pages;


import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.shoppy.com.utils.ElementActions.find;


public class SignUp {

    private final Driver driver;

    // **Locators**
    private final By signUpLink = By.linkText("Sign Up");
    private final By userNameField = By.id("userName");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
    private final By errorMsg = By.cssSelector(".text-destructive");
    private final By toastErrorMsg = By.cssSelector("li[data-state='open'] .text-sm.font-semibold");

    public SignUp(Driver driver) {
        this.driver = driver;
    }

    /* -------------------------------------- Actions -------------------------------------- */

    public void clickSignUpLink() {
        driver.element().click(signUpLink);
    }


    public void fillSignUpForm(String userName, String email, String password) {
        driver.element().set(driver.get(), userNameField, userName);
        driver.element().set(driver.get(), emailField, email);
        driver.element().set(driver.get(), passwordField, password);
    }


    public LoginPage clickSignUpButton() {
        driver.element().click( signUpButton);
        return new LoginPage(driver);
    }

    /* -------------------------------------- Validations -------------------------------------- */


    public boolean isSignUpLinkVisible() {
        return find(driver.get(), signUpLink).isDisplayed();
    }


    public boolean isSignUpFieldsVisible() {
        return find(driver.get(), userNameField).isDisplayed()
                && find(driver.get(), emailField).isDisplayed()
                && find(driver.get(), passwordField).isDisplayed();
    }


    /* -------------------------------------- Assertions -------------------------------------- */

    public void assertErrorMessageDisplayed() {
        assertElementDisplayed(errorMsg, "❌ Error message is not displayed!");
    }

    public void assertToastErrorMessageDisplayed() {
        assertElementDisplayed(toastErrorMsg, "❌ Toast error message is not displayed!");
    }

    private void assertElementDisplayed(By locator, String errorMessage) {
        WebElement element = Waits.waitForElementVisible(driver.get(), locator);
        if (element == null || !element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        }
    }
}
