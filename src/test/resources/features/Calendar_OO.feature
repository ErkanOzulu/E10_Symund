@SYMU10-514 @wip
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
    Then verify that user should see the daily calender view

  @SYMU10-585
  Scenario: User can display weekly calendar view
    When user clicks the menu toggle
    And user clicks the week link
    Then verify that user should see the weekly calender view

  @SYMU10-586
  Scenario: User can display monthly calendar view
    When user clicks the menu toggle
    And user clicks the month link
    Then verify that user should see the monthly calender view


  @SYMU10-602
  Scenario Outline: User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
    When user clicks New event button
    And user fill <"Osman"> in the event name, "<FROM DATE>" from date and "<TO DATE>" to date
    And user clicks the save button
    And user clicks the menu toggle
    And user clicks the month link
    And user clicks the Personal button if it is unselected
    Then verify that user should see <"Osman"> on the related day through the Monthly Calendar view

    Examples:
      | FROM DATE                   | TO DATE                   |
      | from 04/08/2023 at 05:00 AM | to 04/08/2023 at 06:00 AM |
      | from 04/09/2023 at 05:00 AM | to 04/08/2023 at 06:00 AM |
      | from 04/08/2023 at 06:00 AM | to 04/08/2023 at 05:00 AM |
      | from 05/09/2023 at 05:00 AM | to 04/08/2023 at 06:00 AM |
      | from 05/09/2023 at 05:00 AM |                           |
      |                             | to 04/08/2023 at 06:00 AM |
      |                             |                           |

  @SYMU10-603
  Scenario: User can delete any event through the Monthly Calendar view by clicking on the event and then using “more” option
    When user clicks the menu toggle
    And user clicks the month link
    And user clicks the Personal button if it is unselected
    And user clicks on the event which is on <"04/08/2023"> day
    And user clicks more option and toggle to expand menu
    Then verify that user can delete that event


