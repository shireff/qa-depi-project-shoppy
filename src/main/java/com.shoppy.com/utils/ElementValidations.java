package com.shoppy.com.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ElementValidations {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ElementValidations.class);
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";


    public ElementValidations validateTrue(boolean condition, String MSG) {
        try {
            Assert.assertTrue(condition, MSG);
            LogHelper.logInfo(logger,GREEN + BOLD + "✔ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(logger,RED + BOLD + "✘ [FAIL] " + MSG + RESET);
            throw e;
        }
        return this;
    }

    public ElementValidations validateFalse(boolean condition, String MSG) {
        try {
            Assert.assertFalse(condition, MSG);
            LogHelper.logInfo(logger,GREEN + BOLD + "✔ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(logger,RED + BOLD + "✘ [FAIL] " + MSG + RESET);
            throw e;
        }
        return this;
    }

    public <T> ElementValidations validateEquals(T actual, T expected, String MSG) {
        try {
            Assert.assertEquals(actual, expected, MSG);
            LogHelper.logInfo(logger,GREEN + BOLD + "✔ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(logger,RED + BOLD + "✘ [FAIL] " + MSG + RESET);
            throw e;
        }
        return this;
    }

    public ElementValidations validateFail(String MSG) {
        try {
            Assert.fail(MSG);
        } catch (AssertionError e) {
            LogHelper.logError(logger,RED + BOLD + "✘ [FAIL] " + MSG + RESET);
            throw e;
        }
        return this;
    }

}
