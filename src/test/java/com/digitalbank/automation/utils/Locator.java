package com.digitalbank.automation.utils;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class Locator implements WebLocator {

    private final String selector;
    private final LocatorType type;
    private final String name;
    private final int defaultTimeout;

    public Locator(String selector, LocatorType type, String name, int timeout) {
        this.selector = selector;
        this.type = type;
        this.name = name;
        this.defaultTimeout = timeout;
    }

    public By toSeleniumLocator() {
        return switch (type) {
            case CSS -> By.cssSelector(selector);
            case XPATH -> By.xpath(selector);
            case ID -> By.id(selector);
        };
    }

    @Override
    public WebElement findElement(WebDriver driver) {
        return driver.findElement(toSeleniumLocator());
    }
}


