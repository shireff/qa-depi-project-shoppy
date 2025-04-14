package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPageUser
{
    private final Driver driver;

    private final String url = "https://shoppy-ochre.vercel.app/shop/search";
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
    String Search_Button_Text = "Search";
    //search box
    private final By SearchBox = By.xpath("//main/div/div/div/input");
    private final By No_Products_Found_Header = By.xpath("//main/div/h1");
    //products results
    private final By First_Search_ProductName = By.xpath("//main/div/div[2]/div[1]/div/div[2]/h2");           //div[i]/div/div[2]/h2
    private final By First_Search_Category = By.xpath("//main/div/div[2]/div[1]/div/div[2]/div[1]/span[1]");  //div[i]/div/div[2]/div[1]/span[1]
    private final By First_Search_Brand = By.xpath("//main/div/div[2]/div[1]/div/div[2]/div[1]/span[2]");     //div[i]/div/div[2]/div[1]/span[2]
    private final By First_Search_Price = By.xpath("//main/div/div[2]/div[1]/div/div[2]/div[2]/span[1]");     //div[i]/div/div[2]/div[2]/span[1]
    private final By First_Search_SalePrice = By.xpath("//main/div/div[2]/div[1]/div/div[2]/div[2]/span[2]"); //div[i]/div/div[2]/div[2]/span[2]
    private final By First_Search_AddToCardBtn = By.xpath("//main/div/div[2]/div[1]/div/div[3]/button");      //div[i]/div/div[3]/button
    private final By First_Search_Image = By.xpath("//main/div/div[2]/div[1]/div/div[1]/img");                //main/div/div[2]/div[i]/div/div[1]/img
    //footer locators
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");
    public SearchPageUser(Driver driver)
    {
        this.driver = driver;
    }

    //Actions
    @Step("👆click on the search box")
    public SearchPageUser clickOnSearchBox()
    {
        System.out.println("👆click on the search box");
        driver.element().click(SearchBox);
        return this;
    }
    @Step("✍️fill the search box Men")
    public SearchPageUser fillSearchBoxMen()
    {
        System.out.println("✍️fill the search box Men");
        driver.element().type(SearchBox,"Men");
        return this;
    }
    @Step("✍️fill the search box Women")
    public SearchPageUser fillSearchBoxWomen()
    {
        System.out.println("✍️fill the search box Women");
        driver.element().type(SearchBox,"Women");
        return this;
    }
    @Step("✍️fill the search box Kids")
    public SearchPageUser fillSearchBoxKids()
    {
        System.out.println("✍️fill the search box Kids");
        driver.element().type(SearchBox,"Kids");
        return this;
    }
    @Step("✍️fill the search box Footwear")
    public SearchPageUser fillSearchBoxFootwear()
    {
        System.out.println("✍️fill the search box Footwear");
        driver.element().type(SearchBox,"Footwear");
        return this;
    }
    @Step("✍️fill the search box Accessories")
    public SearchPageUser fillSearchBoxAccessories()
    {
        System.out.println("✍️fill the search box Accessories");
        driver.element().type(SearchBox,"Accessories");
        return this;
    }
    @Step("✍️fill the search box Nike")
    public SearchPageUser fillSearchBoxNike()
    {
        System.out.println("✍️fill the search box Nike");
        driver.element().type(SearchBox,"Nike");
        return this;
    }
    @Step("✍️fill the search box Adidas")
    public SearchPageUser fillSearchBoxAdidas()
    {
        System.out.println("✍️fill the search box Adidas");
        driver.element().type(SearchBox,"Adidas");
        return this;
    }
    @Step("✍️fill the search box Puma")
    public SearchPageUser fillSearchBoxPuma()
    {
        System.out.println("✍️fill the search box Puma");
        driver.element().type(SearchBox,"Puma");
        return this;
    }
    @Step("✍️fill the search box Levi's")
    public SearchPageUser fillSearchBoxLevis()
    {
        System.out.println("✍️fill the search box Levi's");
        driver.element().type(SearchBox,"Levi's");
        return this;
    }
    @Step("✍️fill the search box Zara")
    public SearchPageUser fillSearchBoxZara()
    {
        System.out.println("✍️fill the search box Zara");
        driver.element().type(SearchBox,"Zara");
        return this;
    }
    @Step("✍️fill the search box H&M")
    public SearchPageUser fillSearchBoxHM()
    {
        System.out.println("✍️fill the search box H&M");
        driver.element().type(SearchBox,"H&M");
        return this;
    }
    @Step("👆click on the searched image for details")
    public void clickOnSearchedImage()
    {
        System.out.println("👆click on the searched image for details");
        driver.element().click(First_Search_Image);
    }
    //Assertion
    @Step("✅check search tab in nav is visible")
    public SearchPageUser checkThatSearchTabIsVisible()
    {
        System.out.println("✅check search tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Search_Label_Button);
        Assert.assertEquals(actualTitle,Search_Button_Text);
        return this;
    }
    @Step("✅check that search box is displayed")
    public SearchPageUser checkThatSearchBoxIsDisplayed()
    {
        System.out.println("✅check that search box is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),SearchBox));
        return this;
    }
    @Step("✅check that no products found is displayed before search")
    public SearchPageUser checkThatNoProductsFoundIsDisplayed()
    {
        System.out.println("✅check that no products found is displayed before search");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),No_Products_Found_Header));
        return this;
    }
    @Step("✅check that the searched product's name is displayed")
    public SearchPageUser checkThatProductSearchedNameIsDisplayed()
    {
        System.out.println("✅check that the searched product's name is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_ProductName));
        return this;
    }
    @Step("✅check that the searched product's category is displayed")
    public SearchPageUser checkThatProductSearchedCategoryIsDisplayed()
    {
        System.out.println("✅check that the searched product's category is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_Category));
        return this;
    }
    @Step("✅check that the searched product's brand is displayed")
    public SearchPageUser checkThatProductSearchedBrandIsDisplayed()
    {
        System.out.println("✅check that the searched product's brand is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_Brand));
        return this;
    }
    @Step("✅check that the searched product's price is displayed")
    public SearchPageUser checkThatProductSearchedPriceIsDisplayed()
    {
        System.out.println("✅check that the searched product's price is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_Price));
        return this;
    }
    @Step("✅check that the searched product's sale price is displayed")
    public SearchPageUser checkThatProductSearchedSalePriceIsDisplayed()
    {
        System.out.println("✅check that the searched product's sale price is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_SalePrice));
        return this;
    }
    @Step("✅check that the searched product's add to card button is displayed")
    public SearchPageUser checkThatProductSearchedAddToCardIsDisplayed()
    {
        System.out.println("✅check that the searched product's add to card button is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_AddToCardBtn));
        return this;
    }
    @Step("✅check that the searched product's image is displayed")
    public SearchPageUser checkThatProductSearchedImageIsDisplayed()
    {
        System.out.println("✅check that the searched product's image is displayed");
        Assert.assertTrue(ElementActions.isDisplayed(driver.get(),First_Search_Image));
        return this;
    }
}
