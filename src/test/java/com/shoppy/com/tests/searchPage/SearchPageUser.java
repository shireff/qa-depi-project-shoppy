package com.shoppy.com.tests.searchPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageUser
{
    public Driver driver;
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new LoginPage(driver).loginIntoApp("ramymahana7@test.com", "archer@@@97");
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchTap();
    }
    @Test
    public void TestMethod()
    {
        new com.shoppy.com.pages.SearchPageUser(driver).clickOnSearchBox();
        new com.shoppy.com.pages.SearchPageUser(driver).fillSearchBoxHM();
    }
    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
