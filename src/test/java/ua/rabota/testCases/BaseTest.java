package ua.rabota.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ua.rabota.pageObjects.ResultPage_Interm;
import ua.rabota.pageObjects.ResultPage_final;
import ua.rabota.pageObjects.StartPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WebDriver driver = new ChromeDriver();
    StartPage startPage = new StartPage(driver);
    ResultPage_Interm resultPage_interm = new ResultPage_Interm(driver);
    ResultPage_final resultPage_final = new ResultPage_final(driver);



    @BeforeClass
    public void setUp(){
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
