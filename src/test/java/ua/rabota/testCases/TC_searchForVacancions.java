package ua.rabota.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.rabota.pageObjects.StartPage;
import ua.rabota.pageObjects.Vacancy;
import ua.rabota.testData.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TC_searchForVacancions extends BaseTest {
    @Test
    public void navigateToResultPage() throws InterruptedException {
       driver.get(Constants.RABOTAUA_URL);
       startPage.setKeyWordForSearch(Constants.KEYWORD_FOR_SEARCH);
       startPage.setCity(Constants.CITY);
       startPage.clickSearch();
//       Assert.assertEquals(driver.getTitle(), "Работа Automation QA в Киеве, поиск вакансий и работы в IT - Rabota.ua");//TODO uncomment later
       Assert.assertEquals(driver.getTitle(), "Работа QA в Киеве, поиск вакансий и работы в IT - Rabota.ua");
       resultPage_interm.setSearchPeriod("24hours");
       Assert.assertTrue(resultPage_final.infoBar24.getText().contains("24"));
    }

    @Test
    public void collectVacanciesToList(){
        driver.get("https://rabota.ua/zapros/qa/%D0%BA%D0%B8%D0%B5%D0%B2?period=2&lastdate=19.01.2019");
        List <WebElement> linksVacancy = driver.findElements(By.xpath("//a[@class='f-visited-enable ga_listing']"));
        System.out.println("Amount of vacancies found is: " + linksVacancy.size());

        if (linksVacancy.size()>0){
            Vacancy vacancy = new Vacancy();

            for (int i = 0; i < linksVacancy.size(); i++){
                vacancy.vacancyName = linksVacancy.get(i).getAttribute("InnerText");
                System.out.println("Vac name is: " + vacancy.vacancyName);
                vacancy.urlVacancy = linksVacancy.get(i).getAttribute("href");
                System.out.println("Vac url: " + vacancy.urlVacancy);
                linksVacancy.get(i).click();
                Assert.assertNotEquals(driver.getTitle(), "Работа QA в Киеве, поиск вакансий и работы в IT - Rabota.ua");//TODO change to automation
                vacancy.vacancyDescription = obtainVacancyDescription();
                System.out.println("Vac desc: " + vacancy.vacancyDescription);
                driver.navigate().back();
                Assert.assertEquals(driver.getTitle(), "Работа QA в Киеве, поиск вакансий и работы в IT - Rabota.ua");//TODO change to automation
            }
        }


    }

public String obtainVacancyDescription(){
        String description=null;
    try {
        description = driver.findElement(By.xpath("//div[@class='f-vacancy-description']")).getAttribute("innerText");
    } catch (Exception e) {
        description = driver.findElement(By.xpath("//div[@class='d_des']")).getAttribute("innerText");
    }
    return description;
}

@Test
    public void openInNewWindow() throws InterruptedException {
        driver.get("https://plus-qa.smilebox.com/account/Login");
        WebElement we = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/h2/a"));
    Actions actions = new Actions(driver);
    actions.keyDown(Keys.SHIFT).click(we).keyUp(Keys.SHIFT).build().perform();
    Set handles = driver.getWindowHandles();




}

}
