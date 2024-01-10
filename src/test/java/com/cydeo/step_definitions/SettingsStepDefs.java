package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.SettingsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SettingsStepDefs extends BasePage {
BrowserUtils browserUtils=new BrowserUtils();
    SettingsPage settingsPage=new SettingsPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @And("user click to profile icon")
    public void userClickToProfilIcon() {
settingsPage.settingsImg.click();
browserUtils.sleep(3);

    }
    @When("user click to settings part")
    public void userClickToSettingsPart() {


settingsPage.settingIcon.click();



    }


    @Then("user verify to open new page")
    public void userVerifyToOpenNewPage() {
        wait.until(ExpectedConditions.titleIs("Settings - Symund - QA"));
        String expected="settings";
        String actual=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }

    @Then("verify user should see {string}")
    public void verifyUserShouldSee(String looked) {
       settingsPage.verifySettingDashboard(looked);

    }



    @Then("user verify full name value should be in profile icon")
    public void userVerifyFullNameValueShouldBeInProfilIcon() {
        String actual=settingsPage.fullName.getAttribute("value");
        System.out.println(actual);
        String expected=settingsPage.settingsMenu.getAttribute("title");
        System.out.println(expected);
        Assert.assertEquals(expected,actual);
    }

    @And("user click to phone number lock")
    public void userClickToPhoneNumberLock() {
        settingsPage.phoneLockIcon.click();

    }

    @Then("verify user should see private section")
    public void verifyUserShouldSeePrivateSection() {
        String actual = settingsPage.phonePrivate.getText();

        String expected="Private";
        Assert.assertEquals(expected,actual);





    }

    @Then("verify user click to private should see phone icon")
    public void verifyUserClickToPrivateShouldSeePhoneIcon() {
        settingsPage.phonePrivate.click();
        String expectedIcon="phone";
        String actualIcon=settingsPage.privateIcon.getAttribute("class");
        Assert.assertTrue(actualIcon.contains(expectedIcon));
    }

    @Then("verify user should see current time")
    public void verifyUserShouldSeeCurrentTime() {
        wait.until(ExpectedConditions.titleIs("Settings - Symund - QA"));
        browserUtils.sleep(3);
        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = localDateTime.format(formatter);


        String expected=formattedDate;

        String actual=settingsPage.timeOfSettngs.getText();

        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
        Assert.assertTrue(actual.contains(expected));

        // Execute JavaScript code to get the current time

    }


}
