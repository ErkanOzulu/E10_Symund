package com.cydeo.step_definitions;


import com.cydeo.pages.DashboardPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardStepDefs {

    DashboardPage dashboardPage=new DashboardPage();



    @When("user navigates to {string}")
    public void userNavigatesTo(String module) {
        dashboardPage.navigateToModule(module);

    }

    @Then("verify that user lands on {string} page")
    public void verifyThatUserLandsOnPage(String module) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(module));
    }
}
