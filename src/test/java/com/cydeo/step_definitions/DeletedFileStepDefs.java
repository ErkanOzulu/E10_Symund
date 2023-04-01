package com.cydeo.step_definitions;

import com.cydeo.pages.DeletedFilesPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class DeletedFileStepDefs {

    DeletedFilesPage deletedFilesPage = new DeletedFilesPage();
    LoginPage loginPage = new LoginPage();
    List<String> dFilesBeforeOrder = new ArrayList<>();
    List<String> dFilesAfterOrder = new ArrayList<>();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    String firstFile;


    @Given("user is logged in and navigates to {string}")
    public void user_is_logged_in_and_navigates_to(String module) {

        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();
        deletedFilesPage.navigateToModule(module);
    }

    @When("user clicks Deleted files tab")
    public void user_clicks_deleted_files_tab() {

        deletedFilesPage.deletedFiles.click();

    }

    @Then("verify that user can see deleted files board")
    public void verify_that_user_can_see_deleted_files_board() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        try {

            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.noDeletedFiles));
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.alldeletedFilesName.get(0)));
        }

        if (deletedFilesPage.noDeletedFiles.isDisplayed()) {

            Assert.assertTrue("No deleted files", true);
        } else {
            Assert.assertTrue("These are deleted files", deletedFilesPage.alldeletedFilesName.size() > 0);
        }


    }


    @Given("there are at least two different files that were deleted in the different time periods")
    public void there_are_at_least_two_different_files_that_were_deleted_in_the_different_time_periods() {


        try {

            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.noDeletedFiles));
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.alldeletedFilesName.get(0)));
        }

        Assert.assertTrue("There is not enough file for verification", deletedFilesPage.alldeletedFilesName.size() >= 2);

    }


    @When("user clicks order by {string}")
    public void user_clicks_header(String orderType) {

        if (orderType.equalsIgnoreCase("deleted")) {
            orderType = "Date";

            for (WebElement element : deletedFilesPage.alldeletedFilesDate) {
                dFilesBeforeOrder.add(element.getText());
            }

        } else {
            for (WebElement element : deletedFilesPage.alldeletedFilesName) {
                dFilesBeforeOrder.add(element.getText().toLowerCase());
            }
        }


        for (WebElement each : deletedFilesPage.order) {

            if (each.getAttribute("id").contains(orderType)) {
                each.click();
            }
        }


        if (orderType.equalsIgnoreCase("Date")) {
            for (WebElement element : deletedFilesPage.alldeletedFilesDate) {
                dFilesAfterOrder.add(element.getText());
            }
        } else {
            for (WebElement element : deletedFilesPage.alldeletedFilesName) {
                dFilesAfterOrder.add(element.getText().toLowerCase());
            }
        }
    }

    @Then("Verify that all deleted files can be ordered by newest to oldest or visa versa")
    public void verify_that_all_deleted_files_can_be_ordered_by_newest_to_oldest_or_visa_versa() {
        System.out.println("dFilesBeforeOrder = " + dFilesBeforeOrder);
        System.out.println("dFilesAfterOrder = " + dFilesAfterOrder);
        Collections.reverse(dFilesAfterOrder);

        System.out.println("after reverse: " + dFilesAfterOrder);

        Assert.assertEquals(dFilesBeforeOrder, dFilesAfterOrder);
  //str.replaceAll("[^\\d.]", "");


    }


    @Then("Verify that all deleted files can be ordered by alphabetically  based on their names")
    public void verifyThatAllDeletedFilesCanBeOrderedByAlphabeticallyBasedOnTheirNames() {

        System.out.println("dFilesBeforeOrder = " + dFilesBeforeOrder);
        System.out.println("dFilesAfterOrder = " + dFilesAfterOrder);
        Collections.sort(dFilesBeforeOrder);

        System.out.println("after sort " + dFilesBeforeOrder);

        Assert.assertEquals(dFilesBeforeOrder, dFilesAfterOrder);


    }


    @When("user selects a file and click delete")
    public void user_selects_a_file_and_click_delete() {
        Actions actions=new Actions(Driver.getDriver());
        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.allFilles.get(0)));

      firstFile= deletedFilesPage.allFilles.get(0).getText();
        actions.contextClick(deletedFilesPage.allFilles.get(0)).perform();

        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.deleteButton));

        deletedFilesPage.deleteButton.click();

    }
    @When("navigates to Deleted files tab")
    public void navigates_to_deleted_files_tab() {
        wait.until(ExpectedConditions.visibilityOf( deletedFilesPage.deletedFiles));
       deletedFilesPage.deletedFiles.click();
    }
    @Then("verify that user should be able to see the most recent deleted file in the first line")
    public void verify_that_user_should_be_able_to_see_the_most_recent_deleted_file_in_the_first_line() {

        Assert.assertEquals(firstFile, deletedFilesPage.alldeletedFilesName.get(0).getText());

    }




}
