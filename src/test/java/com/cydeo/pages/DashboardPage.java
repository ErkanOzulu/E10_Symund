package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{



    @FindBy(id="settings")
    public WebElement accountSetting;

    public void LogOut(){

        accountSetting.click();
        logOutButton.click();
    }


}
