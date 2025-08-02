package com.digitalbank.automation.utils;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class Locator {

    private final String selector;
    private final String name;
    private final int defaultTimeout;

    public Locator(String selector, String name, int timeout) {
        this.selector = selector;
        this.name = name;
        this.defaultTimeout = timeout;
    }

    @Override
    public WebElement findElement(WebDriver driver) {
        return driver.findElement(toSeleniumLocator());
    }
}


