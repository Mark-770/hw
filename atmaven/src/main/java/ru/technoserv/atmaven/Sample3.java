package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

public class Sample3 {

    public String baseUrl = "http://demo.guru99.com/test/upload/";
    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void sample3() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

            // enter the file path onto the file-selection input field
            uploadElement.sendKeys("C:/Users/Mark/Downloads/POST.png");

            // check the "I accept the terms of service" check box
            driver.findElement(By.id("terms")).click();

            WebElement resultElement = driver.findElement(By.cssSelector("#res"));
            WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
            System.out.println(resultText.getText().contains(" successfully"));
            long start = (new Date()).getTime();
            System.out.println((new Date()).getTime() - start);

            // click the "UploadFile" button
            driver.findElement(By.name("send")).click();
            System.out.println(resultText.getText().contains(" successfully"));

            System.out.println((new Date()).getTime() - start);

            wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

            System.out.println(resultText.getText().contains(" successfully"));

            System.out.println((new Date()).getTime() - start);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

}