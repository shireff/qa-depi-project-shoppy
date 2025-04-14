package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

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
    private final By OrderDate_Title = By.xpath("//div[1]/div[1]/div[3]/p");
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
    @Step("👆click on status dropdown and ✅select the pending status")
    public AdminPanelOrdersDetails clickOnPendingStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Pending);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the in process status")
    public AdminPanelOrdersDetails clickOnInProcessStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_InProcess);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the in shipping status")
    public AdminPanelOrdersDetails clickOnInShippingStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_InShipping);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the delivered status")
    public AdminPanelOrdersDetails clickOnDeliveredStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Delivered);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the rejected status")
    public AdminPanelOrdersDetails clickOnRejectedStatus()
    {
        driver.element().click(Order_Status_DropDown);
        driver.element().click(Order_Status_Rejected);
        return this;
    }
    @Step("👆click on update status button")
    public AdminPanelOrdersDetails clickOnUpdateOrderStatusBtn()
    {
        driver.element().click(Update_Orders_Status_Button);
        return this;
    }
    @Step("👆click on close button")
    public AdminPanelOrders clickOnCloseDetailsBtn()
    {
        driver.element().click(Close_OrderDetails_Button);
        return new AdminPanelOrders(driver);
    }
    //Assertions
    @Step("✅check the the url of the current page")
    public AdminPanelOrdersDetails checkAdminPanelOrdersUrl()
    {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), url);
        return this;
    }
    @Step("✅check the order details title is displayed")
    public AdminPanelOrdersDetails checkOrderDetailsTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderDetails_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order title text")
    public AdminPanelOrdersDetails checkOrderDetailsTitleText()
    {
        driver.assertion().assertElementTextContains(OrderDetails_Title,"Order Details","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order id title is displayed")
    public AdminPanelOrdersDetails checkOrderIdTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderId_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order id text")
    public AdminPanelOrdersDetails checkOrderIdTitleText()
    {
        driver.assertion().assertElementTextEquals(OrderId_Title,"Order ID","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order id is displayed")
    public AdminPanelOrdersDetails checkOrderIdIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderId,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order price title is displayed")
    public AdminPanelOrdersDetails checkOrderPriceTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderPrice_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order price title text")
    public AdminPanelOrdersDetails checkOrderPriceTitleText()
    {
        driver.assertion().assertElementTextContains(OrderPrice_Title,"Order Price","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order price is displayed")
    public AdminPanelOrdersDetails checkOrderPriceIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderPrice,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order date title is displayed")
    public AdminPanelOrdersDetails checkOrderDateTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderDate_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order date title text")
    public AdminPanelOrdersDetails checkOrderDateTitleText()
    {
        driver.assertion().assertElementTextContains(OrderDate_Title,"Order Date","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order date is displayed")
    public AdminPanelOrdersDetails checkOrderDateIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderDate,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order status title is displayed")
    public AdminPanelOrdersDetails checkOrderStatusTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Order_Status_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order status title text")
    public AdminPanelOrdersDetails checkOrderStatusTitleText()
    {
        driver.assertion().assertElementTextContains(OrderStatus_Title,"Order Status","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order status is displayed")
    public AdminPanelOrdersDetails checkOrderStatusIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderStatus,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order items title is displayed")
    public AdminPanelOrdersDetails checkOrderItemsTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(OrderItems_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order items title text")
    public AdminPanelOrdersDetails checkOrderItemsTitleText()
    {
        driver.assertion().assertElementTextContains(OrderItems_Title,"Order Items","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the product name is displayed")
    public AdminPanelOrdersDetails checkProductNameIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(ProductName,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the price title is displayed")
    public AdminPanelOrdersDetails checkPriceTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Price_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the price title text")
    public AdminPanelOrdersDetails checkPriceTitleText()
    {
        driver.assertion().assertElementTextContains(Price_Title,"Price","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the price value is displayed")
    public AdminPanelOrdersDetails checkPriceValueIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Price,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the price value text contains $")
    public AdminPanelOrdersDetails checkPriceValueText()
    {
        driver.assertion().assertElementTextContains(Price,"$","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the quantity title is displayed")
    public AdminPanelOrdersDetails checkQuantityTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Quantity_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the quantity value is displayed")
    public AdminPanelOrdersDetails checkQuantityValueIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Quantity,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the total price is displayed")
    public AdminPanelOrdersDetails checkTotalPriceValueIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(TotalPrice,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the total price value text contains $")
    public AdminPanelOrdersDetails checkTotalPriceValueText()
    {
        driver.assertion().assertElementTextContains(TotalPrice,"$","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the shipping info title is displayed")
    public AdminPanelOrdersDetails checkShippingInfoTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(ShippingInfo_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the shipping info title text")
    public AdminPanelOrdersDetails checkShippingInfoTitleText()
    {
        driver.assertion().assertElementTextEquals(ShippingInfo_Title,"Shipping Info","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the user title is displayed")
    public AdminPanelOrdersDetails checkUserTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(User_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the user title text")
    public AdminPanelOrdersDetails checkUserTitleText()
    {
        driver.assertion().assertElementTextContains(User_Field_Title,"User","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the address title is displayed")
    public AdminPanelOrdersDetails checkAddressTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Address_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the address title text")
    public AdminPanelOrdersDetails checkAddressTitleText()
    {
        driver.assertion().assertElementTextContains(Address_Field_Title,"Address","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the city title is displayed")
    public AdminPanelOrdersDetails checkCityTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(City_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the city title text")
    public AdminPanelOrdersDetails checkCityTitleText()
    {
        driver.assertion().assertElementTextContains(City_Field_Title,"City","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the pinecode title is displayed")
    public AdminPanelOrdersDetails checkPincodeTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Pincode_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the pinecode title text")
    public AdminPanelOrdersDetails checkPincodeTitleText()
    {
        driver.assertion().assertElementTextEquals(Pincode_Field_Title,"Pincode","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the phone title is displayed")
    public AdminPanelOrdersDetails checkPhoneTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Phone_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the phone title text")
    public AdminPanelOrdersDetails checkPhoneTitleText()
    {
        driver.assertion().assertElementTextContains(Phone_Field_Title,"Phone","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the notes title is displayed")
    public AdminPanelOrdersDetails checkNotesTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Notes_Field,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the notes title text")
    public AdminPanelOrdersDetails checkNotesTitleText()
    {
        driver.assertion().assertElementTextContains(Notes_Field_Title,"Notes","The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check the order status title is displayed")
    public AdminPanelOrdersDetails checkOrderStatusDropDownTitleIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(Order_Status_Title,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check the order status title text of dropdown")
    public AdminPanelOrdersDetails checkOrderStatusDropDownTitleText()
    {
        driver.assertion().assertElementTextContains(Order_Status_Title,"Order Status","The text of the element does not match the expected value");
        return this;
    }

}
