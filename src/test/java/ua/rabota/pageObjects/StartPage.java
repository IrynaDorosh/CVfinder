package ua.rabota.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class StartPage {
    WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='fd-f-left-middle fd-f1']//input[contains(@placeholder, 'Введите')]")
    WebElement inputKeyWordForSearch;

    @FindBy (xpath = "//div[@class='fd-f-left-middle fd-f1']//input[contains(@placeholder, 'Введите')]/following::input[1]")
    WebElement inputCity;

    @FindBy(xpath="//div[@class='f-input-block f-input-icon-left f-input-icon-right styles__newheader-input-block___iJ6I5 styles__newheader-input-block-region___2IqyD']/following-sibling::a")
    WebElement buttonSearch;

    public void setKeyWordForSearch (String keyWord){
        inputKeyWordForSearch.clear();
        inputKeyWordForSearch.sendKeys(keyWord);
    }

    public void setCity(String city) throws InterruptedException {
        inputCity.clear();
        inputCity.sendKeys(city);
        Thread.sleep(1000);
    }

    public void clickSearch(){
        buttonSearch.click();
    }







}
