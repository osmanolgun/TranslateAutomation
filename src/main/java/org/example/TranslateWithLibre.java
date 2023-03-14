package org.example;

import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TranslateWithLibre {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://itsdev1.onelog.com/itslanguagemanager/edit.aspx?lang=de&product=willow");
        Thread.sleep(10000);


        for (int i = 0; i <1025 ; i++) {
            WebElement englishValue = driver.findElement(By.xpath("(//b[text()='English value:']/..)[" + (i+1)+ "]"));
            String text = englishValue.getText().replace("English value:","").trim();

            System.out.print(i+1);
            System.out.println(" ----------------------------------");
            System.out.println(text);

            //*******************************************************************************************
            String translatedText = Translator.translate(Language.ENGLISH, Language.GERMAN, text);

            System.out.println(translatedText);


            //*******************************************************************************************

            WebElement textArea = driver.findElement(By.xpath("(//textarea)[" + (i+1)+ "]"));
            textArea.clear();

            textArea.sendKeys(translatedText);

            //*******************************************************************************************

        }

        WebElement save = driver. findElement(By.id("save"));
        //save.click();

        //driver.close();

        //driver.quit();
    }
}