package com.shoppy.com.utils;

import org.slf4j.Logger;

public class LogHelper {

    /**
     * Checks if the current environment is a console (terminal) or not.
     *
     * @return true if the environment is a console, false otherwise
     */
    public static boolean isConsole() {
        return System.console() != null;
    }

    /**
     * Removes ANSI color codes from a log message (used for file logging).
     *
     * @param message the message to remove color codes from
     * @return the message without color codes
     */
    public static String removeColorCodes(String message) {
        return message.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    /**
     * Logs the message conditionally based on whether it's a console or file log.
     * Adds color codes if logging to console, removes color codes for file logging.
     *
     * @param logger the logger instance to log the message
     * @param message the message to be logged
     */
    public static void logInfo(Logger logger, String message) {
        if (isConsole()) {
            logger.info(message); // Log with color codes in console
        } else {
            logger.info(removeColorCodes(message)); // Remove color codes for file logging
        }
    }

    public static void logWarn(Logger logger, String message) {
        if (isConsole()) {
            logger.warn(message);
        } else {
            logger.warn(removeColorCodes(message));
        }
    }

    public static void logError(Logger logger, String message) {
        if (isConsole()) {
            logger.error(message);
        } else {
            logger.error(removeColorCodes(message));
        }
    }
}
