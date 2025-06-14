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
            } catch (Exception e) {
                LOGGER.error("Error loading configuration file", e);
                throw new RuntimeException("Failed to load configuration file", e);
            }
        }
        return config;
    }
}
