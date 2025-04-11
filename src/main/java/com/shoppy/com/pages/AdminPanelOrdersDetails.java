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
    //Actions
    public AdminPanelOrdersDetails clickOnPendingStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Pending);
        return this;
    }
    public AdminPanelOrdersDetails clickOnInProcessStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_InProcess);
        return this;
    }
    public AdminPanelOrdersDetails clickOnInShippingStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_InShipping);
        return this;
    }
    public AdminPanelOrdersDetails clickOnDeliveredStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Delivered);
        return this;
    }
    public AdminPanelOrdersDetails clickOnRejectedStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Rejected);
        return this;
    }
    public AdminPanelOrdersDetails clickOnUpdateOrderStatusBtn()
    {
        driver.element().click(Update_Orders_Status_Button);
        return this;
    }
    public AdminPanelOrders clickOnCloseDetailsBtn()
    {
        driver.element().click(Close_OrderDetails_Button);
        return new AdminPanelOrders(driver);
    }
    //Assertions
    public AdminPanelOrdersDetails checkOrderDetailsTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderDetailsTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderIdTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderIdTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderIdIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderIdText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderPriceTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderPriceTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderPriceIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderPriceText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderDateTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderDateTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderDateIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderDateText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderStatusTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderStatusTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderStatusIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderStatusText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderItemsTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkOrderItemsTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkProductNameIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkProductNameText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPriceTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPriceTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPriceValueIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPriceValueText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkQuantityTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkQuantityTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkQuantityValueIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkQuantityValueText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkTotalPriceValueIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkTotalPriceValueText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkShippingInfoTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkShippingInfoTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkUserTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkUserTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkAddressTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkAddressTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkCityTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkCityTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPincodeTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPincodeTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPhoneTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkPhoneTitleText()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkNotesTitleIsDisplayed()
    {
        return this;
    }
    public AdminPanelOrdersDetails checkNotesTitleText()
    {
        return this;
    }

}
