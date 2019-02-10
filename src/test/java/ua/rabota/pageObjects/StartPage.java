package ua.rabota.pageObjects;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='f-input-block fd-f1 styles__newheader-input-block___iJ6I5 styles__newheader-input-block-keyword___2Izi0']/input")
    public WebElement inputForSearch;

    @FindBy(xpath = "//div[@class='f-input-block fd-f1 styles__newheader-input-block___iJ6I5 styles__newheader-input-block-keyword___2Izi0']/following::input[1]")
    public WebElement inputForCity;

    @FindBy(xpath = "//div[@class='f-input-block f-input-icon-left f-input-icon-right styles__newheader-input-block___iJ6I5 styles__newheader-input-block-region___2IqyD']/following-sibling::a")
    public WebElement buttonSearch;


}
