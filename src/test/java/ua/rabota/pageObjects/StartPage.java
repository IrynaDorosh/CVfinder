package ua.rabota.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.log4testng.Logger;
import ua.rabota.utilities.Helper;

public class StartPage extends Helper {
    WebDriver driver;

    public StartPage(WebDriver driver, Logger log, WebDriverWait wait) {
        super(driver, log, wait);
    }

//    public StartPage(WebDriver driver){
//        this.driver=driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy (xpath = "//div[@class='fd-f-left-middle fd-f1']//input[contains(@placeholder, 'Введите')]")
    WebElement inputKeyWordForSearch;

    @FindBy (xpath = "//div[@class='fd-f-left-middle fd-f1']//input[contains(@placeholder, 'Введите')]/following::input[1]")
    WebElement inputCity;

    @FindBy(xpath="//div[@class='f-input-block f-input-icon-left f-input-icon-right styles__newheader-input-block___iJ6I5 styles__newheader-input-block-region___2IqyD']/following-sibling::a")
    WebElement buttonSearch;

    public void setKeyWordForSearch (String keyWord){
        try {
            inputKeyWordForSearch.clear();
            inputKeyWordForSearch.sendKeys(keyWord);
        } catch (Exception e) {
            log.error("Unsuccedeed to set Key word");
            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
//            e.printStackTrace();
        }
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
