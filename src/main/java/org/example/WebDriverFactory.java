package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public static WebDriver getDriver (String browserType) {
        WebDriver driver=null;

        switch (browserType.toLowerCase()) {
            case "chrome"   :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(); break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox"  :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();break;
            case "edge"     :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();break;
            case "opera"     :
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();break;
            default:
        }
        if(driver !=null) driver.manage().window().maximize();
        return driver;
    }
}
