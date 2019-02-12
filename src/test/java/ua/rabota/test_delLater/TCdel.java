package ua.rabota.test_delLater;

        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class TCdel extends TC_MAIN {

    @Parameters({"username", "password"})
    @Test
    void ttt(String username, String password, String browser) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(browser);

    }

//    @Test
//    void tt() throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver","D:\\CVsearcher\\drivers\\geckodriver.exe");
//
//        WebDriver driver = new FirefoxDriver();
//        driver.get(Constants.RABOTAUA_URL);
//        Thread.sleep(2000);
//        driver.quit();
//    }




}
