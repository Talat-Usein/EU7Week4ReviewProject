package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class WebDriverFactory {
    public static WebDriver getDriver (String BrowserType) {
        WebDriver driver = null;

        switch (BrowserType.toLowerCase()){
            case "edge":
                if(!getOS().toLowerCase().contains("windows")) {
                    return null;
                }else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }

                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                if(!getOS().toLowerCase().contains("os x")||getOS().toLowerCase().contains("mac os")) {
                    return null;
                }else {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
        }
        return driver;
    }

    public static String getOS () {
        String os = System.getProperty("os.name");
        return os;
    }
}
