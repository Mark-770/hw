package ru.technoserv.atmaven.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationDemoTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/V1/index.php";

    @Test
    public void RunTest() {
        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10,0);

        driver.get(baseUrl);

        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement body = driver.findElement(By.cssSelector("body"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

        checkStyleBeforeClicking(userValidationMessage);
        checkStyleBeforeClicking(passwordValidationMessage);


//        passwordControl.click();
//        body.click();
//        String expectedStyle = "visibility: visible;";
//        String actualStyle = passwordValidationMessage.getAttribute("style");
//        Assert.assertEquals(actualStyle, expectedStyle);
//
//
//        usernameControl.click();
//        body.click();
//        String expectedStyle2 = "visibility: visible;";
//        String actualStyle2 = userValidationMessage.getAttribute("style");
//        Assert.assertEquals(actualStyle, expectedStyle);


        // This is not working! See below
        checkStyleAfterClicking(passwordControl, passwordValidationMessage, body);
        checkStyleAfterClicking(usernameControl, userValidationMessage, body);

//        checkStyleAfterClicking(passwordControl, passwordValidationMessage, usernameControl);
//        checkStyleAfterClicking(usernameControl, userValidationMessage, passwordControl);

        checkStyleAfterFilling(usernameControl, userValidationMessage);
        checkStyleAfterFilling(passwordControl, passwordValidationMessage);
        driver.quit();
    }


    private void checkStyleBeforeClicking(WebElement checkingElement){
        String expectedStyle = "";
        String actualStyle = checkingElement.getAttribute("style");

        Assert.assertEquals(actualStyle, expectedStyle);
    }


    private void checkStyleAfterClicking(WebElement interactionElement, WebElement checkingElement, WebElement missClick){
        interactionElement.click();
        missClick.click();


        String expectedStyle = "visibility: visible;";
        String actualStyle = checkingElement.getAttribute("style");
        Assert.assertEquals(actualStyle, expectedStyle);

    }

    private void checkStyleAfterFilling(WebElement interactionElement, WebElement checkingElement){
        interactionElement.sendKeys("a");

        String expectedStyle = "visibility: hidden;";
        String actualStyle = checkingElement.getAttribute("style");
        Assert.assertEquals(actualStyle, expectedStyle);
    }

}