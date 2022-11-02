package com.aqua.TestCases;

import com.aqua.Pages.HomePage;
import com.aqua.Pages.LoginPage;
import com.aqua.Pages.OverviewPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class NewTestCase
{

    WebDriver driver;
    OverviewPage NTC;
    LoginPage login;

    @BeforeEach
    public void SetUp() throws InterruptedException {
    //ChromeDriver definiert
    System.setProperty("webdriver.chrome.driver","C:\\Users\\JohannesWällermann\\Desktop\\SeleniumDriver\\chromedriver.exe");
    driver = new ChromeDriver();
    //Browserfenster Maximieren
    driver.manage().window().maximize();
    //aqua-LoginPage
    String sBaseUrl = "https://aqua-saas2.andagon.com/aquaWebNG/Account/Login?returnUrl=/aquawebng";
    driver.get(sBaseUrl);

    login = new LoginPage(driver);

    //Login mit Standard-Wert
        login.loginValidUser("testuser1@andagon", "Start#123");


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(By.id(("mainNavigationBar_Navigation"))));
    Thread.sleep(1000);
    HomePage HP = new HomePage(driver);
    HP.ClickNavigation();
    //hier erscheint Pop-Up -> refresh mit #
        driver.get("https://aqua-saas2.andagon.com/aquaWebNG/Main/Navigation#");
    }

    @Test
    public void CreateNewTC() throws InterruptedException
    {
    NTC = new OverviewPage(driver);
    NTC.MouseToDropDown();
    NTC.ClickActionTC();
    //Neuer Tab öffnet sich -> Wechsel
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));



    //Wechseln des Tabs zurück
        //driver.close();
        //driver.switchTo().window(tabs2.get(0));
    }

    @AfterEach
    public void tearDown()
    {
    //driver.quit();
    }

}
