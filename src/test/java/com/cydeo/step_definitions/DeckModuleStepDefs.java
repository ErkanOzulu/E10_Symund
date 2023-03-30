package com.cydeo.step_definitions;

import com.cydeo.pages.DeckPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeckModuleStepDefs {

    DeckPage deckPage = new DeckPage();


    @When("User can see the three-line button and click it")
    public void user_can_see_the_three_line_button_and_click_it() {
        deckPage.threeLineButton.isDisplayed();
        deckPage.threeLineButton.click();

    }
    @When("User see the opened sidebar")
    public void user_see_the_opened_sidebar() {
        String actualAriaExpanded = deckPage.threeLineButton.getAttribute("aria-expanded" );
        String expectedAriaExpended = "true";
        Assert.assertEquals(actualAriaExpanded,expectedAriaExpended);
    }
    @When("User see the add-board button and click it")
    public void user_see_the_add_board_button_and_click_it() {
        deckPage.addBoardButton.isDisplayed();
        deckPage.addBoardButton.click();
    }
    @When("User sees the popup box and enters the <{string}>")
    public void user_sees_the_popup_box_and_enters_the(String string) {
        deckPage.inputBoardNameBox.isDisplayed();
        deckPage.inputBoardNameBox.sendKeys(string);
    }

    @And("User click the submit button")
    public void userClickTheSubmitButton() {
        deckPage.inputBoardNameSubmitButton.click();
    }

    @Then("User can see the created <{string}> on the side bar")
    public void user_can_see_the_created_on_the_side_bar(String expectedTitle) {
        String actualTitle = deckPage.boardAddedVerifyButton.getAttribute("title");
    }


}
