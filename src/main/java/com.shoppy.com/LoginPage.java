package com.shoppy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LoginPage extends BasePage {
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
    public LoginPage(WebDriver driver) {
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

    public void setUserName(String userName) {
        set(usernameField, userName);
    }

    public void setPassword(String pass) {
        set(passwordField, pass);
    }

    public HomePage clickLogin() {
       click(loginButton);
        return new HomePage(driver);
    }

    public HomePage loginIntoApp(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        return clickLogin();
    }

    public String getErrorMsg() {
        WebElement errorElement = find(errorMsg);
        return errorElement.getText();
    }

    public String getToastErrorMsgUserNotExist() {
        try {
            WebElement toastElement = find(userNotExistToastMsg);
            return toastElement.getText();
        } catch (Exception e) {
            throw new RuntimeException("Toast message for 'User does not exist' did not appear!", e);
        }
    }


    public String getToastErrorMsg() {
        WebElement toastErrorElement = find(toastErrorMsg);
        return toastErrorElement.getText();
    }



    public boolean isLoggedInAsAdmin(int timeoutInSeconds) {
        try {
            WebElement dashboardHeader = find(adminDashboardHeader);
            return dashboardHeader != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickGoogleLogin() {
        WebElement googleBtn = find(googleLoginButton);
        googleBtn.click();
    }

    public void loginWithGoogle(String email, String password) {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
        driver.findElement(nextButton).click();

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);
        driver.findElement(confirmNextButton).click();

        driver.switchTo().window(mainWindow);
    }


    public boolean isLoggedInAsUser(int timeoutInSeconds) {
        try {
            WebElement dashboardHeader = find(userHeader);
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
