package ua.rabota.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ua.rabota.pageObjects.ResultPageInterm;
import ua.rabota.pageObjects.ResultPageFinal;
import ua.rabota.pageObjects.StartPage;
import ua.rabota.utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    static WebDriver driver = new ChromeDriver();
    public Logger log = Logger.getLogger(this.getClass());
    protected ReadConfig readConfig = new ReadConfig();

    StartPage startPage = new StartPage(driver);
    ResultPageInterm resultPageInterm = new ResultPageInterm(driver);
    ResultPageFinal resultPageFinal = new ResultPageFinal(driver);

    @BeforeClass
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
