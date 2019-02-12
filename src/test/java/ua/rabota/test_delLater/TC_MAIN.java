package ua.rabota.test_delLater;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ua.rabota.testData.Constants;

public class TC_MAIN {

    WebDriver driver;

    @Parameters ({"browser"})
    @BeforeClass
    void setup(String browser){

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","D:\\CVsearcher\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

    }



    @AfterSuite
    void close(){
        driver.quit();
    }
}
