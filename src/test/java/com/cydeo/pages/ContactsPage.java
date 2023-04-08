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

    @FindBy(css = ".app-content-list-item-line-one")
    public List<WebElement> fullNameList;

    @FindBy(xpath = "(//a[@class='app-navigation-entry-link'])[1]")
    public WebElement allContacts;

    @FindBy(xpath = "(//div[@class='app-navigation-entry__utils']/div)[1]")
    public WebElement allContactsNumber;


    @FindBy(xpath = "//div[@class='action-item header-menu']/div/div/button")
    public WebElement threeDotButton;

    @FindBy(xpath = "//button//span[.='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@id='app-navigation-vue']/a")
    public WebElement appNavToggle;


    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement pictureIcon;
    @FindBy(xpath = "//span[.='Choose from Files']/..")
    public WebElement Choosefromfilesbutton;
    @FindBy(xpath = "(//td[@class='filename'])[3]")
    public WebElement picture_jpg;
    @FindBy(xpath = "//button[.='Choose']")
    public WebElement choose_button;
    @FindBy(xpath = "//button[@aria-controls='menu-smmlf']")
    public WebElement three_dot_button;
    @FindBy(xpath = "(//span[@class='action-button__icon icon-delete'])[5]/..")
    public WebElement delete_button;
@FindBy(xpath = "//div[contains(@style,'background-image')]")
    public WebElement verifyPicture;


}
