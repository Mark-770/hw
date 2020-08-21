package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolTip {

    public String baseUrl = "http://demo.guru99.com/test/social-icon.html";
    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mark/Desktop/АвтоТестирование/atmaven/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test
    public void toolTip() {
        String expectedTooltip = "Github";
        try {
            // Find the Github icon at the top right of the header
            WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

            //get the value of the "title" attribute of the github icon
            String actualTooltip = github.getAttribute("title");

            //Assert the tooltip's value is as expected
            System.out.println("Actual Title of Tool Tip = " + actualTooltip);

            if(actualTooltip.equals(expectedTooltip)) {
                System.out.println("Test Case Passed");
            }
            else {
                System.out.println("Test Case FAILED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }


}