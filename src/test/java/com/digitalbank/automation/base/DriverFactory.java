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

        int implicit = ConfigsReader.getConfig().timeouts.implicit;
        driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
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
