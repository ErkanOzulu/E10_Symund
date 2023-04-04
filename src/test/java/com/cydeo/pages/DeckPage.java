package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeckPage extends BasePage{

    public DeckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@class=\"app-navigation-toggle\"]")
    public WebElement threeLineButton;

    @FindBy(xpath = "//*[@title=\"Add board\"]")
    public WebElement addBoardButton;

     @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBoardNameBox;

    @FindBy(xpath = "//input[@class=\"icon-confirm\"]")
    public WebElement inputBoardNameSubmitButton;

    @FindBy(xpath = "(//button[@class=\"action-item action-item--single icon-add undefined undefined has-tooltip\"])[1]")
    public WebElement addListButton;

    @FindBy(xpath = "//input[@id=\"new-stack-input-main\"]")
    public WebElement addListNameBox;

    @FindBy(xpath = "(//span[@class=\"app-navigation-entry__title\"])[3]")
    public WebElement firstBoard;




    public void createBoardBeforeScenarioDeckModule(String str){

        DeckPage deckPage = new DeckPage();
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        String module = "deck";
        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();
        dashboardPage.navigateToModule(module);
        deckPage.threeLineButton.click();
        BrowserUtils.sleep(3);
        System.out.println("firstBoard.getText() = " + firstBoard.getText());
        boolean created = firstBoard.getAttribute("title").contains(str);
        if ( created ) {
            firstBoard.click();
        }else{
            deckPage.addBoardButton.click();
            deckPage.inputBoardNameBox.sendKeys(str);
            deckPage.inputBoardNameSubmitButton.click();
            Driver.getDriver().navigate().refresh();
            BrowserUtils.sleep(3);
            firstBoard.click();
        }


    }


}
