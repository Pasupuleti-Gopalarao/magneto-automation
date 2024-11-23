package com.stb.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Use WebDriverManager to handle the ChromeDriver binary
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless"); // Run Chrome in headless mode
//            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
