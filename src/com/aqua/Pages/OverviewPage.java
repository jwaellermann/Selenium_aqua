package com.aqua.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class OverviewPage
{
    WebDriver driver;
    //Deklarierung der Menüleiste -> NewObjects

    @FindBy (xpath = "//span[contains(text(),'New')]") public WebElement DropDown;
    @FindBy (xpath = "//div[@id='new_test_case']") public WebElement NewTC;
    @FindBy (xpath = "//div[@id='new_defect']") public WebElement NewDF;


    public OverviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Maus bewegt sich zu DropDown-Menü
    public void MouseToDropDown() throws InterruptedException
    {
        Actions action = new Actions(driver);
        action.moveToElement(DropDown).perform();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[@id='new_test_case']"))));
    }
    //Maus klickt auf "NewObject"
    public void ClickActionTC()
    {
        NewTC.click();
    }

    public void ClickActionDF()
    {
        NewDF.click();
    }
}
