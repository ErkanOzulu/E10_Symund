package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
