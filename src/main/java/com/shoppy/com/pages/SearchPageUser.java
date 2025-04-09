package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPageUser
{
    private final Driver driver;
    private final By Search_Label_Button = By.xpath("//div/nav/label[8]");
    String Search_Button_Text = "Search";
    public SearchPageUser(Driver driver)
    {
        this.driver = driver;
    }





    //Assertion
    public SearchPageUser checkThatSearchTabIsVisible()
    {
        System.out.println("✅check search tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Search_Label_Button);
        Assert.assertEquals(actualTitle,Search_Button_Text);
        return this;
    }
}
