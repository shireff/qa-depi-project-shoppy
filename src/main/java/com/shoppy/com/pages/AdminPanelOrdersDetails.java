package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;

public class AdminPanelOrdersDetails
{
    private final Driver driver;
    //locators order details
    private final By OrderDetails_Title = By.xpath("//h3 [@id=\"headlessui-dialog-title-:rn:\"]");
    private final By OrderId_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[1]/div[1]/p");
    private final By OrderPrice_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[1]/div[2]/p");
    private final By OrderDate_Tile = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[1]/div[3]/p");
    private final By OrderStatus_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[1]/div[4]/p");
    //locators order items
    private final By OrderItems_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[3]/div");
    private final By ProductName_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[3]/ul/li/div[1]/span[1]");
    private final By Price_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[3]/ul/li/div[1]/span[2]");
    private final By Quantity_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[3]/ul/li/div[1]/span[3]");
    //locators shipping info
    private final By ShippingInfo_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:rm:\"]/div[1]/div[5]/div");
    private final By User_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[1]/strong");
    private final By Address_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[2]/strong");
    private final By City_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[3]/strong");
    private final By Pincode_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[4]/strong");
    private final By Phone_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[5]/strong");
    private final By Notes_Field_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[6]/strong");
    private final By User_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[1]");
    private final By Address_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[2]");
    private final By City_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[3]");
    private final By Pincode_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[4]");
    private final By Phone_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[5]");
    private final By Notes_Field = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[5]/div[2]/span[6]");
    //Order Status
    private final By Order_Status_Title = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[6]/form/div/div/label");
    private final By Order_Status_DropDown = By.xpath("//*[@id=\"headlessui-dialog-panel-:r1p:\"]/div[1]/div[6]/form/div/div/div/button");
    //Order Status Dropdown

    public AdminPanelOrdersDetails(Driver driver)
    {
        this.driver = driver;
    }
}
