package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.TalkPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
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
        BasePage basePage1=new BasePage();
        basePage1.navigateToModule("spreed");
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
        List<String> part=new ArrayList<>();
        for (String participant : participants) {
            part.add(participant);
        }

        for (String s : part) {
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
}
