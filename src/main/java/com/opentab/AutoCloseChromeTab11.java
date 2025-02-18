package com.opentab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class AutoCloseChromeTab11 {
    public static void main(String[] args) {
        // Path to ChromeDriver (make sure to download the appropriate driver for your system)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");

        // Initialize WebDriver (this opens Chrome)
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open URLs in new tabs
            driver.get("https://dcallcenter.noblesoft");
            Thread.sleep(2000); // Allow time for the page to load
            ((ChromeDriver) driver).executeScript("window.open('https://freepbx-pri.noblesoft:8089/ws', '_blank');");
            ((ChromeDriver) driver).executeScript("window.open('https://freepbx-sec.noblesoft:8089/ws', '_blank');");

            // Switch to all open windows/tabs
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());

            // Loop through all open tabs and close the ones that match a specific URL
            for (String tab : tabs) {
                driver.switchTo().window(tab);
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.contains("freepbx-pri")) {
                    driver.close();  // Close tab with matching URL
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Quit the driver and close all tabs
        }
    }
}