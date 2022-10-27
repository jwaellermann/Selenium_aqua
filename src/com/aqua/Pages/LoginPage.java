package com.aqua.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class LoginPage {
    protected WebDriver driver;

    // <input name="user_name" type="text" value="">
    private By usernameBy = By.xpath("//input[@id='UserName']");
    // <input name="password" type="password" value="">
    private By passwordBy = By.xpath("//input[@id='Password']");
    // <input name="sign_in" type="submit" value="SignIn">
    private By signinBy = By.xpath("//button[@id='submitButton']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * Login as valid user
     *
     * @param userName
     * @param password
     *
     */
    public void loginValidUser(String userName, String password)
    {
        driver.findElement(usernameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signinBy).click();

    }
}