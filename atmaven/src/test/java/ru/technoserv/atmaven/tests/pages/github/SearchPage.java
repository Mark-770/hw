package ru.technoserv.atmaven.tests.pages.github;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Exist;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SearchPage {
    public void search(String query) {
        $("#search_form").find(By.name("q")).setValue(query).pressEnter();
    }

    public SelenideElement repositoriesResults() {
        return $(".codesearch-results");
    }

    public void showUsersResults() {
        $("nav.menu").find(By.partialLinkText("Users")).click();
    }

    public SelenideElement usersResults() {
        $("div.user-list").waitUntil(new Exist(), 1000);
        return $("div.user-list");
    }

    public UserProfilePage openUserProfile(String username) {
        usersResults().find(By.linkText(username)).click();
        return page(UserProfilePage.class);
    }
}