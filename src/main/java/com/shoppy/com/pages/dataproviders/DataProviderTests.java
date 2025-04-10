package com.shoppy.com.pages.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderTests {


    @DataProvider(name = "categoryData")
    public static Object[][] provideCategoryData() {
        return new Object[][]{
                {"Men", true},
                {"Women", true},
                {"Kids", false},
                {"Accessories", true},
                {"Footwear", true}
        };
    }

    @DataProvider(name = "brandData")
    public static Object[][] provideBrandData() {
        return new Object[][]{
                {"Nike", true},
                {"Zara", false},
                {"H&M", true}
        };
    }
}
