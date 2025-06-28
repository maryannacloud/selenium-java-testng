package com.digitalbank.automation.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebLocator {

    WebElement findElement(WebDriver driver);

}