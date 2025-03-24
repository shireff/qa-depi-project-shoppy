package com.shoppy.com.tests.FilterSort;

import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
import com.shoppy.com.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilterSortTests {
    protected WebDriver driver;
    @BeforeClass
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        BrowserActions.openUrl(driver, new ProductsPageUser(driver).url);
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
    }

    @Test
    public void TestCases()  {
        new ProductsPageUser(driver).driverNavigate().clickMenCheckBox().clickHMCheckBox().clickAccessoriesCheckBox();
    }

    @AfterClass
    public void TearDown() {
        BrowserActions.closeBrowser(driver);
    }
}
