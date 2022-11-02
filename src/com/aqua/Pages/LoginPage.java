package com.aqua.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;

    //Deklarierung der benötigten WebElemente
   @FindBy (xpath="//input[@id='UserName']") public WebElement username;

   @FindBy (xpath="//input[@id='Password']") public WebElement passWord;

   @FindBy (xpath="//button[@id='submitButton']") public WebElement signin;




    public LoginPage(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginValidUser(String userName, String password)
    {

        username.sendKeys(userName);
        passWord.sendKeys(password);
        signin.click();

    }

}