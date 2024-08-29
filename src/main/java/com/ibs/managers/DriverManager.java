package com.ibs.managers;

import com.ibs.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.ibs.utils.constants.PropConst.*;

public class DriverManager {
    private WebDriver webDriver;
    private static DriverManager driverManager = null;
    private static final PropManager propManager = PropManager.getPropManager();

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
            String browser = propManager.getProperty(BROWSER);
            switch (browser) {
                case "chrome":
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unknown driver");
            }
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
