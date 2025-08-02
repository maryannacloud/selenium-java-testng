package com.digitalbank.automation.utils;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Locator {

    public enum Strategy {
        CSS,
        XPATH,
        ID,
        NAME,
        CLASS_NAME,
        TAG_NAME,
        LINK_TEXT,
        PARTIAL_LINK_TEXT
    }

    private final String name;
    private final Strategy strategy;
    private final String selector;

    public Locator(String name, Strategy strategy, String selector) {
        this.name = name;
        this.strategy = strategy;
        this.selector = selector;
    }

    public String getName() {
        return name;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public String getSelector() {
        return selector;
    }

    public By toBy() {
        return switch (strategy) {
            case CSS -> By.cssSelector(selector);
            case XPATH -> By.xpath(selector);
            case ID -> By.id(selector);
            case NAME -> By.name(selector);
            case CLASS_NAME -> By.className(selector);
            case TAG_NAME -> By.tagName(selector);
            case LINK_TEXT -> By.linkText(selector);
            case PARTIAL_LINK_TEXT -> By.partialLinkText(selector);
        };
    }
}


