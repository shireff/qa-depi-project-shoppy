package com.shoppy.com.pages;

import DriverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPageUser {
    private final Driver driver;
    private final String url = "https://shoppy-ochre.vercel.app/shop/listing";
    //Sort By
    private final By SortByButton = By.xpath("//button [@aria-haspopup=\"dialog\"]");
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
        System.out.println("⬆️navigating to the products page");
        driver.element().click(Products_Label_Button);
        return this;
    }

    //Category Check Boxes Actions
    @Step("✅clicking on Men CheckBox")
    public ProductsPageUser clickMenCheckBox() {
        System.out.println("✅clicking on Men CheckBox");
        driver.element().click(Men_CheckBox);
        return this;
    }
    @Step("✅clicking women check box")
    public ProductsPageUser clickWomenCheckBox() {
        System.out.println("✅clicking women check box");
        driver.element().click(Women_CheckBox);
        return this;
    }
    @Step("✅clicking kids check box")
    public ProductsPageUser clickKidsCheckBox() {
        System.out.println("✅clicking kids check box");
        driver.element().click(Kids_CheckBox);
        return this;
    }
    @Step("✅clicking Accessors check box")
    public ProductsPageUser clickAccessoriesCheckBox() {
        System.out.println("✅clicking Accessors check box");
        driver.element().click(Accessories_CheckBox);
        return this;
    }
    @Step("✅clicking foot wear check box")
    public ProductsPageUser clickFootWearCheckBox() {
        System.out.println("✅clicking foot wear check box");
        driver.element().click(Footwear_CheckBox);
        return this;
    }

    //Brand Check Boxes Actions
    @Step("✅clicking nick check box")
    public ProductsPageUser clickNickCheckBox() {
        System.out.println("✅clicking nick check box");
        driver.element().click(Nike_CheckBox);
        return this;
    }
    @Step("✅clicking adidas check box")
    public ProductsPageUser clickAdidasCheckBox() {
        System.out.println("✅clicking adidas check box");
        driver.element().click(Adidas_CheckBox);
        return this;
    }
    @Step("✅click puma check box")
    public ProductsPageUser clickPumaCheckBox() {
        System.out.println("✅click puma check box");
        driver.element().click(Puma_CheckBox);
        return this;
    }
    @Step("✅click levis check box")
    public ProductsPageUser clickLevisCheckBox() {
        System.out.println("✅click levis check box");
        driver.element().click(Levis_CheckBox);
        return this;
    }
    @Step("✅click zara check box")
    public ProductsPageUser clickZaraCheckBox() {
        System.out.println("✅click zara check box");
        driver.element().click(Zara_CheckBox);
        return this;
    }
    @Step("✅click HM check box")
    public ProductsPageUser clickHMCheckBox() {
        System.out.println("✅click HM check box");
        driver.element().click(HM_CheckBox);
        return this;
    }

    //Navigation Bar interaction
    @Step("⬆️click home tab")
    public HomePage clickNavBarHome() {
        System.out.println("⬆️click home tab");
        driver.element().click(Home_Label_Button);
        return new HomePage(driver);
    }
    @Step("⬆️click Products tab")
    public ProductsPageUser clickNavBarProducts() {
        System.out.println("⬆️click Products tab");
        driver.element().click(Products_Label_Button);
        return this;
    }
    @Step("⬆️click men tab")
    public ProductsPageUser clickNavBarMen() {
        System.out.println("⬆️click men tab");
        driver.element().click(Men_Label_Button);
        return this;
    }
    @Step("⬆️click women tab")
    public ProductsPageUser clickNavBarWomen() {
        System.out.println("⬆️click women tab");
        driver.element().click(Women_Label_Button);
        return this;
    }
    @Step("⬆️click kids tab")
    public ProductsPageUser clickNavBarKids() {
        System.out.println("⬆️click kids tab");
        driver.element().click(Kids_Label_Button);
        return this;
    }
    @Step("⬆️click foot wear tab")
    public ProductsPageUser clickNavBarFootWear() {
        System.out.println("⬆️click foot wear tab");
        driver.element().click(Footwear_Label_Button);
        return this;
    }
    @Step("⬆️click accessories tab")
    public ProductsPageUser clickNavBarAccessories() {
        System.out.println("⬆️click accessories tab");
        driver.element().click(Accessories_Label_Button);
        return this;
    }
    @Step("⬆️click search tab")
    public SearchPageUser clickNavBarSearch()
    {
        System.out.println("⬆️click search tab");
        driver.element().click(Accessories_Label_Button);
        return new SearchPageUser(driver);
    }

    //Sort By DropDown Action
    @Step("⬆️`Clicking Sort By button and ✅`Selecting Price Low to High.")
    public ProductsPageUser sortByPriceLowToHigh() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Price Low to High.");
        driver.element().click(PriceLowToHigh);
        return this;
    }
    @Step("⬆️Clicking Sort By button and ✅`Selecting Price High to Low. ")
    public ProductsPageUser sortByPriceHighToLow() {
        System.out.println("⬆️Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Price High to Low.");
        driver.element().click(PriceHighToLow);
        return this;
    }
    @Step("⬆️`Clicking Sort By button and ✅`Selecting Title A to Z.")
    public ProductsPageUser sortByTitleA_To_Z() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Title A to Z.");
        driver.element().click(TitleA_To_Z);
        return this;
    }
    @Step("⬆️`Clicking Sort By button and ✅Selecting Title Z to A.")
    public ProductsPageUser sortByTitleZ_To_A() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅Selecting Title Z to A.");
        driver.element().click(TitleZ_To_A);
        return this;
    }

    //Assertions
    @Step("✅check the url of the page")
    public ProductsPageUser checkProductsPageUrl()
    {
        System.out.println("✅check the url of the page");
        Assert.assertEquals(driver.browser().getCurrentURL(driver.get()),url);
        return this;
    }
    //Titles
    @Step("✅check that all products title is displayed")
    public ProductsPageUser checkThatTheAllProductsTitleIsDisplayed() {
        System.out.println("✅check that all products title is displayed");
        String actualTitle = driver.element().getTextOf(AllProductsTitle);
        Assert.assertEquals(actualTitle, AllProductsTitleText);
        return this;
    }
    @Step("✅check that filters title is displayed")
    public ProductsPageUser checkThatTheFiltersTitleIsDisplayed() {
        System.out.println("✅check that filters title is displayed");
        String actualTitle = driver.element().getTextOf(FiltersTitle);
        Assert.assertEquals(actualTitle, FiltersTitleText);
        return this;
    }
    @Step("✅check that category title is displayed")
    public ProductsPageUser checkThatTheCategoryTitleIsDisplayed() {
        System.out.println("✅check that category title is displayed");
        String actualTitle = driver.element().getTextOf(CategoryTitle);
        Assert.assertEquals(actualTitle, CategoryTitleText);
        return this;
    }
    @Step("✅check that brand title is displayed")
    public ProductsPageUser checkThatTheBrandTitleIsDisplayed() {
        System.out.println("✅check that brand title is displayed");
        String actualTitle = driver.element().getTextOf(BrandTitle);
        Assert.assertEquals(actualTitle, BrandTitleText);
        return this;
    }
    @Step("✅check that products count title is displayed")
    public ProductsPageUser checkThatProductsCountMutedTextIsVisible() {
        System.out.println("✅check that products count title is displayed");
        String mutedProductsCount = driver.element().getTextOf(ProductsNumberText);
        Assert.assertTrue(mutedProductsCount.contains("Products"));
        return this;
    }
    //Category Check Boxes Assertions
    @Step("✅check that Men check box is checked")
    public ProductsPageUser checkThatTheMenCheckBoxIsChecked() {
        System.out.println("✅check that Men check box is checked");
        String state = driver.element().getElementAttribute(Men_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that Women check box is checked")
    public ProductsPageUser checkThatTheWomenCheckBoxIsChecked() {
        System.out.println("✅check that Women check box is checked");
        String state = driver.element().getElementAttribute(Women_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that kids check box is checked")
    public ProductsPageUser checkThatTheKidsCheckBoxIsChecked() {
        System.out.println("✅check that kids check box is checked");
        String state = driver.element().getElementAttribute(Kids_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that accessories check box is checked")
    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsChecked() {
        System.out.println("✅check that accessories check box is checked");
        String state = driver.element().getElementAttribute(Accessories_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that foot wear check box is checked")
    public ProductsPageUser checkThatFootWearCheckBoxIsChecked() {
        System.out.println("✅check that foot wear check box is checked");
        String state = driver.element().getElementAttribute(Footwear_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("❎check that Men check box is not checked")
    public ProductsPageUser checkThatTheMenCheckBoxIsNotChecked() {
        System.out.println("❎check that Men check box is not checked");
        String state = driver.element().getElementAttribute(Men_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that Women check box is not checked")
    public ProductsPageUser checkThatTheWomenCheckBoxIsNotChecked() {
        System.out.println("❎check that Women check box is not checked");
        String state = driver.element().getElementAttribute(Women_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that kids check box is not checked")
    public ProductsPageUser checkThatTheKidsCheckBoxIsNotChecked() {
        System.out.println("❎check that kids check box is not checked");
        String state = driver.element().getElementAttribute(Kids_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that accessories check box is not checked")
    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsNotChecked() {
        System.out.println("❎check that accessories check box is not checked");
        String state = driver.element().getElementAttribute(Accessories_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that foot wear check box is not checked")
    public ProductsPageUser checkThatFootWearCheckBoxIsNotChecked() {
        System.out.println("❎check that foot wear check box is not checked");
        String state = driver.element().getElementAttribute(Footwear_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    //Brand Check Boxes Assertions
    @Step("✅check that nike check box is checked")
    public ProductsPageUser checkThatNikeCheckBoxIsChecked() {
        System.out.println("✅check that nike check box is checked");
        String state = driver.element().getElementAttribute(Nike_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that adidas check box is checked")
    public ProductsPageUser checkThatAdidasCheckBoxIsChecked() {
        System.out.println("✅check that adidas check box is checked");
        String state = driver.element().getElementAttribute(Adidas_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that puma check box is checked")
    public ProductsPageUser checkThatPumaCheckBoxIsChecked() {
        System.out.println("✅check that puma check box is checked");
        String state = driver.element().getElementAttribute(Puma_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that levis check box is checked")
    public ProductsPageUser checkThatLevisCheckBoxIsChecked() {
        System.out.println("✅check that levis check box is checked");
        String state = driver.element().getElementAttribute(Levis_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that zara check box is checked")
    public ProductsPageUser checkThatZaraCheckBoxIsChecked() {
        System.out.println("✅check that zara check box is checked");
        String state = driver.element().getElementAttribute(Zara_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("✅check that HM check box is checked")
    public ProductsPageUser checkThatHMCheckBoxIsChecked() {
        System.out.println("✅check that HM check box is checked");
        String state = driver.element().getElementAttribute(HM_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }
    @Step("❎check that nike check box is not checked")
    public ProductsPageUser checkThatNikeCheckBoxIsNotChecked() {
        System.out.println("❎check that nike check box is not checked");
        String state = driver.element().getElementAttribute(Nike_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that adidas check box is not checked")
    public ProductsPageUser checkThatAdidasCheckBoxIsNotChecked() {
        System.out.println("❎check that adidas check box is not checked");
        String state = driver.element().getElementAttribute(Adidas_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that puma check box is not checked")
    public ProductsPageUser checkThatPumaCheckBoxIsNotChecked() {
        System.out.println("❎check that puma check box is not checked");
        String state = driver.element().getElementAttribute(Puma_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that levis check box is not checked")
    public ProductsPageUser checkThatLevisCheckBoxIsNotChecked() {
        System.out.println("❎check that levis check box is not checked");
        String state = driver.element().getElementAttribute(Levis_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that zara check box is not checked")
    public ProductsPageUser checkThatZaraCheckBoxIsNotChecked() {
        System.out.println("❎check that zara check box is not checked");
        String state = driver.element().getElementAttribute(Zara_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    @Step("❎check that HM check box is not checked")
    public ProductsPageUser checkThatHMCheckBoxIsNotChecked() {
        System.out.println("❎check that HM check box is not checked");
        String state = driver.element().getElementAttribute(HM_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }
    //nav bar tabs assertions
    @Step("✅check home tab in nav is visible")
    public HomePage checkThatHomeTabIsVisible() {
        System.out.println("✅check home tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Home_Label_Button);
        Assert.assertEquals(actualTitle, Home_Button_Text);
        return new HomePage(driver);
    }
    @Step("✅check products tab in nav is visible")
    public ProductsPageUser checkThatProductsTabIsVisible() {
        System.out.println("✅check products tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Products_Label_Button);
        Assert.assertEquals(actualTitle, Products_Button_Text);
        return this;
    }
    @Step("✅check men tab in nav is visible")
    public ProductsPageUser checkThatMenTabIsVisible() {
        System.out.println("✅check men tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Men_Label_Button);
        Assert.assertEquals(actualTitle, Men_Button_Text);
        return this;
    }
    @Step("✅check women tab in nav is visible")
    public ProductsPageUser checkThatWomenTabIsVisible() {
        System.out.println("✅check women tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Women_Label_Button);
        Assert.assertEquals(actualTitle, Women_Button_Text);
        return this;
    }
    @Step("✅check kids tab in nav is visible")
    public ProductsPageUser checkThatKidsTabIsVisible() {
        System.out.println("✅check kids tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Kids_Label_Button);
        Assert.assertEquals(actualTitle, Kids_Button_Text);
        return this;
    }
    @Step("✅check foot wear tab in nav is visible")
    public ProductsPageUser checkThatFootwearTabIsVisible() {
        System.out.println("✅check foot wear tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Footwear_Label_Button);
        Assert.assertEquals(actualTitle, Footwear_Button_Text);
        return this;
    }
    @Step("✅check accessories tab in nav is visible")
    public ProductsPageUser checkThatAccessoriesTabIsVisible() {
        System.out.println("✅check accessories tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Accessories_Label_Button);
        Assert.assertEquals(actualTitle, Accessories_Button_Text);
        return this;
    }
    @Step("✅check search tab in nav is visible")
    public ProductsPageUser checkThatSearchTabIsVisible()
    {
        System.out.println("✅check search tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Search_Label_Button);
        Assert.assertEquals(actualTitle,Search_Button_Text);
        return this;
    }

}
