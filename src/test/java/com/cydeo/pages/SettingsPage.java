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


    public void verifySettingDashboard(String settingDashboard){
        if(settingDashboard.equals("name")){
            WebElement verifySettingDashboardelement =  Driver.getDriver().findElement
                    ( By.xpath("//label[@for='displayname']"));
            String actualverify = verifySettingDashboardelement.getText().toLowerCase();
            System.out.println(actualverify);
            System.out.println(settingDashboard);
            Assert.assertTrue(actualverify.contains(settingDashboard));

        }else{
        WebElement verifySettingDashboardelement = 
                Driver.getDriver().findElement(By.xpath("//form[@id='"+settingDashboard.toLowerCase()+"form']"));
        String actualverify = verifySettingDashboardelement.getText().toLowerCase();
        System.out.println(actualverify);
        System.out.println(settingDashboard);
        Assert.assertTrue(actualverify.contains(settingDashboard));}

    }
}
