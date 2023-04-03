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
    TasksPage tasksPage= new TasksPage();

    @Given("user navigate to {string} page")
    public void user_navigate_to_page(String module) {

        tasksPage.navigateToModule(module);
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



       tasksPage.controlIcon.click();
        BrowserUtils.sleep(3);

       tasksPage.deleteBtn.click();
       BrowserUtils.sleep(8);


    }

    @When("added new task list with {string} name")
    public void added_new_task_list_with_name(String name) {
        //tasksPage.tasksLinkBtn.click();
        tasksPage.addListLinkBtn.click();
        BrowserUtils.sleep(3);
        tasksPage.newListNameInputBox.sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(3);


    }

    @When("click to new task input box")
    public void click_to_new_task_input_box() {
       tasksPage.taskNameInputBox.click();
       BrowserUtils.sleep(3);

    }


    @When("write a new task name {string} to new task input box and click enter")
    public void write_a_new_task_name_to_new_task_input_box_and_click_enter(String name) {
        tasksPage.taskNameInputBox.sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(3);
    }
    @Then("user should see the new task name link")
    public void user_should_see_the_new_task_name_link() {
       Assert.assertTrue(tasksPage.taskModule.isDisplayed());
        BrowserUtils.sleep(3);

        tasksPage.controlIcon.click();
        BrowserUtils.sleep(3);

        tasksPage.deleteBtn.click();
        BrowserUtils.sleep(8);


    }

    @When("click to completed task checkbox on the task module")
    public void click_to_completed_task_checkbox_on_the_task_module() {

        tasksPage.completedTaskCheckBox.click();
        BrowserUtils.sleep(3);
    }
    @Then("user should see the completed date message on the task module")
    public void user_should_see_the_completed_date_message_on_the_task_module() {

        Assert.assertTrue(tasksPage.comletedTaskHeader.isDisplayed());


        tasksPage.controlIcon.click();
        BrowserUtils.sleep(3);

        tasksPage.deleteBtn.click();
        BrowserUtils.sleep(8);

    }

    @When("click to the star icon on the right side of task line")
    public void click_to_the_star_icon_on_the_right_side_of_task_line() {

        tasksPage.starIcon.click();
        BrowserUtils.sleep(3);
    }


    @Then("user should see the new task in important tasks list")
    public void user_should_see_the_new_task_in_important_tasks_list() {

        Assert.assertTrue(tasksPage.importantTaskModule.isDisplayed());
        BrowserUtils.sleep(3);

        tasksPage.controlIcon.click();
        BrowserUtils.sleep(3);

        tasksPage.deleteBtn.click();
        BrowserUtils.sleep(8);

    }

    @Then("user should see the number of all uncompleted tasks next to the Current tab")
    public void user_should_see_the_number_of_all_uncompleted_tasks_next_to_the_current_tab() {

        Assert.assertTrue(tasksPage.currentUncompletedTasksNumber.isDisplayed());

        tasksPage.controlIcon.click();
        BrowserUtils.sleep(3);

        tasksPage.deleteBtn.click();
        BrowserUtils.sleep(8);

    }

}
