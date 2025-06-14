package com.digitalbank.automation.utils;

import com.digitalbank.automation.base.DriverFactory;
import com.digitalbank.automation.config.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static int getDefaultTimeout() {
        return ConfigsReader.getConfig().timeouts.implicit;
    }

    /**
     * Waits for an element to be visible on the page.
     *
     * @param locator  By locator of the element
     * @return WebElement once it is visible
     */
    public static WebElement waitForVisibility(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(getDefaultTimeout()))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable on the page.
     *
     * @param locator  By locator of the element
     * @return WebElement once it is clickable
     */
    public static WebElement waitForClickability(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(getDefaultTimeout()))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for an element to be present in the DOM.
     *
     * @param locator By locator of the element
     * @return WebElement once it is present
     */
    public static WebElement waitForPresence(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(getDefaultTimeout()))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for an element to disappear from the DOM.
     *
     * @param locator By locator of the element
     * @return true if the element becomes invisible
     */
    public static boolean waitForInvisibility(By locator) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(getDefaultTimeout()))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
