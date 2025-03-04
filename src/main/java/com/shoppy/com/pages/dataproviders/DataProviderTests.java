package com.shoppy.com.pages.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderTests {


    @DataProvider(name = "categoryData")
    public static Object[][] provideCategoryData() {
        return new Object[][]{
                {"Men", true},       // Expected to have products
                {"Women", false},    // Expected to have no products
                {"Kids", false},
                {"Accessories", false},
                {"Footwear", false}
        };
    }

    @DataProvider(name = "brandData")
    public static Object[][] provideBrandData() {
        return new Object[][]{
                {"Nike", true},      // Expected to have products
                {"Zara", false},     // Expected to have no products
                {"H&M", true}
        };
    }
}
