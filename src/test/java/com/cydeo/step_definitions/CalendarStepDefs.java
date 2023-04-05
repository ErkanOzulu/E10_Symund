package com.cydeo.step_definitions;

import com.cydeo.pages.CalendarPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarStepDefs {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();

    @Given("user is on the calender page")
    public void user_is_on_the_calender_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("symund.url"));
        loginPage.login();
        calendarPage.navigateToModule("calendar");


    }

    @When("user clicks the menu toggle")
    public void user_clicks_the_menu_toggle() {
        BrowserUtils.waitFor(10);
        calendarPage.menuToggleViewButton.click();
    }

    @When("user clicks the day link")
    public void user_clicks_the_day_link() {
        BrowserUtils.waitFor(3);
        calendarPage.dayButton.click();
    }

    @Then("user should see the daily calender view")
    public void user_should_see_the_daily_calender_view() {
        Assert.assertEquals("Day", calendarPage.selectedButton.getText());

    }

    @When("user clicks the week link")
    public void user_clicks_the_week_link() {
        calendarPage.weekButton.click();
    }

    @Then("user should see the weekly calender view")
    public void user_should_see_the_weekly_calender_view() {
        Assert.assertEquals("Week", calendarPage.selectedButton.getText());
    }

    @When("user clicks the month link")
    public void user_clicks_the_month_link() {
        calendarPage.monthButton.click();
    }

    @Then("user should see the monthly calender view")
    public void user_should_see_the_monthly_calender_view() {
        Assert.assertEquals("Month", calendarPage.selectedButton.getText());
    }


}
