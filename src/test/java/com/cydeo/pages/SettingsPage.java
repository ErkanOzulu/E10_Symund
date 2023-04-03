package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='settings']/div/div")
    public WebElement settingsImg;
    @FindBy(linkText = "Settings")
    public WebElement settingIcon;
    @FindBy(xpath = "//input[@name='displayname']")
    public WebElement fullName;
    @FindBy(xpath = "//nav[@id='expanddiv']/ul/li/div/span")
    public WebElement settingsMenu;

    @FindBy(xpath = "//form[@id='phoneform']/h3/div")
    public WebElement phoneLockIcon;
    @FindBy(xpath = "//form[@id='phoneform']/h3/div/div/ul/li/a/p/strong")
    public WebElement phonePrivate;
    @FindBy(id="localeexample")
    public WebElement timeOfSettngs;

    public void verifySettingDashboard(String settingDashboard){
        if(settingDashboard.equals("name")){
            WebElement verifySettingDashboardelement =  Driver.getDriver().findElement
                    ( By.xpath("//label[@for='displayname']"));
            String actualverify = verifySettingDashboardelement.getText().toLowerCase();
            Assert.assertTrue(actualverify.contains(settingDashboard));

        }else{
        WebElement verifySettingDashboardelement = 
                Driver.getDriver().findElement(By.xpath("//form[@id='"+settingDashboard.toLowerCase()+"form']"));
        String actualverify = verifySettingDashboardelement.getText().toLowerCase();
        Assert.assertTrue(actualverify.contains(settingDashboard));}

    }
}
