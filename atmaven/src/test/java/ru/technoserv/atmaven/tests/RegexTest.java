package ru.technoserv.atmaven.tests;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {

    @Test(description = "Тестируем Регэкс")
    public void regexTest() {

        String text = "Мой телефон 1234 a456788 b789";
        System.out.println(text);

        String regex="\\d{3}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.end() + " " + text.substring(matcher.start(), matcher.end()));
        }

    }
}
