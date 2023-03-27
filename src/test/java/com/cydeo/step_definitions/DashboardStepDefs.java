package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardStepDefs {

    BasePage basePage=new BasePage();
    @When("click {string}")
    public void click(String module) {
       basePage.navigateToModule(module);
    }
    @Then("user can navigate to the {string} page")
    public void userCanNavigateToThePage(String module) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(module));
    }


}
