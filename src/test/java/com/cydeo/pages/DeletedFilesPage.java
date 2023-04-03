package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.cert.X509Certificate;
import java.util.List;

public class DeletedFilesPage extends FilesPageE {

    public DeletedFilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private String selectedFile;
    private String selectedFileId;

    public String getSelectedFile() {
        return selectedFile;
    }

    public String getSelectedFileId() {
        return selectedFileId;
    }

    @FindBy(xpath = "//div[@id='app-content-trashbin']/div[3]/h2")
    public WebElement noDeletedFiles;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody//tr")
    public List<WebElement> allDeletedFiles;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//span[@class='innernametext']")
    public List<WebElement> alldeletedFilesName;

    @FindBy(xpath = " //div[@id='app-content-trashbin']//td[@class='date']/span")
    public List<WebElement> alldeletedFilesDate;

    @FindBy(xpath = "//div[@id='app-content-trashbin']/table/thead/tr/th")
    public List<WebElement> order;

    @FindBy(xpath = "(//span[@class='dirinfo'])[2]")
    public WebElement info;

    @FindBy(xpath = "(//span[.='Delete permanently'])[2]")
    public WebElement deletePermanently;

    public void clickThreedot(String fileName) {
        String three = "//div[@id='app-content-trashbin']//tbody//tr[contains(@data-path,'" + fileName + "')]//span[@class='fileactions']/a[2]";

        WebElement threeDot = Driver.getDriver().findElement(By.xpath(three));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(threeDot));

        threeDot.click();

        selectedFile= "//div[@id='app-content-trashbin']//tbody//tr[contains(@data-path,'" + fileName + "')]";
        selectedFileId = Driver.getDriver().findElement(By.xpath(selectedFile)).getAttribute("data-id");

    }


    public void clickRestore(String fileName) {


        selectedFile= "//div[@id='app-content-trashbin']//tbody//tr[contains(@data-path,'" + fileName + "')]";
        selectedFileId = Driver.getDriver().findElement(By.xpath(selectedFile)).getAttribute("data-id");

        String restore = "//div[@id='app-content-trashbin']//tbody//tr[contains(@data-path,'" + fileName + "')]//span[@class='fileactions']/a[1]";

        Driver.getDriver().findElement(By.xpath(restore)).click();



    }


}
