package com.ibs.utils;

import com.ibs.managers.DriverManager;
import com.ibs.managers.PropManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.ibs.utils.constants.PropConst.REMOTE_URL;

public class WebDriverUtils {
    private static PropManager propManager = PropManager.getPropManager();

    /**
     * Creates and returns an instance of {@link WebDriverWait} with the specified timeout duration.
     *
     * @param duration the timeout duration in seconds for which the wait should apply.
     * @return a {@link WebDriverWait} instance configured with the specified timeout duration.
     */
    public static WebDriverWait setExplicitlyWait(Long duration) {
        WebDriver driver = DriverManager.getDriverManager().getWebDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    /**
     * Configures the provided WebDriver with specified options.
     * Maximizes the browser window and sets implicit wait and page load timeout durations.
     *
     * @param driver the WebDriver instance to configure
     * @param implicitlyWait the duration (in seconds) for the implicit wait timeout
     * @param pageLoadTimeout the duration (in seconds) for the page load timeout
     */
    public static void setWebDriverOptions(WebDriver driver, Long implicitlyWait, Long pageLoadTimeout) {
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    }

    public static RemoteWebDriver setRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(propManager.getProperty("browser"));
        capabilities.setVersion("109.0");
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        try {
            return new RemoteWebDriver(URI.create(propManager.getProperty(REMOTE_URL)).toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
