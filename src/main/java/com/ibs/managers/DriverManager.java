package com.ibs.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver webDriver;
    private static DriverManager driverManager = null;

    /**
     * Returns the singleton instance of the DriverManager. If it doesn't exist, a new instance is created.
     * @return the singleton instance of DriverManager
     */
    public static DriverManager getDriverManager() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    /**
     * Returns an instance of WebDriver, initializing it on the first call.
     *
     * If the WebDriver has not been initialized yet, a new instance is created
     *
     * @return an instance of {@link WebDriver} for interacting with the browser.
     */
    public WebDriver getWebDriver() {
        if (webDriver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            webDriver = new ChromeDriver(options);
        }
        return webDriver;
    }

    /**
     * Quits the WebDriver instance and sets it to null.
     */
    public void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
