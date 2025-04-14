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
        System.out.println("👆click on status dropdown");
        driver.element().click(Order_Status_DropDown);
        System.out.println("✅select the pending status");
        driver.element().click(Order_Status_Pending);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the in process status")
    public AdminPanelOrdersDetails clickOnInProcessStatus()
    {
        System.out.println("👆click on status dropdown");
        driver.element().click(Order_Status_DropDown);
        System.out.println("✅select the in process status");
        driver.element().click(Order_Status_InProcess);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the in shipping status")
    public AdminPanelOrdersDetails clickOnInShippingStatus()
    {
        System.out.println("👆click on status dropdown");
        driver.element().click(Order_Status_DropDown);
        System.out.println("✅select the in shipping status");
        driver.element().click(Order_Status_InShipping);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the delivered status")
    public AdminPanelOrdersDetails clickOnDeliveredStatus()
    {
        System.out.println("👆click on status dropdown");
        driver.element().click(Order_Status_DropDown);
        System.out.println("✅select the delivered status");
        driver.element().click(Order_Status_Delivered);
        return this;
    }
    @Step("👆click on status dropdown and ✅select the rejected status")
    public AdminPanelOrdersDetails clickOnRejectedStatus()
    {
        System.out.println("👆click on status dropdown");
        driver.element().click(Order_Status_DropDown);
        System.out.println("✅select the rejected status");
        driver.element().click(Order_Status_Rejected);
        return this;
    }
    @Step("👆click on update status button")
    public AdminPanelOrdersDetails clickOnUpdateOrderStatusBtn()
    {
        System.out.println("👆click on update status button");
        driver.element().click(Update_Orders_Status_Button);
        return this;
    }
    @Step("👆click on close button")
    public AdminPanelOrders clickOnCloseDetailsBtn()
    {
        System.out.println("👆click on close button");
        driver.element().click(Close_OrderDetails_Button);
        return new AdminPanelOrders(driver);
    }
    //Assertions
    @Step("✅check the the url of the current page")
    public AdminPanelOrdersDetails checkAdminPanelOrdersUrl()
    {
        System.out.println("✅check the the url of the current page");
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()), url);
        return this;
    }
    @Step("✅check the order details title is displayed")
    public AdminPanelOrdersDetails checkOrderDetailsTitleIsDisplayed()
    {
        System.out.println("✅check the order details title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDetails_Title));
        return this;
    }
    @Step("✅check the order title text")
    public AdminPanelOrdersDetails checkOrderDetailsTitleText()
    {
        System.out.println("✅check the order title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderDetails_Title).contains("Order Details"));
        return this;
    }
    @Step("✅check the order id title is displayed")
    public AdminPanelOrdersDetails checkOrderIdTitleIsDisplayed()
    {
        System.out.println("✅check the order id title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId_Title));
        return this;
    }
    @Step("✅check the order id text")
    public AdminPanelOrdersDetails checkOrderIdTitleText()
    {
        System.out.println("✅check the order id text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderId_Title).contains("Order ID"));
        return this;
    }
    @Step("✅check the order id is displayed")
    public AdminPanelOrdersDetails checkOrderIdIsDisplayed()
    {
        System.out.println("✅check the order id is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderId));
        return this;
    }
    @Step("✅check the order price title is displayed")
    public AdminPanelOrdersDetails checkOrderPriceTitleIsDisplayed()
    {
        System.out.println("✅check the order price title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice_Title));
        return this;
    }
    @Step("✅check the order price title text")
    public AdminPanelOrdersDetails checkOrderPriceTitleText()
    {
        System.out.println("✅check the order price title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderPrice_Title).contains("Order Price"));
        return this;
    }
    @Step("✅check the order price is displayed")
    public AdminPanelOrdersDetails checkOrderPriceIsDisplayed()
    {
        System.out.println("✅check the order price is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderPrice));
        return this;
    }
    @Step("✅check the order date title is displayed")
    public AdminPanelOrdersDetails checkOrderDateTitleIsDisplayed()
    {
        System.out.println("✅check the order date title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate_Title));
        return this;
    }
    @Step("✅check the order date title text")
    public AdminPanelOrdersDetails checkOrderDateTitleText()
    {
        System.out.println("✅check the order date title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderDate_Title).contains("Order Date"));
        return this;
    }
    @Step("✅check the order date is displayed")
    public AdminPanelOrdersDetails checkOrderDateIsDisplayed()
    {
        System.out.println("✅check the order date is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderDate));
        return this;
    }
    @Step("✅check the order status title is displayed")
    public AdminPanelOrdersDetails checkOrderStatusTitleIsDisplayed()
    {
        System.out.println("✅check the order status title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus_Title));
        return this;
    }
    @Step("✅check the order status title text")
    public AdminPanelOrdersDetails checkOrderStatusTitleText()
    {
        System.out.println("✅check the order status title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderStatus_Title).contains("Order Status"));
        return this;
    }
    @Step("✅check the order status is displayed")
    public AdminPanelOrdersDetails checkOrderStatusIsDisplayed()
    {
        System.out.println("✅check the order status is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderStatus));
        return this;
    }
    @Step("✅check the order items title is displayed")
    public AdminPanelOrdersDetails checkOrderItemsTitleIsDisplayed()
    {
        System.out.println("✅check the order items title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),OrderItems_Title));
        return this;
    }
    @Step("✅check the order items title text")
    public AdminPanelOrdersDetails checkOrderItemsTitleText()
    {
        System.out.println("✅check the order items title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),OrderItems_Title).contains("Order Items"));
        return this;
    }
    @Step("✅check the product name is displayed")
    public AdminPanelOrdersDetails checkProductNameIsDisplayed()
    {
        System.out.println("✅check the product name is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),ProductName));
        return this;
    }
    @Step("✅check the price title is displayed")
    public AdminPanelOrdersDetails checkPriceTitleIsDisplayed()
    {
        System.out.println("✅check the price title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Price_Title));
        return this;
    }
    @Step("✅check the price title text")
    public AdminPanelOrdersDetails checkPriceTitleText()
    {
        System.out.println("✅check the price title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Price_Title).contains("Price"));
        return this;
    }
    @Step("✅check the price value is displayed")
    public AdminPanelOrdersDetails checkPriceValueIsDisplayed()
    {
        System.out.println("✅check the price value is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Price));
        return this;
    }
    @Step("✅check the price value text contains $")
    public AdminPanelOrdersDetails checkPriceValueText()
    {
        System.out.println("✅check the price value text contains $");
        Assert.assertTrue(ElementActions.getText(driver.get(),Price).contains("$"));
        return this;
    }
    @Step("✅check the quantity title is displayed")
    public AdminPanelOrdersDetails checkQuantityTitleIsDisplayed()
    {
        System.out.println("✅check the quantity title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Quantity_Title));
        return this;
    }
    @Step("✅check the quantity value is displayed")
    public AdminPanelOrdersDetails checkQuantityValueIsDisplayed()
    {
        System.out.println("✅check the quantity value is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Quantity));
        return this;
    }
    @Step("✅check the total price is displayed")
    public AdminPanelOrdersDetails checkTotalPriceValueIsDisplayed()
    {
        System.out.println("✅check the total price is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),TotalPrice));
        return this;
    }
    @Step("✅check the total price value text contains $")
    public AdminPanelOrdersDetails checkTotalPriceValueText()
    {
        System.out.println("✅check the total price value text contains $");
        Assert.assertTrue(ElementActions.getText(driver.get(),TotalPrice).contains("$"));
        return this;
    }
    @Step("✅check the shipping info title is displayed")
    public AdminPanelOrdersDetails checkShippingInfoTitleIsDisplayed()
    {
        System.out.println("✅check the shipping info title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),ShippingInfo_Title));
        return this;
    }
    @Step("✅check the shipping info title text")
    public AdminPanelOrdersDetails checkShippingInfoTitleText()
    {
        System.out.println("✅check the shipping info title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),ShippingInfo_Title).contains("Shipping Info"));
        return this;
    }
    @Step("✅check the user title is displayed")
    public AdminPanelOrdersDetails checkUserTitleIsDisplayed()
    {
        System.out.println("✅check the user title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),User_Field));
        return this;
    }
    @Step("✅check the user title text")
    public AdminPanelOrdersDetails checkUserTitleText()
    {
        System.out.println("✅check the user title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),User_Field_Title).contains("User"));
        return this;
    }
    @Step("✅check the address title is displayed")
    public AdminPanelOrdersDetails checkAddressTitleIsDisplayed()
    {
        System.out.println("✅check the address title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Address_Field));
        return this;
    }
    @Step("✅check the address title text")
    public AdminPanelOrdersDetails checkAddressTitleText()
    {
        System.out.println("✅check the address title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Address_Field_Title).contains("Address"));
        return this;
    }
    @Step("✅check the city title is displayed")
    public AdminPanelOrdersDetails checkCityTitleIsDisplayed()
    {
        System.out.println("✅check the city title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),City_Field));
        return this;
    }
    @Step("✅check the city title text")
    public AdminPanelOrdersDetails checkCityTitleText()
    {
        System.out.println("✅check the city title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),City_Field_Title).contains("City"));
        return this;
    }
    @Step("✅check the pinecode title is displayed")
    public AdminPanelOrdersDetails checkPincodeTitleIsDisplayed()
    {
        System.out.println("✅check the pinecode title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Pincode_Field));
        return this;
    }
    @Step("✅check the pinecode title text")
    public AdminPanelOrdersDetails checkPincodeTitleText()
    {
        System.out.println("✅check the pinecode title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Pincode_Field_Title).contains("Pincode"));
        return this;
    }
    @Step("✅check the phone title is displayed")
    public AdminPanelOrdersDetails checkPhoneTitleIsDisplayed()
    {
        System.out.println("✅check the phone title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Phone_Field));
        return this;
    }
    @Step("✅check the phone title text")
    public AdminPanelOrdersDetails checkPhoneTitleText()
    {
        System.out.println("✅check the phone title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Phone_Field_Title).contains("Phone"));
        return this;
    }
    @Step("✅check the notes title is displayed")
    public AdminPanelOrdersDetails checkNotesTitleIsDisplayed()
    {
        System.out.println("✅check the notes title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Notes_Field));
        return this;
    }
    @Step("✅check the notes title text")
    public AdminPanelOrdersDetails checkNotesTitleText()
    {
        System.out.println("✅check the notes title text");
        Assert.assertTrue(ElementActions.getText(driver.get(),Notes_Field_Title).contains("Notes"));
        return this;
    }
    @Step("✅check the order status title is displayed")
    public AdminPanelOrdersDetails checkOrderStatusDropDownTitleIsDisplayed()
    {
        System.out.println("✅check the order status title is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),Order_Status_Title));
        return this;
    }
    @Step("✅check the order status title text of dropdown")
    public AdminPanelOrdersDetails checkOrderStatusDropDownTitleText()
    {
        System.out.println("✅check the order status title text of dropdown");
        Assert.assertTrue(ElementActions.getText(driver.get(),Order_Status_Title).contains("Order Status"));
        return this;
    }

}
