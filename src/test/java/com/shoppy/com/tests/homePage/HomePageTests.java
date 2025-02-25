package com.shoppy.com.tests.homePage;

import com.shoppy.com.HomePage;
import com.shoppy.com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests extends BaseTest {

    @Test
    public void testHomePageHeaderIsDisplayed() {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.isHomePageHeaderDisplayed(), "\n Home page header is not displayed \n");
    }

    @Test
    public void testCategorySelectionMen() {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory("Men");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("category=men"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid.grid-cols-1")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rounded-lg.border.bg-card.text-card-foreground.shadow-sm")));
        Assert.assertTrue(homePage.isFeaturedProductDisplayed(), "\n Category filter failed! \n");
    }

    @Test
    public void testCategorySelectionWoman() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory("Women");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("category=women"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Category filter failed! \n");
    }

    @Test
    public void testCategorySelectionKids() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory("Kids");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("category=kids"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Category filter failed! \n");
    }

    @Test
    public void testCategorySelectionAccessories() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory("Accessories");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("category=accessories"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Category filter failed! \n");
    }

    @Test
    public void testCategorySelectionFootwear() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectCategory("Footwear");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("category=footwear"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Category filter failed! \n");
    }



    @Test
    public void testBrandSelectionNike() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectBrand("Nike");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("brand=nike"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isFeaturedProductDisplayed(), "\n Brand filter failed! \n");
    }

//    @Test
//    public void testBrandSelectionAdidas() throws InterruptedException {
//        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
//        homePage.selectBrand("Adidas");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("brand=adidas"));
//        Thread.sleep(1000);
//        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Brand filter failed! \n");
//    }

//    @Test
//    public void testBrandSelectionPuma() throws InterruptedException {
//        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
//        homePage.selectBrand("Puma");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("brand=puma"));
//        Thread.sleep(1000);
//        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Brand filter failed! \n");
//    }

//    @Test
//    public void testBrandSelectionLevi() throws InterruptedException {
//        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
//        homePage.selectBrand("Levi's");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("brand=levi"));
//        Thread.sleep(1000);
//        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Brand filter failed! \n");
//    }

    @Test
    public void testBrandSelectionZara() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectBrand("Zara");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("brand=zara"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isNoProductsMessageDisplayed(), "\n Brand filter failed! \n");
    }

    @Test
    public void testBrandSelectionHM() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        homePage.selectBrand("H&M");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("brand=h%26m"));
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isFeaturedProductDisplayed(), "\n Brand filter failed! \n");
    }



    @Test
    public void testFeatureProductsInteraction() throws InterruptedException {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Thread.sleep(1000);
        Assert.assertTrue(homePage.isFeaturedProductDisplayed(), "\n ❌ Featured products are not displayed! \n");

        Thread.sleep(1000);
        homePage.clickFirstFeaturedProduct();



        Thread.sleep(1000);
        Assert.assertTrue(homePage.isProductModalDisplayed(), "\n ❌ Product modal did not appear after clicking featured product! \n");

        Assert.assertTrue(homePage.isProductTitleVisible(), "\n ❌ Product title is missing in modal! \n");
        Assert.assertTrue(homePage.isProductPriceVisible(), "\n ❌ Product price is missing in modal! \n");

    }

    @Test
    public void testCustomerReviewsVisibility() {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.isCustomerReviewsDisplayed(), "\n Customer reviews section is missing! \n");
    }

    @Test
    public void testFooterLinks() {
        HomePage homePage = loginPage.loginIntoApp("shireffn369+f@gmail.com", "Shireff@123");
        Assert.assertTrue(homePage.areFooterLinksWorking(), "\n Footer links are not working! \n");
    }
}
