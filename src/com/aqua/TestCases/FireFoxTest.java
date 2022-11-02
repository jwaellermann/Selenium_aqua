package com.aqua.TestCases;


import com.aqua.Pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class FireFoxTest
{
    WebDriver gDriver;
    LoginPage login;

    @BeforeEach
    public void SetUp()
    {
        //ChromeDriver definiert
        System.setProperty("webdriver.gecko.driver","C:\\Users\\JohannesWällermann\\Desktop\\SeleniumDriver\\geckodriver.exe");
        gDriver = new FirefoxDriver();
        //Browserfenster Maximieren
        gDriver.manage().window().maximize();
        //aqua-LoginPage
        String sBaseUrl = "https://aqua-saas2.andagon.com/aquaWebNG/Account/Login?returnUrl=/aquawebng";
        gDriver.get(sBaseUrl);

    }

    @Test
    public void LoginFirefox()
    {
        login = new LoginPage(gDriver);

        //Login mit Standard-Wert
        login.loginValidUser("testuser1@andagon", "Start#123");


        //Assertion
        WebDriverWait wait = new WebDriverWait(gDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Navigation')]")));
        WebElement Title = gDriver.findElement(By.xpath("//input[@class='title']"));
        Assertions.assertTrue(Title.isDisplayed());



    }
    @AfterEach
    public void tearDown()
    {
        gDriver.quit();
    }


}