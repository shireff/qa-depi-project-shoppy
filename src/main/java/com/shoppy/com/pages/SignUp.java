package com.shoppy.com.pages;


import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

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
    @Step("Click Sign Up link")
    public SignUp clickSignUpLink() {
        driver.element().click(signUpLink);
        return this;
    }

    @Step("Fill sign-up form with username, email, password")
    public SignUp fillSignUpForm(String userName, String email, String password) {
        driver.element().set( userNameField, userName);
        driver.element().set(emailField, email);
        driver.element().set( passwordField, password);
        return this;
    }

    @Step("Click Sign Up button")
    public LoginPage clickSignUpButton() {
        driver.element().click(signUpButton);
        return new LoginPage(driver);
    }

    /* -------------------------------------- Validations -------------------------------------- */

    @Step("Check if Sign Up link is visible")
    public boolean isSignUpLinkVisible() {
        return find(driver.get(), signUpLink).isDisplayed();
    }

    @Step("Check if sign-up fields are visible")
    public boolean isSignUpFieldsVisible() {
        return find(driver.get(), userNameField).isDisplayed()
                && find(driver.get(), emailField).isDisplayed()
                && find(driver.get(), passwordField).isDisplayed();
    }


    /* -------------------------------------- Assertions -------------------------------------- */
    @Step("Assert Sign Up link is visible")
    public SignUp assertSignUpLinkIsVisible() {
        driver.validations().validateTrue(isSignUpLinkVisible(), "❌ Sign Up link is not visible!");
        return this;
    }

    @Step("Assert sign-up fields are visible")
    public SignUp assertSignUpFieldsAreVisible() {
        driver.validations().validateTrue(isSignUpFieldsVisible(), "❌ Sign-up fields are not all visible!");
        return this;
    }

    @Step("Assert current URL contains '/auth/register'")
    public SignUp assertOnRegisterPageUrl() {
        String currentUrl = driver.browser().getCurrentURL(driver.get());;
        driver.validations().validateTrue(currentUrl.contains("/auth/register"),
                "❌ Current URL does not contain '/auth/register'. Actual URL: " + currentUrl);
        return this;
    }
    @Step("Assert error message is displayed")
    public SignUp assertErrorMessageDisplayed() {
        driver.assertion().assertElementDisplayed(errorMsg, "❌ Error message is not displayed!");
        return this;
    }
    @Step("Assert toast error message is displayed")
    public SignUp assertToastErrorMessageDisplayed() {
        driver.assertion().assertElementDisplayed(toastErrorMsg, "❌ Toast error message is not displayed!");
        return this;
    }
}
