package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;

public class AdminPanelOrdersDetails
{
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/admin/orders";
    //locators order details
    private final By OrderDetails_Title = By.xpath("//h3");
    private final By OrderId_Title = By.xpath("//div[1]/div[1]/div[1]/p");
    private final By OrderId = By.xpath("//div[1]/div[1]/div[1]/label");
    private final By OrderPrice_Title = By.xpath("//div[1]/div[1]/div[2]/p");
    private final By OrderPrice = By.xpath("//div[1]/div[1]/div[2]/label");
    private final By OrderDate_Tile = By.xpath("//div[1]/div[1]/div[3]/p");
    private final By OrderDate = By.xpath("//div[1]/div[1]/div[3]/label");
    private final By OrderStatus_Title = By.xpath("//div[1]/div[1]/div[4]/p");
    private final By OrderStatus = By.xpath("//div[1]/div[1]/div[4]/div");
    //locators order items
    private final By OrderItems_Title = By.xpath("//div[1]/div[3]/div");
    private final By ProductName = By.xpath("//div[1]/div[3]/ul/li/div[1]/span[1]");
    private final By Price_Title = By.xpath("//div[1]/div[3]/ul/li/div[1]/span[2]/strong");
    private final By Price = By.xpath("//div[1]/div[3]/ul/li/div[1]/span[2]");
    private final By Quantity_Title = By.xpath("//div[1]/div[3]/ul/li/div[1]/span[3]/strong");
    private final By Quantity = By.xpath("//div[1]/div[3]/ul/li/div[1]/span[3]");
    private final By TotalPrice = By.xpath("//div[1]/div[3]/ul/li/div[2]/span");
    //locators shipping info
    private final By ShippingInfo_Title = By.xpath("//div[1]/div[5]/div");
    private final By User_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[1]/strong");
    private final By Address_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[2]/strong");
    private final By City_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[3]/strong");
    private final By Pincode_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[4]/strong");
    private final By Phone_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[5]/strong");
    private final By Notes_Field_Title = By.xpath("//div[1]/div[5]/div[2]/span[6]/strong");
    private final By User_Field = By.xpath("//div[1]/div[5]/div[2]/span[1]");
    private final By Address_Field = By.xpath("//div[1]/div[5]/div[2]/span[2]");
    private final By City_Field = By.xpath("//div[1]/div[5]/div[2]/span[3]");
    private final By Pincode_Field = By.xpath("//div[1]/div[5]/div[2]/span[4]");
    private final By Phone_Field = By.xpath("//div[1]/div[5]/div[2]/span[5]");
    private final By Notes_Field = By.xpath("//div[1]/div[5]/div[2]/span[6]");
    //Order Status
    private final By Order_Status_Title = By.xpath("//div[1]/div[6]/form/div/div/label");
    //Order Status Dropdown
    private final By Order_Status_DropDown = By.xpath("//div[1]/div[6]/form/div/div/div/button");
    private final By Order_Status_Pending = By.xpath("//div[1]/div[6]/form/div/div/div/select/option[1]");
    private final By Order_Status_InProcess = By.xpath("//div[1]/div[6]/form/div/div/div/select/option[2]");
    private final By Order_Status_InShipping = By.xpath("//div[1]/div[6]/form/div/div/div/select/option[3]");
    private final By Order_Status_Delivered = By.xpath("//div[1]/div[6]/form/div/div/div/select/option[4]");
    private final By Order_Status_Rejected = By.xpath("//div[1]/div[6]/form/div/div/div/select/option[5]");
    //Buttons end of form
    private final By Update_Orders_Status_Button = By.xpath("//div[1]/div[6]/form/button");
    private final By Close_OrderDetails_Button = By.xpath("//div[2]/button");


    public AdminPanelOrdersDetails(Driver driver)
    {
        this.driver = driver;
    }
}
