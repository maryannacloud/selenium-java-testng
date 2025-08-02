package com.digitalbank.automation.tests.base;

import com.digitalbank.automation.utils.DriverFactory;
import com.digitalbank.automation.utils.DriverManager;
import com.digitalbank.automation.utils.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected DriverManager driverManager;

    @Parameters({"browser", "headless"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser,
                      @Optional String headless) {
        // You can later load DriverManager from a factory or DI container
        driverManager = new SeleniumDriverManager(); // Use interface here
        driverManager.initDriver(browser, headless != null ? Boolean.parseBoolean(headless) : null);
        driver = driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
