package task6.connection;

import lombok.Getter;

import java.util.ResourceBundle;

public class DatabaseSettings {
    private static final String DATABASE = "database";
    private static final String URL_KEY = "url";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(DATABASE);
    @Getter
    private static final String URL = getValue(URL_KEY);
    @Getter
    private static final String USER = getValue(USER_KEY);
    @Getter
    private static final String PASSWORD = getValue(PASSWORD_KEY);

    private static String getValue(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
