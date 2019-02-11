package ua.rabota.utilities;

import org.testng.TestException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class ReadConfig2 {

    String result = "";
    InputStream inputStream;
    Properties prop = new Properties();
    Date time = new Date(System.currentTimeMillis());

    public ReadConfig2() throws IOException {
        try {

            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

 public String getrabotaUrl() {
     String URL = prop.getProperty("rabotaUrl");
     if (URL != null){
         return URL;
     } else {


         throw new TestException("Property is null");
     }

 }

//    // get the property value and print it out
//    String user = prop.getProperty("user");
//    String company1 = prop.getProperty("company1");
//    String company2 = prop.getProperty("company2");
//    String company3 = prop.getProperty("company3");
//
//    result = "Company List = " + company1 + ", " + company2 + ", " + company3;
//            System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
//} catch (Exception e) {
//        System.out.println("Exception: " + e);
//        } finally {
//        inputStream.close();
//        }
//        return result;

        }
