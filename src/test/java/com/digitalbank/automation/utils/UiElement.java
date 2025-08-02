package com.digitalbank.automation.utils;

public interface UiElement {

    void click();

    void type(String text);

    void clear();

    boolean isDisplayed();

    boolean isEnabled();

    String getText();

    String getAttribute(String name);

    void waitUntilVisible();

    void waitUntilClickable();
}
