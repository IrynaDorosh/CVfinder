package ua.rabota.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage_final {

    WebDriver driver;

    public ResultPage_final(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//p[@class='fd-peasant']")
    public  WebElement infoBar24;

    @FindBy(xpath="//a[@class='f-visited-enable ga_listing']")
    public  WebElement linkVacancy;


}
