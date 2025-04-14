package com.shoppy.com.tests.AdminOrdersPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminPanelOrdersDetails;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminOrderDetailsPageTest
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn().clickOnViewDetailsBtn();
    }
    @Test
    public void TestMethod()
    {
        new AdminPanelOrdersDetails(driver).clickOnCloseDetailsBtn();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
