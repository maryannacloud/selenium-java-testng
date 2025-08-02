package com.digitalbank.automation.pages;

import com.digitalbank.automation.base.DriverFactory;
import com.digitalbank.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage () {
        this.driver = DriverFactory.getDriver();
    }
}
