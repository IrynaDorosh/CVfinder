package ua.rabota.testCases;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ua.rabota.model.Vacancy;
import ua.rabota.testData.Constants;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class SearchForVacancies extends BaseTest {

    private List<Vacancy> vacanciesList = new ArrayList<>();

    @Parameters({"period", "textForAssertingPeriod"})
    @Test
    public void navigateToResultPage(String period, String textForAssertingPeriod) throws InterruptedException {
        driver.get(Constants.RABOTAUA_URL);
        startPage.sendKeysInField(Constants.KEYWORD_FOR_VACANCY_SEARCH, startPage.inputForSearch);
        startPage.sendKeysInField(Constants.CITY, startPage.inputForCity, 1000);
        startPage.click(startPage.buttonSearch);
        Assert.assertEquals(driver.getTitle(), "Работа qa automation в Киеве, поиск вакансий и работы в IT - Rabota.ua");
        resultPageInterm.setSearchPeriod(period);//7 days
        Assert.assertTrue(resultPageFinal.infoBarVacancy.getText().contains(textForAssertingPeriod));//7 дней
    }

    @Test(dependsOnMethods = {"navigateToResultPage"})
    public void collectVacanciesToList() {
        vacanciesList = new ArrayList<>();
        Vacancy vacancy;
        List<WebElement> linksBlockVacancy = driver.findElements(resultPageFinal.blockWithAllVacasyInfo);
        if (linksBlockVacancy.size() > 0) {

            for (int i = 0; i < linksBlockVacancy.size(); i++) {
                vacancy = new Vacancy();
                vacancy.vacancyName = resultPageFinal.obtainVacancyName(linksBlockVacancy.get(i));
                vacancy.urlVacancy = resultPageFinal.obtainVacancyURL(linksBlockVacancy.get(i));
                vacancy.companyName = resultPageFinal.obtainCompanyName(linksBlockVacancy.get(i));
                vacancy.vacancyDescription = resultPageFinal.obtainVacancyDescription(vacancy.urlVacancy);
                vacanciesList.add(vacancy);
            }
        } else {
            log.info("No vacanciesList found, list of vacanciesList is empty");
            throw new TestException("No vacanciesList found, list of vacanciesList is empty");
        }
    }

//@Test
//void preMock()  {
//    System.out.println("sds");
//}
//    @Test (dependsOnMethods = {"preMock"})
//    void mock()  {
//
//        Vacancy v1 = new Vacancy();
//        Vacancy v2 = new Vacancy();
//        Vacancy v3 = new Vacancy();
//        v1.vacancyDescription = "hjghg java";
//        v1.companyName = "Company1";
//        v1.urlVacancy = "www.v1.com";
//        v1.vacancyName = "vacName";
//        v2.vacancyDescription = "hjghg fhhdhd";
//        v2.companyName = "Company2";
//        v2.urlVacancy = "www.v2.com";
//        v2.vacancyName = "vacName";
//        v3.vacancyDescription = "hjghg fhhdhd java";
//        v3.companyName = "Company3";
//        v3.urlVacancy = "www.v3.com";
//        v3.vacancyName = "vacName";
//        vacanciesList.add(v1);
//        vacanciesList.add(v2);
//        vacanciesList.add(v3);
//
//    }


    @Test(dependsOnMethods = {"collectVacanciesToList", "navigateToResultPage"})
    public void writeSelectedVacToWorkbook() {
        List<Vacancy> filteredVacList = new ArrayList<>();

        for (int i = 0; i < vacanciesList.size(); i++) {
            if (vacanciesList.get(i).vacancyDescription.toLowerCase().contains("java")) {
                filteredVacList.add(vacanciesList.get(i));
            }
        }

        if (filteredVacList.size() > 0) {
            Workbook workbook = new XSSFWorkbook();
            Sheet newSheet = workbook.createSheet("Vacancies");

            for (int i = 0; i < filteredVacList.size(); i++) {
                Row row = newSheet.createRow(i);
                row.createCell(0).setCellValue(filteredVacList.get(i).companyName);
                row.createCell(1).setCellValue(filteredVacList.get(i).vacancyName);
                row.createCell(2).setCellValue(filteredVacList.get(i).vacancyDescription);
            }

            try {
                FileOutputStream fileOut = new FileOutputStream("D:\\Downloads\\FilteredVacancies.xlsx");
                workbook.write(fileOut);
                fileOut.close();
            } catch (Exception e) {
                log.error("Impossible to write to .xlsx file");
            }
        }
    }


}
