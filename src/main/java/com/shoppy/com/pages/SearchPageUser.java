package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPageUser
{
    private final Driver driver;

    private final String url = "https://shoppy-ochre.vercel.app/shop/search";
    private final By Search_Label_Button = By.xpath("//div/nav/label[8]");
    String Search_Button_Text = "Search";
    //search box
    private final By SearchBox = By.xpath("//main/div/div/div/input");
    private final By No_Products_Found_Header = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/h1");
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
