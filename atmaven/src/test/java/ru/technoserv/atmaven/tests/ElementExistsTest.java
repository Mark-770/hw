package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementExistsTest {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void elementExists() {
        WebElement existingElement = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input"));
        Assert.assertTrue(existingElement.isDisplayed());

        try {
        WebElement notExistingElement = driver.findElement(By.name("noSuchName"));
        // в норме, этот код не должен выполняться
        Assert.fail();
        }
        catch (NoSuchElementException e) {

        }
    }

    @AfterClass
    public void closeSite() {
        driver.close();
    }

}
