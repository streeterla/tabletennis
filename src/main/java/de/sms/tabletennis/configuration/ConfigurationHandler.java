package de.sms.tabletennis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by streeter on 28.03.16.
 */
@Component
public class ConfigurationHandler {
    private static ConfigurationHandler configurationHandler = new ConfigurationHandler();

    public static ConfigurationHandler getInstance() {
        return configurationHandler;
    }

    private ConfigurationHandler() {
    }

    @Value("${COLUMN.LAST.NAME}")
    private int COLUMN_LAST_NAME;
    @Value("${COLUMN.FIRST.NAME}")
    private int COLUMN_FIRST_NAME;
    @Value("${COLUMN.PRIVATE.PHONE}")
    private int COLUMN_PRIVATE_PHONE;
    @Value("${COLUMN.MOBILE.PHONE}")
    private int COLUMN_MOBILE_PHONE;
    @Value("${COLUMN.BUSINESS.PHONE}")
    private int COLUMN_BUSINESS_PHONE;
    @Value("${COLUMN.PRIVATE.EMAIL}")
    private int COLUMN_PRIVATE_EMAIL;
    @Value("${COLUMN.BUSINESS.EMAIL}")
    private int COLUMN_BUSINESS_EMAIL;
    @Value("${COLUMN.STREET}")
    private int COLUMN_STREET;
    @Value("${COLUMN.POSTAL.CODE}")
    private int COLUMN_POSTAL_CODE;
    @Value("${COLUMN.CITY}")
    private int COLUMN_CITY;
    @Value("${COLUMN.BIRTHDAY}")
    private int COLUMN_BIRTHDAY;

    public static Object getProperty(String property) {
        try {
            Object object = ConfigurationHandler.class.getMethod("get" + property).invoke(null);
            return String.valueOf(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getCOLUMN_LAST_NAME() {
        return COLUMN_LAST_NAME;
    }

    private int getCOLUMN_FIRST_NAME() {
        return COLUMN_FIRST_NAME;
    }

    private int getCOLUMN_PRIVATE_PHONE() {
        return COLUMN_PRIVATE_PHONE;
    }

    private int getCOLUMN_MOBILE_PHONE() {
        return COLUMN_MOBILE_PHONE;
    }

    private int getCOLUMN_BUSINESS_PHONE() {
        return COLUMN_BUSINESS_PHONE;
    }

    private int getCOLUMN_PRIVATE_EMAIL() {
        return COLUMN_PRIVATE_EMAIL;
    }

    private int getCOLUMN_BUSINESS_EMAIL() {
        return COLUMN_BUSINESS_EMAIL;
    }

    private int getCOLUMN_STREET() {
        return COLUMN_STREET;
    }

    private int getCOLUMN_POSTAL_CODE() {
        return COLUMN_POSTAL_CODE;
    }

    private int getCOLUMN_CITY() {
        return COLUMN_CITY;
    }

    private int getCOLUMN_BIRTHDAY() {
        return COLUMN_BIRTHDAY;
    }
}
