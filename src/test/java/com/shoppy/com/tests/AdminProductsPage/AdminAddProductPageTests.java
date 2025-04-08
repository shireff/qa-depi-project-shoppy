package com.shoppy.com.tests.AdminProductsPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminAddProductPage;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminProductsPage;
import com.shoppy.com.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class AdminAddProductPageTests {
    public Driver driver;
    protected LoginPage loginPage;
    private String LoginUrl = "https://shoppy-ochre.vercel.app/auth/login";
    private String productsUrl = "https://shoppy-ochre.vercel.app/admin/products";

    @BeforeClass
    public void setup() {
        driver = new Driver("CHROME");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.browser().openUrl(driver.get(), LoginUrl);
        loginPage = new LoginPage(driver);
        loginPage.setUserName("Arima@example.com");
        loginPage.setPassword("123456789");
        loginPage.clickLogin();

    }

    @Test
    public void verifyThatAddProductButtonIsWorking() {

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.browser().closeBrowser(driver.get());
    }
}
