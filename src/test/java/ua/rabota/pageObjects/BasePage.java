package ua.rabota.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    Logger log = Logger.getLogger(this.getClass());
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void sendKeysInField(String keys, WebElement webElement) {
        try {
            webElement.clear();
            webElement.sendKeys(keys);
        } catch (Exception e) {
            log.error("Unsucceeded to send " + keys + "into" + webElement + " " + e);
            throw e;
        }
    }

    public void sendKeysInField(String keys, WebElement webElement, int mills) throws InterruptedException {
        try {
            webElement.clear();
            webElement.sendKeys(keys);
            Thread.sleep(mills);
        } catch (Exception e) {
            log.error("Unsucceeded to send " + keys + " into " + webElement + " " + e);
            throw e;
        }
    }

    public void click(WebElement webElement) {
        waitForElementToBeClickabe(webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            log.error("Cannot click on " + webElement + " " + e);
            throw e;
        }
    }

    protected void waitForElementToBeClickabe(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            log.error("The following element is not clickable " + e);
            throw e;
        }
    }


}
