package com.digitalbank.automation.pages;

import com.digitalbank.automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage () {
        this.driver = DriverFactory.getDriver();
    }
}
