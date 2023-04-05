package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilesPageE extends BasePage {

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFiles;

    @FindBy(css="#app-navigation-toggle")
    public WebElement iconMenu;

    @FindBy(xpath = "//div[@id='recommendations']//span[@class='name']")
    public List<WebElement> recentFiles;


    @FindBy(xpath = "//div[@id='app-content-files']//span[@class='innernametext']")
    public List<WebElement>allFilles;

    @FindBy(css = "#rightClickMenu>ul>li[class='action-5']")
    public WebElement deleteButton;


}
