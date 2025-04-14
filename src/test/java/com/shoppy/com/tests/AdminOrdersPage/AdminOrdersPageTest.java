package com.shoppy.com.tests.AdminOrdersPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.AdminPanelOrders;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminOrdersPageTest
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
        new AdminDashboardPage(driver).clickOnOrdersBtn();
    }
    @Test
    public void TestMethod()
    {
        new AdminPanelOrders(driver).clickOnViewDetailsBtn();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
