package com.aqua.TestCases;


import com.aqua.Pages.HomePage;
import com.aqua.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageNavigation
{
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException
    {
        //ChromeDriver definiert
        System.setProperty("webdriver.chrome.driver","C:\\Users\\JohannesWällermann\\Desktop\\SeleniumDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //Browserfenster Maximieren
        driver.manage().window().maximize();
        //aqua-Start-Seite
        driver.get("https://aqua-saas2.andagon.com/aquaWebNG/Account/Login?returnUrl=/aquawebng");

        LoginPage login = new LoginPage(driver);

        //Login mit Standard-Wert
        login.loginValidUser("testuser1@andagon", "Start#123");


    }


    @Test
    public void GoToNav() throws InterruptedException
    {

        //w8 for Element (aka das Element, worauf ich warte)

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement NavButton = driver.findElement(By.id("mainNavigationBar_Navigation"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(("mainNavigationBar_Navigation"))));

        HomePage HP = new HomePage(driver);
        HP.ClickNavigation();

        //Assertion
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='aq-pfl__title']")));
        WebElement Favorite = driver.findElement(By.xpath("//span[@class='aq-pfl__title']"));
        Assertions.assertTrue(Favorite.isDisplayed());

    }


    @After
    public void TearDown()
    {
        driver.close();
    }


}
