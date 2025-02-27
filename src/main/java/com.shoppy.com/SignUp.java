package com.shoppy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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


    public SignUp(WebDriver driver) {
        super(driver);
    }

//    private WebElement getVisibleElement(By locator) {
//        List<WebElement> elements = driver.findElements(locator);
//        for (WebElement element : elements) {
//            if (element.isDisplayed()) {
//                return element;
//            }
//        }
//        throw new RuntimeException("No visible element found for: " + locator.toString());
//    }

    public void clickSignUpLink() {
        click(signUpLink);
        System.out.println("✅ Navigated to the Sign Up page.");
    }

    public boolean isSignUpLinkVisible() {
        try {
            WebElement signUpLinkElement = find(signUpLink);
            return signUpLinkElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSignUpFieldsVisible() {
        try {
            WebElement userName = find(userNameField);
            WebElement email = find(emailField);
            WebElement password = find(passwordField);

            return userName.isDisplayed() && email.isDisplayed() && password.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void fillSignUpForm(String userName, String email, String password) {

        set(userNameField,userName);

        set(emailField,email);

        set(passwordField,password);
        System.out.println("✅ Form fields are filled.");
    }

    public LoginPage clickSignUpButton() {
        click(signUpButton);
        System.out.println("✅ Clicked on the Sign Up button.");
        return new LoginPage(driver);
    }
}
