package ua.rabota.pageObjects;

import com.sun.xml.internal.bind.v2.TODO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage_Interm {

    WebDriver driver;

    public ResultPage_Interm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='f-vacancylist-dropdown-wrap']")
    WebElement dropDownPeriod;

    @FindBy(xpath = "//h2[@class='f-vacancylist-dropdown-wrap']//a[contains(text(),'24')]")
    WebElement period24hours;

    public void setSearchPeriod(String period) {
        dropDownPeriod.click();
        if (period.equals("24hours")) {
            period24hours.click();
        } else {
            System.out.println("Incorrect period");
        }
        //TODO throw new exception;


    }
}
