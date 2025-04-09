package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;

public class AdminPanelOrders
{
    private final Driver driver;

    //basic locators of the page
    private final By Logout_Button = By.xpath("//div[1]/div/div/div/header/div/button");
    private final By AllOrders_Title = By.xpath("//main/div/div/div[1]/div");
    //orders table head
    private final By OrderId_Title = By.xpath("//div[2]/div/table/thead/tr/th[1]");
    private final By OrderDate_Tile = By.xpath("//div[2]/div/table/thead/tr/th[2]");
    private final By OrderStatus_Title = By.xpath("//div[2]/div/table/thead/tr/th[3]");
    private final By OrderPrice_Title = By.xpath("//div[2]/div/table/thead/tr/th[4]");
    //Admin panel nav
    private final By AdminPanel_Title = By.xpath("//aside/div/h2");
    private final By DashBoard_Button = By.xpath("//nav/div[1]");
    private final By Products_Button = By.xpath("//nav/div[2]");
    private final By Orders_Button = By.xpath("//nav/div[3]");


    //orders table locators
    private final By OrderId_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[1]");//tr[i]/td[i]
    private final By OrderDate_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[2]");//tr[i]/td[i]
    private final By OrderStatus_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[3]");//tr[i]/td[i]
    private final By OrderPrice_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[4]");//tr[i]/td[i]
    private final By ViewOrderDetails_FirstOrder = By.xpath("//tr[1]/td[5]/button");  //tr[i]

    public AdminPanelOrders(Driver driver)
    {
        this.driver = driver;
    }
}
