package com.digitalbank.automation.utils;

import org.openqa.selenium.WebDriver;

public class UiDriver {

    private final WebDriver driver;

    public UiDriver() {
        this.driver = DriverFactory.getDriver();
    }

    public UiElement element(Locator locator) {
        return new DefaultUiElement(driver, locator);
    }
}
