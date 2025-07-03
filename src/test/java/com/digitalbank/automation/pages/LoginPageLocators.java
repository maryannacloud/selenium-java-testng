package com.digitalbank.automation.pages;

import com.digitalbank.automation.utils.Locator;
import com.digitalbank.automation.utils.LocatorType;
import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final Locator USERNAME_TITLE = new Locator(
            "form[action='/bank/login'] div.form-group:first-of-type > label > strong",
            LocatorType.CSS,
            "Username Field Title",
            10
    );

    public static final Locator PASSWORD_TITLE = new Locator(
            "form[action='/bank/login'] div.form-group:nth-of-type(2) > label > strong",
            LocatorType.CSS,
            "Password Field Title",
            10
    );

    public static final Locator USERNAME_INPUT = new Locator(
            "input[name='username']",
            LocatorType.CSS,
            "Username Input Field",
            10
    );

    public static final Locator PASSWORD_INPUT = new Locator(
            "input[name='password']",
            LocatorType.CSS,
            "Password Input Field",
            10
    );

    public static final Locator USERNAME_PLACEHOLDER = new Locator(
            "input[placeholder='Enter User Name']",
            LocatorType.CSS,
            "Username Placeholder",
            10
    );

    public static final Locator PASSWORD_PLACEHOLDER = new Locator(
            "input[placeholder='Enter Password']",
            LocatorType.CSS,
            "Password Placeholder",
            10
    );
}
