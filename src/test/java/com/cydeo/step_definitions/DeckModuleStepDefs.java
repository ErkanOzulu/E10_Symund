package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.DeckPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DeckModuleStepDefs {

    DeckPage deckPage = new DeckPage();
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @When("User can see the three-line button and click it")
    public void user_can_see_the_three_line_button_and_click_it() {
        deckPage.threeLineButton.isDisplayed();
        deckPage.threeLineButton.click();

    }

    @When("User see the opened sidebar")
    public void user_see_the_opened_sidebar() {
        String actualAriaExpanded = deckPage.threeLineButton.getAttribute("aria-expanded");
        String expectedAriaExpended = "true";
        Assert.assertEquals(actualAriaExpanded, expectedAriaExpended);
    }

    @When("User see the add-board button and click it")
    public void user_see_the_add_board_button_and_click_it() {
        deckPage.addBoardButton.isDisplayed();
        deckPage.addBoardButton.click();
    }

    @And("User sees the popup box and enters the {string}")
    public void userSeesThePopupBoxAndEntersThe(String string) {
        deckPage.inputBoardNameBox.isDisplayed();
        deckPage.inputBoardNameBox.sendKeys(string);
    }

    @And("User click the submit button")
    public void userClickTheSubmitButton() {
        deckPage.inputBoardNameSubmitButton.click();
    }


    @Then("User can see the created {string} on the side bar")
    public void userCanSeeTheCreatedOnTheSideBar(String expectedTitle) {
        String boardLocaterText = "//span[@title='" + expectedTitle + "']";
        WebElement boardAddedVerifyButton = Driver.getDriver().findElement(By.xpath(boardLocaterText));

        String actualTitle = boardAddedVerifyButton.getAttribute("title");

        Assert.assertEquals(actualTitle, expectedTitle);
    }



    @And("User see and click the + add list button")
    public void user_see_and_click_the_button() {

        String actualAddButton = deckPage.addListButton.getAttribute("textContent");
        String expectedAddButton = "Add list";
        Assert.assertTrue(actualAddButton.contains(expectedAddButton));
        deckPage.addListButton.click();

    }

    @When("User write the {string} in the windows that opens and presses enter")
    public void user_write_the_in_the_windows_that_opens_and_presses_enter(String string) {
        deckPage.addListNameBox.sendKeys(string + Keys.ENTER);
    }

    @Then("User see the {string} under board name")
    public void user_see_the_under_board_name(String listName) {
        String listNameWebElementText = "//h3[contains(text(),'"+ listName +"')]";
        BrowserUtils.sleep(3);
        WebElement board = Driver.getDriver().findElement(By.xpath( listNameWebElementText ) );
        Assert.assertEquals(board.getText(),listName);
    }


    @When("User is on the Deck page and created {string} board")
    public void userIsOnTheDeckPageAndCreatedBoard(String boardName) {
        deckPage.createBoardBeforeScenarioDeckModule(boardName);
    }

    @When("User click the add list button, created the {string} list and click add card button")
    public void user_click_the_add_list_button_and_created_the_list(String string) {
        deckPage.createdMainTeamListBeforeScenario(string);
    }


    @When("User see the input card name box under {string} and write the {string} and presses enter from keyboard")
    public void user_see_the_input_card_name_box_under_and_write_the_and_presses_enter_from_keyboard(String listName, String cardName) {
            deckPage.createCardName(listName,cardName);
    }

    @Then("User see the {string} under {string} list")
    public void user_see_the_under_list(String cardName, String listName) {
        deckPage.cardNameCreatedUnderRightListVerify(cardName,listName);
    }


}
