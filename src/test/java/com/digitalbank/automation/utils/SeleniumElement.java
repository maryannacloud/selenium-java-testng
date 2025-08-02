package com.digitalbank.automation.utils;

import org.openqa.selenium.WebElement;

public class SeleniumElement implements UiElement{

    private final WebElement webElement;

    public SeleniumElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }

    public void type(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void shouldBeVisible() {
        if (!webElement.isDisplayed()) {
            throw new AssertionError("Element is not visible");
        }
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }
}
