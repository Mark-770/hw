package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Sample4 {

    public String baseUrl = "http://demo.guru99.com/test/yahoo.html";
    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void sample4() {
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");

        String wgetCommand = "cmd -P C:/Users/Mark/Downloads/ --no-check-certificate " + sourceLocation;
        System.out.println(wgetCommand);
        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
//
//        String baseUrl = "http://demo.guru99.com/test/yahoo.html";
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(baseUrl);
//        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
//        String sourceLocation = downloadButton.getAttribute("href");
//
//
//        String wgetCommand = "wget -P /Users/igor/Downloads/test --no-check-certificate " + sourceLocation;
//        System.out.println(wgetCommand);
//        try {
//            Process exec = Runtime.getRuntime().exec(wgetCommand);
//            int exitVal = exec.waitFor();
//            System.out.println("Exit value: " + exitVal);
//        } catch (InterruptedException | IOException ex) {
//            System.out.println(ex.toString());
//        } finally {
//            // remove file
//            driver.quit();
//        }
//    }
}