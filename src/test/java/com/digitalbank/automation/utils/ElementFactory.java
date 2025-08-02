package com.digitalbank.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFactory {

    public static UiElement create(By seleniumBy) {
        WebElement element = driver.findElement(seleniumBy);
        return new SeleniumElement(element);
    }

}
