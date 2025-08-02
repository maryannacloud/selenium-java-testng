package com.digitalbank.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefaultUiElement implements UiElement {

    private final WebDriver driver;
    private final Locator locator;

    public DefaultUiElement(WebDriver driver, Locator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    private WebElement find() {
        return driver.findElement(locator.toBy());
    }

    @Override
    public void click() {
        find().click();
    }

    @Override
    public void type(String text) {
        find().sendKeys(text);
    }

    @Override
    public void clear() {
        find().clear();
    }

    @Override
    public boolean isDisplayed() {
        return find().isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return find().isEnabled();
    }

    @Override
    public String getText() {
        return find().getText();
    }

    @Override
    public String getAttribute(String name) {
        return find().getAttribute(name);
    }

    @Override
    public void waitUntilVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator.toBy()));
    }

    @Override
    public void waitUntilClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator.toBy()));
    }
}
