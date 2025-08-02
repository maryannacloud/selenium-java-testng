package com.digitalbank.automation.utils;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

    void initDriver(String browserOverride, Boolean headlessOverride);
    WebDriver getDriver();
    void quitDriver();
}
