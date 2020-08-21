package ru.company.benedis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;

public class OpenBank {
    public String baseUrl = "https://www.open.ru/";
    public WebDriver driver;

    public static double replaceStr(String numberStr) {
        return parseDouble(numberStr.replace(",", "."));
    }

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void checkCourseUsd() {
        WebElement bankBuyDollar = driver.findElements(By.xpath("//*[@id=\"main\"]//div//span[@class =\"main-page-exchange__rate\"]")).get(0);
        WebElement bankSellDollar = driver.findElements(By.xpath("//*[@id=\"main\"]//div//span[@class =\"main-page-exchange__rate\"]")).get(1);

      course(bankBuyDollar, bankSellDollar);
    }

    @Test
    public void checkCourseEuro() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement bankBuyEuro = driver.findElements(By.xpath("//*[@id=\"main\"]//div//span[@class =\"main-page-exchange__rate\"]")).get(2);
        WebElement bankSellEuro = driver.findElements(By.xpath("//*[@id=\"main\"]//div//span[@class =\"main-page-exchange__rate\"]")).get(3);

        course(bankBuyEuro, bankSellEuro);

    }

     Assert.assertEquals(MyBankValue, bankSellValue, 0.0);

    private void course(WebElement bankBuyEuro, WebElement bankSellEuro) {
        String bEuro = bankBuyEuro.getText();
        String sEuro = bankSellEuro.getText();
        double numberBuyEuro = replaceStr(bEuro);
        double numberSellEuro = replaceStr(sEuro);

        if (numberBuyEuro < numberSellEuro) {
            System.out.println("Курс покупки меньше курса продажи");
            System.out.println("Test Passed");
        } else {
            System.out.println("Курс продажи выше курса покупки");
        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

}

