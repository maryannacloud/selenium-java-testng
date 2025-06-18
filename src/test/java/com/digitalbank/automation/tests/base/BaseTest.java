package com.digitalbank.automation.tests.base;

import com.digitalbank.automation.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser", "headless"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser,
                      @Optional String headless) {
        DriverFactory.initDriver(browser, headless != null ? Boolean.parseBoolean(headless) : null);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
