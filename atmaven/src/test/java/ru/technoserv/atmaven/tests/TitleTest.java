package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TitleTest {
    public String baseUrl = "https://google.com";
    public WebDriver driver ;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void testTitle() {

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

}
