package ru.vtb.benedis;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ru.vrb.benedis.ConvertorTest.replaceStr;

public class VtbConvertor {

    private ConvertorTest page;
   
    @BeforeClass
    public void before() {
        page = ConvertorTest.getExchangePage();
        $x("//*[@id=\"cookiemsgoffpls\"]/p[1]").click();
    }

   @Test
    public void smaller30000RubWithUsd() throws InterruptedException {
        String rur = "3000";
        page.parentInput1();
        page.input1().clear();
        page.setValueInput(page.input1(), rur);
        page.selectCurrency1Click();
        page.selectedFieldRurInput1();
        page.input2().click();
        page.selectCurrency2Click();
        page.selectedFieldUsdInput2();
        page.input2().getValue();
        page.linkSmaller30000();
        page.bankSellValue();
        page.wantValue();
        Assert.assertEquals(page.wantValue(), page.bankSellValue(), 0.0);
    }

    @Test
    public void smaller30000UsdWithRub() throws InterruptedException {
        String usd = "3000";
        page.parentInput1();
        page.input1();
        page.input1().clear();
        page.setValueInput(page.input1(), usd);
        page.selectCurrency1ForUsd();
        page.linkSmaller30000();
        page.bankBuy();
        double MyBankValue = replaceStr(page.selectCurrency1ForUsd());
        System.out.println(MyBankValue);
        System.out.println(page.bankBuy());
        Assert.assertEquals(MyBankValue,  page.bankBuy(), 0.0);
    }

    @Test
    public void more30000RubWithUsd() throws InterruptedException {
        SelenideElement parentInput1 = $x("//*[@id=\"method1\"]/../..");
        parentInput1.click();
        SelenideElement input1 = $(By.xpath("//input[@id=\"method1\"]"));
        input1.click();
        input1.clear();
//        input1.setValue("30000");
        Thread.sleep(3000);
        input1.sendKeys("30000000");
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]//span//li[1]")).click();
        Thread.sleep(3000);
        SelenideElement parentInput2 = $x("//*[@id=\"method2\"]");
        parentInput2.click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]//span//li[3]")).click();
        String wantValue = $(By.xpath("//*[@id=\"method1\"]/../../../../div[2]/div[2]")).getText();
        String[] MyWantValue = wantValue.split(" ", 2);
        Thread.sleep(5000);
        SelenideElement linkMore30000 = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div[2]/a[2]"));
        linkMore30000.click();
        Thread.sleep(5000);
        SelenideElement bankSell = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[3]/div/span"));
        double bankSellValue = replaceStr(bankSell.getText());
        double MyBankValue = replaceStr(MyWantValue[0]);
        System.out.println(bankSellValue);
        System.out.println(MyBankValue);
        Assert.assertEquals(MyBankValue, bankSellValue, 0.0);
    }

    @Test
    public void more30000UsdWithRub() throws InterruptedException {
        SelenideElement parentInput1 = $x("//*[@id=\"method1\"]/../..");
        parentInput1.click();
        SelenideElement input1 = $(By.xpath("//input[@id=\"method1\"]"));
        input1.click();
        input1.clear();
        Thread.sleep(3000);
        input1.sendKeys("50000");
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
        String myWantValue = wantValue.replace(",",".").replaceAll("\\s+","").replaceAll("\u00a0", "").split("=",2)[1].split("₽",2)[0];

        SelenideElement linkMore30000 = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div[2]/a[2]"));
        linkMore30000.click();

        SelenideElement bankBuy = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/span"));
        double bankSellValue = replaceStr(bankBuy.getText());
        double MyBankValue = replaceStr(myWantValue);
        System.out.println(bankSellValue);
        System.out.println(MyBankValue);

        Assert.assertEquals(MyBankValue, bankSellValue, 0.0);
    }

    @Test
    public void more30000RubWithEur() throws InterruptedException {
        SelenideElement parentInput1 = $x("//*[@id=\"method1\"]/../..");
        parentInput1.click();
        SelenideElement input1 = $(By.xpath("//input[@id=\"method1\"]"));
        input1.click();
        input1.clear();
        Thread.sleep(3000);

        input1.sendKeys("30000000");
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method1\"]/../..//div[3]//span//li[1]")).click();
        Thread.sleep(3000);

        SelenideElement parentInput2 = $x("//*[@id=\"method2\"]");
        parentInput2.click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]")).click();
        $(By.xpath("//*[@id=\"method2\"]/../..//div[3]//span//li[2]")).click();

        Thread.sleep(3000);
        String wantValue = $(By.xpath("//*[@id=\"method1\"]/../../../../div[2]/div[2]")).getText();
        String[] MyWantValue = wantValue.split(" ", 2);

        SelenideElement linkMore30000 = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[3]/td[1]/div[2]/a[2]"));
        linkMore30000.click();
        SelenideElement bankSell = $(By.xpath("/html/body/main/div/section[5]/div/div/div/div[2]/div/div[1]/div/section[1]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[3]/td[3]/div/span"));
        double bankSellValue = replaceStr(bankSell.getText());
        double MyBankValue = replaceStr(MyWantValue[0]);
        System.out.println(bankSellValue);
        System.out.println(MyBankValue);
        Assert.assertEquals(MyBankValue, bankSellValue, 0.0);
    }



}
