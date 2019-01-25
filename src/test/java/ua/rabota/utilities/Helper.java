package ua.rabota.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.TestException;
import org.testng.log4testng.Logger;

public class Helper {

    private static int timeout = 10;
    private  WebDriver driver; //TODO makes it static
    protected Logger log;
    protected WebDriverWait wait;
    public Actions actions;
    public Select select;

    public Helper(WebDriver driver, Logger log, WebDriverWait wait){
        this.driver = driver;
        this.log = log;
        this.wait = wait;
    }

    public String getPageTitle() {
        try {
            log.info("Some information");
            return driver.getTitle();
        } catch (Exception e) {
            log.error("ERROR: " + "Current page title is: %s" + driver.getTitle());
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
        }
    }

    public void click(WebElement we){
        we.click();
    }








}
