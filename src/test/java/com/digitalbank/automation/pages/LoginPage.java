package com.digitalbank.automation.pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(LoginPageLocators.USERNAME_TITLE);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(LoginPageLocators.PASSWORD_TITLE);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(LoginPageLocators.LOGIN_BUTTON);
        loginButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(LoginPageLocators.ERROR_MESSAGE);
        return errorMessage.getText();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(LoginPageLocators.USERNAME_TITLE).isDisplayed();
    }
}
