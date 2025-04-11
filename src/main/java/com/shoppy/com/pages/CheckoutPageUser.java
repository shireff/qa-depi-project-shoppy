package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;

public class CheckoutPageUser
{
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/shop/checkout";
    //Nav Bar Responsive Button
    private final By Responsive_Nav_Button = By.xpath("//header/div/button [@type=\"button\"]");
    //Nav Bar  Buttons Responsive and Normal working for both
    private final By Home_Label_Button = By.xpath("//nav/label[1]");
    private final By Products_Label_Button = By.xpath("//nav/label[2]");
    private final By Men_Label_Button = By.xpath("//nav/label[3]");
    private final By Women_Label_Button = By.xpath("//nav/label[4]");
    private final By Kids_Label_Button = By.xpath("//nav/label[5]");
    private final By Footwear_Label_Button = By.xpath("//nav/label[6]");
    private final By Accessories_Label_Button = By.xpath("//nav/label[7]");
    private final By Search_Label_Button = By.xpath("//nav/label[8]");
    private final By Shoppy_Icon = By.xpath("//header/div/a");
    //footer locators
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");
    //Checkout Title Image
    private final By Title_Image = By.xpath("//img [@alt=\"Account Image\"]");
    //Buyer form adding address
    private final By User_Saved_Address = By.xpath("//main/div/div[2]/div[1]/div[1]/p");
    private final By AddNewAddress_Title = By.xpath("//main/div/div[2]/div[1]/div[2]/div");
    private final By Address_Label = By.xpath("//form/div/div[1]/label");
    private final By Address_Input = By.xpath("//input [@id=\"address\"]");
    private final By City_Label = By.xpath("//form/div/div[2]/label");
    private final By City_Input = By.xpath("//input [@id=\"city\"]");
    private final By PineCode_Label = By.xpath("//form/div/div[3]/label");
    private final By PinCode_Input = By.xpath("//input [@id=\"pincode\"]");
    private final By Phone_Label = By.xpath("//form/div/div[4]/label");
    private final By Phone_input = By.xpath("//input [@id=\"phone\"]");
    private final By Notes_Label = By.xpath("//form/div/div[5]/label");
    private final By Notes_TextArea = By.xpath("//textarea [@id=\"notes\"]");
    private final By AddAddress_Button = By.xpath("//button[@type=\"submit\"]");
    //product checkout
    private final By Product_Image = By.xpath("//main/div/div[2]/div[2]/div[1]/img");
    private final By Product_Name = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/h3");
    private final By Minus_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/button[1]");
    private final By Add_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/button[2]");
    private final By ProductQuantity_Label = By.xpath("//main/div/div[2]/div[2]/div[1]/div[1]/div/span");
    private final By ProductPrice_Label = By.xpath("//main/div/div[2]/div[2]/div[1]/div[2]/p");
    private final By DeleteProduct_Button = By.xpath("//main/div/div[2]/div[2]/div[1]/div[2]/*[local-name() = 'svg']");
    //Total Buying part
    private final By Total_Title = By.xpath("//main/div/div[2]/div[2]/div[3]/div/span[1]");
    private final By TotalBuy_Label = By.xpath("//main/div/div[2]/div[2]/div[3]/div/span[2]");
    private final By PayPal_Button = By.xpath("//main/div/div[2]/div[2]/div[4]/div[1]");
    private final By Cash_Button = By.xpath("//main/div/div[2]/div[2]/div[4]/div[2]");
    // check out button
    private final By Checkout_Button = By.xpath("//main/div/div[2]/div[2]/div[5]/button");
    //constructor
    public CheckoutPageUser(Driver driver)
    {
        this.driver = driver;
    }
}
