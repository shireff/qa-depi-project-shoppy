package com.shoppy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignUp extends BasePage {
    private By signUpLink = By.linkText("Sign Up");
    private By userNameField = By.id("userName");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");

    private By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");

    private WebElement getVisibleElement(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        throw new RuntimeException("No visible element found for: " + locator.toString());
    }

    public void clickSignUpLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement signUp = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpLink));
        signUp.click();

        wait.until(ExpectedConditions.urlContains("/auth/register"));

        System.out.println("✅ Navigated to the Sign Up page.");
    }

    public boolean isSignUpLinkVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement signUpLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpLink));
            return signUpLinkElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSignUpFieldsVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement userName = getVisibleElement(userNameField);
            WebElement email = getVisibleElement(emailField);
            WebElement password = getVisibleElement(passwordField);

            return userName.isDisplayed() && email.isDisplayed() && password.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void fillSignUpForm(String userName, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement userNameElement = getVisibleElement(userNameField);
        userNameElement.clear();
        userNameElement.sendKeys(userName);

        WebElement emailElement = getVisibleElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);

        WebElement passwordElement = getVisibleElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);

        System.out.println("✅ Form fields are filled.");
    }

    public LoginPage clickSignUpButton() {
        WebElement button = getVisibleElement(signUpButton);
        button.click();
        System.out.println("✅ Clicked on the Sign Up button.");
        return new LoginPage();
    }
}
