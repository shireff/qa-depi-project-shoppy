package com.shoppy.com.pages;

import DriverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPageUser {
    private final Driver driver;
    public final String url = "https://shoppy-ochre.vercel.app/shop/listing";
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
    private final By Search_Label_Button = By.xpath("//div/nav/label[8]");

    //Muted Text Products Number
    private final By ProductsNumberText = By.xpath("//span [@class=\"text-muted-foreground\"]");
    //Text Variables
    String AllProductsTitleText = "All Products";
    By AllProductsTitle = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/div[2]/div[1]/h2");
    String FiltersTitleText = "Filters";
    By FiltersTitle = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/div[1]/div[1]/h2");
    String CategoryTitleText = "Category";
    By CategoryTitle = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/div[1]/div[2]/div[1]/h3");
    String BrandTitleText = "Brand";
    By BrandTitle = By.xpath("//*[@id=\"root\"]/div[1]/div/main/div/div[1]/div[2]/div[3]/h3");
    String Home_Button_Text = "Home";
    String Products_Button_Text = "Products";
    String Men_Button_Text = "Men";
    String Women_Button_Text = "Women";
    String Kids_Button_Text = "Kids";
    String Footwear_Button_Text = "Footwear";
    String Accessories_Button_Text = "Accessories";
    String Search_Button_Text = "Search";


    //Constructor
    public ProductsPageUser(Driver driver) {
        this.driver = driver;
    }

    //Actions
    public ProductsPageUser driverNavigate() {
        //   Thread.sleep(100);
        System.out.println("⬆️navigating to the products page");
        driver.element().click(Products_Label_Button);
        return this;
    }

    //Category Check Boxes Actions
    public ProductsPageUser clickMenCheckBox() {
        System.out.println("✅clicking on Men CheckBox");
        driver.element().click(Men_CheckBox);
        return this;
    }

    public ProductsPageUser clickWomenCheckBox() {
        System.out.println("✅clicking women check box");
        driver.element().click(Women_CheckBox);
        return this;
    }

    public ProductsPageUser clickKidsCheckBox() {
        System.out.println("✅clicking kids check box");
        driver.element().click(Kids_CheckBox);
        return this;
    }

    public ProductsPageUser clickAccessoriesCheckBox() {
        System.out.println("✅clicking Accessors check box");
        driver.element().click(Accessories_CheckBox);
        return this;
    }

    public ProductsPageUser clickFootWearCheckBox() {
        System.out.println("✅clicking foot wear check box");
        driver.element().click(Footwear_CheckBox);
        return this;
    }

    //Brand Check Boxes Actions
    public ProductsPageUser clickNickCheckBox() {
        System.out.println("✅clicking nick check box");
        driver.element().click(Nike_CheckBox);
        return this;
    }

    public ProductsPageUser clickAdidasCheckBox() {
        System.out.println("✅clicking adidas check box");
        driver.element().click(Adidas_CheckBox);
        return this;
    }

    public ProductsPageUser clickPumaCheckBox() {
        System.out.println("✅click puma check box");
        driver.element().click(Puma_CheckBox);
        return this;
    }

    public ProductsPageUser clickLevisCheckBox() {
        System.out.println("✅click levis check box");
        driver.element().click(Levis_CheckBox);
        return this;
    }

    public ProductsPageUser clickZaraCheckBox() {
        System.out.println("✅click zara check box");
        driver.element().click(Zara_CheckBox);
        return this;
    }

    public ProductsPageUser clickHMCheckBox() {
        System.out.println("✅click HM check box");
        driver.element().click(HM_CheckBox);
        return this;
    }

    //Navigation Bar interaction
    public HomePage clickNavBarHome() {
        System.out.println("⬆️click home tab");
        driver.element().click(Home_Label_Button);
        return new HomePage(driver);
    }

    public ProductsPageUser clickNavBarProducts() {
        System.out.println("⬆️click Products tab");
        driver.element().click(Products_Label_Button);
        return this;
    }

    public ProductsPageUser clickNavBarMen() {
        System.out.println("⬆️click men tab");
        driver.element().click(Men_Label_Button);
        return this;
    }

    public ProductsPageUser clickNavBarWomen() {
        System.out.println("⬆️click women tab");
        driver.element().click(Women_Label_Button);
        return this;
    }

    public ProductsPageUser clickNavBarKids() {
        System.out.println("⬆️click kids tab");
        driver.element().click(Kids_Label_Button);
        return this;
    }

    public ProductsPageUser clickNavBarFootWear() {
        System.out.println("⬆️click foot wear tab");
        driver.element().click(Footwear_Label_Button);
        return this;
    }

    public ProductsPageUser clickNavBarAccessories() {
        System.out.println("⬆️click accessories tab");
        driver.element().click(Accessories_Label_Button);
        return this;
    }
//    public void clickNavBarSearch()
//    {
//        System.out.println("⬆️click search tab");
//        driver.element().click(driver.get(),Accessories_Label_Button);
//    }

    //Sort By DropDown Action
    public ProductsPageUser sortByPriceLowToHigh() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Price Low to High.");
        driver.element().click(PriceLowToHigh);
        return this;
    }

    public ProductsPageUser sortByPriceHighToLow() {
        System.out.println("⬆️Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Price High to Low.");
        driver.element().click(PriceHighToLow);
        return this;
    }

    public ProductsPageUser sortByTitleA_To_Z() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅`Selecting Title A to Z.");
        driver.element().click(TitleA_To_Z);
        return this;
    }

    public ProductsPageUser sortByTitleZ_To_A() {
        System.out.println("⬆️`Clicking Sort By button.");
        driver.element().click(SortByButton);
        System.out.println("✅Selecting Title Z to A.");
        driver.element().click(TitleZ_To_A);
        return this;
    }

    //Assertions
    //Titles
    public ProductsPageUser checkThatTheAllProductsTitleIsDisplayed() {
        System.out.println("✅check that all products title is displayed");
        String actualTitle = driver.element().getTextOf(AllProductsTitle);
        Assert.assertEquals(actualTitle, AllProductsTitleText);
        return this;
    }

    public ProductsPageUser checkThatTheFiltersTitleIsDisplayed() {
        System.out.println("✅check that filters title is displayed");
        String actualTitle = driver.element().getTextOf(FiltersTitle);
        Assert.assertEquals(actualTitle, FiltersTitleText);
        return this;
    }

    public ProductsPageUser checkThatTheCategoryTitleIsDisplayed() {
        System.out.println("✅check that category title is displayed");
        String actualTitle = driver.element().getTextOf(CategoryTitle);
        Assert.assertEquals(actualTitle, CategoryTitleText);
        return this;
    }

    public ProductsPageUser checkThatTheBrandTitleIsDisplayed() {
        System.out.println("✅check that brand title is displayed");
        String actualTitle = driver.element().getTextOf(BrandTitle);
        Assert.assertEquals(actualTitle, BrandTitleText);
        return this;
    }

    public ProductsPageUser checkThatProductsCountMutedTextIsVisible() {
        System.out.println("✅check that products count title is displayed");
        String mutedProductsCount = driver.element().getTextOf(ProductsNumberText);
        Assert.assertTrue(mutedProductsCount.contains("Products"));
        return this;
    }

    //Category Check Boxes Assertions
    public ProductsPageUser checkThatTheMenCheckBoxIsChecked() {
        System.out.println("✅check that Men check box is checked");
        String state = driver.element().getElementAttribute(Men_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatTheWomenCheckBoxIsChecked() {
        System.out.println("✅check that Women check box is checked");
        String state = driver.element().getElementAttribute(Women_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatTheKidsCheckBoxIsChecked() {
        System.out.println("✅check that kids check box is checked");
        String state = driver.element().getElementAttribute(Kids_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsChecked() {
        System.out.println("✅check that accessories check box is checked");
        String state = driver.element().getElementAttribute(Accessories_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatFootWearCheckBoxIsChecked() {
        System.out.println("✅check that foot wear check box is checked");
        String state = driver.element().getElementAttribute(Footwear_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatTheMenCheckBoxIsNotChecked() {
        System.out.println("❎check that Men check box is not checked");
        String state = driver.element().getElementAttribute(Men_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatTheWomenCheckBoxIsNotChecked() {
        System.out.println("❎check that Women check box is not checked");
        String state = driver.element().getElementAttribute(Women_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatTheKidsCheckBoxIsNotChecked() {
        System.out.println("❎check that kids check box is not checked");
        String state = driver.element().getElementAttribute(Kids_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatTheAccessoriesCheckBoxIsNotChecked() {
        System.out.println("❎check that accessories check box is not checked");
        String state = driver.element().getElementAttribute(Accessories_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatFootWearCheckBoxIsNotChecked() {
        System.out.println("❎check that foot wear check box is not checked");
        String state = driver.element().getElementAttribute(Footwear_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    //Brand Check Boxes Assertions
    public ProductsPageUser checkThatNikeCheckBoxIsChecked() {
        System.out.println("✅check that nike check box is checked");
        String state = driver.element().getElementAttribute(Nike_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatAdidasCheckBoxIsChecked() {
        System.out.println("✅check that adidas check box is checked");
        String state = driver.element().getElementAttribute(Adidas_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatPumaCheckBoxIsChecked() {
        System.out.println("✅check that puma check box is checked");
        String state = driver.element().getElementAttribute(Puma_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatLevisCheckBoxIsChecked() {
        System.out.println("✅check that levis check box is checked");
        String state = driver.element().getElementAttribute(Levis_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatZaraCheckBoxIsChecked() {
        System.out.println("✅check that zara check box is checked");
        String state = driver.element().getElementAttribute(Zara_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatHMCheckBoxIsChecked() {
        System.out.println("✅check that HM check box is checked");
        String state = driver.element().getElementAttribute(HM_CheckBox, "data-state");
        Assert.assertEquals(state, "checked");
        return this;
    }

    public ProductsPageUser checkThatNikeCheckBoxIsNotChecked() {
        System.out.println("❎check that nike check box is not checked");
        String state = driver.element().getElementAttribute(Nike_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatAdidasCheckBoxIsNotChecked() {
        System.out.println("❎check that adidas check box is not checked");
        String state = driver.element().getElementAttribute(Adidas_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatPumaCheckBoxIsNotChecked() {
        System.out.println("❎check that puma check box is not checked");
        String state = driver.element().getElementAttribute(Puma_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatLevisCheckBoxIsNotChecked() {
        System.out.println("❎check that levis check box is not checked");
        String state = driver.element().getElementAttribute(Levis_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatZaraCheckBoxIsNotChecked() {
        System.out.println("❎check that zara check box is not checked");
        String state = driver.element().getElementAttribute(Zara_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    public ProductsPageUser checkThatHMCheckBoxIsNotChecked() {
        System.out.println("❎check that HM check box is not checked");
        String state = driver.element().getElementAttribute(HM_CheckBox, "data-state");
        Assert.assertEquals(state, "unchecked");
        return this;
    }

    //nav bar tabs assertions
    public HomePage checkThatHomeTabIsVisible() {
        System.out.println("✅check home tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Home_Label_Button);
        Assert.assertEquals(actualTitle, Home_Button_Text);
        return new HomePage(driver);
    }

    public ProductsPageUser checkThatProductsTabIsVisible() {
        System.out.println("✅check products tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Products_Label_Button);
        Assert.assertEquals(actualTitle, Products_Button_Text);
        return this;
    }

    public ProductsPageUser checkThatMenTabIsVisible() {
        System.out.println("✅check men tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Men_Label_Button);
        Assert.assertEquals(actualTitle, Men_Button_Text);
        return this;
    }

    public ProductsPageUser checkThatWomenTabIsVisible() {
        System.out.println("✅check women tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Women_Label_Button);
        Assert.assertEquals(actualTitle, Women_Button_Text);
        return this;
    }

    public ProductsPageUser checkThatKidsTabIsVisible() {
        System.out.println("✅check kids tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Kids_Label_Button);
        Assert.assertEquals(actualTitle, Kids_Button_Text);
        return this;
    }

    public ProductsPageUser checkThatFootwearTabIsVisible() {
        System.out.println("✅check foot wear tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Footwear_Label_Button);
        Assert.assertEquals(actualTitle, Footwear_Button_Text);
        return this;
    }

    public ProductsPageUser checkThatAccessoriesTabIsVisible() {
        System.out.println("✅check accessories tab in nav is visible");
        String actualTitle = driver.element().getTextOf(Accessories_Label_Button);
        Assert.assertEquals(actualTitle, Accessories_Button_Text);
        return this;
    }
//    public void checkThatSearchTabIsVisible()
//    {
//        System.out.println("✅check search tab in nav is visible");
//        String actualTitle = driver.element().getTextOf(Search_Label_Button);
//        Assert.assertEquals(actualTitle,Search_Button_Text);
//    }

}
