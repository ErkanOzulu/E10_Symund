package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage{


    @FindBy(xpath = "//span[.=\"Day\"]")
    public WebElement dayButton;

    @FindBy(xpath = "//span[.=\"Week\"]")
    public WebElement weekButton;

    @FindBy(xpath = "//span[.=\"Month\"]")
    public WebElement monthButton;

    @FindBy(xpath = "(//li[@class=\"action active\"]//span)[2]")
    public WebElement selectedButton;

    @FindBy(css = "[aria-label = 'Actions']")
    public WebElement menuToggleViewButton;

    @FindBy(xpath = "//button[contains(@class,'new-event')]")
    public WebElement newEventButton;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitleInputBox;

    @FindBy(xpath = "(//input[@name='date'])[2]")
    public WebElement inputDateFrom;

    @FindBy(xpath = "(//input[@name='date'])[3]")
    public WebElement inputDateTo;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='fc-event-title']")
    public List<WebElement> eventTitleContainer;

    @FindBy(css = "div.fc-event-title")
    public WebElement eventTitle;

    @FindBy(xpath = "(//div[@class='event-popover__buttons'])/button")
    public WebElement moreButton;

    @FindBy(xpath = "(//div[@class='trigger'])[9]")
    public WebElement menuToggleForDelete;

    @FindBy(xpath = "(//span[@class='action-button__text'])[5]")
    public WebElement deleteButton;


    @FindBy(xpath = "//span[@title='Personal']")
    public WebElement personalCheckBox;





}
