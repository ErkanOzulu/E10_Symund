package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "submit-form")
    public WebElement logInButton;
    @FindBy(css = "#lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(css = "#reset-password-submit")
    public WebElement resetButton;
    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongMessage;

    @FindBy(className = "toggle-password")
    public WebElement eyeSign;

    public void login() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        logInButton.click();
    }


    @FindBy(xpath = "//nav[@id='expanddiv']/ul//a")
    public List<WebElement> list;


}
