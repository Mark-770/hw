package ru.technoserv.atmaven.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.technoserv.atmaven.tests.pages.github.RepositoryPage;
import ru.technoserv.atmaven.tests.pages.github.SearchPage;
import ru.technoserv.atmaven.tests.pages.github.UserProfilePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static java.util.Arrays.asList;

@Listeners({ScreenShooter.class, BrowserPerTest.class})
public class GithubTest {
    private SearchPage searchPage;

    @BeforeMethod
    public void openGitHub() {
        System.out.println("Strategy = " + Configuration.pageLoadStrategy);
        searchPage = open("http://github.com/search", SearchPage.class);
    }

    @Test
    public void userCanSearchRepositories() {
        searchPage.search("pylover");
        searchPage.repositoriesResults().shouldHave(text("pylover/bee"));
    }

    @Test
    public void userCanSearchUsers() {
        searchPage.search("mcgray");
        searchPage.showUsersResults();
        searchPage.usersResults().shouldHave(text("Oleksiy Rezchykov"));

        UserProfilePage userProfilePage = searchPage.openUserProfile("mcgray");
        userProfilePage.showRepositories();
        userProfilePage.getRepositories().shouldHave(text("bdd-tools"));
    }

    @Test
    public void userCanBrowseProjectSources() {
        UserProfilePage userProfilePage = open("https://github.com/mcgray", UserProfilePage.class);
        userProfilePage.showRepositories();

        RepositoryPage repository = userProfilePage.openRepository("bdd-tools");
        for (String path : asList("cucumber-jvm-html-elements", "src", "test", "java/ua/com/mcgray/bdd/tools", "FindTreasureStepdefs.java")) {
            repository.openSource(path);
        }
        repository.getSourceLines().shouldHave(text("hidden treasure"));
    }
}