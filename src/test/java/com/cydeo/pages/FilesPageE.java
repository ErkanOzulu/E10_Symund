package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilesPageE extends BasePage {

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFilesTab;

    @FindBy(linkText= "All files")
    public WebElement allFilesTab;

    @FindBy(xpath = "//div[@id='recommendations']//span[@class='name']")
    public List<WebElement> recentFiles;


    @FindBy(xpath = "//div[@id='app-content-files']//span[@class='innernametext']")
    public List<WebElement> allFillesName;

    @FindBy(xpath = "//div[@id=\"app-content-files\"]//tbody[@id='fileList']/tr")
    public List<WebElement> allFilles;

    @FindBy(css = "#rightClickMenu>ul>li[class='action-5']")
    public WebElement deleteButton;

    @FindBy(className = "dirinfo")
    public WebElement infoFilesPage;


}
