package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.SettingsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsStepDefs extends BasePage {
BrowserUtils browserUtils=new BrowserUtils();
    SettingsPage settingsPage=new SettingsPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

    @And("user click to profil icon")
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
      ;
    }



    @Then("user verify full name value should be in profil icon")
    public void userVerifyFullNameValueShouldBeInProfilIcon() {
    }

    @And("user click to phone number lock")
    public void userClickToPhoneNumberLock() {
    }

    @Then("verify user should see private section")
    public void verifyUserShouldSeePrivateSection() {
    }

    @Then("verify user should see current time")
    public void verifyUserShouldSeeCurrentTime() {
    }
}
