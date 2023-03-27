package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardStepDefs {

    BasePage basePage=new BasePage();



    @When("user navigates to {string}")
    public void userNavigatesTo(String module) {
        basePage.navigateToModule(module);

    }

    @Then("verify that user lands on {string} page")
    public void verifyThatUserLandsOnPage(String module) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(module));
    }
}
