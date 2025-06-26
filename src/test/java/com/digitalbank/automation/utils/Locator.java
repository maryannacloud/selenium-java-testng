package com.digitalbank.automation.utils;

import lombok.Getter;
import org.openqa.selenium.By;

public class Locator {

    private final String selector;
    private final LocatorType type;

    @Getter
    private final String name;

    private final int defaultTimeout;

    public Locator(String selector, LocatorType type, String name, int timeout) {
        this.selector = selector;
        this.type = type;
        this.name = name;
        this.defaultTimeout = timeout;
    }

    public By asBy() {
        return switch (type) {
            case CSS -> By.cssSelector(selector);
            case XPATH -> By.xpath(selector);
            case ID -> By.id(selector);
        };
    }

    public int getTimeout() {
        return defaultTimeout;
    }
}


