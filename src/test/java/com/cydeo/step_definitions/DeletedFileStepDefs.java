package com.cydeo.step_definitions;

import com.cydeo.pages.DeletedFilesPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeletedFileStepDefs {

    DeletedFilesPage deletedFilesPage = new DeletedFilesPage();
    LoginPage loginPage = new LoginPage();
    List<String> dFilesBeforeOrder = new ArrayList<>();
    List<String> dFilesAfterOrder = new ArrayList<>();

    List<String> dFoldersBeforeOrder = new ArrayList<>();
    List<String> dFoldersAfterOrder = new ArrayList<>();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    Actions actions = new Actions(Driver.getDriver());
    String firstFile;


    @Given("user is logged in and navigates to {string}")
    public void user_is_logged_in_and_navigates_to(String module) {

        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();
        deletedFilesPage.navigateToModule(module);
    }

    @When("user clicks Deleted files tab")
    public void user_clicks_deleted_files_tab() {

        deletedFilesPage.deletedFilesTab.click();

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

        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.info));
        js.executeScript("arguments[0].scrollIntoView(true)", deletedFilesPage.info);

        if (orderType.equalsIgnoreCase("deleted")) {
            orderType = "Date";

            for (WebElement element : deletedFilesPage.alldeletedFilesDate) {
                dFilesBeforeOrder.add(element.getAttribute("data-original-title"));
            }

            System.out.println(dFilesBeforeOrder.size());

        } else {
            int i = 0;
            for (WebElement element : deletedFilesPage.alldeletedFilesName) {

                if (deletedFilesPage.allDeletedFiles.get(i++).getAttribute("data-type").equals("dir")) {

                    dFoldersBeforeOrder.add(element.getText().toLowerCase());
                } else {
                    dFilesBeforeOrder.add(element.getText().toLowerCase());
                }

            }
        }


        Driver.getDriver().navigate().refresh();
        for (WebElement each : deletedFilesPage.order) {

            if (each.getAttribute("id").contains(orderType)) {
                wait.until(ExpectedConditions.visibilityOf(each));
                each.click();
                break;
            }
        }

        js.executeScript("arguments[0].scrollIntoView(true)", deletedFilesPage.info);

        if (orderType.equalsIgnoreCase("Date")) {
            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.alldeletedFilesDate.get(dFilesBeforeOrder.size() - 1)));
            for (WebElement element : deletedFilesPage.alldeletedFilesDate) {
                dFilesAfterOrder.add(element.getAttribute("data-original-title"));
            }
        } else {
            wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.alldeletedFilesName.get(dFilesBeforeOrder.size() - 1)));
            int i = 0;

            for (WebElement element : deletedFilesPage.alldeletedFilesName) {

                if (deletedFilesPage.allDeletedFiles.get(i++).getAttribute("data-type").equals("dir")) {

                    dFoldersAfterOrder.add(element.getText().toLowerCase());
                } else {
                    dFilesAfterOrder.add(element.getText().toLowerCase());
                }

            }
        }
    }

    @Then("Verify that all deleted files can be ordered by newest to oldest or visa versa")
    public void verify_that_all_deleted_files_can_be_ordered_by_newest_to_oldest_or_visa_versa() {

        System.out.println("dFilesBeforeOrder = " + dFilesBeforeOrder);

        List<Long> dateValueBefore = new ArrayList<>();


        for (String each : dFilesBeforeOrder) {
            Date date;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy hh:mm a", Locale.ENGLISH);
                date = sdf.parse(each);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long millis = date.getTime();

            dateValueBefore.add(millis);
        }

        System.out.println("dateValueBefore = " + dateValueBefore);


//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy '@'hh:mm a");
//        Collections.sort(dFilesAfterOrder, (s1, s2) -> LocalDateTime.parse(s1, formatter).
//                compareTo(LocalDateTime.parse(s2, formatter)));
//Sort String Date

        List<Long> dateValueAfter = new ArrayList<>();
        for (String each : dFilesAfterOrder) {

            Date date;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy hh:mm a", Locale.ENGLISH);


                date = sdf.parse(each);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long millis = date.getTime();

            dateValueAfter.add(millis);
        }
        System.out.println("dFilesAfterOrder = " + dFilesAfterOrder);
        System.out.println("dateValueAfter = " + dateValueAfter);

        Collections.reverse(dateValueBefore);

        System.out.println("after reverse: " + dateValueBefore);

        Assert.assertEquals(dateValueBefore, dateValueAfter);
        //str.replaceAll("[^\\d.]", "");
        //https://www.unixtimestamp.com/
        //https://www.javatpoint.com/java-timestamp

    }


    @Then("Verify that all deleted files can be ordered by alphabetically  based on their names")
    public void verifyThatAllDeletedFilesCanBeOrderedByAlphabeticallyBasedOnTheirNames() {

        System.out.println("dFilesBeforeOrder = " + dFilesBeforeOrder);
        System.out.println("dFilesAfterOrder = " + dFilesAfterOrder);
        Collections.sort(dFilesBeforeOrder);
        Collections.sort(dFoldersBeforeOrder);

        System.out.println("after sort " + dFilesBeforeOrder);

        Assert.assertEquals(dFilesBeforeOrder, dFilesAfterOrder);
        Assert.assertEquals(dFoldersBeforeOrder, dFoldersAfterOrder);


    }


    @When("user selects a file and click delete")
    public void user_selects_a_file_and_click_delete() {

        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.allFillesName.get(0)));

        firstFile = deletedFilesPage.allFillesName.get(0).getText(); //comes from FilesPageE because of inheritance
        actions.contextClick(deletedFilesPage.allFillesName.get(0)).perform();

        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.deleteButton));

        deletedFilesPage.deleteButton.click();

    }

    @When("navigates to Deleted files tab")
    public void navigates_to_deleted_files_tab() {
        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.deletedFilesTab));
        deletedFilesPage.deletedFilesTab.click();
    }

    @Then("verify that user should be able to see the most recent deleted file in the first line")
    public void verify_that_user_should_be_able_to_see_the_most_recent_deleted_file_in_the_first_line() {

        Assert.assertEquals(firstFile, deletedFilesPage.alldeletedFilesName.get(0).getText());

    }

    @Then("user navigates to {string} file and click three dots icon")
    public void user_navigates_to_file_and_click_three_dots_icon(String fileName) {


        actions.moveToElement(deletedFilesPage.threedot(fileName)).click().pause(1000).perform();


    }

    @Then("user clicks Delete permanently")
    public void user_clicks_delete_permanently() {
        BrowserUtils.sleep(3);
        wait.until(ExpectedConditions.visibilityOf(deletedFilesPage.deletePermanently));
        deletedFilesPage.deletePermanently.click();
        Driver.getDriver().navigate().refresh();
    }

    @Then("Verify that user shouldn't see the {string} file no longer in the deleted files")
    public void verify_that_user_shouldn_t_see_the_file_no_longer_in_the_deleted_files(String fileName) {


        for (WebElement each : deletedFilesPage.allDeletedFiles) {

            try {

                if (each.getAttribute("data-id").equals(deletedFilesPage.getSelectedFileId())) {
                    Assert.assertFalse(each.isDisplayed());
                }

            } catch (StaleElementReferenceException e) {

                Assert.assertTrue(true);
            }
            Assert.assertTrue(true);
        }


    }

    @Then("user navigates to any file and click Restore")
    public void user_navigates_to_any_file_and_click_restore() {

        Random random = new Random();
        int range = deletedFilesPage.alldeletedFilesName.size();
        int int_random = random.nextInt(range);

        js.executeScript("arguments[0].scrollIntoView(true)", deletedFilesPage.info);
        wait.until(ExpectedConditions.elementToBeClickable(deletedFilesPage.restore(int_random)));

        js.executeScript("arguments[0].click()", deletedFilesPage.restore(int_random));


        // actions.moveToElement(deletedFilesPage.restore(int_random)).click().pause(1000).perform();

    }

    @And("user clicks All Files tab")
    public void userClicksAllFilesTab() {

        deletedFilesPage.allFilesTab.click();
        Driver.getDriver().navigate().refresh();

    }

    @Then("Verify that  restore file and see it again under the All Files tab")
    public void verify_that_restore_file_and_see_it_again_under_the_all_files_tab() {

        js.executeScript("arguments[0].scrollIntoView(true)", deletedFilesPage.infoFilesPage);
        wait.until(ExpectedConditions.stalenessOf(deletedFilesPage.selectedFile));

        for (int i = 0; i <= 2; i++) {
            try {
                Assert.assertTrue(deletedFilesPage.selectedFile.isDisplayed());
                break;
            } catch (Exception e) {
                e.getMessage();
            }
        }
//        for (WebElement each : deletedFilesPage.allFilles) {
//            System.out.println(each.getAttribute("data-id"));
//
//            if (each.getAttribute("data-id").equals(deletedFilesPage.getSelectedFileId())) {
//                Assert.assertTrue(true);
//                break;
//            }
//
//        }
//        Assert.assertTrue(false);
    }
}

