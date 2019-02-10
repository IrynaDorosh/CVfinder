package ua.rabota.pageObjects;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.TestException;

public class ResultPageInterm extends BasePage {

    private WebDriver driver;

    public ResultPageInterm(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='f-vacancylist-dropdown-wrap']")
    WebElement dropDownPeriod;

    @FindBy(xpath = "//h2[@class='f-vacancylist-dropdown-wrap']//a[contains(text(),'24')]")
    WebElement period24hours;

    @FindBy(xpath = "//h2[@class='f-vacancylist-dropdown-wrap']//a[contains(text(),'7')]")
    WebElement period7days;


    /**
     * METHODS
     **/

    public void setSearchPeriod(String period) {
        try {
            waitForElementToBeClickabe(dropDownPeriod);
            dropDownPeriod.click();
        } catch (Exception e) {
            log.error("Unsucceeded in setting period: " + period + " e: " + e);
            throw e;
        }

        if (period.equals("24 hours")) {
            period24hours.click();
        } else if (period.equals("7 days")) {
            period7days.click();
        } else {
            log.error("Unsucceeded in setting period from period drop-down " + period);
            throw new TestException("Incorrect period was set");
        }

    }
}
