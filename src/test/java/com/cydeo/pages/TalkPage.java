package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage extends BasePage {




    @FindBy(xpath = "//button[@slot='trigger']")
    public WebElement addButton;
@FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement creatConverssation;
@FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement inputField;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement searchParticipants;
@FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public WebElement grupName;

@FindBy(xpath ="//span[@class='participant-row__user-name']" )
    public List<WebElement> participants;
@FindBy(xpath = "//span[.='Remove participant']")
    public WebElement removeParticipant;

@FindBy(xpath = "//span[@class='user-bubble__title']")
    public List<WebElement> addedNames;

@FindBy(xpath = "//div[@class='new-message-form__advancedinput']")
    public WebElement inputMessage;
@FindBy(xpath = "//div[@class='message-status has-tooltip']")
    public WebElement messageTik;

@FindBy(xpath = "//div[@class='trigger']/button")
    public WebElement grupmodule;
@FindBy(xpath = "//span[.='Delete conversation']")
    public WebElement deleteGroup;
@FindBy(xpath = "//button[.='Yes']")
    public WebElement yesPopup;
@FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public List<WebElement> groups;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public WebElement group;
}
