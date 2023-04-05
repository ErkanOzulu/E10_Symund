package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {

    public TasksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//div[@class='header-left']/ul/li[12]")
    public WebElement tasksLinkBtn;

@FindBy(xpath = "//*[@id=\"app-navigation-vue\"]/ul/li[7]/a")
    public WebElement addListLinkBtn;

@FindBy(xpath = "//*[@id=\"newListInput\"]")
    public WebElement newListNameInputBox;

@FindBy(xpath = "(//a[@class='app-navigation-entry-link'])[8]")
    public WebElement newListLink;

//@FindBy(xpath = "//button[@aria-controls='menu-iobmo']")
@FindBy(xpath = "//*[@id=\"list_new-task-list\"]/div/div/div/div/button")
public WebElement controlIcon;

//@FindBy(xpath = "(//button[@class='action-button focusable'])[1]")

//@FindBy(xpath = "//*[@id=\"menu-vumxn\"]/li[4]/button")
@FindBy(xpath = "//div[@class='popover__wrapper']/div/div/div/ul/li[4]")
public WebElement deleteBtn;


//After creating task list

@FindBy(xpath = "//input[@id='target']")
public WebElement taskNameInputBox;

@FindBy(xpath = "//div[@class='task-info']")
    public WebElement taskModule;

@FindBy(xpath = "//div[@class='task-checkbox']")
    public WebElement completedTaskCheckBox;

@FindBy(xpath = "//*[@id=\"app-content-vue\"]/div/div[2]/div/h2")
    public WebElement comletedTaskHeader;

@FindBy(xpath = "//button[@class='inline task-star reactive no-nav']")
    public WebElement starIcon;

@FindBy(xpath = "(//a[@class='app-navigation-entry-link'])[1]")
    public WebElement importantTaskModule;

//@FindBy(xpath = "(//div[@class='app-navigation-entry__counter'])[1]")
@FindBy(xpath = "(//div[.=1])[2]")
    public WebElement importantTaskCounter;

@FindBy(xpath = "(//li[@id='collection_current']/div/div)[1]")
    public WebElement currentUncompletedTasksNumber;




}
