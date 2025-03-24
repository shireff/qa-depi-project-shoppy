package com.shoppy.com.tests.FilterSort;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
import com.shoppy.com.utils.BrowserActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilterSortTests {
    public Driver driver;

    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.browser().openUrl(driver.get(), new ProductsPageUser(driver.get()).url);
        //  BrowserActions.openUrl(driver, new ProductsPageUser(driver.get()).url);
        new LoginPage(driver.get()).loginIntoApp("ramymahana7@test.com", "archer@@@97");
    }

    @Test
    public void TestCases() {
        new ProductsPageUser(driver.get()).driverNavigate().clickMenCheckBox().clickHMCheckBox().clickAccessoriesCheckBox();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
     //   BrowserActions.closeBrowser(driver);
    }
}
