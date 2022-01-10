package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CherCherTest {

    /*
    Task1
        1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        2. Click on "Click me to open an alert after 5 seconds"
        3. Explicitly wait until alert is present
        4. Then handle the Javascript alert
     */


    WebDriver driver; //declare our reference for the object
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("edge"); // create the object
        driver.manage().window().maximize();
        //implicitly wait, this is going to be applied to whole tst cases elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void AlertPresentTest () {

        driver.findElement(By.cssSelector("#alert")).click();

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    @Test
    public void disabledButtonTest () {

        WebElement button = driver.findElement(By.id("disable"));

        driver.findElement(By.id("enable-button")).click();

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("Button is enabled go on! "+button.isEnabled());

        Assert.assertTrue(button.isEnabled(), "Verify the button is enabled");

        button.click();

    }
}
