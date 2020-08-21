package ru.technoserv.atmaven.tests.pages.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RepositoryPage {
    public void openSource(String path) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $$("div.Box-row").findBy(text(path)).find(By.cssSelector("a")).click();
    }

    public SelenideElement getSourceLines() {
        return $("div.data");
    }
}