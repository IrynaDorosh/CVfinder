package ua.rabota.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import java.util.ArrayList;

public class ResultPageFinal extends BasePage {

    private WebDriver driver;

    public ResultPageFinal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='ctl00_content_vacancyList_Period_lblCurrentPerioValue']")
    public WebElement infoBarVacancy;

    public By blockWithAllVacasyInfo = By.xpath("//article[@class='f-vacancylist-vacancyblock']");




    public String obtainVacancyName(WebElement we){
        return we.findElement(By.className("ga_listing")).getAttribute("innerText");
    }

    public String obtainVacancyURL(WebElement we) {
        return we.findElement(By.className("ga_listing")).getAttribute("href");
    }

    public String obtainCompanyName(WebElement we) {
        return we.findElement(By.cssSelector(".f-text-dark-bluegray.f-visited-enable")).getAttribute("innerText");
    }



     public String obtainVacancyDescription(String url) {
        String description = null;
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url); //open new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //switching control to new tab
        driver.switchTo().window(tabs.get(1));

        try {
            description = driver.findElement(By.xpath("//div[@class='f-vacancy-description-inner-content']")).getAttribute("innerText");
        } catch (Exception e) {
            try {
                description = driver.findElement(By.xpath("//div[@class='d_content']")).getAttribute("innerText");
            } catch (Exception e1) {
                try {
                    description = driver.findElement(By.xpath("//div[@class='descr']")).getAttribute("innerText");
                } catch (Exception e2) {
                    log.fatal("Cannot find WE for obtaining vacancy description");
                    throw new TestException("Cannot find WE for obtaining vacancy description");
                }
            }
        }
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return description;
    }

}
