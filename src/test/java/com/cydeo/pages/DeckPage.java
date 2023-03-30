package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeckPage extends BasePage{

    public DeckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class=\"app-navigation-toggle\"]")
    public WebElement threeLineButton;

    @FindBy(xpath = "//a[@class=\"app-navigation-entry-link\"]")
    public WebElement addBoardButton;

     @FindBy(xpath = "//a[@placeholder=\"Board name\"]")
    public WebElement inputBoardNameBox;




}
