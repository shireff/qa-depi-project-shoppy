package com.shoppy.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPageUser
{
    private final WebDriver driver;

    //Sort By
    private final By SortByButton = By.xpath("//button[@id=\"radix-:r87:\"]");
    private final By PriceLowToHigh = By.xpath("//div[@role=\"menuitemradio\"][1]");
    private final By PriceHighToLow = By.xpath("//div[@role=\"menuitemradio\"][2]");
    private final By TitleA_To_Z = By.xpath("//div[@role=\"menuitemradio\"][3]");
    private final By TitleZ_To_A = By.xpath("//div[@role=\"menuitemradio\"][4]");
    //Filter CheckBoxes Categories
    private final By Men_CheckBox = By.xpath("//button[@id=\"men\"]");
    private final By Women_CheckBox = By.xpath("//button[@id=\"women\"]");
    private final By Kids_CheckBox = By.xpath("//button[@id=\"kids\"]");
    private final By Accessories_CheckBox = By.xpath("//button[@id=\"accessories\"]");
    private final By Footwear_CheckBox = By.xpath("//button[@id=\"footwear\"]");
    //Filter CheckBoxes Brand
    private final By Nike_CheckBox = By.xpath("//button[@id=\"nike\"]");
    private final By Adidas_CheckBox = By.xpath("//button[@id=\"adidas\"]");
    private final By Puma_CheckBox = By.xpath("//button[@id=\"puma\"]");
    private final By Levis_CheckBox = By.xpath("//button[@id=\"levi\"]");
    private final By Zara_CheckBox = By.xpath("//button[@id=\"zara\"]");
    private final By HM_CheckBox = By.xpath("//button[@id=\"h&m\"]");
    //Nav Bar  Buttons
    private final By Home_Label_Button = By.xpath("//div/nav/label[1]");
    private final By Products_Label_Button = By.xpath("//div/nav/label[2]");
    private final By Men_Label_Button = By.xpath("//div/nav/label[3]");
    private final By Women_Label_Button = By.xpath("//div/nav/label[4]");
    private final By Kids_Label_Button = By.xpath("//div/nav/label[5]");
    private final By Footwear_Label_Button = By.xpath("//div/nav/label[6]");
    private final By Accessories_Label_Button = By.xpath("//div/nav/label[7]");
    //Constructor
    public ProductsPageUser(WebDriver driver)
    {
        this.driver = driver;
    }
    //Actions

    //Category Check Boxes
    public ProductsPageUser clickMenCheckBox()
    {
        driver.findElement(Men_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickWomenCheckBox()
    {
        driver.findElement(Women_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickKidsCheckBox()
    {
        driver.findElement(Kids_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickAccessoriesCheckBox()
    {
        driver.findElement(Accessories_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickFootWearCheckBox()
    {
        driver.findElement(Footwear_CheckBox).click();
        return this;
    }
    //Brand Check Boxes
    public ProductsPageUser clickNickCheckBox()
    {
        driver.findElement(Nike_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickAdidasCheckBox()
    {
        driver.findElement(Adidas_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickPumaCheckBox()
    {
        driver.findElement(Puma_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickLevisCheckBox()
    {
        driver.findElement(Levis_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickZaraCheckBox()
    {
        driver.findElement(Zara_CheckBox).click();
        return this;
    }
    public ProductsPageUser clickHMCheckBox()
    {
        driver.findElement(HM_CheckBox).click();
        return this;
    }
    //Navigation Bar interaction
    public HomePage clickNavBarHome()
    {
        driver.findElement(Home_Label_Button).click();
        return new HomePage(driver);
    }
    public ProductsPageUser clickNavBarProducts()
    {
        driver.findElement(Products_Label_Button).click();
        return this;
    }
    public ProductsPageUser clickNavBarMen()
    {
        driver.findElement(Men_Label_Button).click();
        return this;
    }
    public ProductsPageUser clickNavBarWomen()
    {
        driver.findElement(Women_Label_Button).click();
        return this;
    }
    public ProductsPageUser clickNavBarKids()
    {
        driver.findElement(Kids_Label_Button).click();
        return this;
    }
    public ProductsPageUser clickNavBarFootWear()
    {
        driver.findElement(Footwear_Label_Button).click();
        return this;
    }
    public ProductsPageUser clickNavBarAccessories()
    {
        driver.findElement(Accessories_Label_Button).click();
        return this;
    }
    //Sort By DropDown
    public ProductsPageUser sortByPriceLowToHigh()
    {
        new Select(driver.findElement(SortByButton)).selectByVisibleText(driver.findElement(PriceLowToHigh).getText());
        return this;
    }
    public ProductsPageUser sortByPriceHighToLow()
    {
        new Select(driver.findElement(SortByButton)).selectByVisibleText(driver.findElement(PriceHighToLow).getText());
        return this;
    }
    public ProductsPageUser sortByTitleA_To_Z()
    {
        new Select(driver.findElement(SortByButton)).selectByVisibleText(driver.findElement(TitleA_To_Z).getText());
        return this;
    }
    public ProductsPageUser sortByTitleZ_To_A()
    {
        new Select(driver.findElement(SortByButton)).selectByVisibleText(driver.findElement(TitleZ_To_A).getText());
        return this;
    }

    //Assertions

}
