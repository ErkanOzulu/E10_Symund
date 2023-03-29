package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    /*
    In this class we will store WebElements common to all pages
     */

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "[data-id='logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//div[@id='app-dashboard']/h2")
    public WebElement header;

    @FindBy(className ="notifications")
    public WebElement notification;

    @FindBy(id ="unified-search")
    public WebElement search;

    @FindBy(id ="contactsmenu")
    public WebElement searchContact;


public void navigateToModule(String module){

        String moduleLocator="//li[@data-id='"+module.toLowerCase()+"']";
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();

}



}
