package com.digitalbank.automation.pages;

import org.openqa.selenium.By;

public class SignUpPage extends BasePage {

    // Locators
    private static final By SIGN_UP_BUTTON = By.id("signUpButton");
    private static final By EMAIL_INPUT = By.id("emailInput");
    private static final By PASSWORD_INPUT = By.id("passwordInput");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("confirmPasswordInput");
    private static final By SUBMIT_BUTTON = By.id("submitButton");

    // Methods
    public void clickSignUp() {
        click(SIGN_UP_BUTTON);
    }

    public void enterEmail(String email) {
        type(EMAIL_INPUT, email);
    }

    public void enterPassword(String password) {
        type(PASSWORD_INPUT, password);
    }

    public void confirmPassword(String password) {
        type(CONFIRM_PASSWORD_INPUT, password);
    }

    public void submit() {
        click(SUBMIT_BUTTON);
    }
}
