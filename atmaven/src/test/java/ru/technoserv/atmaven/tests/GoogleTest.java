package ru.technoserv.atmaven.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.technoserv.atmaven.tests.pages.google.GooglePage;
import ru.technoserv.atmaven.tests.pages.google.SearchResultsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    @Test
    public void userCanSearch() {
        GooglePage page = open("http://google.com/ncr", GooglePage.class);
        SearchResultsPage results = page.searchFor("selenide");
        Assert.assertTrue(results.getResults().size() > 5);
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }
}
