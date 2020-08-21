package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest {

    @Test
    public void testElement() {
        open("http://demo.guru99.com/test/newtours/");
        System.out.println(getWebDriver().getTitle());
        $(By.xpath("//*[@id=\"site-name\"]/a")).shouldHave(text("Demo Site"));
    }

    @Test
    public void testTitle() {
        open("http://www.google.com");

        assertEquals("Google", title());   // OK
    }
}
