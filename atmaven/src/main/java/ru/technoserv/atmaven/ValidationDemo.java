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

public class ValidationDemo {
    public String baseUrl = "http://demo.guru99.com/V1/index.php";
    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void validation() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            WebElement usernameControl = driver.findElement(By.name("uid"));
            WebElement passwordControl = driver.findElement(By.name("password"));
            WebElement misc = driver.findElement(By.cssSelector("body"));
            WebElement userValidationMessage = driver.findElement(By.id("message23"));
            WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

            System.out.println(userValidationMessage.getAttribute("style"));
            System.out.println(passwordValidationMessage.getAttribute("style"));

            usernameControl.click();
            passwordControl.click();
            misc.click();

            System.out.println(userValidationMessage.getAttribute("style"));
            System.out.println(passwordValidationMessage.getAttribute("style"));

            usernameControl.sendKeys("a");
            passwordControl.sendKeys("a");

            System.out.println(userValidationMessage.getAttribute("style"));
            System.out.println(passwordValidationMessage.getAttribute("style"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }

}
