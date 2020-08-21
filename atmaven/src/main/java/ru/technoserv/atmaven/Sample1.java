package ru.technoserv.atmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample1 {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver chromeDriver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get(baseUrl);
    }
    @Test
    public void sample1(){
//        WebDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get(baseUrl);
        System.out.println("Chrome title = " + chromeDriver.getTitle());
    }

    @AfterClass
    public void closeSite() {
        chromeDriver.quit();
    }


}
