package com.aqua.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTCPage {
    WebDriver driver;
    //Deklarierung der Testfall-Seite

    @FindBy (xpath = "//div[@class='cke_textarea_inline cke_editable cke_editable_inline cke_contents_ltr cke_show_borders cke_focus']") public WebElement Description;
    @FindBy (xpath = "//div[@id='rbn_itm_save']") public WebElement SaveButton;
    @FindBy (xpath = "//div[@id='rbn_itm_close']") public WebElement CloseButton;
    @FindBy (xpath = "//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']//div[@class='dx-texteditor-container']//div[@class='dx-texteditor-input-container']//input[@type='text']") public WebElement StatusDD;
    @FindBy (xpath = "//div[@id='Significance']//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']//div[@class='dx-texteditor-container']//div[@class='dx-texteditor-input-container']//input[@type='text']") public WebElement SignifikanzDD;
    @FindBy (xpath = "//input[@id='Priority']") public WebElement PriorityDD;



    public NewTCPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Maus bewegt sich zu DropDown-Menü
    public void MouseToDropDown()
    {
        //driver.findElement(DropDownNewBy).moveToElement();
    }
    //Maus klickt auf "NewObject"
    public void ClickAction(String NewObject)
    {
        //WebElement NewAction = driver.findElement(NewObject).click();
    }
}
