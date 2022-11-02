package com.aqua.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Home Page
 */

public class HomePage
{
    WebDriver driver;
    //Deklarierung der Menüleiste, nur "Navigation interessiert uns"
    private By NavigationBy = By.id("mainNavigationBar_Navigation");
    private By OptionsBy = By.xpath("//div[@class='aq-user-picture has-picture']");
    private By LogoutBy = By.xpath("//li[contains(text(),'Logout')]");

    public HomePage(WebDriver driver)
    {
       this.driver = driver;
    }

    public void ClickNavigation()
    {
        driver.findElement(NavigationBy).click();
    }






  /* More methods offering the services represented by Home Page
  of Logged User. These methods in turn might return more Page Objects
  for example click on Compose mail button could return ComposeMail class object */
}