package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPageUser
{
    private Driver driver;

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
    //Constructor
    public SearchPageUser(Driver driver)
    {
        this.driver = driver;
    }

    //Actions
    @Step("👆click on search tap")
    public SearchPageUser clickOnSearchTap()
    {
        driver.element().click(Search_Label_Button);
        return this;
    }
    @Step("👆click on the search box")
    public SearchPageUser clickOnSearchBox()
    {
        driver.element().click(SearchBox);
        return this;
    }
    @Step("✍️fill the search box Men")
    public SearchPageUser fillSearchBoxMen()
    {
        driver.element().type(SearchBox,"Men");
        return this;
    }
    @Step("✍️fill the search box Women")
    public SearchPageUser fillSearchBoxWomen()
    {
        driver.element().type(SearchBox,"Women");
        return this;
    }
    @Step("✍️fill the search box Kids")
    public SearchPageUser fillSearchBoxKids()
    {
        driver.element().type(SearchBox,"Kids");
        return this;
    }
    @Step("✍️fill the search box Footwear")
    public SearchPageUser fillSearchBoxFootwear()
    {
        driver.element().type(SearchBox,"Footwear");
        return this;
    }
    @Step("✍️fill the search box Accessories")
    public SearchPageUser fillSearchBoxAccessories()
    {
        driver.element().type(SearchBox,"Accessories");
        return this;
    }
    @Step("✍️fill the search box Nike")
    public SearchPageUser fillSearchBoxNike()
    {
        driver.element().type(SearchBox,"Nike");
        return this;
    }
    @Step("✍️fill the search box Adidas")
    public SearchPageUser fillSearchBoxAdidas()
    {
        driver.element().type(SearchBox,"Adidas");
        return this;
    }
    @Step("✍️fill the search box Puma")
    public SearchPageUser fillSearchBoxPuma()
    {
        driver.element().type(SearchBox,"Puma");
        return this;
    }
    @Step("✍️fill the search box Levi's")
    public SearchPageUser fillSearchBoxLevis()
    {
        driver.element().type(SearchBox,"Levi's");
        return this;
    }
    @Step("✍️fill the search box Zara")
    public SearchPageUser fillSearchBoxZara()
    {
        driver.element().type(SearchBox,"Zara");
        return this;
    }
    @Step("✍️fill the search box H&M")
    public SearchPageUser fillSearchBoxHM()
    {
        driver.element().type(SearchBox,"H&M");
        return this;
    }
    @Step("👆click on the searched image for details")
    public void clickOnSearchedImage()
    {
        driver.element().click(First_Search_Image);
    }
    //Assertion
    @Step("✅check search tab in nav is visible")
    public SearchPageUser checkThatSearchTabIsVisible()
    {
        driver.assertion().assertElementTextEquals(Search_Label_Button,Search_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check that search box is displayed")
    public SearchPageUser checkThatSearchBoxIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(SearchBox,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that no products found is displayed before search")
    public SearchPageUser checkThatNoProductsFoundIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(No_Products_Found_Header,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's name is displayed")
    public SearchPageUser checkThatProductSearchedNameIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_ProductName,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's category is displayed")
    public SearchPageUser checkThatProductSearchedCategoryIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_Category,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's brand is displayed")
    public SearchPageUser checkThatProductSearchedBrandIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_Brand,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's price is displayed")
    public SearchPageUser checkThatProductSearchedPriceIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_Price,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's sale price is displayed")
    public SearchPageUser checkThatProductSearchedSalePriceIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_SalePrice,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's add to card button is displayed")
    public SearchPageUser checkThatProductSearchedAddToCardIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_AddToCardBtn,"The element is not displayed as expected");
        return this;
    }
    @Step("✅check that the searched product's image is displayed")
    public SearchPageUser checkThatProductSearchedImageIsDisplayed()
    {
        driver.assertion().assertElementDisplayed(First_Search_Image,"The element is not displayed as expected");
        return this;
    }
    @Step("✅Check if the footer rights reserved text is displayed")
    public SearchPageUser checkFooterRightsReservedDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_Rights_Reserved, "The footer rights reserved text is not displayed.");
        return this;
    }

    @Step("✅Check the text of the footer rights reserved")
    public SearchPageUser checkFooterRightsReservedText(String expectedText) {
        driver.assertion().assertElementTextContains(Footer_Rights_Reserved, expectedText, "The footer rights reserved text does not match.");
        return this;
    }

    @Step("✅Check if the GitHub link is displayed")
    public SearchPageUser checkFooterGitHubDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_GitHub, "The GitHub link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check if the LinkedIn link is displayed")
    public SearchPageUser checkFooterLinkedInDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_LinkedIn, "The LinkedIn link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check if the WhatsApp link is displayed")
    public SearchPageUser checkFooterWhatsAppDisplayed() {
        driver.assertion().assertElementDisplayed(Footer_WhatsApp, "The WhatsApp link in the footer is not displayed.");
        return this;
    }

    @Step("✅Check the href attribute of the GitHub link")
    public SearchPageUser checkFooterGitHubLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_GitHub, "href", expectedLink, "The GitHub link in the footer is incorrect.");
        return this;
    }

    @Step("✅Check the href attribute of the LinkedIn link")
    public SearchPageUser checkFooterLinkedInLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_LinkedIn, "href", expectedLink, "The LinkedIn link in the footer is incorrect.");
        return this;
    }

    @Step("✅Check the href attribute of the WhatsApp link")
    public SearchPageUser checkFooterWhatsAppLink(String expectedLink) {
        driver.assertion().assertElementAttributeEquals(Footer_WhatsApp, "href", expectedLink, "The WhatsApp link in the footer is incorrect.");
        return this;
    }
}
