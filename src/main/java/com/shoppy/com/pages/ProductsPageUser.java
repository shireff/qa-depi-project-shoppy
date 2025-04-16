package com.shoppy.com.pages;

import DriverFactory.Driver;
import com.shoppy.com.utils.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPageUser {
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/shop/listing";
    //Sort By
    private final By SortByButton = By.xpath("//button [@type=\"button\"]/span");
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
    //Muted Text Products Number
    private final By ProductsNumberText = By.xpath("//span [@class=\"text-muted-foreground\"]");
    //Text Variables
    String AllProductsTitleText = "All Products";
    By AllProductsTitle = By.xpath("//main/div/div[2]/div[1]/h2");
    String FiltersTitleText = "Filters";
    By FiltersTitle = By.xpath("//main/div/div[1]/div[1]/h2");
    String CategoryTitleText = "Category";
    By CategoryTitle = By.xpath("//main/div/div[1]/div[2]/div[1]/h3");
    String BrandTitleText = "Brand";
    By BrandTitle = By.xpath("//main/div/div[1]/div[2]/div[3]/h3");
    String Home_Button_Text = "Home";
    String Products_Button_Text = "Products";
    String Men_Button_Text = "Men";
    String Women_Button_Text = "Women";
    String Kids_Button_Text = "Kids";
    String Footwear_Button_Text = "Footwear";
    String Accessories_Button_Text = "Accessories";
    String Search_Button_Text = "Search";
    //footer locators
    private final By Footer_Rights_Reserved = By.xpath("//footer/div/p");
    private final By Footer_GitHub = By.xpath("//footer/div/div/a[1]");
    private final By Footer_LinkedIn = By.xpath("//footer/div/div/a[2]");
    private final By Footer_WhatsApp = By.xpath("//footer/div/div/a[3]");

    //Constructor
    public ProductsPageUser(Driver driver) {
        this.driver = driver;
    }

    //Actions
    @Step("⬆️navigating to the products page")
    public ProductsPageUser driverNavigate() {
        driver.element().click(Products_Label_Button);
        return this;
    }

    //Category Check Boxes Actions
    @Step("✅clicking on Men CheckBox")
    public ProductsPageUser clickMenCheckBox() {
        driver.element().click(Men_CheckBox);
        return this;
    }
    @Step("✅clicking women check box")
    public ProductsPageUser clickWomenCheckBox() {
        driver.element().click(Women_CheckBox);
        return this;
    }
    @Step("✅clicking kids check box")
    public ProductsPageUser clickKidsCheckBox() {
        driver.element().click(Kids_CheckBox);
        return this;
    }
    @Step("✅clicking Accessors check box")
    public ProductsPageUser clickAccessoriesCheckBox() {
        driver.element().click(Accessories_CheckBox);
        return this;
    }
    @Step("✅clicking foot wear check box")
    public ProductsPageUser clickFootWearCheckBox() {
        driver.element().click(Footwear_CheckBox);
        return this;
    }

    //Brand Check Boxes Actions
    @Step("✅clicking nick check box")
    public ProductsPageUser clickNickCheckBox() {
        driver.element().click(Nike_CheckBox);
        return this;
    }
    @Step("✅clicking adidas check box")
    public ProductsPageUser clickAdidasCheckBox() {
        driver.element().click(Adidas_CheckBox);
        return this;
    }
    @Step("✅click puma check box")
    public ProductsPageUser clickPumaCheckBox() {
        driver.element().click(Puma_CheckBox);
        return this;
    }
    @Step("✅click levis check box")
    public ProductsPageUser clickLevisCheckBox()
    {
        driver.element().click(Levis_CheckBox);
        return this;
    }
    @Step("✅click zara check box")
    public ProductsPageUser clickZaraCheckBox() {
        driver.element().click(Zara_CheckBox);
        return this;
    }
    @Step("✅click HM check box")
    public ProductsPageUser clickHMCheckBox() {
        driver.element().click(HM_CheckBox);
        return this;
    }

    //Navigation Bar interaction
    @Step("⬆️click home tab")
    public HomePage clickNavBarHome() {
        driver.element().click(Home_Label_Button);
        return new HomePage(driver);
    }
    @Step("⬆️click Products tab")
    public ProductsPageUser clickNavBarProducts() {
        driver.element().click(Products_Label_Button);
        return this;
    }
    @Step("⬆️click men tab")
    public ProductsPageUser clickNavBarMen() {
        driver.element().click(Men_Label_Button);
        return this;
    }
    @Step("⬆️click women tab")
    public ProductsPageUser clickNavBarWomen() {
        driver.element().click(Women_Label_Button);
        return this;
    }
    @Step("⬆️click kids tab")
    public ProductsPageUser clickNavBarKids() {
        driver.element().click(Kids_Label_Button);
        return this;
    }
    @Step("⬆️click foot wear tab")
    public ProductsPageUser clickNavBarFootWear() {
        driver.element().click(Footwear_Label_Button);
        return this;
    }
    @Step("⬆️click accessories tab")
    public ProductsPageUser clickNavBarAccessories() {
        driver.element().click(Accessories_Label_Button);
        return this;
    }
    @Step("⬆️click search tab")
    public SearchPageUser clickNavBarSearch()
    {
        driver.element().click(Accessories_Label_Button);
        return new SearchPageUser(driver);
    }

    //Sort By DropDown Action
    @Step("⬆️`Clicking Sort By button and ✅`Selecting Price Low to High.")
    public ProductsPageUser sortByPriceLowToHigh() {
        Waits.waitForElementVisible(driver.get(),SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(PriceLowToHigh);
        return this;
    }
    @Step("⬆️Clicking Sort By button and ✅`Selecting Price High to Low. ")
    public ProductsPageUser sortByPriceHighToLow() {
        Waits.waitForElementVisible(driver.get(),SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(PriceHighToLow);
        return this;
    }
    @Step("⬆️`Clicking Sort By button and ✅`Selecting Title A to Z.")
    public ProductsPageUser sortByTitleA_To_Z() {
        Waits.waitForElementVisible(driver.get(),SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(TitleA_To_Z);
        return this;
    }
    @Step("⬆️`Clicking Sort By button and ✅Selecting Title Z to A.")
    public ProductsPageUser sortByTitleZ_To_A() {
        Waits.waitForElementVisible(driver.get(),SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(SortByButton);
        driver.element().click(TitleZ_To_A);
        return this;
    }

    //Assertions
    @Step("✅check the url of the page")
    public ProductsPageUser checkProductsPageUrl()
    {
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()),url);
        return this;
    }
    //Titles
    @Step("✅check that all products title is displayed")
    public ProductsPageUser checkThatTheAllProductsTitleIsDisplayed() {
        driver.assertion().assertElementTextEquals(AllProductsTitle,AllProductsTitleText,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check that filters title is displayed")
    public ProductsPageUser checkThatTheFiltersTitleIsDisplayed() {
        driver.assertion().assertElementTextEquals(FiltersTitle,FiltersTitleText,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check that category title is displayed")
    public ProductsPageUser checkThatTheCategoryTitleIsDisplayed() {
        driver.assertion().assertElementTextEquals(CategoryTitle,CategoryTitleText,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check that brand title is displayed")
    public ProductsPageUser checkThatTheBrandTitleIsDisplayed() {
        driver.assertion().assertElementTextEquals(BrandTitle,BrandTitleText,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check that products count title is displayed")
    public ProductsPageUser checkThatProductsCountMutedTextIsVisible() {
        driver.assertion().assertElementTextContains(ProductsNumberText,"Products","The text of the element does not match the expected value");
        return this;
    }
    //Category Check Boxes Assertions
    @Step("✅check that Men check box is checked")
    public ProductsPageUser checkThatTheMenCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Men_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that Women check box is checked")
    public ProductsPageUser checkThatTheWomenCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Women_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that kids check box is checked")
    public ProductsPageUser checkThatTheKidsCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Kids_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that accessories check box is checked")
    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Accessories_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that foot wear check box is checked")
    public ProductsPageUser checkThatFootWearCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Footwear_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("❎check that Men check box is not checked")
    public ProductsPageUser checkThatTheMenCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Men_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that Women check box is not checked")
    public ProductsPageUser checkThatTheWomenCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Women_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that kids check box is not checked")
    public ProductsPageUser checkThatTheKidsCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Kids_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that accessories check box is not checked")
    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Accessories_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that foot wear check box is not checked")
    public ProductsPageUser checkThatFootWearCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Footwear_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }

    //Brand Check Boxes Assertions
    @Step("✅check that nike check box is checked")
    public ProductsPageUser checkThatNikeCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Nike_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that adidas check box is checked")
    public ProductsPageUser checkThatAdidasCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Adidas_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that puma check box is checked")
    public ProductsPageUser checkThatPumaCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Puma_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that levis check box is checked")
    public ProductsPageUser checkThatLevisCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Levis_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that zara check box is checked")
    public ProductsPageUser checkThatZaraCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(Zara_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("✅check that HM check box is checked")
    public ProductsPageUser checkThatHMCheckBoxIsChecked() {
        driver.assertion().assertElementAttributeEquals(HM_CheckBox,"data-state","checked","The attribute value does not match");
        return this;
    }
    @Step("❎check that nike check box is not checked")
    public ProductsPageUser checkThatNikeCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Nike_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that adidas check box is not checked")
    public ProductsPageUser checkThatAdidasCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Adidas_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that puma check box is not checked")
    public ProductsPageUser checkThatPumaCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Puma_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that levis check box is not checked")
    public ProductsPageUser checkThatLevisCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Levis_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that zara check box is not checked")
    public ProductsPageUser checkThatZaraCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(Zara_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    @Step("❎check that HM check box is not checked")
    public ProductsPageUser checkThatHMCheckBoxIsNotChecked() {
        driver.assertion().assertElementAttributeEquals(HM_CheckBox,"data-state","unchecked","The attribute value does not match");
        return this;
    }
    //nav bar tabs assertions
    @Step("✅check home tab in nav is visible")
    public HomePage checkThatHomeTabIsVisible() {
        driver.assertion().assertElementTextEquals(Home_Label_Button,Home_Button_Text,"The text of the element does not match the expected value");
        return new HomePage(driver);
    }
    @Step("✅check products tab in nav is visible")
    public ProductsPageUser checkThatProductsTabIsVisible() {
        driver.assertion().assertElementTextEquals(Products_Label_Button,Products_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check men tab in nav is visible")
    public ProductsPageUser checkThatMenTabIsVisible() {
        driver.assertion().assertElementTextEquals(Men_Label_Button,Men_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check women tab in nav is visible")
    public ProductsPageUser checkThatWomenTabIsVisible() {
        driver.assertion().assertElementTextEquals(Women_Label_Button,Women_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check kids tab in nav is visible")
    public ProductsPageUser checkThatKidsTabIsVisible() {
        driver.assertion().assertElementTextEquals(Kids_Label_Button,Kids_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check foot wear tab in nav is visible")
    public ProductsPageUser checkThatFootwearTabIsVisible() {
        driver.assertion().assertElementTextEquals(Footwear_Label_Button,Footwear_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check accessories tab in nav is visible")
    public ProductsPageUser checkThatAccessoriesTabIsVisible() {
        driver.assertion().assertElementTextEquals(Accessories_Label_Button,Accessories_Button_Text,"The text of the element does not match the expected value");
        return this;
    }
    @Step("✅check search tab in nav is visible")
    public ProductsPageUser checkThatSearchTabIsVisible()
    {
        driver.assertion().assertElementTextEquals(Search_Label_Button,Search_Button_Text,"The text of the element does not match the expected value");
        return this;
    }

}
