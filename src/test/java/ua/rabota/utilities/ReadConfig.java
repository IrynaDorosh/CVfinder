package ua.rabota.utilities;

import org.testng.TestException;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    private Properties prop;
    private Logger log= Logger.getLogger(this.getClass());

    public ReadConfig() {
        File file = new File(".\\src\\resources\\config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        }
        catch (Exception e) {
            log.error("Unsucceeded in reading config");
            throw new TestException("Property is null" + e);
        }
       }

    public String getUrl() {
        if (prop != null) {
            return prop.getProperty("rabotaUrl");
        } else {
            log.info("Property RabotaUrl not found");
        }
        return null;
    }

    public String getKeywordForVacancySearch(){
        if (prop != null) {
            return prop.getProperty("keyWordForVacancySearch");
        } else {
            log.info("Property keyWordForVacancySearch not found");
        }
        return null;
    }

    public String getCity(){
        if (prop != null) {
            return prop.getProperty("city");
        } else {
            log.info("Property City not found");
        }
        return null;
    }
}
