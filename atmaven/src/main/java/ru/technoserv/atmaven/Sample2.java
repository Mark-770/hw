package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample2 {
    public         String baseUrl = "http://demo.guru99.com/test/login.html";

    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void sample2() {
        try {
            // Get the WebElement corresponding to the Email Address(TextField)
            WebElement email = driver.findElement(By.id("email"));

            // Get the WebElement corresponding to the Password Field
            WebElement password = driver.findElement(By.name("passwd"));

            email.sendKeys("abcd@gmail.com");
            password.sendKeys("abcdefghlkjl");
            System.out.println("Text Field Set");

            // Deleting values in the text box
            email.clear();
            password.clear();
            System.out.println("Text Field Cleared");

            // Find the submit button
            WebElement login = driver.findElement(By.id("SubmitLogin"));

            // Using click method to submit form
            email.sendKeys("abcd@gmail.com");
            password.sendKeys("abcdefghlkjl");
            login.click();
            System.out.println("Login Done with Click");

            //using submit method to submit the form. Submit used on password field
            driver.get(baseUrl);
            driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
            driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
            driver.findElement(By.id("SubmitLogin")).submit();
            System.out.println("Login Done with Submit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
//        // declaration and instantiation of objects/variables
//        WebDriver driver = new ChromeDriver();
//
//        String baseUrl = "http://demo.guru99.com/test/login.html";
//        driver.get(baseUrl);
//
//
////
////        driver.quit();
//
//    }
}