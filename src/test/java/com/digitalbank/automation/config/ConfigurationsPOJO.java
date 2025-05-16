package com.digitalbank.automation.config;

import java.text.MessageFormat;

public class ConfigurationsPOJO {

    public String baseUrl;
    public String browser;
    public boolean headless;
    public DbConfig dbUrl;

    public static class DbConfig {
        public String url;
        public String username;
        public String password;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "ConfigurationsPOJO'{'baseUrl=''{0}'', browser=''{1}'', headless={2}, dbUrl={3}'}'", baseUrl, browser, headless, dbUrl);
    }
}
