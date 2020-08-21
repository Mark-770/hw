package ru.company.benedis;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Double.parseDouble;

public class SelenideTestOpenBank {


    @Test
    public void checkCourseUsd() {

        open("https://www.open.ru/");
        try {
            ElementsCollection spanCol = $$(By.xpath("//*[@id=\"main\"]//div//span[@class =\"main-page-exchange__rate\"]"));
            String usdBuy = (spanCol.get(0).should(exist).getText());
            String usdSell = (spanCol.get(1).should(exist).getText());
            String eurBuy = (spanCol.get(2).should(exist).getText());
            String eurSell = (spanCol.get(3).should(exist).getText());

            double usdBuyValue = replaceStr(usdBuy);
            double usdSellValue = replaceStr(usdSell);
            double eurBuyValue = replaceStr(eurBuy);
            double eurSellValue = replaceStr(eurSell);

            if (usdBuyValue < usdSellValue) {
                System.out.println("Курс покупки меньше курса продажи");
                System.out.println("Test Passed");
            } else {
                System.out.println("Курс продажи выше курса покупки");
            }

            if (eurBuyValue < eurSellValue) {
                System.out.println("Курс покупки меньше курса продажи");
                System.out.println("Test Passed");
            } else System.out.println("Курс продажи выше курса покупки");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double replaceStr(String numberStr) {
        return parseDouble(numberStr.replace(",", "."));
    }

}
