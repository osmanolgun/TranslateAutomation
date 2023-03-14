package org.example;

import com.deepl.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TranslateWithDeepL {
    public static void main(String[] args) throws InterruptedException, DeepLException {

        //Sayfa Chrome'da açılığ 10 saniye bekleniyor. Tam yüklensin diye.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://itsdev1.onelog.com/itslanguagemanager/edit.aspx?lang=de&product=willow");
        Thread.sleep(10000);

        for (int i = 0; i < 1025; i++) {

            //İngilizce metinleri sayfadan çekiyor
            WebElement englishValue = driver.findElement(
                    By.xpath("(//b[text()='English value:']/..)[" + (i + 1) + "]"));
            String text = englishValue.getText().replace("English value:", "").trim();

            System.out.println(i + 1 + " ----------------------------------");
            System.out.println(text);

            //İngilizce -> Almanca çeviri (DEEPL)
            String authKey = "";
            Translator translator = new Translator(authKey);
            TextResult textResult = translator.translateText(text, LanguageCode.English, LanguageCode.German);
            String translatedText = textResult.getText();
            System.out.println(translatedText);

            //Almanca metinler kutulara giriliyor
            WebElement textArea = driver.findElement(By.xpath("(//textarea)[" + (i + 1) + "]"));
            textArea.clear();
            textArea.sendKeys(translatedText);
        }


        // save butonuna tıklanıyor
        WebElement save = driver.findElement(By.id("save"));
        Thread.sleep(1000);
        save.click();
        //driver.close();
    }
}