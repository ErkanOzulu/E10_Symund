package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeletedFilesPage extends FilesPageE {

    public DeletedFilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//div[@id='app-content-trashbin']/div[3]/h2")
    public WebElement noDeletedFiles;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//span[@class='innernametext']")
    public List<WebElement> alldeletedFilesName;

   @FindBy(xpath = " //div[@id='app-content-trashbin']//td[@class='date']/span")
   public List<WebElement> alldeletedFilesDate;

    @FindBy(xpath = "//div[@id='app-content-trashbin']/table/thead/tr/th")
    public List<WebElement>order;

    @FindBy(xpath = "(//span[@class='dirinfo'])[2]")
    public WebElement info;

}
