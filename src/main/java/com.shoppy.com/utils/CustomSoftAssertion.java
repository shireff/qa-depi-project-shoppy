package com.shoppy.com.utils;


import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    /**
     * Soft assertion for condition being true
     */
    public CustomSoftAssertion softAssertionTrue(boolean condition, String MSG) {
        try {
            assertTrue(condition, MSG);
            LogHelper.logInfo(GREEN + BOLD + "✅ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(RED + BOLD + "❌ [FAIL] " + MSG + RESET);
        }
        return this;
    }

    /**
     * Soft assertion for condition being false
     */
    public CustomSoftAssertion softAssertionFalse(boolean condition, String MSG) {
        try {
            assertFalse(condition, MSG);
            LogHelper.logInfo(GREEN + BOLD + "✅ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(RED + BOLD + "❌ [FAIL] " + MSG + RESET);
        }
        return this;
    }

    /**
     * Soft assertion for equality of two values
     */
    public <T> CustomSoftAssertion softAssertionEquals(T actual, T expected, String MSG) {
        try {
            assertEquals(actual, expected, MSG);
            LogHelper.logInfo(GREEN + BOLD + "✅ [PASS] " + MSG + RESET);
        } catch (AssertionError e) {
            LogHelper.logError(RED + BOLD + "❌ [FAIL] " + MSG + RESET);
        }
        return this;
    }

    /**
     * Executes all assertions and logs the result
     */
    public void assertAllAssertions() {
        LogHelper.logInfo(CYAN + "🔍 Running all assertions..." + RESET);
        assertAll();
        LogHelper.logError(CYAN + "✅ All assertions completed." + RESET);
    }
}
