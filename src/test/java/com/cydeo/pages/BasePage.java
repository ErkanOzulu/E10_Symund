package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    /*
    In this class we will store WebElements common to all pages
     */

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@id=\"expanddiv\"]/ul/li[4]/a")
    public WebElement logOutButton;

    @FindBy(xpath = "//h2[contains(.,'Good afternoon')]")
    public WebElement header;

    @FindBy(id="settings")
    public WebElement accountSetting;

    public void LogOut(){

        accountSetting.click();
        logOutButton.click();
}

public void navigateToModule(String module){

        String moduleLocator="//li[@data-id='"+module.toLowerCase()+"']";
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();

}


}
