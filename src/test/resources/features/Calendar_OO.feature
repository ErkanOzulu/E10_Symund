@SYMU10-514
Feature: Calender Functionality
  As a user, I should be able to see
  Daily-Weekly-Monthly calendar view
  and create a new event under the Calendar module

  Background: user is logged in and on the calender page
    Given user is on the calender page
  @SYMU10-584
  Scenario: User can display daily calendar view
    When user clicks the menu toggle
    And user clicks the day link
    Then user should see the daily calender view
  @SYMU10-585
  Scenario: User can display weekly calendar view
    When user clicks the menu toggle
    And user clicks the week link
    Then user should see the weekly calender view
  @SYMU10-586
  Scenario: User can display monthly calendar view
    When user clicks the menu toggle
    And user clicks the month link
    Then user should see the monthly calender view