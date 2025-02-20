package com.shoppy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMsg = By.cssSelector(".text-destructive");
    private final By toastErrorMsg = By.cssSelector("li[data-state='open'] .text-sm.font-semibold");
    private final By userNotExistToastMsg = By.xpath("//li[@data-state='open']//div[contains(text(),'User does not exists! Please register')]");
    private final By adminDashboardHeader = By.xpath("//h2[text()='Admin Panel']");
    private final By userHeader = By.xpath("//span[text()='Shoppy']");
    private WebElement getVisibleElement(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        throw new RuntimeException("No visible element found for: " + locator.toString());
    }

    public void setUserName(String userName) {
        WebElement emailField = getVisibleElement(usernameField);
        emailField.clear();
        emailField.sendKeys(userName);
    }

    public void setPassword(String pass) {
        WebElement passField = getVisibleElement(passwordField);
        passField.clear();
        passField.sendKeys(pass);
    }

    public ProductsPage clickLogin() {
        WebElement button = getVisibleElement(loginButton);
        button.click();
        return new ProductsPage();
    }

    public ProductsPage loginIntoApp(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        return clickLogin();
    }

    public String getErrorMsg() {
        WebElement errorElement = getVisibleElement(errorMsg);
        return errorElement.getText();
    }

    public String getToastErrorMsgUserNotExist() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNotExistToastMsg));
            return toastElement.getText();
        } catch (Exception e) {
            throw new RuntimeException("Toast message for 'User does not exist' did not appear!", e);
        }
    }


    public String getToastErrorMsg() {
        WebElement toastErrorElement = getVisibleElement(toastErrorMsg);
        return toastErrorElement.getText();
    }



    public boolean isLoggedInAsAdmin(int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashboardHeader));
            return dashboardHeader != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedInAsUser(int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(userHeader));
            return dashboardHeader != null;
        } catch (Exception e) {
            return false;
        }
    }

}


//package com.shoppy.com;
//import org.openqa.selenium.By;
//
//public class LoginPage extends BasePage {
//    private By usernameField = By.id("email");
//    private By passwordField = By.id("password");
//    private By loginButton = By.xpath("//button[@type='submit']");
//    private By errorMsg = By.cssSelector("text-destructive");
//
//
//    public void setUserName(String userName) {
//        set(usernameField, userName);
//    }
//
//    public void setPassword(String pass) {
//        set(passwordField, pass);
//    }
//
//    public ProductsPage clickLogin() {
//        click(loginButton);
//        return new ProductsPage();
//    }
//
//    public ProductsPage loginIntoApp(String userName, String password) {
//        setUserName(userName);
//        setPassword(password);
//        return clickLogin();
//    }
//
//    public String getErrorMsg() {
//        return find(errorMsg).getText();
//    }
//
//}
