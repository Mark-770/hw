package ru.technoserv.atmaven.tests.pages.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public ElementsCollection getResults() {
        return $$("#rso .g");
    }
    public SelenideElement getResult(int index) {
        return $("#rso .g", index);
    }
}
