package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;

public class AdminPanelOrders
{
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/admin/orders";
    //Responsive nav menu button
    private final By Res_Nav_Button = By.xpath("//header/button");
    //Admin panel responsive
    private final By AdminPanel_Title_Responsive = By.xpath("//h2/h2");
    private final By DashBoard_Button_Responsive = By.xpath("//div/div/nav/div[1]/span");
    private final By Products_Button_Responsive = By.xpath("//div/div/nav/div[2]/span");
    private final By Orders_Button_Responsive = By.xpath("//div/div/nav/div[3]/span");
    //Admin panel nav
    private final By AdminPanel_Title = By.xpath("//aside/div/h2");
    private final By DashBoard_Button = By.xpath("//nav/div[1]");
    private final By Products_Button = By.xpath("//nav/div[2]");
    private final By Orders_Button = By.xpath("//nav/div[3]");
    //logout button
    private final By Logout_Button = By.xpath("//div[1]/div/div/div/header/div/button");
    //basic locators of the page
    private final By AllOrders_Title = By.xpath("//main/div/div/div[1]/div");
    //orders table head
    private final By OrderId_Title = By.xpath("//div[2]/div/table/thead/tr/th[1]");
    private final By OrderDate_Tile = By.xpath("//div[2]/div/table/thead/tr/th[2]");
    private final By OrderStatus_Title = By.xpath("//div[2]/div/table/thead/tr/th[3]");
    private final By OrderPrice_Title = By.xpath("//div[2]/div/table/thead/tr/th[4]");
    //orders table locators
    private final By OrderId_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[1]");//tr[i]/td[i]   tr[i] for the next order
    private final By OrderDate_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[2]");//tr[i]/td[i] tr[i] for the next order
    private final By OrderStatus_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[3]");//tr[i]/td[i]   tr[i] for the next order
    private final By OrderPrice_FirstOrder = By.xpath("//main/div/div/div[2]/div/table/tbody/tr[1]/td[4]");//tr[i]/td[i]    tr[i] for the next order
    private final By ViewOrderDetails_FirstOrder = By.xpath("//tr[1]/td[5]/button");  //tr[i]





    //constructors
    public AdminPanelOrders(Driver driver)
    {
        this.driver = driver;
    }
}
