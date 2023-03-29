@SYMU10-544
Feature:Tasks Module Functionality

  As a user  I should be able to create a new task list or a single task and add any task to completed and importants tasks list.

  Background:User is expected to be on the Tasks page

    Given user is logged in and on the dashboard page
    And user navigate to "Tasks" page

  @SYMU10-542
  Scenario: Create a new list of tasks

    When click to addList button
    And write a new list name "New Task List" to new list input box and click enter
    Then verify that user should see the new list link




