package com.shoppy.com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {
    private static Logger getLogger() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LoggerFactory.getLogger(className);
    }

    public static boolean isConsole() {
        return System.console() != null;
    }

    public static String removeColorCodes(String message) {
        return message.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    public static void logInfo(String message) {
        Logger logger = getLogger();
        if (isConsole()) {
            logger.info(message);
        } else {
            logger.info(removeColorCodes(message));
        }
    }

    public static void logWarn(String message) {
        Logger logger = getLogger();
        if (isConsole()) {
            logger.warn(message);
        } else {
            logger.warn(removeColorCodes(message));
        }
    }

    public static void logError(String message) {
        Logger logger = getLogger();
        if (isConsole()) {
            logger.error(message);
        } else {
            logger.error(removeColorCodes(message));
        }
    }
}
