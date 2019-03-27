package com.yaman.config;

import static java.lang.System.getenv;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.FileReader;
import java.util.Properties;

public class ConfigUtils {
	private static Properties config;
    private static String LOGIN_URL = "server.login";
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
	private static final String CADASTRO_URL = "server.cadastro";

    private static Properties load() throws Exception {
        config = new Properties();
        if (config.isEmpty()) {
            config.load(new FileReader(CONFIG_FILE));
        }
        return config;
    }

    public static String getProperty(String property, String defaultValue) {
        String result = null;

        try {
            result = getenv(property);
            if (isBlank(result)) {
                result = System.getProperty(property);
            }
            if (isBlank(result)) {
                Properties file = load();
                result = file.getProperty(property, defaultValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String getLoginUrl() {
        return getProperty(LOGIN_URL, "");
    }
    
    public static String getCadastroUrl() {
		return getProperty(CADASTRO_URL, "");
	}

}