package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
