package com.cydeo.step_definitions;

import com.cydeo.pages.CalendarPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;




public class CalendarStepDefs {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();
    int beforeDeletingSize;
    int afterDeletingSize;



    @Given("user is on the calender page")
    public void user_is_on_the_calender_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();
        calendarPage.navigateToModule("calendar");


    }

    @When("user clicks the menu toggle")
    public void user_clicks_the_menu_toggle() {
        BrowserUtils.waitFor(3);
        calendarPage.menuToggleViewButton.click();
    }

    @When("user clicks the day link")
    public void user_clicks_the_day_link() {
        BrowserUtils.waitFor(3);
        calendarPage.dayButton.click();
    }

    @Then("verify that user should see the daily calender view")
    public void verify_that_user_should_see_the_daily_calender_view() {
        Assert.assertEquals("Day", calendarPage.selectedButton.getText());

    }

    @When("user clicks the week link")
    public void user_clicks_the_week_link() {
        calendarPage.weekButton.click();
    }

    @Then("verify that user should see the weekly calender view")
    public void verify_that_user_should_see_the_weekly_calender_view() {
        Assert.assertEquals("Week", calendarPage.selectedButton.getText());
    }

    @When("user clicks the month link")
    public void user_clicks_the_month_link() {
        calendarPage.monthButton.click();
    }

    @Then("verify that user should see the monthly calender view")
    public void verify_that_user_should_see_the_monthly_calender_view() {
        Assert.assertEquals("Month", calendarPage.selectedButton.getText());
    }

    @When("user clicks New event button")
    public void user_clicks_new_event_button() {
        calendarPage.newEventButton.click();
    }

    @When("user clicks the save button")
    public void user_clicks_the_save_button() {
       BrowserUtils.waitFor(4);
        calendarPage.saveButton.click();
    }



    @Then("verify that user should see <{string}> on the related day through the Monthly Calendar view")
    public void verify_that_user_should_see_on_the_related_day_through_the_monthly_calendar_view(String string) {

        for (WebElement eachEventTitle : calendarPage.eventTitleContainer) {
            System.out.println("eachEventTitle.getText() = " + eachEventTitle.getText());
            if (eachEventTitle.getText().equals(string)){
                Assert.assertEquals(string,eachEventTitle.getText());
                break;
            }

        }


    }

    @When("user clicks the Personal button if it is unselected")
    public void user_clicks_the_personal_button_if_it_is_unselected() {
        if (!(calendarPage.personalCheckBox.isSelected())){
            calendarPage.personalCheckBox.click();
        }

    }

    @When("user fill <{string}> in the event name, {string} from date and {string} to date")
    public void user_fill_in_the_event_name_from_date_and_to_date(String string, String string2, String string3) {
        // Firstly we clear the box and later send keys for date
        calendarPage.inputDateFrom.sendKeys(Keys.chord(Keys.CONTROL, "a")+Keys.DELETE +string2);
        calendarPage.inputDateTo.sendKeys(Keys.chord(Keys.CONTROL, "a")+Keys.DELETE+ string3);
        calendarPage.eventTitleInputBox.sendKeys(string);
    }


    @When("user clicks on the event which is on <{string}> day")
    public void user_clicks_on_the_event_which_is_on_day(String string) {

        // event number before deleting the event
        beforeDeletingSize = calendarPage.eventTitleContainer.size();
        System.out.println("beforeDeletingSize = " + beforeDeletingSize);

         calendarPage.eventTitle.click();
    }
    @When("user clicks more option and toggle to expand menu")
    public void user_clicks_more_option_and_toggle_to_expand_menu() {


        calendarPage.moreButton.click();

        calendarPage.menuToggleForDelete.click();
    }
    @Then("verify that user can delete that event")
    public void verify_that_user_can_delete_that_event() {



        // we delete the event
        calendarPage.deleteButton.click();
        BrowserUtils.waitFor(2);


       // after deleting the event we check the number of events but before that we have to refresh the page
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitFor(10);


        afterDeletingSize = calendarPage.eventTitleContainer.size();
        System.out.println("afterDeletingSize = " + afterDeletingSize);

        Assert.assertTrue(afterDeletingSize + 1 == beforeDeletingSize);
    }


}
