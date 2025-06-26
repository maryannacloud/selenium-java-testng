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

    protected void click(By locator) {
        WaitUtils.waitForClickability(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    protected boolean isVisible(By locator) {
        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
