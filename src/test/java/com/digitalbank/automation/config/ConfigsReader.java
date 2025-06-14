package com.digitalbank.automation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class ConfigsReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigsReader.class);
    private static ConfigurationsPOJO config;

    public static ConfigurationsPOJO getConfig() {
        if (config == null) {
            LOGGER.info("Loading configuration from general-configs.yaml");
            try (InputStream input = ConfigsReader.class
                                        .getClassLoader()
                                        .getResourceAsStream("general-configs.yaml")) {

                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                config = mapper.readValue(input, ConfigurationsPOJO.class);

                config.dbUrl.username = resolveEnvVariables(config.dbUrl.username);
                config.dbUrl.password = resolveEnvVariables(config.dbUrl.password);

            } catch (Exception e) {
                LOGGER.error("Error loading configuration file", e);
                throw new RuntimeException("Failed to load configuration file", e);
            }
        }
        return config;
    }

    private static String resolveEnvVariables(String value) {
        if (value != null && value.contains("${")) {
            int start = value.indexOf("${") + 2;
            int end = value.indexOf("}");
            String envVar = value.substring(start, end);
            String envValue = System.getenv(envVar);
            return envValue != null ? envValue : "";
        }
        return value;
    }
}
