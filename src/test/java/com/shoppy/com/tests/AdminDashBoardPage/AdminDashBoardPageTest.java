package com.shoppy.com.tests.AdminDashBoardPage;

import DriverFactory.Driver;
import com.shoppy.com.pages.AdminDashboardPage;
import com.shoppy.com.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class AdminDashBoardPageTest
{
    public Driver driver;
    String image1 = new File("src/test/resources/images/dash_1.jpg").getAbsolutePath();
    String image2 = new File("src/test/resources/images/dash_2.jpg").getAbsolutePath();
    String image3 = new File("src/test/resources/images/dash_3.jpg").getAbsolutePath();
    @BeforeClass
    public void SetUp() {
        driver = new Driver("chrome");
        new LoginPage(driver).loginIntoApp("ramymahana7@gmail.com", "archer@@@97");
    }
    @Test
    public void TestMethod()
    {
        new AdminDashboardPage(driver).uploadImageDashBoard(image1).clickOnUploadBtn();
        new AdminDashboardPage(driver).uploadImageDashBoard(image2).clickOnUploadBtn();
        new AdminDashboardPage(driver).uploadImageDashBoard(image3).clickOnUploadBtn();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
