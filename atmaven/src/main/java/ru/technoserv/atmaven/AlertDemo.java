package ru.technoserv.atmaven;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertDemo {
    public String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void alertMessage() {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);


        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = alert.getText();

        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());

        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println(alertMessage2);

        alert2.accept();

    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }


}