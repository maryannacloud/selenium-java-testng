package com.digitalbank.automation.config;

import dev.failsafe.Timeout;

import java.text.MessageFormat;

public class ConfigurationsPOJO {

    public String baseUrl;
    public String host;
    public String browser;
    public boolean headless;
    public Timeouts timeouts;
    public DbConfig dbUrl;

        @Override
        public String toString() {
            return MessageFormat.format(
                    "ConfigurationsPOJO'{'baseUrl=''{0}'', host = ''{1}'', browser=''{2}'', headless={3}, dbUrl={4}'}'",
                    baseUrl, host, browser, headless, dbUrl);
    }

    public static class DbConfig {
        public String url;
        public String username;
        public String password;

        @Override
        public String toString() {
            return MessageFormat.format(
                    "DbConfig'{'url=''{0}'', username=''{1}'', password=''{2}''",
                    url, username, password);
        }
    }

    public static class Timeouts {
        public int implicit;
        public int pageLoad;
        public int script;
    }
}
