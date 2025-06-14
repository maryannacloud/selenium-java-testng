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

    /**
     * Waits for visibility and clicks the element.
     * @param locator By locator of the element
     */
    protected void click(By locator) {
        WaitUtils.waitForClickability(locator).click();
    }

    /**
     * Waits for visibility and types the given text.
     * @param locator By locator of the input element
     * @param text Text to enter
     */
    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the visible text of the element.
     * @param locator By locator of the element
     * @return Text content of the element
     */
    protected String getText(By locator) {
        return WaitUtils.waitForVisibility(locator).getText();
    }

    /**
     * Checks if an element is visible.
     * @param locator By locator of the element
     * @return true if visible, false otherwise
     */
    protected boolean isVisible(By locator) {
        try {
            return WaitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
