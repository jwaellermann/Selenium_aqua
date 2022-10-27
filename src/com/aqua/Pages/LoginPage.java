package com.aqua.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    // <input name="user_name" type="text" value="">
    private By usernameBy = By.xpath("//input[@id='UserName']");
    // <input name="password" type="password" value="">
    private By passwordBy = By.xpath("//input[@id='Password']");
    // <input name="sign_in" type="submit" value="SignIn">
    private By signinBy = By.xpath("//button[@id='submitButton']");


    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void loginValidUser(String userName, String password)
    {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signinBy).click();

    }
}