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
    }

    @And("user enter {string} as Conversation name on displayed field")
    public void userEnterAsConversationNameOnDisplayedField(String conName) {
        talkPage.inputField.sendKeys(conName);

    }

    @And("User verify group name {string}")
    public void userVerifyGroupName(String groupName) {
        Assert.assertEquals(groupName,talkPage.grupName.getText());
    }

    @Then("Verify user should  see the participants  on the right-hand menu as below")
    public void verifyUserShouldSeeTheParticipantsOnTheRightHandMenuAsBelow(List<String> participants) throws InterruptedException {
        Thread.sleep(5000);
        List<String> part=new ArrayList<>();
        for (WebElement participant : talkPage.participants) {
part.add(participant.getText());
        }
        for (String participant : participants) {
            Assert.assertTrue(part.contains(participant));
        }






    }



    @And("user click trash button from opened moudle")
    public void userClickTrashButtonFromOpenedMoudle() {
        talkPage.removeParticipant.click();
    }

    @Then("user should verify that deleted partisipant name doesn't displey anymore")
    public void userShouldVerifyThatDeletedPartisipantNameDoesnTDispleyAnymore() {

    }

    @And("user click three point modul near the paricipant {string}")
    public void userClickThreePointModulNearTheParicipant(String partisipant) throws InterruptedException {

       String moduleLocator="//button[@aria-label='Settings for participant \""+partisipant+"\"']";
        //li[@data-id='"+module.toLowerCase()+"']
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath(moduleLocator)),10);
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
}
