package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//div[@id=\"stack-add\"]/button")
    public WebElement addListButton;

    @FindBy(xpath = "//input[@id=\"new-stack-input-main\"]")
    public WebElement addListNameBox;

    @FindBy(xpath = "(//span[@class=\"app-navigation-entry__title\"])[3]")
    public WebElement firstBoard;

    @FindBy(xpath = "(//button[@aria-expanded=\"false\"])[5]")
    public WebElement threeDotsButtonUnderCard;

    @FindBy(xpath = "//span[text()='Assign to me']")
    public WebElement assignToMeButton;

    @FindBy(xpath = "//div[@data-original-title=\"null\"]")
    public WebElement assignedToMeImage;

    @FindBy(xpath = "(//div[@class=\"smooth-dnd-container vertical\"])[2]")
    public WebElement secondListArea;


    public void createBoardBeforeScenarioDeckModule(String boardName){

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
        boolean created = firstBoard.getAttribute("title").contains(boardName);
        if ( created ) {
            firstBoard.click();
        }else{
            deckPage.addBoardButton.click();
            BrowserUtils.sleep(2);
            deckPage.inputBoardNameBox.sendKeys(boardName);
            deckPage.inputBoardNameSubmitButton.click();
            Driver.getDriver().navigate().refresh();
            BrowserUtils.sleep(3);
            firstBoard.click();
        }
    }

    public boolean listNameIsDisplayed(String listName) {
        String xpathForList = "//h3[contains(text(), '" + listName + "')]";
        try {
            boolean listNameCreatedBefore = Driver.getDriver().findElement(By.xpath(xpathForList)).getText().contains(listName);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void createdMainTeamListBeforeScenario(String listName){

        DeckPage deckPage = new DeckPage();
        String addCardButtonLocatorText = "//h3[contains(text(), '" + listName + "')]/../button";

        if (listNameIsDisplayed(listName)){
            WebElement addCardButton = Driver.getDriver().findElement(By.xpath(addCardButtonLocatorText));
            addCardButton.click();
        }else {
            deckPage.addListButton.click();
            deckPage.addListNameBox.sendKeys(listName + Keys.ENTER);
            Driver.getDriver().navigate().refresh();
            BrowserUtils.sleep(3);
            WebElement addCardButton = Driver.getDriver().findElement(By.xpath(addCardButtonLocatorText));
            addCardButton.click();
        }
    }

    public void createCardName(String listName, String cardName){

        String enterCardNameBoxText = "((//h3[contains(text(),'" + listName + "')]/../../div)[2]//input)[1]";
        WebElement enterCardNameBoxUnderRightListBox = Driver.getDriver().findElement(By.xpath(enterCardNameBoxText));
        enterCardNameBoxUnderRightListBox.sendKeys(cardName + Keys.ENTER);
    }

    public void cardNameCreatedUnderRightListVerify(String cardName, String listName){

        String cardNameUnderListNameText = "//span[contains(text(),'"+ cardName +"')]/../../../../../../../div/h3";
        BrowserUtils.sleep(3);
        WebElement cardNameUnderListName = Driver.getDriver().findElement(By.xpath(cardNameUnderListNameText));
        System.out.println("cardNameUnderListName.getText() = " + cardNameUnderListName.getText());
        System.out.println("listName = " + listName);
        Assert.assertTrue(cardNameUnderListName.getText().contains(listName));

    }





}
