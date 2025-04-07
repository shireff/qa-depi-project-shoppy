package com.shoppy.com.tests.FilterSort;

import DriverFactory.Driver;
import com.shoppy.com.pages.LoginPage;
import com.shoppy.com.pages.ProductsPageUser;
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
        driver.browser().openUrl(driver.get(), new ProductsPageUser(driver).url);
        new LoginPage(driver.get()).loginIntoApp("ramymahana7@test.com", "archer@@@97");
    }

    @Test
    public void TestCase_Demo() {
        new ProductsPageUser(driver).driverNavigate().clickMenCheckBox().clickHMCheckBox().clickAccessoriesCheckBox();
    }
    @Test
    public void usingAllCheckBoxes()
    {
        new ProductsPageUser(driver).driverNavigate().clickMenCheckBox().
                clickWomenCheckBox().
                clickKidsCheckBox().
                clickAccessoriesCheckBox().
                clickFootWearCheckBox().
                clickNickCheckBox().
                clickAdidasCheckBox().
                clickPumaCheckBox().
                clickLevisCheckBox().
                clickZaraCheckBox().
                clickHMCheckBox().checkThatTheMenCheckBoxIsChecked().
                checkThatTheWomenCheckBoxIsChecked().
                checkThatTheKidsCheckBoxIsChecked().
                checkThatTheAccessoriesCheckBoxIsChecked().
                checkThatFootWearCheckBoxIsChecked().
                checkThatNikeCheckBoxIsChecked().
                checkThatAdidasCheckBoxIsChecked().
                checkThatPumaCheckBoxIsChecked().
                checkThatLevisCheckBoxIsChecked().
                checkThatZaraCheckBoxIsChecked().
                checkThatHMCheckBoxIsChecked();
    }

    @AfterClass
    public void TearDown() {
        driver.browser().closeBrowser(driver.get());
    }
}
