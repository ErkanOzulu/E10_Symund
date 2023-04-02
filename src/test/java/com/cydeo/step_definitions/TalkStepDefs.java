package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.TalkPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TalkStepDefs {

    TalkPage talkPage =new TalkPage();
    @When("User click talk module")
    public void userClickTalkModule() {

      talkPage.navigateToModule("spreed");
    }

    @When("user click add button")
    public void userClickAddButton() {
        talkPage.addButton.click();
    }

    @And("User click add participants button")
    public void userClickAddParticipantsButton() {
talkPage.creatConverssation.click();
    }



    @And("User add participants that have name as below")
    public void userAddParticipantsThatHaveNameAsBelow(List<String> participants) {


        for (String s : participants) {
            talkPage.searchParticipants.clear();
            talkPage.searchParticipants.sendKeys(s);
            String addPart="//*[.='"+s+"']";

            WebElement tab = Driver.getDriver().findElement(By.xpath(addPart));
            tab.click();
        }
    }

    @And("User click create Conversation button")
    public void UserClickCreateConversationButton() {

        talkPage.creatConverssation.click();
        BrowserUtils.waitFor(3);
    }

    @And("user enter {string} as Conversation name on displayed field")
    public void userEnterAsConversationNameOnDisplayedField(String conName) {
        talkPage.inputField.sendKeys(conName);

    }

    @And("User verify group name {string}")
    public void userVerifyGroupName(String groupName) {
        Assert.assertEquals(groupName,talkPage.grupName.getText());
    }


    @And("user click trash button from opened moudle")
    public void userClickTrashButtonFromOpenedMoudle() {
        talkPage.removeParticipant.click();
    }

    @Then("user should verify that deleted partisipant name doesn't displey anymore")
    public void userShouldVerifyThatDeletedPartisipantNameDoesnTDispleyAnymore() {

    }

    @And("user click settings modul near the paricipant {string}")
    public void userClickThreePointModulNearTheParicipant(String partisipant) throws InterruptedException {
BrowserUtils.waitFor(5);
       String moduleLocator="//button[@aria-label='Settings for participant \""+partisipant+"\"']";
        //li[@data-id='"+module.toLowerCase()+"']

       Driver.getDriver().findElement(By.xpath(moduleLocator)).click();


    }

    @Then("user should verify that {string} name doesn't displey anymore")
    public void userShouldVerifyThatNameDoesnTDispleyAnymore(String deletedParticipand) {
        BrowserUtils.waitFor(5);
        List<String> part=new ArrayList<>();
        for (WebElement participant : talkPage.participants) {
            part.add(participant.getText());
        }
        for (String participant : part) {
            Assert.assertFalse(participant.contains(deletedParticipand));
        }

    }

    @Then("Verify user should  see the added participants  on the right-hand menu")
    public void verifyUserShouldSeeTheAddedParticipantsOnTheRightHandMenu() {
        BrowserUtils.waitFor(5);
        List<String> part1=new ArrayList<>();
        for (WebElement participant : talkPage.addedNames) {
            part1.add(participant.getText());
        }
        List<String> part=new ArrayList<>();
        for (WebElement participant : talkPage.participants) {
            part.add(participant.getText());
        }

        for (String participant : part1) {
            Assert.assertTrue(part.contains(participant));
        }
    }


    @When("User type {string} inside inputbox and enter")
    public void userTypeInsideInputboxAndEnter(String message) {
talkPage.inputMessage.sendKeys(message+ Keys.ENTER);

    }

    @Then("Verify the message should be seen on the chat screen")
    public void verifyTheMessageShouldBeSeenOnTheChatScreen() {

Assert.assertTrue(talkPage.messageTik.isDisplayed());
    }


    @And("User click trash button opening window")
    public void userClickTrashButtonOpeningWindow() {
        talkPage.deleteGroup.click();
    }

    @When("User click  groupModul near group conversation")
    public void userClickGroupModulNearGroupConversation() {
        BrowserUtils.waitFor(5);
        talkPage.grupmodule.click();
    }



    @And("User click yes button displayed popup")
    public void userClickYesButtonDisplayedPopup() {
        talkPage.yesPopup.click();
        BrowserUtils.waitFor(3);
    }

    @Then("verify {string}  has been deleted")
    public void verifyHasBeenDeleted(String group) {
BrowserUtils.waitFor(3);


        for (WebElement element : talkPage.groups) {
            if (element.getText().equals(group))
                Assert.fail();
            break;
        }
    }

    @When("User click any group")
    public void userClickAnyGroup() {
        talkPage.group.click();
    }

    @When("User click settings Module near {string} conversation")
    public void userClickGroupModuleNearConversation(String groupSettings) {
        String settings="//button[@aria-label='Settings for conversation \""+groupSettings+"\"']";
WebElement set=Driver.getDriver().findElement(By.xpath(settings));
set.click();
    }
}
