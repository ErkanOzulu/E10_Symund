package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(xpath = "//input[@id='contact-org']")
    public WebElement inputCompany;

    @FindBy(xpath = "//input[@id='contact-title']")
    public WebElement inputTitle;

    @FindBy(xpath = "//button[@id='new-contact-button']")
    public WebElement newContactButton;

    @FindBy(xpath = "//input[@id='contact-fullname']")
    public WebElement inputFullName;

    @FindBy(xpath = "//input[@id='contact-avatar-upload']/../div/div")
    public WebElement initials;

    @FindBy(xpath = "//div[@id='contacts-list']//div[@class='unknown']")
    public List<WebElement> initialsList;

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> fullNameList;

    @FindBy(xpath = "(//a[@class='app-navigation-entry-link'])[1]")
    public WebElement allContacts;


    @FindBy(xpath = "//div[@class='action-item header-menu']/div/div/button")
    public WebElement threeDotButton;

    @FindBy(xpath = "//button//span[.='Delete']")
    public WebElement deleteButton;
}
