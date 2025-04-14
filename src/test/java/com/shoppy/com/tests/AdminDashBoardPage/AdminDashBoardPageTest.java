package com.shoppy.com.tests.AdminDashBoardPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminDashBoardPageTest
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
    }
    @Test
    public void TestMethod()
    {
        new AdminDashboardPage(driver).clickOnUploadBtn();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
