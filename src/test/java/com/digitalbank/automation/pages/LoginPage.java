package com.digitalbank.automation.pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement();
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(;
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement();
        loginButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement();
        return errorMessage.getText();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement().isDisplayed();
    }
}
