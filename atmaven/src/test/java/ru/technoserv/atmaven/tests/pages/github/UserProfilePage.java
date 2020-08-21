package ru.technoserv.atmaven.tests.pages.github;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserProfilePage {
    public void showRepositories() {
        $("nav.UnderlineNav-body").find(By.partialLinkText("Repositories")).click();
    }

    public SelenideElement getRepositories() {
        return $("div#user-repositories-list");
    }

    public RepositoryPage openRepository(String repositoryName) {
        getRepositories().find(By.partialLinkText(repositoryName)).click();
        return page(RepositoryPage.class);
    }
}