package com.digitalbank.automation.base;

import com.digitalbank.automation.config.ConfigsReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Factory class for managing WebDriver instances using ThreadLocal.
 * Supports multiple browsers (Chrome, Firefox, Edge) and headless execution.
 *
 * <p>This class is responsible for initializing, providing, and quitting WebDriver instances.
 * It uses values from {@code db-config.yaml} via {@link ConfigsReader}, but also allows runtime overrides
 * via method parameters (useful for TestNG parameterization or CI/CD pipelines).</p>
 *
 * <p>Example usage:
 * <pre>{@code
 *     DriverFactory.initDriver("chrome", true);
 *     WebDriver driver = DriverFactory.getDriver();
 *     driver.get("https://example.com");
 * }</pre>
 * </p>
 *
 *  @author Maryna Nesterenko
 *  @since 2025-05-15
 */

public class DriverFactory {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browserOverride, Boolean headlessOverride) {
        String browser = browserOverride != null ? browserOverride : ConfigsReader.getConfig().browser;
        boolean headless = headlessOverride != null ? headlessOverride : ConfigsReader.getConfig().headless;

        WebDriver driverInstance;

        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) firefoxOptions.addArguments("--headless");
                driverInstance = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) edgeOptions.addArguments("--headless");
                driverInstance = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driverInstance = new ChromeDriver(chromeOptions);
                break;
        }

        driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverInstance.manage().window().maximize();
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
