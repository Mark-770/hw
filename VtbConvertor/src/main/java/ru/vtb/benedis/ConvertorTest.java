package ru.vtb.benedis;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Double.parseDouble;

public class ConvertorTest {
    private static final String url = "https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/";
    static String USD = "USD";
    static String RUR = "RUR";
    static String EUR = "EUR";


    public static ConvertorTest getExchangePage() {
        return open(url, ConvertorTest.class);
    }

    public static double replaceStr(String numberStr) {
        return parseDouble(numberStr.replace(",", "."));
    }}
