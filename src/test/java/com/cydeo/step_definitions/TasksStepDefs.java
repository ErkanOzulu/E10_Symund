package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.TasksPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class TasksStepDefs {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    TasksPage tasksPage= new TasksPage();

    @Given("user is logged in dashboard page and clicked to Tasks button and on the Tasks page")
    public void user_is_logged_in_dashboard_page_and_clicked_to_tasks_button_and_on_the_tasks_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();

        tasksPage.tasksLinkBtn.click();
    }
    @When("click to addList button")
    public void click_to_add_list_button() {

        tasksPage.addListLinkBtn.click();
        BrowserUtils.sleep(3);

    }

    @When("write a new list name {string} to new list input box and click enter")
    public void write_a_new_list_name_to_new_list_input_box_and_click_enter(String name){

        tasksPage.newListNameInputBox.sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(3);
     }

    @Then("verify that user should see the new list link")
    public void verify_that_user_should_see_the_new_list_link() {

        Assert.assertTrue(tasksPage.newListLink.isDisplayed());

    }

}
