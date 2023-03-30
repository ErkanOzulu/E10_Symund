package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {

    public TasksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "(//a[@aria-label='Tasks'])[1]")
    public WebElement tasksLinkBtn;

@FindBy(xpath = "//*[@id=\"app-navigation-vue\"]/ul/li[7]/a")
    public WebElement addListLinkBtn;

@FindBy(xpath = "//*[@id=\"newListInput\"]")
    public WebElement newListNameInputBox;

@FindBy(xpath = "(//a[@class='app-navigation-entry-link'])[8]")
    public WebElement newListLink;

//After creating task list

@FindBy(xpath = "//input[@id='target']")
public WebElement taskNameInputBox;

@FindBy(xpath = "//div[@class='task-info']")
    public WebElement taskModule;




}
