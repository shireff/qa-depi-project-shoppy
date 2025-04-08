package com.shoppy.com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenshotManager {

    static String screenshotDirectory = "./screenshots";

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        Path screenshotDirPath = Paths.get(screenshotDirectory);
        Path screenshotPath = screenshotDirPath.resolve(screenshotName + ".png");

        byte[] byteArray = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            // Ensure the screenshots directory exists
            Files.createDirectories(screenshotDirPath);

            Files.write(screenshotPath, byteArray, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }


}
