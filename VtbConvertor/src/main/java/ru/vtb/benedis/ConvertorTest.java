package ru.vtb.benedis;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
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
    }

    public void parentInput1() throws InterruptedException {
        $x("//*[@id=\"method1\"]/../..").click();

    }

    public SelenideElement input1() throws InterruptedException {
        //        input1.click();
//        input1.clear();
//        Thread.sleep(3000);
        return $(By.xpath("//input[@id=\"method1\"]"));
    }

    public SelenideElement input2() throws InterruptedException {
        return $(By.xpath("//input[@id=\"method2\"]"));
    }

    public void setValueInput(SelenideElement element, String value) {
        element.sendKeys(value);
    }


    public void selectCurrency1Click() {
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]")).click();
    }

    public String selectCurrency1ForUsd() throws InterruptedException {
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]//span//li[3]")).click();
        Thread.sleep(3000);
        SelenideElement parentInput2 = $x("//*[@id=\"method2\"]");
        parentInput2.click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]//span//li[1]")).click();
        String input2Value = parentInput2.getValue();
        Thread.sleep(3000);
        String wantValue = $(By.xpath("//*[@id=\"method1\"]/../../../../div[2]/div[2]")).getText();
        return wantValue.replace(",", ".").replaceAll("\\s+", "").replaceAll("\u00a0", "").split("=", 2)[1].split("₽", 2)[0];
    }

    public void selectCurrency2Click() {
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]")).click();
    }

    public void selectedFieldRurInput1() {
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]//span//li[1]")).click();
    }

    public void selectedFieldUsdInput2() {
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]//span//li[3]")).click();
    }

    public double wantValue() throws InterruptedException {
//        Thread.sleep(5000);
        String wantValue = $(By.xpath("//*[@id=\"method1\"]/../../../../div[2]/div[2]")).getText();
        String[] MyWantValue = wantValue.split(" ", 2);
        return replaceStr(MyWantValue[0]);
    }

    public void linkSmaller30000() {
        $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div[2]/a[1]")).click();
    }
    public void linkMore30000() throws InterruptedException {
         $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div[2]/a[2]")).click();
//        Thread.sleep(8000);
    }

    public double bankSellValue() throws InterruptedException {
        SelenideElement bankSell = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[3]/div/span"));
        return replaceStr(bankSell.getText());
    }
    public double bankBuy() {
        SelenideElement bankBuy = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/span"));
        return replaceStr(bankBuy.getText());

    }

}
